package pl.martitafilix.celebrities;

import pl.martitafilix.celebrities.domain.Celebrity;

public interface I_CheckTalent {
	// Functional interface must have the only one method.
	boolean test(Celebrity celebrity);
	
//	String getTalent();
}