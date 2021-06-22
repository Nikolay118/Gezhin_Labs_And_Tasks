import java.util.Scanner;

import package1.Point3d;




	class Main{
	    public static void main(String[] args){

	        Scanner scan = new Scanner(System.in);

	        Point3d p1 = new Point3d(1, 3, 1);

	        Point3d p2 = new Point3d(2, 2, 2);

	        Point3d p3 = new Point3d(3, 3, 3);

	        Point3d p4 = new Point3d();

	        System.out.println(p4.getX());
	        p4.setX(3);
	        System.out.println(p4.getX());
	        System.out.println(p1.distanceTo(p2));

	        if ((Point3d.comparison(p1, p2) == false) && (Point3d.comparison(p2, p3) == false)) {
	            System.out.println(Point3d.computeArea(p1, p2, p3));
	}
	        else
	        	System.out.println("Введите разные точки!");
	}
}

