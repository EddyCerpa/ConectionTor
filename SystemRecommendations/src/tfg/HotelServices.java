package tfg;

public enum HotelServices{

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


	private final String nameService;
	private final String positiveRegularExpression;
	private final String negativeREgularExpression;
	
	HotelServices (String nameService_, String positiveRegularExpression_){
			nameService = nameService_;
			positiveRegularExpression= positiveRegularExpression_;
			negativeREgularExpression = null;
	}
		
	HotelServices (String nameService_, String positiveRegularExpression_,String negativeREgularExpression_){
			nameService = nameService_;
			positiveRegularExpression = positiveRegularExpression_;
			negativeREgularExpression = negativeREgularExpression_;
		}

	public String getNameService() {
		return nameService;
	}
	
	public String getPositiveRegularExpression() {
		return positiveRegularExpression;
	}
	
	public String getNegativeREgularExpression() {
		return negativeREgularExpression;
	}
}