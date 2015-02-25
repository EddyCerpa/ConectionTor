package tfg;

public class URLAnalysis {
	
	private String url;
	private ContainerKeyWord positiveRegularExpresion;
	private ContainerKeyWord negativeRegularExpresion;
	private ContainerKeyWord negativeWord;
	private ContainerKeyWord positiveWord;
	public static String line_separator = System.getProperty("line.separator");
	
	
	public URLAnalysis(String url_) {
		// TODO Auto-generated constructor stub
		url = url_;
		positiveRegularExpresion = new ContainerKeyWord();
		negativeRegularExpresion = new ContainerKeyWord();
		negativeWord = new ContainerKeyWord();
		positiveWord = new ContainerKeyWord();
	}
	
	public void addPostiveExpresion(String string){
		positiveRegularExpresion.addRegularExpression(string);
	}
	
	
	public void addNegativeExpresion(String string){
		negativeRegularExpresion.addRegularExpression(string);
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return url+ line_separator
				+ "Positive RE"+line_separator+positiveRegularExpresion.toString()+ line_separator
				+ "Negative RE"+ line_separator+negativeRegularExpresion.toString()+ line_separator
				+ "Negative Word"+ line_separator+negativeWord.toString()+ line_separator
				+ "Positive Word"+ line_separator+positiveWord.toString()+ line_separator;
		
	}



	public void addPositiveWord(String string) {
		positiveWord.addRegularExpression(string);
	}
	
	public void addNegativeWord(String string) {
		negativeWord.addRegularExpression(string);
	}


	
}
