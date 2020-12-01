package pl.martitafilix.cats.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cats {

	static Scanner SC = new Scanner(System.in);
	static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-mm-dd");
	
	public static void main(String[] args) throws ParseException {

		Date date_of_birth;
		Cat kitten, user_cat;
		
		// Date formatting 
		date_of_birth = SDF.parse("2020-10-15");
		
		kitten = new Cat("Kitty", date_of_birth, (float) 1.0, "Mommy");
		
		System.out.println(kitten.introduceYourself());
		
		user_cat = new Cat();
		gettingCatFromUser(user_cat);
		System.out.println(user_cat.introduceYourself());
	}
	
	private static void gettingCatFromUser(Cat cat) {
				
		System.out.print("Podaj imie swojego kota: ");
		cat.setName(getUserInput());
		
		do {
			System.out.print("Data jego urodzenia (rrrr-mm-dd): ");
			try {
				cat.setDate_of_birth(SDF.parse(getUserInput()));
			} catch(ParseException pe) {
				System.out.println("Niepoprawna data! Podaj w formacie (rrrr-mm-dd).");
			}
		} while(cat.getDate_of_birth() == null);
		
		do {
			System.out.print("Waga kota: ");
			try {
				cat.setWeight(Float.valueOf(getUserInput()));
			}
			catch (NumberFormatException nfe) {
				System.out.println("Podano niepoprawny format wagi! Podaj w formacie(10.0).");
			}
		} while (cat.getWeight() == null);
			
		System.out.print("Imię opiekuna: ");
		cat.setName_of_catKeeper(getUserInput());	
	
		System.out.println("Dziękuję, to wszystko!");
	}
	
	public static String getUserInput() {
		return SC.nextLine().trim();
	}
}
