package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import control.ConstantList;

@SuppressWarnings("rawtypes")
public class ListRender extends JLabel implements ListCellRenderer {

	private static final long serialVersionUID = 1L;

	private String path;

	public ListRender() {
		super();
		path = "";
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		String text = value.toString();
		setText(text);
		ImageIcon img = new ImageIcon(path);
		setIcon(new ImageIcon(img.getImage().getScaledInstance(ConstantList.IMG_SIZE, ConstantList.IMG_SIZE, Image.SCALE_DEFAULT)));
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return this;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}
