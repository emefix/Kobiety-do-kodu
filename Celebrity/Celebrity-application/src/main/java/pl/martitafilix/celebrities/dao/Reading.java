package pl.martitafilix.celebrities.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.martitafilix.celebrities.domain.Celebrity;

@Component
//@Service
//@Repository
public class Reading implements I_CelebrityDAO {

	private List<Celebrity> celebrities;

	public Reading() {
		this.celebrities = new ArrayList<Celebrity>();
		this.initData();
	}
	/**
	 * Add a celebrity.
	 */
	@Override
	public void addCelebrity(Celebrity c) {
		c.setId(celebrities.size());
		this.celebrities.add(c);
//		System.out.println("added: " + c.getName());
	}
	/**
	 * Get all celebrities.
	 */
	@Override
	public List<Celebrity> getCelebrities() {
		return this.celebrities;
	}
	/**
	 * Get celebrity by id.
	 */
	@Override
	public Celebrity getCelebrityById(Integer id) {
		
		if(id < celebrities.size()) {
			return celebrities.get(id);
		} else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder all = new StringBuilder();
		
		this.celebrities.forEach(c -> { all.append(c.getName() + ", ");});
		return all.toString();
	}
	
	private void initData() {
		
		this.celebrities.addAll(
			Arrays.asList(
				new Celebrity() {{	setId(0); setName("Igor Herbut");		setCanSing(true);	}},
				new Celebrity() {{	setId(1); setName("Kayah");				setCanSing(true);	}},
				new Celebrity() {{	setId(2); setName("Maciej Zakościelny");setCanAct(true);	}},
				new Celebrity() {{	setId(3); setName("Augustin Egurrola");	setCanDance(true);	}},
				new Celebrity() {{	setId(4); setName("Marcin Hakiel");		setCanDance(true);	}},
				new Celebrity() {{	setId(5); setName("Edyta Górniak");		setCanSing(true);	}}
			)
		);
	}
}
