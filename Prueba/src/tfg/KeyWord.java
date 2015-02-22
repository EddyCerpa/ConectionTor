package tfg;

import java.util.Hashtable;
import java.util.Map;

public class KeyWord {

		private Map<String, Integer> a;
		public static String line_separator = System.getProperty("line.separator");
		
		public KeyWord() {
			// TODO Auto-generated constructor stub
			a = new Hashtable<String, Integer>(2);
		}
		
		public void addRegularExpression(String regularExpresionPos){
			if (a.containsKey(regularExpresionPos))
				a.put(regularExpresionPos, a.get(regularExpresionPos)+1);
			else
				a.put(regularExpresionPos, 1);
		}
		
		@Override
		public String toString() {
			if (a.isEmpty())
				return "";
		// TODO Auto-generated method stub
			String string = "";
			for (String key : a.keySet()) {
				string += key +" "+ a.get(key) + line_separator ;
			}
			return string;
		}
		
}
