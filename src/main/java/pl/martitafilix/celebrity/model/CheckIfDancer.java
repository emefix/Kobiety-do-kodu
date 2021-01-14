package pl.martitafilix.celebrity.model;

public class CheckIfDancer implements CheckTalent {

	public boolean test(Celebrity celebrity) {
		return celebrity.isCanDance();
	}

	public String getTalent() {
		return "Dancer";
	}
}
