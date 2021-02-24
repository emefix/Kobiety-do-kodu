package pl.martitafilix.cats.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CatDTO {

	@NotBlank
	private String	name;
	
	@Pattern(regexp="[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]")
	private String 	date_of_birth;
	
	@NotNull @Min(0)
	private Float 	weight;
	
	@NotBlank
	private String	name_of_catKeeper;
	
	// Getters and setters:
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getName_of_catKeeper() {
		return name_of_catKeeper;
	}
	public void setName_of_catKeeper(String name_of_catKeeper) {
		this.name_of_catKeeper = name_of_catKeeper;
	}	
}
