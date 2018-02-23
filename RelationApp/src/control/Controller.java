package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Person;
import model.PersonManager;
import persistence.FileManager;
import view.JFramePrincipal;

public class Controller implements ActionListener {

	private JFramePrincipal principalFrame;
	private PersonManager personManager;
	
	public Controller() {
		principalFrame = new JFramePrincipal(this);
		personManager = new PersonManager();
		loadFile();
	}
	
	private void loadFile() {
		if (new File(ConstantList.PATH_FILE).exists()) {
			for (Person person : FileManager.loadUsers(ConstantList.PATH_FILE)) {
				personManager.addPerson(person);
				principalFrame.load(personManager.getPersonGroup());
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (CommandApp.valueOf(e.getActionCommand())) {
		case COMMAND_ADD_PERSON:
			addPerson();
			break;
		case COMMAND_AFFINITY:
			calculateAffinity();
			break;
		case COMMAND_SIGN_IN:
			principalFrame.signIn();
			break;
		case COMMAND_USER_LIST:
			principalFrame.load(personManager.getPersonGroup());
			break;
		case COMMAND_SELECT_FILE:
			principalFrame.loadJFileChooser();
			break;
		}
	}

	public void addPerson() {
		String[] info = principalFrame.newUser();
		Random random = new Random();
		if (validateInfo(info)) {
			try {
				Person person = new Person(random.nextInt(1000)+1, info[0], info[1], info[2], info[3], info[4]);
				personManager.addPerson(person);
				FileManager.writeUser(ConstantList.PATH_FILE, personManager.getPersonGroup());
				JOptionPane.showMessageDialog(null, ConstantList.CONFIRMATION, ConstantList.OK, JOptionPane.INFORMATION_MESSAGE);
				principalFrame.resetForm();
				principalFrame.load(personManager.getPersonGroup());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, ConstantList.INFO_ERROR , ConstantList.ERROR, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public boolean validateInfo(String[] userInfo) {
		for (int i = 0; i < userInfo.length; i++) {
			if (userInfo[i].equals("")) {
				return false;
			}
		}
		return true;
	}
	
	public void calculateAffinity() {
		String[] users = principalFrame.userAffinity();
		double affinity = personManager.afinity(personManager.searchPerson(users[0]), personManager.searchPerson(users[1]));
		principalFrame.setPercent((int) affinity);
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}