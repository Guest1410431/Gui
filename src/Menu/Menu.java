package Menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Menu implements KeyListener
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int headerHeight;

	private Button submitButton;

	private TextField[] textFields;

	private static int keyFocus;

	public Menu(int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		width = 300;
		height = 200;
		headerHeight = 40;

		keyFocus = 0;

		updatePositions();
	}

	private void updatePositions()
	{
		textFields = new TextField[4];

		submitButton = new Button(xPos + width - 60, yPos + height + 10, "Submit");

		textFields[0] = new TextField(1000, 1000, "");
		textFields[1] = new TextField(xPos + 10, yPos + 50, "Start Node");
		textFields[2] = new TextField(xPos + 10, yPos + 80, "End Node");
		textFields[3] = new TextField(xPos + 10, yPos + 110, "Edge Weight");
	}

	public void mouseClicked(int mouseX, int mouseY)
	{
		for (int i = 1; i < textFields.length; i++)
		{
			if (textFields[i].contains(mouseX, mouseY))
			{
				keyFocus = i;
				textFields[i].setFocus(true);
			}
			else
			{
				textFields[i].setFocus(false);
			}
		}
		if (submitButton.contains(mouseX, mouseY))
		{
			System.out.println("Node From: " + textFields[1].getInput() + " | Node To: " + textFields[2].getInput()
					+ " | Edge Weight: " + textFields[3].getInput());
			xPos = 1000;
			yPos = 1000;
			updatePositions();
		}
	}

	public boolean contains(int mouseX, int mouseY)
	{
		return (xPos <= mouseX && xPos + width >= mouseX && yPos <= mouseY && yPos + height + headerHeight >= mouseY);
	}

	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}

	public void render(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(xPos, yPos, width, headerHeight);

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(xPos, yPos + headerHeight, width, height);

		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, headerHeight);
		g.drawRect(xPos, yPos + headerHeight, width, height);
		g.setColor(Color.WHITE);
		g.drawString("Add Edge to Graph", xPos + 10, yPos + 20);

		for (int i = 1; i < textFields.length; i++)
		{
			textFields[i].render(g);
		}
		submitButton.render(g);
	}
	public void keyPressed(KeyEvent e)
	{

	}

	public void keyReleased(KeyEvent e)
	{

	}

	public void keyTyped(KeyEvent e)
	{
		if(keyFocus != 0)
		{
			String input = textFields[keyFocus].getInput();
			
			if(e.getKeyChar() == '\b')
			{
				if(input.length() > 0)
				{
					input = input.substring(0, input.length()-1);
				}
			}
			else
			{
				input += e.getKeyChar(); 
			}
			textFields[keyFocus].setInput(input);
		}
	}
}













