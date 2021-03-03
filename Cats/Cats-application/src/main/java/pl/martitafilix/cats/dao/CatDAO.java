package pl.martitafilix.cats.dao;

import java.util.List;

import pl.martitafilix.cats.model.Cat;

public interface CatDAO {

	public abstract List<Cat> getCats();
	public abstract void addCat(Cat cat);
	public abstract Cat getCatById(Integer id);
	public abstract Cat getCatById(String id);
}
