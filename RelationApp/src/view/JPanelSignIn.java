package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.freixas.jcalendar.JCalendarCombo;

import control.CommandApp;
import control.ConstantList;
import control.Controller;
import model.Gender;
import model.Ocupation;

public class JPanelSignIn extends JPanel {

	private static final long serialVersionUID = 1L;

	private Controller controller;
	private JTextField userName;
	private JComboBox<Gender> userGender;
	private JComboBox<Ocupation> userOcupation;
	private JCalendarCombo birthDate;
	private JFileChooser chooserImg;
	
	public JPanelSignIn(Controller controller) {
		this.controller = controller;
		setLayout(new BorderLayout());
		informationPanel();
	}

	public void informationPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(10, 1));
		jPanel.add(UtilityList.createJLabel(ConstantList.NAME));
		userName = new JTextField();
		userName.setHorizontalAlignment(JTextField.CENTER);
		userName.setFont(ConstantList.WORD_FONT);
		jPanel.add(userName);
		jPanel.add(UtilityList.createJLabel(ConstantList.BIRTHDATE));
		birthDate = new JCalendarCombo();
		birthDate.setFont(ConstantList.WORD_FONT);
		jPanel.add(birthDate);
		jPanel.add(UtilityList.createJLabel(ConstantList.GENDER));
		userGender = new JComboBox<Gender>(Gender.values());
		userGender.setFont(ConstantList.WORD_FONT);
		jPanel.add(userGender);
		jPanel.add(UtilityList.createJLabel(ConstantList.OCUPATION));
		userOcupation = new JComboBox<Ocupation>(Ocupation.values());
		userOcupation.setFont(ConstantList.WORD_FONT);
		jPanel.add(userOcupation);
		jPanel.add(UtilityList.createJButtonText(CommandApp.COMMAND_SELECT_FILE, controller));
		jPanel.add(UtilityList.createJButton(CommandApp.COMMAND_ADD_PERSON, controller));
		add(jPanel, BorderLayout.CENTER);
	}
	
	public void loadJFileChooser() {
		chooserImg = new JFileChooser();
		chooserImg.setFileFilter(new FileNameExtensionFilter(".jpg", "JPG"));
		chooserImg.setDialogTitle(ConstantList.PHOTO);
		chooserImg.showOpenDialog(this);
	}
	
	public String[] getInfo() {
		Date date = birthDate.getDate();
		SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy");
		String[] info = {chooserImg.getSelectedFile().getPath() ,userName.getText(), sFormat.format(date),
				userGender.getSelectedItem().toString(), userOcupation.getSelectedItem().toString()};
		return info;
	}
	
	public void resetForm() {
		userName.setText("");
	}
}