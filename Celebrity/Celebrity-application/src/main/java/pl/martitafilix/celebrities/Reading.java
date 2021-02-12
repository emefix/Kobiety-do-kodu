package pl.martitafilix.celebrities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.martitafilix.celebrities.domain.Celebrity;

@Repository
public class Reading {

	private List<Celebrity> celebrities = new ArrayList<Celebrity>();

	public void addCelebrity(Celebrity c) {
		this.celebrities.add(c);
//		System.out.println("added: " + c.getName());
	}

	public List<Celebrity> getCelebrities() {
		return this.celebrities;
	}
	
	public Celebrity getCelebrityById(Integer id) {
		
		if(id < celebrities.size()) {
			return celebrities.get(id);
		} else {
			return null;
		}
	}
}
