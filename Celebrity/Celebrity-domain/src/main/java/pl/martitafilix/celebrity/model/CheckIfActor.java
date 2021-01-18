package pl.martitafilix.celebrity.model;

public class CheckIfActor implements CheckTalent {

	public boolean test(Celebrity celebrity) {
		return celebrity.isCanAct();
	}

	public String getTalent() {
		return "Actor";
	}
}
