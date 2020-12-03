package pl.martitafilix.cats.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cat {

	static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-mm-dd");
	
	private	String	name;
	private	Date 	date_of_birth;
	private Float 	weight;
	private String 	name_of_catKeeper;

	
	public Cat() {}
	
	public Cat(String name, Date date_of_birth, Float weight, String name_of_catKeeper) {

		this.name = name;
		this.date_of_birth = date_of_birth;
		this.weight = weight;
		this.name_of_catKeeper = name_of_catKeeper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
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
	
	public String introduceYourself() {

		String txt;
		txt =  "Cześć, jestem "			+ this.name + " - ";
		txt += "\nUrodziłem się dn: " 	+ SDF.format(this.date_of_birth) + " - ";
		txt += "\nWażę: " 				+ this.weight 	+ " - ";
		txt += "\nOpiekuje się mną: " 	+ this.name_of_catKeeper;
		return txt;
	}
}
