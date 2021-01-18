package pl.martitafilix.cats.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import pl.martitafilix.cats.model.Cat;
import pl.martitafilix.cats.model.CatShelter;

public class ShowCatsButtonHandling extends ButtonHandling {

	public ShowCatsButtonHandling(CatShelter shelter, JLabel label) {
		super(shelter, label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		displayAllCats();
		
		int selected = new GettingDataFromUser().getCatIndex();
		displayCat(selected);
	}
	
	private void displayAllCats() {
		Cat cat;
		String label_html = "<html>";
		List<Cat> cats = this.catShelter.getCats();

//		for (Cat c : cats)	
		for (int i = 0; i < cats.size(); i++)	{
			cat = cats.get(i);
			label_html += (i+1) + ": " + cat.getName() + "<br/>";
		}
		label_html += "</html>";
		this._label_showInfo.setText(label_html);
	}
	
	private void displayCat(int selected) {
		Cat cat;
		String label_html = "<html>";
		List<Cat> cats = this.catShelter.getCats();
		
		if(cats.size() > selected-1) {
			cat = cats.get(selected-1);
			String str_cat = cat.introduceYourself();
			label_html = "<html>" + str_cat.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>";
			this._label_showInfo.setText(label_html);			
		} else {
			JOptionPane.showMessageDialog(null,
                    "Brak kota o wybranym numerze!", "Błąd", JOptionPane.ERROR_MESSAGE);
		}
	}
}
