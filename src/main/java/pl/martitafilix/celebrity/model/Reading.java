package pl.martitafilix.celebrity.model;

import java.util.ArrayList;
import java.util.List;

public class Reading {

	private List<Celebrity> celebrities = new ArrayList<Celebrity>();

	public void addCelebrity(Celebrity c) {
		this.celebrities.add(c);
//		System.out.println("added: " + c.getName());
	}

	public List<Celebrity> getCelebrities() {
		return this.celebrities;
	}
}
