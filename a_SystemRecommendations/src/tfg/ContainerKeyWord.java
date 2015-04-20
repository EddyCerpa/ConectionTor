package tfg;

import java.util.Hashtable;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ContainerKeyWord {

		private Map<String, Integer> container;
		public static String line_separator = System.getProperty("line.separator");
		
		public ContainerKeyWord() {
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
			String string = "";
			for (String key : container.keySet()) {
				string += key +" "+ container.get(key) + line_separator ;
			}
			return string;
		}
		
		public int getQuantityElement(){
			return container.size();
		}

		public JsonArray buildJsonArray(){
			JsonObject jsonObject;
			JsonArray jsonArray = new JsonArray();
			for (String key : container.keySet()) {
				jsonObject = new JsonObject();
				jsonObject.addProperty("type", key);
				jsonObject.addProperty("value", container.get(key));
				jsonArray.add(jsonObject);
			}
			return jsonArray;
		}
}
