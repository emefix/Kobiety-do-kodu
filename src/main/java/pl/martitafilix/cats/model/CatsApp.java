package pl.martitafilix.cats.model;

import java.text.ParseException;
import java.util.Date;

public class CatsApp {

	public static void main(String[] args) throws ParseException {

		CatShelter catShelter = new CatShelter();
		
		Date date_of_birth = new Date();
		try {
			date_of_birth = Cat.SDF.parse("2020-10-15");
		} catch (ParseException pe) {
			System.out.println("Niepoprawna data!");
		}
		Cat kitten = new Cat("Kitty", date_of_birth, (float) 1.0, "Mommy");
		
		
		GettingCatFromUser getCat = new GettingCatFromUser();
//		Cat userCat_1 = new Cat();
		Cat userCat_2 = new Cat();
		
//		getCat.getCat_try_catch(userCat_1);
		getCat.getCat_pattern(userCat_2);
		
		catShelter.addCat(kitten);
//		catShelter.addCat(userCat_1);
		catShelter.addCat(userCat_2);	
		
		catShelter.showCats(); 
	}
}
