package pl.martitafilix.cats.controller;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import pl.martitafilix.cats.model.Cat;

public class GettingDataFromUser {
	
	static Scanner SC = new Scanner(System.in);
	
	public Cat getCat() {
		return this.getDataFromJPane_pattern();
	}

	public static String getUserInputConsole() {
		return SC.nextLine().trim();
	}
	
	public static String getUserInputJPane(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	private Cat getDataFromJPane_pattern() {
		 
		Cat cat = new Cat();
		
		cat.setName(getUserInputJPane("Podaj imie swojego kota: "));
	
		Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
		String inputDate;
		do {
			inputDate = getUserInputJPane("Data jego urodzenia w formacie [rrrr-mm-dd]: ");
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
			inputWeight = getUserInputJPane("Waga kota w formacie(10.0): ");
			if (weightPattern.matcher(inputWeight).matches()) {
				cat.setWeight(Float.valueOf(inputWeight));
			}
		} while (cat.getWeight() == null);
			
		cat.setName_of_catKeeper(getUserInputJPane("Imię opiekuna: "));	
//		JOptionPane.showMessageDialog(null, "Dziękuję, to wszystko!", "Informacje dotyczące kota", JOptionPane.INFORMATION_MESSAGE);

		return cat;
	}

	private Cat getDataFromConsole_try_catch() {
		
		Cat cat = new Cat();
		
		System.out.print("Podaj imie swojego kota: ");
		cat.setName(getUserInputConsole());
		
		do {
			System.out.print("Data jego urodzenia w formacie [rrrr-mm-dd]: ");
			try {
				cat.setDate_of_birth(Cat.SDF.parse(getUserInputConsole()));
			} catch(ParseException pe) {
				System.out.println("Niepoprawna data!");
			}
		} while(cat.getDate_of_birth() == null);
		
		do {
			System.out.print("Waga kota w formacie(10.0): ");
			try {
				cat.setWeight(Float.valueOf(getUserInputConsole()));
			}
			catch (NumberFormatException nfe) {
				System.out.println("Podano niepoprawny format wagi!");
			}
		} while (cat.getWeight() == null);
			
		System.out.print("Imię opiekuna: ");
		cat.setName_of_catKeeper(getUserInputConsole());	
	
		System.out.println("Dziękuję, to wszystko!\n");
		return cat;
	}
	
	private Cat getDataFromConsole_pattern() {
			
		Cat cat = new Cat();
		
		System.out.print("Podaj imie swojego kota: ");
		cat.setName(getUserInputConsole());
	
		Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
		String inputDate;
		do {
			System.out.print("Data jego urodzenia w formacie [rrrr-mm-dd]: ");
			inputDate = getUserInputConsole();
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
			inputWeight = getUserInputConsole();
			if (weightPattern.matcher(inputWeight).matches()) {
				cat.setWeight(Float.valueOf(inputWeight));
			}
		} while (cat.getWeight() == null);
			
		System.out.print("Imię opiekuna: ");
		cat.setName_of_catKeeper(getUserInputConsole());	
	
		System.out.println("Dziękuję, to wszystko!");
		return cat;
	}

	public int getCatIndex() {
		
		String str_num;
		Pattern number_pattern = Pattern.compile("[0-9]+");
		do {
			str_num = getUserInputJPane("Podaj numer kota, by poznać szczegóły: ");
		} while(!number_pattern.matcher(str_num).matches());
		
		return Integer.parseInt(str_num);
	}
}
