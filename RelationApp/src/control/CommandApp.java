package control;

import javax.swing.ImageIcon;

public enum CommandApp {

	COMMAND_ADD_PERSON("COMMAND_ADD_PERSON", "Agregar persona", "/img/addPerson.png"),
	COMMAND_AFFINITY("COMMAND_AFFINITY", "Afinidad", ""),
	COMMAND_SIGN_IN("COMMAND_SIGN_IN", "Agregar", ""), 
	COMMAND_USER_LIST("COMMAND_USER_LIST", "Lista", ""), 
	COMMAND_SELECT_FILE("COMMAND_SELECT_FILE", "Seleccionar imagen", "");
	
	private String command;
	private String title;
	private String imagePath;
	
	private CommandApp(String command, String title, String imagePath) {
		this.command = command;
		this.title = title;
		this.imagePath = imagePath;
	}

	public String getCommand() {
		return command;
	}

	public String getTitle() {
		return title;
	}
	
	public ImageIcon getIcon() {
		return new ImageIcon(getClass().getResource(imagePath));
	}
}