package pl.martitafilix.cats.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pl.martitafilix.cats.model.CatShelter;
import pl.martitafilix.cats.controller.AddingCatButtonHandling;
import pl.martitafilix.cats.controller.ShowCatsButtonHandling;
import pl.martitafilix.cats.controller.ButtonHandling;

public class AppInterface extends JFrame {

	//region Constructor
	public AppInterface() {
		this.InitializeComponent();
	}
	//endregion
	
	//region Initializing the components of app window.
	private void InitializeComponent() {
		//
		// Initializing
		//
		String str_appName	= "The cats app";
		this.setName(str_appName);

		this._panel_choiceButtons	= new JPanel(new GridLayout(3,1));
		this._panel_showInfo		= new JPanel(new FlowLayout());
		
		String str_addCat 	= "Dodaj nowego kota";
		String str_showCats = "Pokaż koty";
		String str_exit 	= "Zakończ";
		
		this._label_showInfo	= new JLabel("", SwingConstants.LEFT);
		
		this._button_addCat		= new JButton(str_addCat);
		this._button_showCats	= new JButton(str_showCats);
		this._button_appExit	= new JButton(str_exit);
		//
		// JFrame
		//		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(new BorderLayout());
		
		this.add(_panel_choiceButtons, BorderLayout.NORTH);
		this.add(_panel_showInfo, BorderLayout.SOUTH);
		//
		// _panel_choiceButtons
		//
		this._panel_choiceButtons.add(_button_addCat);
		this._panel_choiceButtons.add(_button_showCats);
		this._panel_choiceButtons.add(_button_appExit);
		
		this._panel_showInfo.add(_label_showInfo);
		//
		// buttons - addActionListener
		//
		this.catShelter = new CatShelter();
		this._button_addCat.addActionListener(new AddingCatButtonHandling(catShelter, _label_showInfo));
		this._button_showCats.addActionListener(new ShowCatsButtonHandling(catShelter,  _label_showInfo));
		this._button_appExit.addActionListener(new ButtonHandling());
		
		this.setLocation(500, 300);
		this.pack();
		this.setVisible(true);
	}
	
	// endregion	

	//region Fields	
	private static final long serialVersionUID = 1L;
	
	private JPanel	_panel_choiceButtons;
	private JPanel	_panel_showInfo;

	private JLabel	_label_showInfo;
	
	private JButton	_button_addCat;
	private JButton	_button_showCats;
	private JButton	_button_appExit;
	
	private CatShelter catShelter;
	// endregion	
}
