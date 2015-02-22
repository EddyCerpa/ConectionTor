package prueba2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mian {

	public static void main(String[] args) {
		System.out.println(GestionWord.toStringPositiveWords());
		Pattern p = Pattern.compile(GestionWord.toStringNegativeWords());
		 //Matcher m = p.matcher("one cat two cats in the yard");
		 Matcher m = p.matcher("hotel palace tiene buen servicio jaja mala opción jaj no me acuerdo Hotel palace tiene wifi gratis no se por q es y ademas con limpieza continua es un buen hotel con todo lo que necesitas ademas vuelvo a decir todo lo que necesitas y tiene parking en el hotel ");
		 StringBuffer sb = new StringBuffer();
		 while (m.find()) {
		    // m.appendReplacement(sb, "dog");
		     // en vez de hacer if else poner todo en un enumerado
		     
		     System.out.println(m.group(0));
		    /* if (m.group().equalsIgnoreCase("cat"))
		    	 cat++;
		     else
		    	 yard++;
		     System.out.println(m.group());
		     count ++;*/
		 }

	}

	
	
	
}
