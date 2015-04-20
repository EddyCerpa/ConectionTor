/**
 * OnionCoffee - Anonymous Communication through TOR Network
 * Copyright (C) 2005-2007 RWTH Aachen University, Informatik IV
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package org.silvertunnel_ng.netlib.layer.tor.common;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Trust manager for TLS connections.
 * 
 * @author hapke
 */
public class TorX509TrustManager implements X509TrustManager
{
	/** */
	private static final Logger LOG = LoggerFactory.getLogger(TorX509TrustManager.class);

	public static final Pattern cnPattern = Pattern.compile(".*CN=(.*?)(,.*)*",
			Pattern.UNIX_LINES + Pattern.CASE_INSENSITIVE + Pattern.DOTALL);

	public TorX509TrustManager()
	{
	}

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException
	{
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException
	{
		if (chain.length != 2)
		{
			throw new CertificateException("Certificate Chain length != 2");
		}

		String dnName0 = chain[0].getSubjectDN().getName();
		String dnName1 = chain[1].getSubjectDN().getName();

		final Matcher dnName0Match = cnPattern.matcher(dnName0);
		final Matcher dnName1Match = cnPattern.matcher(dnName1);

		if (!dnName0Match.matches() || !dnName1Match.matches())
		{
			LOG.warn("TorX509TrustManager.checkServerTrusted(): not matched"
					+ " dnName0=" + dnName0 + ", dnName1=" + dnName1);
			throw new CertificateException(
					"Name field of Certificate does not have the right format");
		}

		dnName0 = dnName0Match.group(1);
		dnName1 = dnName1Match.group(1);

		if (dnName1.indexOf(dnName0) > 1)
		{
			throw new CertificateException(
					"Certifier and Certificate owner don't have the same name");
		}

		// XXX: It seems that the string has changed to <signing>, though
		// the second chapter of main-tor-spec still says <identity>
		LOG.debug("dnName0 = {}, dnName1 = {}", dnName0.toString(), dnName1.toString());
		if (dnName1.indexOf("<identity>") != -1
				&& dnName1.indexOf("<signing>") != -1)
		{
			throw new CertificateException(
					"Certifier Field does not have the required form");
		}

		final Date now = new Date();
		if (now.before(chain[0].getNotBefore()))
		{
			throw new CertificateException("Certificate is not valid yet");
		}
		if (now.after(chain[0].getNotAfter()))
		{
			throw new CertificateException("Certificate has expired");
		}

		// TODO: the subject unique ID has to be extracted from the ASN1
		// stuff of the Directory entry and compared to the one given here.
	}

	@Override
	public X509Certificate[] getAcceptedIssuers()
	{
		LOG.debug("X509Certificate[] getAcceptedIssuers()");
		return new X509Certificate[0];
	}

}
