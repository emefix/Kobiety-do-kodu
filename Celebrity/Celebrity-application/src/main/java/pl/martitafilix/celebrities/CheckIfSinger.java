package pl.martitafilix.celebrities;

import pl.martitafilix.celebrities.domain.Celebrity;

public class CheckIfSinger implements I_CheckTalent {

	public boolean test(Celebrity celebrity) {
		return celebrity.isCanSing();
	}

	public String getTalent() {
		return "Singer";
	}	
}
