package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;

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
		JButton button = new JButton("Reset");
		
		frame.setLayout(new BorderLayout());
		frame.add(display, BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);
		
		display.addMouseListener(new MouseListener());
        button.addActionListener(new ActionHandler());
		
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
            generator.getInitialRange(range);
            drawFractal();
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
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }
}
