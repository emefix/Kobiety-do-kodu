package pl.martitafilix.celebrities.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.martitafilix.celebrities.domain.Celebrity;

@Component
//@Service
public class SpringDataCelebrityDAO  implements I_CelebrityDAO  {
	
	@Autowired
	private I_CelebrityCrudRepository celebrityRepository;
	
	/**
	 * Add a celebrity.
	 */
	@Override
	@Transactional
	public void addCelebrity(Celebrity celebrity) {
		celebrityRepository.save(celebrity);
	}
	
	/**
	 * Get all celebrities.
	 */
	@Override
	@Transactional
	public List<Celebrity> getCelebrities() {
		
		List<Celebrity> celebrities = celebrityRepository.findAll();
		return celebrities;
	}
	
	/**
	 * Get a celebrity by id.
	 */
	@Override
	@Transactional
	public Celebrity getCelebrityById(Integer id) {
		
		Celebrity celebrity = celebrityRepository.findById(id).get();
		
		if(celebrity != null) {
			return celebrity ;
		}
		return null; 
	}
}
