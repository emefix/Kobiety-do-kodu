package pl.martitafilix.celebrity.model;

public class CheckIfSinger implements CheckTalent {

	public boolean test(Celebrity celebrity) {
		return celebrity.isCanSing();
	}

	public String getTalent() {
		return "Singer";
	}	
}
