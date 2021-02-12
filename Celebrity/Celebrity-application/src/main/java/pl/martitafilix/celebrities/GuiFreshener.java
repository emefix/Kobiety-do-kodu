package pl.martitafilix.celebrities;

import pl.martitafilix.celebrities.domain.Celebrity;

public class GuiFreshener {

	private CelebrityGUIController guiController;

	public GuiFreshener(CelebrityGUIController guiController) {
		this.guiController = guiController;
	}

	public void notifyGui(Celebrity celebrity) {
		this.guiController.updateCelebrityList(celebrity);
//		System.out.println("update");
	}
}
