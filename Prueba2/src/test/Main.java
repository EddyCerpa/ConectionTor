package test;

import java.io.IOException;

import org.silvertunnel_ng.netlib.api.NetFactory;
import org.silvertunnel_ng.netlib.api.NetLayerIDs;
import org.silvertunnel_ng.netlib.api.NetSocket;
import org.silvertunnel_ng.netlib.api.util.TcpipNetAddress;
import org.silvertunnel_ng.netlib.util.ByteArrayUtil;
import org.silvertunnel_ng.netlib.util.HttpUtil;

public class Main {
	
	public static void main(String[] args) {
		final String TORCHECK_HOSTNAME = "httptest.silvertunnel-ng.org";
	    final TcpipNetAddress TORCHECK_NETADDRESS = new TcpipNetAddress(TORCHECK_HOSTNAME, 80);
	    
	   //TcpipNetAddress.LOG = LoggerFactory.getLogger(TcpipNetAddress.class);
	  //  System.out.println(Main.class);
	    // create connection
	    NetSocket topSocket = null;
		try {
			topSocket = NetFactory.getInstance().getNetLayerById(NetLayerIDs.TOR_OVER_TLS_OVER_TCPIP)
			        .createNetSocket(null, null, TORCHECK_NETADDRESS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("error");
		}
	    HttpUtil.getInstance();
	    // communicate with the remote side
	    byte[] httpResponse = null;
		try {
			httpResponse = HttpUtil.get(topSocket, TORCHECK_NETADDRESS, "/checktor.php", 5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			System.out.println("error");
		}
	    String httpResponseStr = ByteArrayUtil.showAsString(httpResponse);
	    System.out.println("http response body: " + httpResponseStr);
	    if ("Congratulations. Your browser is configured to use Tor.".equals(httpResponseStr))
	        {
	        System.out.println("works");
	    }
	    else
	    {
	        System.out.println("something went wrong");
	    }
	}
}
