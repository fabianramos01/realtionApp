package view;

import java.awt.Toolkit;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import control.CommandApp;
import control.ConstantList;
import control.Controller;

public class JMenuBarUser extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	private JMenu userOption;
	private JMenuItem userList;
	private JMenuItem newUser;
	
	public JMenuBarUser(Controller controller) {
		userOption = new JMenu(ConstantList.USER);
		newUser = new JMenuItem(CommandApp.COMMAND_SIGN_IN.getTitle());
		newUser.addActionListener(controller);
		newUser.setActionCommand(CommandApp.COMMAND_SIGN_IN.getCommand());
		newUser.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		userOption.add(newUser);
		userList = new JMenuItem(CommandApp.COMMAND_USER_LIST.getTitle());
		userList.addActionListener(controller);
		userList.setActionCommand(CommandApp.COMMAND_USER_LIST.getCommand());
		userList.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		userOption.add(userList);
		add(userOption);
	}
}