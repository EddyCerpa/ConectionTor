package prueba2;

public enum CaracteristHotel {
	POSICION ("[P|p]posicion ","([B|b]ien situado|[C|c]entro|[C|c]�ntrico) ","lejos "),
	
	
	TARIFA ("[C|c]oste|[T|t]arifa ", "(tarifa plana mini bar|"
			+ "barato|"
			+ "sencillo|"
			+ "magnifico presio|"
			+ "buena relacion calidad presio|"
			+ "ofertas y promociones) ", null),
	
	SUGERENCIAS ("([R|r]ecomendacion|[S|s]ugerencias|barato|economico) ",
			"(mascotas permitidas|"
			+ "estancia agradable|"
			+ "excelente ospitalidad|"
			+ "atencion rapida|"
			+ "buena calidad|"
			+ "elegante y distinguido|"
			+ "buen dise�o y estilo|"
			+ "buena experiencia|"
			+ "encanto|"
			+ "recomendado experiencia inmejorable|"
			+ "perfecta estancia|"
			+ "sentirse como en casa|"
			+ "muy buena opcion|"
			+ "trato muy cordia|"
			+ "buenisimo servicio|"
			+ "todo lo que necesitas) ",
			
			
			"(obligan a contratar cama supletoria para ni�os menores de 4 a�os|"
					+ "pol�tica de ni�os|"
					+ "proh�ben hospedaje de mascotas|"
					+ "sin posibilidad de cama supletoria|"
					+ "contaminan el medio ambiente|"
					+ "ba�o muy peque�o|"
					+ "ba�o con poca presi�n de agua|"
					+ "hotel mal ubicado sector muy ruidoso|"
					+ "no tiene parking|"
					+ "mala relaci�n calidad precio|"
					+ "muy mala atenci�n|"
					+ "checkin lento|sin organizaci�n de eventos|"
					+ "mal trato por personal del hotel|"
					+ "mala opci�n|"
					+ "por debajo de mis expectativas|"
					+ "es un chasco|"
					+ "mala recepci�n|ba�o poco cuidado|"
					+ "instalaciones en mal funcionamiento|"
					+ "habitaciones sin mantenimiento|"
					+ "necesita mejorar|"
					+ "remodelaci�n de habitaciones|"
					+ "relaci�n calidad precio deplorable|"
					+ "servicios de la habitaci�n son tercermundista|"
					+ "no cumple el n�mero de estrellas|"
					+ "calidad y servicio no es de N estrellas|"
					+ "spa y ubicaci�n p�simos|"
					+ "spa peque�o|"
					+ "desayuno muy caro|"
					+ "jacuzzi averiado) "),
	
	WORD (null,"(buena|elegante|eficaz|apreciable|gratis|limpieza) ", "(mala|peque�o|caro|averiado|chasco|sin|no tiene) ");
	
	private String wor;
	private String erPos;
	private String erNeg;


	CaracteristHotel (String wor_, String erPos_,String erNeg_){
		wor = wor_;
		erPos = erPos_;
		erNeg = erNeg_;
	}
	
	public String getErPos() {
		return erPos;
	}
	
	public String getErNeg() {
		return erNeg;
	}

	public String getWor() {
		// TODO Auto-generated method stub
		return wor;
	}
}
