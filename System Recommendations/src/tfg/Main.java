package tfg;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

				
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

	private static void terminsWebs(Scanner sc) {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.print("Enter your search: ");
		String query = sc.nextLine();
		String url = "http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=" + query.replaceAll("\\s", "%20").trim();
		try {
			TestGetJSON.getJSON(url);
			Web webs = new Web();
			webs.addUrlList(TestGetJSON.getJSON(url));
			System.out.println(webs.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private static void statisticalResults(Scanner sc) {
		sc.nextLine();
		System.out.print("Enter your search: ");
		String query = sc.nextLine();
		EstimationHotel eh = new EstimationHotel();
		try {
			System.out.println("Bayes: " + eh.searchBayes("Hotel Madrid", "Palace"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void nearlyHotel(Scanner sc) {
		//40.420138, -3.704801, 500
				
				
				System.out.println( "Enter latitude:");
				double latitude = sc.nextDouble();
				System.out.println( "Enter longitude:");
				double longitude = sc.nextDouble();
				System.out.println("Enter radius: ");
				int radius = sc.nextInt();
				Position position = new Position(latitude, longitude,radius);
				NearlyHotel nH = new NearlyHotel(
						"https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=",
						"AIzaSyBhmi0Tza5mePpDCBv4F4_OJywxEhD67Ic",position);
				
				//TestGetJSON.getJSON(nH.getUrl());
				try {
					//ArrayList<Hotel> hotels = nH.SearchHotel(position);
					nH.SearchHotel(TestGetJSON.getJSON(nH.getUrl()));
					System.out.println(nH.toString());
					/*
					
					System.out.println(nH.SearchHotel(position).toString());
					System.out.println("Fin");*/
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
