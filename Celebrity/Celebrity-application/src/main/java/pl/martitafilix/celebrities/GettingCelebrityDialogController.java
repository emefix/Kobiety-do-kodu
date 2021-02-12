package pl.martitafilix.celebrities;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import pl.martitafilix.celebrities.domain.Celebrity;

public class GettingCelebrityDialogController {

	private GettingCelebrityDialog 	_dialog;
	private Reading 				reading;
	private Celebrity 				celebrity;
	private GuiFreshener			guiFreshener;

	public GettingCelebrityDialogController(GettingCelebrityDialog dialog, 
			GuiFreshener guiFreshener, Reading reading) {

		this._dialog 		= dialog;
		this.guiFreshener 	= guiFreshener;
		this.reading 		= reading;
		this.celebrity		= new Celebrity();

		this.initialize();
	}

	private void initialize() {
		// lambda expression
		this._dialog.get_button_OK().addActionListener((ActionEvent e) -> {
			button_add_OnClick();
		});
		// lambda expression
		this._dialog.get_button_cancel().addActionListener((e) -> { 
				button_cancel_OnClick();
		});
		// anonymous class
		this._dialog.get_chbox_isCanSing().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					 celebrity.setCanSing(true);
				else celebrity.setCanSing(false);
			}
		});
		// lambda expression
		this._dialog.get_chbox_isCanAct().addItemListener((ItemEvent e) -> { 
				if (e.getStateChange() == ItemEvent.SELECTED) 
					 celebrity.setCanAct(true); 
				else celebrity.setCanAct(false);
		});
		// lambda expression
		this._dialog.get_chbox_isCanDance().addItemListener(e -> {
				if (e.getStateChange() == ItemEvent.SELECTED) 
					 celebrity.setCanDance(true);
				else celebrity.setCanDance(false);
		});
	}

	private void button_add_OnClick() {

//		Pattern namePattern = Pattern.compile("[A-Z]{1}[a-z]*\\s+[A-Z]{1}[a-z]*");
		String name = _dialog.get_field_name().getText();
		this.celebrity.setName(name);
			
		this.reading.addCelebrity(celebrity);
		this.guiFreshener.notifyGui(celebrity);
		
		this._dialog.dispose();
	}

	private void button_cancel_OnClick() {
		this._dialog.dispose();
	}
}
