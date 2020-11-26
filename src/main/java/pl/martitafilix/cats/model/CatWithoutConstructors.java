package pl.martitafilix.cats.model;

public class CatWithoutConstructors {
	
	String name = "nie mam imienia";

	public CatWithoutConstructors() {
		// The constructor without parameters
	}
	
	public CatWithoutConstructors(String name) {
		this(); //	The method call without parameters the same class.
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String saySomething(String what_to_say) {
		return "I say: " + what_to_say;
	}
	
}
