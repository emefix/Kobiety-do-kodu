package pl.martitafilix.celebrities;

import pl.martitafilix.celebrities.dao.PudelekReading;
import pl.martitafilix.celebrities.dao.Reading;

public class CelebrityApp {

	public static void main(String[] args) {
		
		CelebrityGUI 	gui 	= new CelebrityGUI();
		Reading 		pudelek = new PudelekReading();
		
		new CelebrityGUIController(gui, pudelek);
	}
}
