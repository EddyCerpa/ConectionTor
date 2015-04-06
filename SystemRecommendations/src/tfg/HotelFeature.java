package tfg;

public enum HotelFeature {
	POSICION ("[P|p]posicion ","([B|b]ien situado|[C|c]entro|[C|c]éntrico) ","lejos "),
	
	
	TARIFA ("[C|c]oste|[T|t]arifa ", "(tarifa plana mini bar|"
			+ "barato|"
			+ "sencillo|"
			+ "magnifico precio|"
			+ "buena relacion calidad precio|"
			+ "ofertas y promociones) ", "sin ofertas|muy caro"), //null
	
	SUGERENCIAS ("([R|r]ecomendacion|[S|s]ugerencias|barato|economico) ",
			"(mascotas permitidas|"
			+ "estancia agradable|"
			+ "excelente ospitalidad|"
			+ "atencion rapida|"
			+ "buena calidad|"
			+ "elegante y distinguido|"
			+ "buen diseño y estilo|"
			+ "buena experiencia|"
			+ "encanto|"
			+ "recomendado experiencia inmejorable|"
			+ "perfecta estancia|"
			+ "sentirse como en casa|"
			+ "muy buena opcion|"
			+ "trato muy cordia|"
			+ "buenisimo servicio|"
			+ "todo lo que necesitas) ",
			
			
			"(obligan a contratar cama supletoria para niños menores de 4 años|"
					+ "política de niños|"
					+ "prohíben hospedaje de mascotas|"
					+ "sin posibilidad de cama supletoria|"
					+ "contaminan el medio ambiente|"
					+ "baño muy pequeño|"
					+ "baño con poca presión de agua|"
					+ "hotel mal ubicado sector muy ruidoso|"
					+ "no tiene parking|"
					+ "mala relación calidad precio|"
					+ "muy mala atención|"
					+ "checkin lento|sin organización de eventos|"
					+ "mal trato por personal del hotel|"
					+ "mala opción|"
					+ "por debajo de mis expectativas|"
					+ "es un chasco|"
					+ "mala recepciñon|baño poco cuidado|"
					+ "instalaciones en mal funcionamiento|"
					+ "habitaciones sin mantenimiento|"
					+ "necesita mejorar|"
					+ "remodelación de habitaciones|"
					+ "relación calidad precio deplorable|"
					+ "servicios de la habitación son tercermundista|"
					+ "no cumple el número de estrellas|"
					+ "calidad y servicio no es de N estrellas|"
					+ "spa y ubicación pésimos|"
					+ "spa pequeño|"
					+ "desayuno muy caro|"
					+ "jacuzzi averiado) "),
	
	WORD (null,"(buena|elegante|eficaz|apreciable|gratis|limpieza) ", "(mala|pequeño|caro|averiado|chasco|sin|no tiene) ");
	
	private String wordFeature;
	private String positiveRegularExpression;
	private String negativeREgularExpression;


	HotelFeature (String wordFeature_, String positiveRegularExpression_,String negativeREgularExpression_){
		wordFeature = wordFeature_;
		positiveRegularExpression = positiveRegularExpression_;
		negativeREgularExpression = negativeREgularExpression_;
	}
	
	public String getNegativeREgularExpression() {
		return negativeREgularExpression;
	}
	
	public String getPositiveRegularExpression() {
		return positiveRegularExpression;
	}
	
	public String getWordFeature() {
		return wordFeature;
	}
}
