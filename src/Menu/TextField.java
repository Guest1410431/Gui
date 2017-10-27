package Menu;

import java.awt.Color;
import java.awt.Graphics;

public class TextField
{	
	private boolean focus;
	
	private int xPos;
	private int yPos;
	private String placeHolderText;
	
	private int width;
	private int height;
	
	private String inputText;
	private String test;
	
	public TextField(int xPos, int yPos, String placeHolderText)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.placeHolderText = placeHolderText;

		focus = false;
		width = 200;
		height = 20;
		inputText = "";
		test = "";
	}
	public boolean contains(int mouseX, int mouseY)
	{
		return (xPos <= mouseX && xPos+width >= mouseX && yPos <= mouseY && yPos+height >= mouseY);
	}
	public void setInput(String inputText)
	{
		this.inputText = inputText;
		this.test = "hello";
		
		System.out.println("Input Text: " + this.inputText + " | Length: " + inputText.length());
	}
	public String getInput()
	{
		return inputText;
	}
	public void setFocus(boolean focus)
	{
		this.focus = focus;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
		
		if(focus)
		{
			g.drawRect(xPos-1, yPos-1, width+2, height+2);
		}
		if(test.length() == 0)
		{
			g.setColor(Color.GRAY);
			g.drawString(placeHolderText, xPos + 10, yPos+ (height/2) + 5);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.drawString(inputText, xPos + 10, yPos + (height/2) + 5);
		}
		g.drawString("Input Text: [" + inputText + "] | Length: " + inputText.length(), 100, 100);
		g.drawString(" Test Text: [" + test + "] | Length: " + test.length(), 100, 120);
	}	
}
