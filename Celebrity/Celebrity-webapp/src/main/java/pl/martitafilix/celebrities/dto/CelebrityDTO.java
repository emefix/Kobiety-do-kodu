package pl.martitafilix.celebrities.dto;

import javax.validation.constraints.NotBlank;

public class CelebrityDTO {

	@NotBlank( message="The name cannot be blank!" ) 
	private String 	name;
	
	private boolean canSing;
	private boolean canAct;
	private boolean canDance;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanSing() {
		return canSing;
	}

	public void setCanSing(boolean canSing) {
		this.canSing = canSing;
	}

	public boolean isCanAct() {
		return canAct;
	}

	public void setCanAct(boolean canAct) {
		this.canAct = canAct;
	}

	public boolean isCanDance() {
		return canDance;
	}

	public void setCanDance(boolean canDance) {
		this.canDance = canDance;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
