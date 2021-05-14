package pl.martitafilix.celebrities.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.martitafilix.celebrities.domain.Celebrity;

@Repository
public interface I_CelebrityCrudRepository extends CrudRepository<Celebrity, Integer> {

	@SuppressWarnings("unchecked")
	public Celebrity save(Celebrity celebrity);
	public List<Celebrity> findAll();
	public Optional<Celebrity> findById(Integer id);
}
