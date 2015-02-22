package prueba2;

public enum ServiciosHotels{
	// palabra, ers+, ers-
	// positivas poner antes con
	// servicios
	SPA ("[S|s]pa ","([a|A]gradable|confortable) ","pesimo "),
	GIMNACIO ("Gym|[g|G]imnacio ","(favuloso|amplio) ","pequeño "),
	DESAYUNO ("[D|d]esayuno ","gratis ","((muy )?)caro "),
	WIFI ("[W|w]ifi ","(en zonas comunes|gratuito|gratis|en todo el establecimeinto) "),
	LIMPIEZA("[L|l]impieza ","continua "),
	PISCINA("[P|p]iscina ","cubierta "),
	COCINA("[C|c]ocina ", "incluida "),
	TERRAZA("[T|t]erraza ", "incluida ","pequeña "),
	LAVANDERIA("[L|l]avanderia ", "incluida ","no incluida"),
	RESTAURANTE("[R|r]estaurante ", "buena comida ", "sin servicio de habitacion "),
	PARKING("[P|p]arking ", "en el hotel ", "no incluido"),
	
	BIEN_COMUNICADO ("[C|c]omunicación ","([B|b]ien comunicado|[B|b]uena cominicación) "),
	DISTANCIA ("[C|c]erca", "de las estaciones de transporte "),
	

	HABITACIONES ("[H|h]abitaciones ","(con abundantes enchufes|cómodas|insonorizadas) ","pequeñas ");


	private final String wor;
	private final String erPos;
	private final String erNeg;

	ServiciosHotels (String word){
		wor = word;
		erPos= null;
		erNeg = null;
	}
		
	ServiciosHotels (String wor_, String erPos_){
			wor = wor_;
			erPos= erPos_;
			erNeg = null;
		}
		
		ServiciosHotels (String wor_, String erPos_,String erNeg_){
			wor = wor_;
			erPos = erPos_;
			erNeg = erNeg_;
		}

	public String getWor() {
		return wor;
	}
	
	public String getErPos() {
		return erPos;
	}
	
	public String getErNeg() {
		return erNeg;
	}
	
	public String toStringREPositiva(){
		String string = "([C|c]on|[T|t]iene|[D|d]ispones) (";
		for (ServiciosHotels ser : ServiciosHotels.values()) {
			// Espresiones a las cuales le podemos anteponer las palabras "con, tiene, dispone, etc"
			string += "(" + ser.getWor()+ser.getErPos() + ")|";	
		}
		
		string = string.substring(0, string.length()-1)+ ")";
		string += "|"+CaracteristHotel.POSICION.getErPos();
		string += "|"+CaracteristHotel.TARIFA.getErPos();
		string += "|"+CaracteristHotel.SUGERENCIAS.getErPos();
		
		return string;
	}
}