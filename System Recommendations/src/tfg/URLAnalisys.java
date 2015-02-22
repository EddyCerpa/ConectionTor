package tfg;

public class URLAnalisys {
	
	private String url;
	private KeyWord positiveRegularExpresion;
	private KeyWord negativeRegularExpresion;
	private KeyWord negativeWord;
	private KeyWord positiveWord;
	public static String line_separator = System.getProperty("line.separator");
	
	
	public URLAnalisys(String url_) {
		// TODO Auto-generated constructor stub
		url = url_;
		positiveRegularExpresion = new KeyWord();
		negativeRegularExpresion = new KeyWord();
		negativeWord = new KeyWord();
		positiveWord = new KeyWord();
	}
	
	public void addPostiveExpresion(String er){
		positiveRegularExpresion.addRegularExpression(er);
	}
	
	
	public void addNegativeExpresion(String er){
		negativeRegularExpresion.addRegularExpression(er);
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



	public void addPositiveWord(String word) {
		// TODO Auto-generated method stub
		positiveWord.addRegularExpression(word);
	}
	
	public void addNegativeWord(String word) {
		// TODO Auto-generated method stub
		negativeWord.addRegularExpression(word);
	}


	
}
