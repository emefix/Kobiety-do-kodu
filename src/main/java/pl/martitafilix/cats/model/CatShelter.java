package pl.martitafilix.cats.model;

import java.util.ArrayList;
import java.util.List;

public class CatShelter {

	private List<Cat> cats = new ArrayList<Cat>();
		
	public void addCat(Cat cat) {
		this.cats.add(cat);
		System.out.println("Added the cat to the cat shelter.");
	}
	
	public void showCats() {
		for (Cat c : cats)	System.out.println(c.introduceYourself() + "\n");
	}
}
