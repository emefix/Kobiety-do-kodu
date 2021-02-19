package pl.martitafilix.celebrities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.martitafilix.celebrities.domain.Celebrity;

@Repository
public class Reading {

	private List<Celebrity> celebrities;// = new ArrayList<Celebrity>();

	public Reading() {
		this.celebrities = new ArrayList<Celebrity>();
		this.initData();
	}
	
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
	
	@Override
	public String toString() {
		
		StringBuilder all = new StringBuilder();
		
		this.celebrities.forEach(c -> { all.append(c.getName() + ", ");});
		return all.toString();
	}
	
	private void initData() {
		
		this.celebrities.addAll(
			Arrays.asList(
				new Celebrity() {{	setName("Igor Herbut");			setCanSing(true);	}},
				new Celebrity() {{	setName("Kayah");				setCanSing(true);	}},
				new Celebrity() {{	setName("Maciej Zakościelny");	setCanAct(true);	}},
				new Celebrity() {{	setName("Augustin Egurrola");	setCanDance(true);	}},
				new Celebrity() {{	setName("Marcin Hakiel");		setCanDance(true);	}},
				new Celebrity() {{	setName("Edyta Górniak");		setCanSing(true);	}}
			)
		);
	}
}
