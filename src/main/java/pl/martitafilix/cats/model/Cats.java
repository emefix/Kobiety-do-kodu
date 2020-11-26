package pl.martitafilix.cats.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cats {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf;
		Date date_of_birth;
		Cat kitten;
		
		// Date formatting 
		sdf =  new SimpleDateFormat("yyyy-mm-dd");
		date_of_birth = sdf.parse("2020-10-15");
		
		kitten = new Cat("Kitty", date_of_birth, (float) 1.0, "Mommy");
		
		System.out.println(kitten.introduceYourself());
	}
}
