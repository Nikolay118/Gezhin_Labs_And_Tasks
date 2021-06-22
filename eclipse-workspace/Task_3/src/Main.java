import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        
        String[] cities = new String[] {"Nice", "Abu Dhabi", "Naples", "Vatican City"};
        int[] nass = new int[] {942208, 1482816, 2186853, 572};
        System.out.println("millionsRounding = " + Arrays.toString(millionsRounding(cities, nass)));
        
        System.out.println("otherSides = " + Arrays.toString(otherSides(1)));

        System.out.println("rps = " + rps("scissors", "paper"));
        
        int[] s = new int[] {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        System.out.println("warOfNumbers = " + warOfNumbers(s));
        
        System.out.println("reverseCase = " + reverseCase("TRUE developer"));
        
        System.out.println("inatorInator = " + inatorInator("EvilClone"));
        
        System.out.println("doesBrickFit = " + doesBrickFit(1, 2, 2, 1, 1));
        
        System.out.println("totalDistance = " + totalDistance(55.5, 5.5, 5, false));
        
        int[] s_2 = new int[] {3, 3, 3, 3, 3};
        System.out.println("mean = " + mean(s_2));
        
        System.out.println("parityAnalysis = " + parityAnalysis(3));
}
    
    static String[] millionsRounding(String[] cities, int[] nas)
    {
    	int len = nas.length;
    	String[] s = new String[len];
    	for (int i = 0; i < len; i++)
    	{
    		String num = new String();
    		double nas_2 = nas[i];
    		long a = Math.round(nas_2 / 1000000);
    		if (a != 0)
    			num = Long.toString(a) + "000000";
    		else
    			num = "0";
    		s[i] = cities[i] + " - " + num;
    	}
    	return s;
    }
    
    static String[] otherSides(double a)
    {
    	String[] s = new String[2];
    	DecimalFormat df = new DecimalFormat( "#.##" );
    	double b = 2 * a;
    	s[0] =  df.format(b);
    	b = Math.sqrt(3) * a;
    	s[1] =  df.format(b);
    	return s;
    }
    
    static String rps (String a, String b)
    {
    	String s = new String();
    	if (a == b)
    		s = "TIE";
    	else
    	{
    		if (a == "rock")
    		{
    			if (b == "scissors")
    				s = "Player1 wins";
    			else
    				s = "Player2 wins";
    		}
    		if (a == "scissors")
    		{
    			if (b == "paper")
    				s = "Player1 wins";
    			else
    				s ="Player2 wins";
    		}
    		if (a == "paper")
    		{
    			if (b == "rock")
    				s = "Player1 wins";
    			else
    				s = "Player2 wins";
    		}
    	}
    	return s;
    }
    
    static int warOfNumbers(int[] a)
    {
        int len = a.length;
        int nechet = 0;
        int chet = 0;
        int b = 0;
        for (int i = 0; i <= len - 1; i++)
        	{
        		if (a[i] % 2 == 0)
        			chet += a[i];
        		else
        			nechet += a[i];
        	}
        	if (nechet > chet)
        		b =  nechet - chet;
        	else
        		b =  chet - nechet;
        return b;
    }
    
    static String reverseCase(String a)
    {
    	String result = "";
    	char[] chars = a.toCharArray();
    	for ( char c : chars ){
    	if (Character.isLowerCase(c))
    	c = Character.toUpperCase(c);
    	else
    	c = Character.toLowerCase(c);
    	result += c;
    	}
    	return result;
    }
    static String inatorInator(String a)
    {
    	String res = new String();
    	String sogl = "BCDFGHJKLMNPQRSTVWXYZ".toLowerCase();
    	char[] chars = a.toCharArray();
    	int len = chars.length;
    	String last_letter = new String();
    	last_letter = Character.toString(chars[len - 1]);
    	if (sogl.contains(last_letter))
    	{
    		res = a + "inator " + String.valueOf(len) + "000";
    	}
    	else
    		res = a + "-inator " + String.valueOf(len) + "000";
    	return res;
    }
    
    static String doesBrickFit(int a, int b, int c, int w, int h)
    {
    	String res = new String();
    	if ((a * b <= w * h)||(a * c <= w * h))
    		res = "true";
    	else
    		res = "false";
    	return res;
    }
    
    static String totalDistance(double fuel, double consumption, double passengers, boolean b)
    {
    	double base_consumption = consumption * ((100 + 5 * passengers) / 100);
    	double total_cunsumption = base_consumption;
    	if (b == true)
    		total_cunsumption = base_consumption * 110 / 100;
    	DecimalFormat df = new DecimalFormat( "#.##" );
    	return df.format(fuel * 100 / total_cunsumption);
    }
    
    static String mean(int[] a)
    {
    	int len = a.length;
    	int summ = 0;
    	for (int i = 0; i < len; i++)
    		summ += a[i];
    	double len_2 = len;
    	DecimalFormat df = new DecimalFormat( "#.##" );
    	return df.format(summ / len_2);
    }
    
    static boolean parityAnalysis(int a)
    {
    	int b = a;
    	int summ = 0;
    	while (b != 0)
    	{
    		summ += b % 10;
    		b = b / 10;
    	}
    	return (summ % 2 == a % 2);
    }
}