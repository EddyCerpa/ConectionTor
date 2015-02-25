package tfg;

public class RegularExpression {
	/**
	 * Debuelve ERs positivas
	 * @return
	 */
	public static String toStringPositiveRegularExpression(){
		String string = "([C|c]on|[T|t]iene|[D|d]ispones) (";
		for (HotelServices hotelServices : HotelServices.values()) 
			string += "(" + hotelServices.getNameService()+hotelServices.getPositiveRegularExpression() + ")|";	
		string = string.substring(0, string.length()-1) + ")";
		string += "|"+HotelFeature.POSICION.getPositiveRegularExpression();
		string += "|"+HotelFeature.TARIFA.getPositiveRegularExpression();
		string += "|"+HotelFeature.SUGERENCIAS.getPositiveRegularExpression();
		System.out.println(string);
		return string;
	}
	
	/**
	 * Debuelve ERs negativas
	 * @return
	 */
	public static String toStringNegativeREgularExpression(){
		String string = "([S|s]in|[N|n]o tiene|[N|n]o [D|d]ispones) (";
		for (HotelServices ser : HotelServices.values()) 
			string += "(" + ser.getNameService()+ser.getPositiveRegularExpression() + ")|";	
		
		string = string.substring(0, string.length()-1) + ")";
		string += "|"+HotelFeature.POSICION.getNegativeREgularExpression();
		string += "|"+HotelFeature.TARIFA.getNegativeREgularExpression();
		string += "|"+HotelFeature.SUGERENCIAS.getNegativeREgularExpression();
		
		return string;
	}
	
	/**
	 * Debuelve palabras positivas
	 * @return
	 */
	public static String toStringPositiveWords(){
		String string = "";
		
		for (HotelServices hotelServices : HotelServices.values()) 
			string += hotelServices.getNameService()+ "|";	
		for (HotelFeature hotelFeature : HotelFeature.values()) {
			if (hotelFeature.toString().equalsIgnoreCase("WORD"))
				string += hotelFeature.getPositiveRegularExpression()+ "|";
			else
				string += hotelFeature.getWordFeature() + "|";
		}
		string = string.substring(0, string.length()-1);
		return string;
	}
	
	/**
	 * Debuelve palabras negativas
	 * @return
	 */
	public static String toStringNegativeWords(){
		return HotelFeature.WORD.getNegativeREgularExpression();
	}
}
