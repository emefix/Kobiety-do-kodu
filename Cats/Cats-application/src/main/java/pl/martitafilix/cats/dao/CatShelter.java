package pl.martitafilix.cats.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.martitafilix.cats.model.Cat;

@Repository
public class CatShelter implements CatDAO {

	private List<Cat> cats;
		
	public CatShelter() {
		cats = new ArrayList<Cat>();
		initData();
	}

	@Override
	public List<Cat> getCats() {
		return this.cats;
	}
	
	@Override
	public void addCat(Cat cat) {
		this.cats.add(cat);
//		System.out.println("Added the cat to the cat shelter.");
	}
	
	@Override
	public Cat getCatById(Integer id) {
		
		if(id < cats.size()) {
			return cats.get(id);
		} else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder all = new StringBuilder();
		
		cats.forEach(c -> { all.append(c.getName() + ", ");});
		return all.toString();
	}
	
	private void initData() {
		
		Cat c1 = new Cat();
		c1.setName("Bob");
		c1.setWeight((float) 5.2);
		c1.setName_of_catKeeper("Igor");
		
		Cat c2 = new Cat();
		c2.setName("Liza");
		c2.setWeight((float) 3);
		c2.setName_of_catKeeper("Kacper");
		
		Cat c3 = new Cat();
		c3.setName("Diwo");
		c3.setWeight((float) 1.8);
		c3.setName_of_catKeeper("Ola");
		
		Cat c4 = new Cat();
		c4.setName("Punia");
		c4.setWeight((float) 1.2);
		c4.setName_of_catKeeper("Dawid");
		
		try {
			c1.setDate_of_birth(Cat.SDF.parse("2020-01-25"));
			c2.setDate_of_birth(Cat.SDF.parse("2020-05-04"));
			c3.setDate_of_birth(Cat.SDF.parse("2020-11-15"));
			c4.setDate_of_birth(Cat.SDF.parse("2021-01-03"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		cats.addAll(Arrays.asList(c1, c2, c3, c4));
	}
}
