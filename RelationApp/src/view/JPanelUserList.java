package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import control.ConstantList;
import model.Gender;
import model.Person;

public class JPanelUserList extends JPanel {

	private static final long serialVersionUID = 1L;

	private JList<String> userListMale;
	private JList<String> userListFemale;

	public JPanelUserList() {
		setLayout(new GridLayout(1, 2));
		setBorder(BorderFactory.createTitledBorder(null, ConstantList.USER_LIST, 
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
				ConstantList.LABEL_FONT, ConstantList.APP_COLOR));
		userListMale = new JList<String>();
		add(userListMale);
		userListFemale = new JList<String>();
		add(userListFemale);
	}
	
	public void loadList(ArrayList<Person> list) {
		remove(userListMale);
		remove(userListFemale);
		DefaultListModel<String> modelMale = new DefaultListModel<String>();
		userListMale = new JList<String>(modelMale);
		userListMale.setFont(ConstantList.WORD_FONT);
		DefaultListModel<String> modelFemale = new DefaultListModel<String>();
		userListFemale = new JList<String>(modelFemale);
		userListFemale.setFont(ConstantList.WORD_FONT);
		ListRender male = new ListRender();
		ListRender female = new ListRender();
		userListMale.setCellRenderer(male);
		userListFemale.setCellRenderer(female);
		if (!list.isEmpty() || list.size() < 1) {
			for (Person person : list) {
				if (person.getGender().equals(Gender.Masculino)) {
					modelMale.addElement(person.getId() + "-" + person.getName());
					male.setPath(person.getPhoto());
				} else {
					modelFemale.addElement(person.getId() + "-" + person.getName());
					female.setPath(person.getPhoto());
				}	
			}
		} else if (list.size() == 1) {
			if (list.get(0).getGender().equals(Gender.Femenino)) {
				modelMale.addElement(list.get(0).getId() + "-" + list.get(0).getName());
				modelFemale.addElement(ConstantList.EMPTY_LIST);
			} else {
				modelFemale.addElement(list.get(0).getId() + "-" + list.get(0).getName());
				modelMale.addElement(ConstantList.EMPTY_LIST);
			}
		}else {
			modelFemale.addElement(ConstantList.EMPTY_LIST);
			modelMale.addElement(ConstantList.EMPTY_LIST);
		}
		add(userListFemale);
		add(userListMale);
	}
	
	public String[] getSelectedItems() {
		String[] items = {userListMale.getSelectedValue(), userListFemale.getSelectedValue()};
		return items;
	}
}