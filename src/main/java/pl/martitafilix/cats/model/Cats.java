package pl.martitafilix.cats.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cats {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf;
		Date date_of_birth;
		Cat kitten, user_cat;
		
		// Date formatting 
		sdf =  new SimpleDateFormat("yyyy-mm-dd");
		date_of_birth = sdf.parse("2020-10-15");
		
		kitten = new Cat("Kitty", date_of_birth, (float) 1.0, "Mommy");
		
		System.out.println(kitten.introduceYourself());
		
		user_cat = new Cat();
		gettingCatFromUser(user_cat);
		System.out.println(user_cat.introduceYourself());
	}
	
	private static void gettingCatFromUser(Cat cat) throws ParseException {
		
		Scanner sc 				= new Scanner(System.in);
		SimpleDateFormat sdf 	= new SimpleDateFormat("yyyy-mm-dd");
		
		System.out.print("Podaj imie swojego kota: ");
		cat.setName(sc.nextLine());
		
		System.out.print("Data jego urodzenia (rrrr-mm-dd): ");
		cat.setDate_of_birth(sdf.parse(sc.nextLine()));
		
		System.out.print("Waga kota: ");
		cat.setWeight(sc.nextFloat());
		
		System.out.print("Imię opiekuna: ");
		cat.setName_of_catKeeper(sc.next());		
	}
}
