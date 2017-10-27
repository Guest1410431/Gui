package Utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Graph.Graph;
import Menu.Menu;

public class Window extends JPanel
{
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	
	private boolean paused = true;
	
	private Graph graph;

	private JFrame frame;
	
	private Menu menu;
	
	public Window()
	{
		// Set up Graph
		initGraph();

		// Set up Window
		initWindow();
	}

	private void initGraph()
	{
		graph = new Graph(100);
	}

	private void initWindow()
	{
		menu = new Menu(1000, 1000);
		
		setBackground(Color.WHITE);

		frame = new JFrame();

		frame.setTitle("Gui Messarounds");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.addKeyListener(menu);
		//frame.addKeyListener(menu.getEndTextField());
		//frame.addKeyListener(menu.getEdgeWeightTextField());
		
		frame.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				// Pause the app
				if(key == KeyEvent.VK_P || key == KeyEvent.VK_SPACE)
				{
					paused = !paused;
				}
				// Step update
				if(key == KeyEvent.VK_S)
				{
					graph.update();
				}
				// Close the window
				if (key == KeyEvent.VK_ESCAPE)
				{
					System.exit(1);
				}
			}
			public void keyReleased(KeyEvent e)
			{
			}

			public void keyTyped(KeyEvent e)
			{
			}
		});
		frame.addMouseListener(new MouseListener()
		{
			public void mouseReleased(MouseEvent e)
			{
				
			}
			public void mousePressed(MouseEvent e)
			{
				
			}
			public void mouseExited(MouseEvent e)
			{
				
			}
			public void mouseEntered(MouseEvent e)
			{
				
			}
			public void mouseClicked(MouseEvent e)
			{
				int mouseX = e.getX()-10;
				int mouseY = e.getY()-40;
				
				if(menu.contains(mouseX, mouseY))
				{
					menu.mouseClicked(mouseX, mouseY);
				}
				else if(!menu.contains(mouseX, mouseY))
				{
					if(menu.getX() == 1000 && menu.getY() == 1000) 
					{
						menu = new Menu(mouseX, mouseY);
					}
					else
					{
						menu = new Menu(1000, 1000);
					}
				}
			}
		});
		frame.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent e)
			{
				if(paused)
				{
					graph.debug(e.getX(), e.getY());
				}
			}
			public void mouseDragged(MouseEvent e)
			{
				
			}
		});
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Render here
		graph.render(g);
		menu.render(g);
	}

	public void update()
	{
		// Update here
		if(!paused)
		{
			graph.update();
		}
		repaint();
	}
}











