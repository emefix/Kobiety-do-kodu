package pl.martitafilix.celebrity;

import pl.martitafilix.celebrity.controller.CelebrityGUIController;
import pl.martitafilix.celebrity.model.PudelekReading;
import pl.martitafilix.celebrity.model.Reading;
import pl.martitafilix.celebrity.view.CelebrityGUI;

public class CelebrityApp {

	public static void main(String[] args) {
		
		CelebrityGUI 	gui 	= new CelebrityGUI();
		Reading 		pudelek = new PudelekReading();
		
		new CelebrityGUIController(gui, pudelek);
	}
}
