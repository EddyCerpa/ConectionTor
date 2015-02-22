package prueba2;

public class GestionWord {
	/**
	 * Debuelve ERs positivas
	 * @return
	 */
	public static String toStringREPositiva(){
		String string = "([C|c]on|[T|t]iene|[D|d]ispones) (";
		for (ServiciosHotels ser : ServiciosHotels.values()) {
			// Espresiones a las cuales le podemos anteponer las palabras "con, tiene, dispone, etc"
			string += "(" + ser.getWor()+ser.getErPos() + ")|";	
		}
		
		string = string.substring(0, string.length()-1) + ")";
		string += "|"+CaracteristHotel.POSICION.getErPos();
		string += "|"+CaracteristHotel.TARIFA.getErPos();
		string += "|"+CaracteristHotel.SUGERENCIAS.getErPos();
		System.out.println(string);
		return string;
	}
	
	/**
	 * Debuelve ERs negativas
	 * @return
	 */
	public static String toStringRENegativa(){
		String string = "([S|s]in|[N|n]o tiene|[N|n]o [D|d]ispones) (";
		for (ServiciosHotels ser : ServiciosHotels.values()) {
			// Espresiones a las cuales le podemos anteponer las palabras "con, tiene, dispone, etc"
			string += "(" + ser.getWor()+ser.getErPos() + ")|";	
		}
		
		string = string.substring(0, string.length()-1) + ")";
		string += "|"+CaracteristHotel.POSICION.getErNeg();
		string += "|"+CaracteristHotel.TARIFA.getErNeg();
		string += "|"+CaracteristHotel.SUGERENCIAS.getErNeg();
		
		return string;
	}
	
	/**
	 * Debuelve palabras positivas
	 * @return
	 */
	public static String toStringPositiveWords(){
		String string = "";
		
		for (ServiciosHotels ser : ServiciosHotels.values()) {
			// Espresiones a las cuales le podemos anteponer las palabras "con, tiene, dispone, etc"
			string += ser.getWor()+ "|";	
		}
		for (CaracteristHotel ser : CaracteristHotel.values()) {
			// Espresiones a las cuales le podemos anteponer las palabras "con, tiene, dispone, etc"
			if (ser.toString().equalsIgnoreCase("WORD"))
				string += ser.getErPos()+ "|";
			else
				string += ser.getWor() + "|";
		}
		string = string.substring(0, string.length()-1);
		return string;
	}
	
	/**
	 * Debuelve palabras negativas
	 * @return
	 */
	public static String toStringNegativeWords(){
		return CaracteristHotel.WORD.getErNeg();
	}

}
