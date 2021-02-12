package pl.martitafilix.cats;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.martitafilix.cats.model.Cat;

@Repository
public class CatShelter {

	private List<Cat> cats = new ArrayList<Cat>();
		
	public void addCat(Cat cat) {
		this.cats.add(cat);
//		System.out.println("Added the cat to the cat shelter.");
	}
	
	public List<Cat> getCats() {
		return this.cats;
	}
	
	public Cat getCatById(Integer id) {
		
		if(id < cats.size()) {
			return cats.get(id);
		} else {
			return null;
		}
	}
}
