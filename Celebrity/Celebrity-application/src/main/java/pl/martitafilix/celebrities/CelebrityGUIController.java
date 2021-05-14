package pl.martitafilix.celebrities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pl.martitafilix.celebrities.dao.Reading;
import pl.martitafilix.celebrities.domain.Celebrity;

public class CelebrityGUIController {

	private CelebrityGUI 	_gui;
	private Reading 		reading;
	private GuiFreshener	guiFreshener;

	public CelebrityGUIController(CelebrityGUI gui, Reading reading) {

		this._gui 			= gui;
		this.reading 		= reading;
		this.guiFreshener 	= new GuiFreshener(this);
		
		this.initialize();
	}

	private void initialize() {
		
		this.loadCelebrities();
		// anonymous class
//		this._gui.get_button_addCelebrity().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				gettingCelebrityDialogOpen();
//			}
//		});
		// lambda expression
		this._gui.get_button_addCelebrity().addActionListener(e -> {
			gettingCelebrityDialogOpen();
		});
		// anonymous class
		this._gui.get_list_celebrities().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				listValueChanged(e);
			}
			private void listValueChanged(ListSelectionEvent e) {
				if(! _gui.get_list_celebrities().getValueIsAdjusting()) {
					int index = _gui.get_list_celebrities().getSelectedIndex();
					displaySelectedCelebrity(index);
				}
			}
		});
		// anonymous class - double use
		this._gui.get_button_printIfSinger().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTalent(new CheckIfSinger(), "Singers");
			}
		}); 
		// lambda expression - double use
		this._gui.get_button_printIfActor().addActionListener((ActionEvent e) -> {
				printTalent((Celebrity c) -> {return c.isCanAct();}, "Actors");
		}); 
		//lambda expression - double use
		this._gui.get_button_printIfDancer().addActionListener(e -> {
				printTalent(c -> c.isCanDance(), "Dancers");
		}); 
	}
	
	private void loadCelebrities() {
		
		this.reading.getCelebrities().addAll(
			Arrays.asList(
				new Celebrity() {{	setName("Igor Herbut");			setCanSing(true);	}},
				new Celebrity() {{	setName("Kayah");				setCanSing(true);	}},
				new Celebrity() {{	setName("Maciej Zakościelny");	setCanAct(true);	}},
				new Celebrity() {{	setName("Augustin Egurrola");	setCanDance(true);	}},
				new Celebrity() {{	setName("Marcin Hakiel");		setCanDance(true);	}},
				new Celebrity() {{	setName("Edyta Górniak");		setCanSing(true);	}}
			)
		);
		List<Celebrity> celebrities = this.reading.getCelebrities();
		for (Celebrity c : celebrities) 
			this.updateCelebrityList(c);
	}

	private void gettingCelebrityDialogOpen() {

		GettingCelebrityDialog _dialog = new GettingCelebrityDialog();
		new GettingCelebrityDialogController(_dialog, this.guiFreshener, this.reading);
	}

	private void displaySelectedCelebrity(int index) {
		
		String str_celebrity = this.reading.getCelebrities().get(index).printData();
		this._gui.get_area_celebrityDesc().setText(str_celebrity);
	}
	
	public void updateCelebrityList(Celebrity celebrity) {		
		this._gui.get_listModel().addElement(celebrity);
	}
	
	private void printTalent(I_CheckTalent checker, String talent) { 
		
		this._gui.get_area_celebrityDesc().setText(talent + ":\n");
		
		List<Celebrity> celebrities = this.reading.getCelebrities();
		// Sorting the collection, a stream and a lambda expression 
		celebrities.stream()
			.sorted((Celebrity c1, Celebrity c2) -> (
					c1.getName().compareTo(c2.getName())))
			.forEach((Celebrity c) -> {
				if (checker.test(c)) 
					this._gui.get_area_celebrityDesc().append(c.getName() + ",\n");
			});
	}
	//
	// Instead of creating the CheckTalent interface for testing, we can 
	// use the Predicate interface from java.util.function package.
	//
	private void printTalent2(Predicate<Celebrity> checker, String talent) { 
		
		this._gui.get_area_celebrityDesc().setText(talent + ":\n");
		
		List<Celebrity> celebrities = this.reading.getCelebrities();
		// Sorting the collection, lambda expression 
		Comparator<Celebrity> sortByName = (Celebrity c1, Celebrity c2) -> (
			c1.getName().compareTo(c2.getName())
		);
		celebrities.sort(sortByName);
		// generically
		for (Celebrity c: celebrities) 
			if(checker.test(c)) 
				this._gui.get_area_celebrityDesc().append(c.getName() + ",\n");
	}
}