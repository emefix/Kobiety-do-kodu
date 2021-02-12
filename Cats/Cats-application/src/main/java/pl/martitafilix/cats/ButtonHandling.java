package pl.martitafilix.cats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ButtonHandling implements ActionListener {

	protected JLabel 		_label_showInfo;
	protected CatShelter 	catShelter;
	
	public ButtonHandling() {
	}
	
	public ButtonHandling(CatShelter shelter, JLabel label) {
		
		this._label_showInfo 	= label;
		this.catShelter 		= shelter;
	}

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
