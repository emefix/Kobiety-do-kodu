package pl.martitafilix.celebrities.dao;

import java.util.List;

import pl.martitafilix.celebrities.domain.Celebrity;

public interface CelebrityDAO {

	public void addCelebrity(Celebrity c);
	public List<Celebrity> getCelebrities();
	public Celebrity getCelebrityById(Integer id);
}
