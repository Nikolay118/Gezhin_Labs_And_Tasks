package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Package1.FractalExplorer.ActionHandler;

public class FractalExplorer
{
	private int screenSize;
	private JImageDisplay display;
	private FractalGenerator generator;
	private Rectangle2D.Double range;
	
	public FractalExplorer(int size)
	{
		screenSize = size;
		range = new Rectangle2D.Double();
		generator = new Mandelbrot();
	}
	
	public void createAndShowGUI()
	{
		JFrame frame = new JFrame("Fractals");
		
		display = new JImageDisplay(screenSize, screenSize);
		
		JButton button = new JButton("Reset Display");
        button.setActionCommand("Reset Display");
        
		JButton button2 = new JButton("Save Image");
        button2.setActionCommand("Save Image");
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(new Mandelbrot());
		comboBox.addItem(new Tricorn());
		comboBox.addItem(new BurningShip());
		
		JLabel label = new JLabel("Fractal:");
		
		JPanel panelNorth = new JPanel();
		panelNorth.add(label);
		panelNorth.add(comboBox);
		
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		panelSouth.add(button2);
		
		frame.setLayout(new BorderLayout());
		frame.add(display, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelNorth, BorderLayout.NORTH);
		
		display.addMouseListener(new MouseListener());
		
        button.addActionListener(new ActionHandler());
        button2.addActionListener(new ActionHandler());
        
        comboBox.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				if (comboBox.getSelectedItem().toString().equals("Tricorn"))
        				{
        					range = new Rectangle2D.Double();
        					generator = new Tricorn();
            				generator.getInitialRange(range);
            				drawFractal();
            				System.out.println("Tricorn");
        				}
        				if (comboBox.getSelectedItem().toString().equals("MandelBrot"))
        				{
        					range = new Rectangle2D.Double();
        					generator = new Mandelbrot();
            				generator.getInitialRange(range);
            				drawFractal();
            				System.out.println("Mandelbrot");
        				}
        				if (comboBox.getSelectedItem().toString().equals("Burning Ship"))
        				{
        					range = new Rectangle2D.Double();
        					generator = new BurningShip();
            				generator.getInitialRange(range);
            				drawFractal();
            				System.out.println("Burning Ship");
        				}

        			}
        		}
        	);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);		
	}
	
	private void drawFractal()
	{
		for (int i = 0; i < display.getWidth(); i++)
		{
			for (int j = 0; j < display.getHeight(); j++)
			{
				double xCoord = generator.getCoord (range.x, range.x + range.width, screenSize, i);
				double yCoord = generator.getCoord (range.y, range.y + range.height, screenSize, j);
				int counter = generator.numIterations(xCoord, yCoord);
				if (counter == 1)
				{
					display.drawPixel(i, j, 0);
				}
				else
				{
					float hue = 0.7f + (float) counter / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(i, j, rgbColor);
				}
			}
		}
		display.repaint();
	}
	
	public class ActionHandler implements ActionListener
	{
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (e.getActionCommand().equals("Reset Display"))
        	{
        		generator.getInitialRange(range);
        		drawFractal();
        	}
        	if (e.getActionCommand().equals("Save Image"))
        	{
        		 JFileChooser fileChooser = new JFileChooser();
        		 fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
        		 fileChooser.setAcceptAllFileFilterUsed(false);
        		 
        		 int choice = fileChooser.showSaveDialog(display);
        		 
        		 if (choice == JFileChooser.CANCEL_OPTION)
        		 {
        			 fileChooser.cancelSelection();
        		 }
        		 if (choice == JFileChooser.APPROVE_OPTION)
        		 {
        			 File directory = fileChooser.getSelectedFile();
        			 try 
        			 {
        				 ImageIO.write(display.bi, "png", directory);
        			 } 
        			 catch (Exception e1)
        			 {
        				 JOptionPane.showMessageDialog(display, e1.getMessage(), "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
        			 }
        			 
        		 }
        	}
        }
    }
    public class MouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e) {
            double x = FractalGenerator.getCoord(range.x, range.x + range.width, screenSize, e.getX());
            double y = FractalGenerator.getCoord(range.y, range.y + range.width, screenSize, e.getY());
            FractalGenerator.recenterAndZoomRange(range, x, y, 0.5);
            drawFractal();
        }
    }
    
    public static void main(String[] args) {
        FractalExplorer fractalExplorer = new FractalExplorer(800);
        fractalExplorer.generator.getInitialRange(fractalExplorer.range);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }

}
