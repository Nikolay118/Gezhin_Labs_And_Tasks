package Package1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Graphics;

public class JImageDisplay extends javax.swing.JComponent {
	
	private  BufferedImage bi;
	
	public JImageDisplay(int w, int h)
	{
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Dimension di = new Dimension(w, h);
		super.setPreferredSize(di);
	}
	

	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(bi, 0, 0, bi.getWidth(), bi.getHeight(), null);
	}


	public void clearImage() {
		for (int i = 0; i < bi.getWidth(); i++)
		{
			for (int j = 0; j < bi.getHeight(); j++)
			{
				drawPixel(i, j, 0);
			}
		}
	}


	public void drawPixel(int x, int y, int rgbColor)
	{
		bi.setRGB(x, y, rgbColor);
	}

	public BufferedImage getImage()
	{
		return bi;
	}

}
