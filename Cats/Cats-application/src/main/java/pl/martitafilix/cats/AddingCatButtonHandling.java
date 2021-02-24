package pl.martitafilix.cats;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import pl.martitafilix.cats.dao.CatShelter;
import pl.martitafilix.cats.model.Cat;

public class AddingCatButtonHandling extends ButtonHandling {
	
	public AddingCatButtonHandling(CatShelter shelter, JLabel label) {
		super(shelter, label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Cat new_cat = new Cat();
		new_cat = new GettingDataFromUser().getCat();
		
		String str_cat = new_cat.introduceYourself();
		String label_html = "<html>" + str_cat.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>";
		this._label_showInfo.setText(label_html);

		this.catShelter.addCat(new_cat);
		JOptionPane.showMessageDialog(null, "Poprawnie dodano kota do schroniska!", "Info", JOptionPane.INFORMATION_MESSAGE);
	}
}
