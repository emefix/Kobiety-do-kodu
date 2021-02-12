package pl.martitafilix.celebrities;

public class CelebrityApp {

	public static void main(String[] args) {
		
		CelebrityGUI 	gui 	= new CelebrityGUI();
		Reading 		pudelek = new PudelekReading();
		
		new CelebrityGUIController(gui, pudelek);
	}
}
