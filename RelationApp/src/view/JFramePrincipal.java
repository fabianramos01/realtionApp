package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.CommandApp;
import control.ConstantList;
import control.Controller;
import model.Person;

public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Controller controller;
	private JPanelUserList jPanelUserList;
	private JPanelSignIn jPanelSignIn;
	private JPanel jPanel;
	private JPanelPercent jPanelPercent;

	public JFramePrincipal(Controller controller) {
		this.controller = controller;
		setTitle(ConstantList.TITLE);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_PATH)).getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPanel = new JPanel(new BorderLayout());
		jPanelUserList = new JPanelUserList(); 
		jPanelSignIn = new JPanelSignIn(controller);
		setJMenuBar(new JMenuBarUser(controller));
		load(new ArrayList<Person>());
	}
	
	public void load(ArrayList<Person> list) {
		jPanel.removeAll();
		jPanel.updateUI();
		setResizable(true);
		setSize(ConstantList.WIDTH, ConstantList.HEIGTH);
		setResizable(false);
		jPanelUserList.loadList(list);
		jPanel.add(jPanelUserList, BorderLayout.CENTER);
		panelAffinity();
		add(jPanel);
		setVisible(true);
	}
	
	public void signIn() {
		jPanel.removeAll();
		jPanel.updateUI();
		setResizable(true);
		setSize(ConstantList.WIDTH_FORM, ConstantList.HEIGTH_FORM);
		setResizable(false);
		jPanel.add(jPanelSignIn);
		add(jPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void panelAffinity() {
		JPanel jPanelAffinity = new JPanel(new BorderLayout());
		jPanelAffinity.add(UtilityList.createJButtonText(CommandApp.COMMAND_AFFINITY, controller), BorderLayout.WEST);
		jPanelPercent = new JPanelPercent();
		jPanelAffinity.add(jPanelPercent, BorderLayout.CENTER);
		jPanel.add(jPanelAffinity, BorderLayout.SOUTH);
	}
	
	public void setPercent(int affinity) {
		jPanelPercent.setPercent(affinity);
		jPanelPercent.repaint();
	}
	
	public String[] newUser() {
		return jPanelSignIn.getInfo();
	}
	
	public void loadJFileChooser() {
		jPanelSignIn.loadJFileChooser();
	}
	
	public void resetForm() {
		jPanelSignIn.resetForm();
	}
	
	public String[] userAffinity() {
		return jPanelUserList.getSelectedItems();
	}
}