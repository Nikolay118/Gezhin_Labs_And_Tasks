package Package1;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Reader6 {
	String str;
	String str1;
	int number;
	ArrayList<Integer> arrayList = new ArrayList<>();
	ArrayList<Integer> arrayList2 = new ArrayList<>();
	
	void scan1()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите первое предложение");
		str = scn.nextLine();
		System.out.println("Введите второе предложение");
		str1 = scn.nextLine();
		scn.close();
	}
	void scan2()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите предложение");
		str = scn.nextLine();
		System.out.println("Длина среза");
		number = scn.nextInt();
	}
	
	void scan3()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите message");
		str = scn.nextLine();
		System.out.println("Введите key");
		str1 = scn.nextLine();	
		scn.close();
	}
	
	void scan4() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		number = Integer.parseInt(reader.readLine());
		boolean flag = true;
		while (flag)
		{
			String number = reader.readLine();
			if (number.equals(""))
			{
				flag = false;
				break;
			}
			arrayList.add(Integer.parseInt(number));
		}
	}
	
	void scan5()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите число");
		number = scn.nextInt();
		scn.close();
	}
	
	void scan6()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите число");
		str = scn.nextLine();
		scn.close();
	}
	
	void scan7()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите предложение");
		str = scn.nextLine();
		scn.close();
	}
	
	void scan8()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите число");
		number = scn.nextInt();
		scn.close();
	}
	
	void scan9()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите пердложение");
		str = scn.nextLine();
	}
	
	void scan10() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag)
		{
			String number = reader.readLine();
			if (number.equals(""))
			{
				flag = false;
				break;
			}
			arrayList2.add(Integer.parseInt(number));
		}
	}

}