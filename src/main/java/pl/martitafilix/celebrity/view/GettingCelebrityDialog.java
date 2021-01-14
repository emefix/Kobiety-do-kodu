package pl.martitafilix.celebrity.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GettingCelebrityDialog extends JDialog {

	public GettingCelebrityDialog() {
		this.InitializeComponent();
	}
	//
	// intitialize:
	//
	private void InitializeComponent() {

		this.setLayout(new BorderLayout(10, 10));

		Container cp = getContentPane();
		cp.add(this.getInputNamePanel(), 	BorderLayout.NORTH);
		cp.add(this.getTalentChBoxPanel(), 	BorderLayout.CENTER);
		cp.add(this.getButtonPanel(), 		BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Adding the new celebrity");
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	//
	// getPanels:
	//
	private JPanel getInputNamePanel() {

		JPanel _panel 		= new JPanel();
		this._field_name 	= new JTextField(20);
		this._label_getName = new JLabel("Name and Last name: ");

		_panel.add(this._label_getName);
		_panel.add(this._field_name);
		
		return _panel;
	}

	private JPanel getTalentChBoxPanel() {

		JPanel _panel = new JPanel(new GridLayout(3, 2, 20, 10));
		_panel.setBorder(BorderFactory.createTitledBorder("What talent? "));

		String[] talent = new String[] { "sing", "act", "dance" };
		this._chbox_isCanSing 	= new JCheckBox(talent[0], false);
		this._chbox_isCanAct 	= new JCheckBox(talent[1], false);
		this._chbox_isCanDance 	= new JCheckBox(talent[2], false);

		this._label_canSing 	= new JLabel("Can sing.");
		this._label_canAct 		= new JLabel("Can act.");
		this._label_canDance 	= new JLabel("Can dance.");

		_panel.add(this._label_canSing);
		_panel.add(this._chbox_isCanSing);
		
		_panel.add(this._label_canAct);
		_panel.add(this._chbox_isCanAct);
		
		_panel.add(this._label_canDance);
		_panel.add(this._chbox_isCanDance);

		return _panel;
	}
	//
	// getters:
	//
	private JPanel getButtonPanel() {

		JPanel _panel = new JPanel();

		String[] options 	= { "OK", "Cancel" };
		this._button_OK 	= new JButton(options[0]);
		this._button_cancel = new JButton(options[1]);

		_panel.add(_button_OK);
		_panel.add(_button_cancel);

		return _panel;
	}

	public JCheckBox get_chbox_isCanSing() {
		return _chbox_isCanSing;
	}

	public JCheckBox get_chbox_isCanAct() {
		return _chbox_isCanAct;
	}

	public JCheckBox get_chbox_isCanDance() {
		return _chbox_isCanDance;
	}

	public JButton get_button_OK() {
		return _button_OK;
	}

	public JButton get_button_cancel() {
		return _button_cancel;
	}

	public JTextField get_field_name() {
		return _field_name;
	}
	//
	// fields:
	//
	private static final long serialVersionUID = 1L;
	
	private JTextField 	_field_name;

	private JCheckBox 	_chbox_isCanSing;
	private JCheckBox 	_chbox_isCanAct;
	private JCheckBox 	_chbox_isCanDance;

	private JLabel 		_label_getName;
	private JLabel 		_label_canSing;
	private JLabel 		_label_canAct;
	private JLabel 		_label_canDance;

	private JButton 	_button_OK;
	private JButton 	_button_cancel;
}
