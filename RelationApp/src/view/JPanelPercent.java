package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import control.ConstantList;

public class JPanelPercent extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private int percent;
	
	public JPanelPercent() {
		percent = 0;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(80, 0, ConstantList.WIDTH_PERCENT, ConstantList.HIGTH_PERCENT);
		g.setColor(Color.BLACK);
		g.fillRect(80, 0, calculatePercent(), ConstantList.HIGTH_PERCENT);
		g.setColor(ConstantList.APP_COLOR);
		g.setFont(ConstantList.WORD_FONT);
		g.drawString(percent + "%", 210, 30);
	}
	
	private int calculatePercent() {
		return percent*ConstantList.WIDTH_PERCENT/100;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
}