package pl.martitafilix.celebrities.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="celebrities")
public class Celebrity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String 	name;
	private boolean canSing;
	private boolean canAct;
	private boolean canDance;
	
	public Celebrity() {}

	public Celebrity(String name, boolean canSing, boolean canAct, boolean canDance) {

		this.name 		= name;
		this.canSing 	= canSing;
		this.canAct 	= canAct;
		this.canDance 	= canDance;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public boolean isCanSing() {
		return canSing;
	}

	public boolean isCanAct() {
		return canAct;
	}

	public boolean isCanDance() {
		return canDance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCanSing(boolean canSing) {
		this.canSing = canSing;
	}

	public void setCanAct(boolean canAct) {
		this.canAct = canAct;
	}

	public void setCanDance(boolean canDance) {
		this.canDance = canDance;
	}
	
	public String printData() {
		return this.name 
				+ (this.isCanSing() 	? " is a singer; " 	: "") 
				+ (this.isCanAct() 		? " is a actor; " 	: "") 
				+ (this.isCanDance() 	? " is a dancer; " 	: "");
	}

	@Override
	public String toString() {
		return this.name;
	}
}
