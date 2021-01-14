package pl.martitafilix.celebrity.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import pl.martitafilix.celebrity.model.Celebrity;

public class CelebrityGUI extends JFrame {

	public CelebrityGUI() {
		this.InitializeComponent();
	}
	//
	// intitialize:
	//
	private void InitializeComponent() {

		this.setName("The celebrity app");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);		
		
		Container cp = getContentPane();
	    cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

		cp.add(this.getMainPanel());
		cp.add(this.getCelebrityDescAreaPanel());
		cp.add(this.getTalentCheckingButtonPanel());
		
		this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		this.setLocation(400, 70);
		this.setResizable(false); this.setSize(600,600);
//		this.pack();
		this.setVisible(true);
	}
	//
	// getPanels:
	//
	private JPanel getMainPanel() {
		
		JPanel _panel = new JPanel(new BorderLayout());
		_panel.setBorder(BorderFactory.createTitledBorder("Celebrities"));

		
		this._listModel 			= new DefaultListModel<Celebrity>();
		this._list_celebrities		= new JList<Celebrity>(this._listModel);
		this._list_celebrities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this._button_addCelebrity 	= new JButton("Add a new celebrity");

		_panel.add(new JScrollPane(_list_celebrities),	BorderLayout.NORTH);
		_panel.add(_button_addCelebrity, 				BorderLayout.SOUTH);

		return _panel;
	}
	
	private JPanel getTalentCheckingButtonPanel() {
		
		JPanel _panel = new JPanel(new FlowLayout());
		_panel.setBorder(BorderFactory.createTitledBorder("Check talents"));

		this._button_printIfSinger 	= new JButton("Check if there is a singer");
		this._button_printIfActor 	= new JButton("Check if there is a actor");
		this._button_printIfDancer 	= new JButton("Check if there is a dancer");
		
		_panel.add(_button_printIfSinger);
		_panel.add(_button_printIfActor);
		_panel.add(_button_printIfDancer);
		
		return _panel;
	}
	
	private JPanel getCelebrityDescAreaPanel() {
		
		JPanel _panel = new JPanel();
		
		this._area_celebrityDesc = new JTextArea("Information about the celebrity.");
		this._area_celebrityDesc.setFont(new Font("Serif", Font.ITALIC, DEFAULT_SIZE));
		
		_panel.add(_area_celebrityDesc);
		return _panel;
	}
	//
	// getters:
	//
	public DefaultListModel<Celebrity> get_listModel() {
		return _listModel;
	}
	
	public JList<Celebrity> get_list_celebrities() {
		return _list_celebrities;
	}
	
	public JTextArea get_area_celebrityDesc() {
		return this._area_celebrityDesc;
	}
	
	public JButton get_button_addCelebrity() {
		return _button_addCelebrity;
	}
	
	public JButton get_button_printIfSinger() {
		return _button_printIfSinger;
	}

	public JButton get_button_printIfActor() {
		return _button_printIfActor;
	}

	public JButton get_button_printIfDancer() {
		return _button_printIfDancer;
	}
	//
	// setters:
	//
	public void set_list_celebrities(JList<Celebrity> _list_celebrities) {
		this._list_celebrities = _list_celebrities;
	}
	//
	// fields:
	//
	private static final long 	serialVersionUID 	= 1L;
	private static final int 	DEFAULT_WIDTH 		= 500;
	private static final int 	DEFAULT_HEIGHT 		= 500;
	private static final int 	DEFAULT_SIZE 		= 13;
	
	private DefaultListModel<Celebrity> _listModel;
	private JList<Celebrity>	_list_celebrities;
	
	private JButton 			_button_addCelebrity;
	private JButton 			_button_printIfSinger;
	private JButton 			_button_printIfActor;
	private JButton 			_button_printIfDancer;
	
	private JTextArea 			_area_celebrityDesc;
}
