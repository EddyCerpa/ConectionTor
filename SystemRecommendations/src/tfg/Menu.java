package tfg;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.JSONException;

public class Menu {

	public void run() {
		buildMenu();
	}	
	

	private void buildMenu() {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		do {
			System.out.println("Chose the operation:");
			System.out.println("1-Search nearly hotels");
			System.out.println("2-Statistical results");
			System.out.println("3-Search termins webs results");
			System.out.println("4-Exit");
			try {
				int num = sc.nextInt();
				if (num == 1){
					nearlyHotel(sc);
				}
				else if (num == 2){
					statisticalResults(sc);
				}
				else if (num == 3) {
					terminsWebs(sc);
				}
				else if (num == 4){
					exit = true;
				}
				else{
					System.out.println("wrong format");
				}
			}catch (InputMismatchException e) {
				System.out.println("wrong format");
			}
		}while (!exit);
		
		sc.close();
		
	}




	private void terminsWebs(Scanner sc){
		sc.nextLine();
		System.out.print("Enter your search: ");
		String query = sc.nextLine();
		
		
		System.out.println("Enter the number of webs to scan [must be less than 57]");
		int numberUrl = sc.nextInt();
		
		int pages = numberUrl / 8;
		int restWebs  = numberUrl % 8;
		WebFound webFound = new WebFound(numberUrl);
		int i = 0;
		
		for (; i < pages; i++)
			try {
				String url = TestGetJSON.generateGoogleApiSearch(query, i*8); 
				webFound.addUrlList(TestGetJSON.getJSON(url),8);
				
			} catch (Exception e) {e.printStackTrace();}
		
		// resto
		if (restWebs != 0){
			i++;
	
			try {
				String url = TestGetJSON.generateGoogleApiSearch(query, (i*8));
				webFound.addUrlList(TestGetJSON.getJSON(url),restWebs);
			} catch (JSONException | IOException e2) {
				
				e2.printStackTrace();
			}
		}
		// 
		try {
			webFound.scanWebs(numberUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(webFound.toString(numberUrl));
	}

	private void statisticalResults(Scanner sc) {
		sc.nextLine();
		System.out.print("Enter the city: ");
		String city = sc.nextLine();
		
		System.out.print("Enter the name hotel: ");
		String nameHotel = sc.nextLine();
		System.out.print("Enter the termin: ");
		String term = sc.nextLine();
		
		try {
			System.out.println("Bayes: " + EstimationHotel.getBayes(city, nameHotel, term)/*eh.searchBayes("Hotel Madrid", "Palace")*/);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void nearlyHotel(Scanner sc) {
		// 40.420138, -3.704801, 500

		System.out.println("Enter latitude:");
		double latitude = sc.nextDouble();
		System.out.println("Enter longitude:");
		double longitude = sc.nextDouble();
		System.out.println("Enter radius: ");
		int radius = sc.nextInt();
		PositionOfSearch position = new PositionOfSearch(latitude, longitude,radius);
		NearlyHotel nH = new NearlyHotel(position);

		try {
			nH.SearchHotel();
			System.out.println(nH.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.run();
	}

	

}
