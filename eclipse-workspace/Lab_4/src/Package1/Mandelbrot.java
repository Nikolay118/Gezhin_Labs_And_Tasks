package Package1;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator
{
	public static final int MAX_ITERATIONS = 2000;
	
	@Override
	public void getInitialRange (Rectangle2D.Double range)
	{
		range.x = -2;
		range.y = -1.5;
		range.width = 3;
		range.height = 3;
	}
	
	@Override
	public int numIterations(double x, double y) {
		double xn = x;
		double yn = y;
		int counter = 0;
		while (counter < MAX_ITERATIONS) {
			counter++;
			double k = xn * xn - yn*yn+x;
			double m = 2 * xn * yn + y;
			xn = k;
			yn = m;
			if (xn*xn+yn*yn > 4)
				break;
		}
		if (counter == MAX_ITERATIONS)
			return -1;
		return counter;
	}
}
