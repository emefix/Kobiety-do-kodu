package pl.martitafilix.celebrities;

import pl.martitafilix.celebrities.domain.Celebrity;

public class CheckIfDancer implements CheckTalent {

	public boolean test(Celebrity celebrity) {
		return celebrity.isCanDance();
	}

	public String getTalent() {
		return "Dancer";
	}
}
