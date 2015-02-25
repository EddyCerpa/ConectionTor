package tfg;

import java.util.Hashtable;
import java.util.Map;

public class ContainerKeyWord {

		private Map<String, Integer> container;
		public static String line_separator = System.getProperty("line.separator");
		
		public ContainerKeyWord() {
			// TODO Auto-generated constructor stub
			container = new Hashtable<String, Integer>(2);
		}
		
		public void addRegularExpression(String positiveRegularExpression){
			if (container.containsKey(positiveRegularExpression))
				container.put(positiveRegularExpression, container.get(positiveRegularExpression)+1);
			else
				container.put(positiveRegularExpression, 1);
		}
		
		@Override
		public String toString() {
			if (container.isEmpty())
				return "";
		// TODO Auto-generated method stub
			String string = "";
			for (String key : container.keySet()) {
				string += key +" "+ container.get(key) + line_separator ;
			}
			return string;
		}
		
}
