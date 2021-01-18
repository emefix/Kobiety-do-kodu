package pl.martitafilix.celebrity.model;

public interface CheckTalent {
	// Functional interface must have the only one method.
	boolean test(Celebrity celebrity);
	
//	String getTalent();
}