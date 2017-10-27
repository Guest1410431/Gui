package Menu;

import java.awt.Color;
import java.awt.Graphics;

public class Button
{
	private int xPos;
	private int yPos;
	
	private int width;
	private int height;
	
	private String buttonName;
	
	public Button(int xPos, int yPos, String buttonName)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		
		width = 50;
		height = 20;
		
		this.buttonName = buttonName;
	}
	public boolean contains(int mouseX, int mouseY)
	{
		return (xPos <= mouseX && xPos+width >= mouseX && yPos <= mouseY && yPos+height >= mouseY);
	}
	public void mouseClicked()
	{
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
		g.drawString(buttonName, (int)(xPos + (width/2)-20), yPos+ (height/2) + 5);
	}
}
