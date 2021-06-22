package Package1;

import java.awt.geom.Rectangle2D;


public class BurningShip extends FractalGenerator {
	public static final int MAX_ITERATIONS = 2000;
	
	@Override
	public void getInitialRange (Rectangle2D.Double range)
	{
		range.x = -2;
		range.y = -2.5;
		range.width = 4;
		range.height = 4;
	}
	
	@Override
	public int numIterations(double x, double y) {
		double xn = x;
		double yn = y;
		int counter = 0;
		while (counter < MAX_ITERATIONS) {
			counter++;
			double k = xn * xn - yn*yn+x;
			double m = 2 * Math.abs(xn) * Math.abs(yn) + y;
			xn = k;
			yn = m;
			if (xn*xn+yn*yn > 4)
				break;
		}
		if (counter == MAX_ITERATIONS)
			return -1;
		return counter;
	}
	
	@Override
	public String toString()
	{
		return "Burning Ship";
	}
}