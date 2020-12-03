package pl.martitafilix.cats.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class CatShelter {

	private ArrayList<Cat> cats = new ArrayList<Cat>();
	
	public CatShelter()  {
		
		Date date_of_birth = new Date();
		try {
			date_of_birth = Cat.SDF.parse("2020-10-15");
		} catch (ParseException pe) {
			System.out.println("Niepoprawna data!");
		}
		Cat kitten = new Cat("Kitty", date_of_birth, (float) 1.0, "Mommy");
		
		
		GettingCatFromUser getCat = new GettingCatFromUser();
		Cat userCat_1 = new Cat();
		Cat userCat_2 = new Cat();
		
		getCat.getCat_try_catch(userCat_1);
		getCat.getCat_pattern(userCat_2);
		
		cats.add(kitten);
		cats.add(userCat_1);
		cats.add(userCat_2);	
	}
	
	public void showCats() {
		for (Cat c : cats)	System.out.println(c.introduceYourself() + "\n");
	}
}
