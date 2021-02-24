package pl.martitafilix.cats.dao;

import java.util.List;

import pl.martitafilix.cats.model.Cat;

public interface CatDAO {

	public List<Cat> getCats();
	public void addCat(Cat cat);
	public Cat getCatById(Integer id);
}
