package pl.martitafilix.cats.model;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GettingCatFromUser {
	
	static Scanner SC = new Scanner(System.in);
	
	public static String getUserInput() {
		return SC.nextLine().trim();
	}

	public void getCat_try_catch(Cat cat) {
		
		System.out.print("Podaj imie swojego kota: ");
		cat.setName(getUserInput());
		
		do {
			System.out.print("Data jego urodzenia w formacie [rrrr-mm-dd]: ");
			try {
				cat.setDate_of_birth(Cat.SDF.parse(getUserInput()));
			} catch(ParseException pe) {
				System.out.println("Niepoprawna data!");
			}
		} while(cat.getDate_of_birth() == null);
		
		do {
			System.out.print("Waga kota w formacie(10.0): ");
			try {
				cat.setWeight(Float.valueOf(getUserInput()));
			}
			catch (NumberFormatException nfe) {
				System.out.println("Podano niepoprawny format wagi!");
			}
		} while (cat.getWeight() == null);
			
		System.out.print("Imię opiekuna: ");
		cat.setName_of_catKeeper(getUserInput());	
	
		System.out.println("Dziękuję, to wszystko!\n");
	}
	
	public void getCat_pattern(Cat cat) {
			
		System.out.print("Podaj imie swojego kota: ");
		cat.setName(getUserInput());
	
		Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
		String inputDate;
		do {
			System.out.print("Data jego urodzenia w formacie [rrrr-mm-dd]: ");
			inputDate = getUserInput();
			if (datePattern.matcher(inputDate).matches()) {
				try {
					cat.setDate_of_birth(Cat.SDF.parse(inputDate));
				} catch (ParseException pe) {
					System.out.println("Niepoprawna data!");
				}
			}
		} while(cat.getDate_of_birth() == null);
		
		Pattern weightPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
		String inputWeight;
		do {
			System.out.print("Waga kota w formacie(10.0): ");
			inputWeight = getUserInput();
			if (weightPattern.matcher(inputWeight).matches()) {
				cat.setWeight(Float.valueOf(inputWeight));
			}
		} while (cat.getWeight() == null);
			
		System.out.print("Imię opiekuna: ");
		cat.setName_of_catKeeper(getUserInput());	
	
		System.out.println("Dziękuję, to wszystko!");
	}
}
