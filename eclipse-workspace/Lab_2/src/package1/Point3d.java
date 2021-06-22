package package1;
import package1.Point2d;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point3d extends Point2d {

private double zCoord;


public Point3d(double x, double y, double z){
    xCoord = x;
    yCoord = y;
    zCoord = z;
}

public Point3d() {

	xCoord = 0;
	yCoord = 0;
	zCoord = 0;
}

public double getZ () {
return zCoord;
}


public void setZ ( double val) {
zCoord = val;
}



public static boolean comparison ( Point3d a, Point3d b) {
if ((a.getX() == b.getX())&&(a.getY() == b.getY())&&(a.getZ() == b.getZ()))
return true;
else
return false;
}


public  double distanceTo ( Point3d a) {
return Math.sqrt(Math.pow(a.getX() - xCoord, 2) + Math.pow(a.getY() - yCoord, 2) + Math.pow(a.getZ() - zCoord, 2));
}

public static double computeArea (Point3d a, Point3d b, Point3d c){
double ab = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2) + Math.pow(b.getZ() - a.getZ(), 2));
double ac = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2) + Math.pow(c.getZ() - a.getZ(), 2));
double bc = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2) + Math.pow(c.getZ() - b.getZ(), 2));
double p = (ab + bc + ac) / 2;
return Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
}
}