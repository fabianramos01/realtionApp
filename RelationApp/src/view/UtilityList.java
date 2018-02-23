package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import control.CommandApp;
import control.ConstantList;
import control.Controller;

public class UtilityList {
	
	public static JLabel createJLabel(String word) {
		JLabel jLabel = new JLabel(word);
		jLabel.setFont(ConstantList.LABEL_FONT);
		jLabel.setForeground(ConstantList.APP_COLOR);
		jLabel.setHorizontalAlignment(JLabel.CENTER);
		return jLabel;
	}
	
	public static ImageIcon scaledImage(String path, int size) {
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(size,size,Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImg);
	}
	
	public static ImageIcon scaledImageSrc(ImageIcon icon, int size) {
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(size,size,Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImg);
	}
	
	public static JButton createJButton(CommandApp command, Controller controller) {
		JButton jButton = new JButton();
		jButton.setOpaque(false);
		jButton.setContentAreaFilled(false);
		jButton.setBorderPainted(false);
		jButton.setIcon(command.getIcon());
		jButton.setToolTipText(command.getTitle());
		jButton.setActionCommand(command.getCommand());
		jButton.addActionListener(controller);
		return jButton;
	}
	
	public static JButton createJButtonText(CommandApp command, Controller controller) {
		JButton jButton = new JButton();
		jButton.setBorderPainted(false);
		jButton.setBackground(ConstantList.APP_COLOR);
		jButton.setText(command.getTitle());
		jButton.setFont(ConstantList.LABEL_FONT);
		jButton.setForeground(Color.WHITE);
		jButton.setActionCommand(command.getCommand());
		jButton.addActionListener(controller);
		return jButton;
	}
}