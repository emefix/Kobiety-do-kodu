package pl.martitafilix.celebrities.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.martitafilix.celebrities.domain.Celebrity;

@Component
//@Service
public interface I_CelebrityDAO {

	public void addCelebrity(Celebrity c);
	public List<Celebrity> getCelebrities();
	public Celebrity getCelebrityById(Integer id);
}
