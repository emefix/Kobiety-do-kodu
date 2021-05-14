package pl.martitafilix.celebrities;

import pl.martitafilix.celebrities.domain.Celebrity;

public class CheckIfActor implements I_CheckTalent {

	public boolean test(Celebrity celebrity) {
		return celebrity.isCanAct();
	}

	public String getTalent() {
		return "Actor";
	}
}
