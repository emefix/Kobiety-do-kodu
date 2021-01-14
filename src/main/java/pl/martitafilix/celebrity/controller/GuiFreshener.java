package pl.martitafilix.celebrity.controller;

import pl.martitafilix.celebrity.model.Celebrity;

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
