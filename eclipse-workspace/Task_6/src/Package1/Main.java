package Package1;

import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) throws IOException
	{
		zadaniye1();
		zadaniye2();
		zadaniye3();
		zadaniye4();
		zadaniye5();
		zadaniye6();
		zadaniye7();
		zadaniye8();
		zadaniye9();
		zadaniye10();
	}
	
	
	public static void zadaniye1()
	{
		System.out.println("Задание №1");
		System.out.println(chet1("My world evolves in a beautiful space called Tesh.","sworn love lived"));
	}

	public static String chet1(String str,String str1)
	{
		String result = "";
		int counter = 0;
		int Flag = 1;
		int cor = 0;
		str = str.replaceAll("[^A-Za-zА-Яа-я]", "");
		str = str.toLowerCase();
		str1 = str1.replaceAll("[^A-Za-zА-Яа-я]", "");
		str1 = str1.toLowerCase();
		
		ArrayList<Character> arrayList = new ArrayList<>();
		
		for (int i = 0;i < str1.length();i++)
		{
			arrayList.add(str1.charAt(i));
		}
		
		ArrayList<Character> arrayList2 = new ArrayList<>(arrayList);
		
		while (cor + str1.length() <= str.length())
		{
			for (int i = cor;i < cor + str1.length();i++)
			{
				if (arrayList.contains(str.charAt(i))== false || Flag == 0)
				{	result = "";
					arrayList.removeAll(arrayList2);
					for (int p = 0;p < arrayList2.size();p++)
					{
						arrayList.add(arrayList2.get(p));
					}
					counter = 0;
					break;
				}

				Flag = 0;
				for (int j = 0;j < arrayList.size();j++)
				{	
					if (str.charAt(i) == arrayList.get(j))
					{
						result += arrayList.get(j);
						arrayList.remove(j);
						counter += 1;
						Flag = 1;
						break;
					}
				}
				
				if (str1.length() <= counter)
					return result;
			}
			cor += 1;
		}
			if (str1.length() > counter)
				return "noutfond";
			else
				return result;
	}

	public static void zadaniye2()
	{
		System.out.println("");
		System.out.println("Задание №2");
		System.out.println(chet2("intercontinentalisationalism",6).toString());
	}
	

	private static ArrayList<String> arrayList = new ArrayList<>();
	public static ArrayList<String> chet2(String strInput,int number)
	{
		String result = "";
		String pereda4a = "";
		if (number > strInput.length())
		{
			Collections.sort(arrayList);
			return arrayList;
		}
		
		for (int i = 0;i < number;i++)
		{
			result = result + strInput.charAt(i);
		}
		
		for (int i = number;i < strInput.length();i++)
		{
			pereda4a += strInput.charAt(i);
		}
		arrayList.add(result);
		chet2(pereda4a,number);
		return arrayList;
			
	}
	
	public static void zadaniye3()
	{
		System.out.println("");
		System.out.println("Задание №3");
		System.out.println(chet3("myworldevolvesinhers","tesh"));
	}

	public static String chet3(String str,String str1)
	{
		char[] charArray = str1.toCharArray();
		char[] charArrayTwo = str.toCharArray();
		char[] charNum = {'1','2','3','4','5','6','7','9'};
        int[] copyNum = new int[str1.length()];
		int numI = (int) Math.ceil((double)str.length() / str1.length());
		int[][] arrayTwo = new int[numI+1][str1.length()];
		int[][] copyArrayTwo = new int[numI+1][str1.length()];
		for (int i = 0;i < str1.length();i++)
		{
			for (int j = 0;j < 8;j++) 
			{
				if (charArray[i] == charNum[j])
				{
					arrayTwo[0][i] = charArray[i] - 48;
					copyNum[i] = charArray[i] - 48;
					break;
				}
				else 
				{
					arrayTwo[0][i] = charArray[i];
					copyNum[i] = charArray[i];
				}
				
			}
		}
		
		int g = 0;
		for (int i = 1;i < numI + 1;i++)
			for (int j = 0;j < str1.length();j++)
			{
				if (g < charArrayTwo.length)
				{
					arrayTwo[i][j] = charArrayTwo[g];
					g++;
				}
				else 
				{
					arrayTwo[i][j] = 32;
				}
			}
		
		Arrays.sort(copyNum);
		int[] flagMassiv = new int[str1.length()];
		for (int i = 0; i < str1.length();i++)
		{
			for (int j = 0;j < str1.length();j++)
			{
				if ((arrayTwo[0][i] == copyNum[j]) && (flagMassiv[j] == 0))
				{
					arrayTwo[0][i] = j + 1;
					flagMassiv[j] = 1;
				}
			}
		}
		
		int index;
		for (int i = 0;i < str1.length();i++)
		{
				index = arrayTwo[0][i] - 1;
				for (int z = 0;z < numI + 1;z++)
				{
					copyArrayTwo[z][index] = arrayTwo[z][i];
				}
		}
		
		String finalAnswer = "";
		for (int i = 1;i < numI + 1;i++)
		{
			for (int j = 0;j < str1.length();j++)
			{
				finalAnswer = finalAnswer + (char)copyArrayTwo[i][j];
			}
		}
		return finalAnswer;
		
	}
	
	public static void zadaniye4() throws IOException
	{
		System.out.println("");
		System.out.println("Задание №4");
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(9);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(15);
		arrayList.add(3);
		System.out.println(chet4(arrayList,45).toString());
	}
	
	// В четвертом задании происходит проверка всех пар элементов массива на равенство введенному числу n
	// Если такая пара чисел находится, то записывается минимальный и максимальный индекс в ArrayList
	public static ArrayList<Integer> chet4(ArrayList<Integer> arrayList,int n)
	{
		int minNum = 0;
		int maxNum = 0;
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		for (int i = 1;i < arrayList.size();i++)
		{
			for (int j = i - 1;j >= 0;j--)
			{
					if (arrayList.get(i) * arrayList.get(j) == n)
					{
							minNum = arrayList.get(Math.min(i,j));
							maxNum = arrayList.get(Math.max(i,j));
							arrayList2.add(minNum);
							arrayList2.add(maxNum);
							return arrayList2;
					}
			}
		}
		return arrayList2;
	}
	
	public static void zadaniye5()
	{
		System.out.println("");
		System.out.println("Задание №5");
		System.out.println(Arrays.toString(chet5(125)));
	}
	
	
	public static int counter = 0;
	public static String[] chet5(int number)
	{
		String[] array = {String.valueOf(number),String.valueOf(counter)};
		if (Integer.parseInt(array[0]) == 0)
		{
			String[] answer = {String.valueOf(number),String.valueOf(counter)};
			return answer;
		}
		counter += 1;
		chet5(Integer.parseInt(array[0]) / counter);
		String[] answer = {String.valueOf(number),String.valueOf(counter - 1)};
		int factorial = 1;
		for (int i = 0;i < counter - 1;i++)
		{
			factorial *= (i+1);
		}
		if (Integer.parseInt(answer[0]) == factorial)
			return answer;
		else
		{
			String[] answer2 = {""};
			return answer2;
	
		}	
	}
	
	public static void zadaniye6()
	{
		System.out.println("");
		System.out.println("Задание №6");
		chet6("0.(6)");
	}
	

	public static void chet6(String number)
	{
		ArrayList<Integer> arrayListVes = new ArrayList<>();
		ArrayList<Integer> arrayListDoPeriod = new ArrayList<>();
		String numberVes = number;
		numberVes = numberVes.replaceAll("\\)", "");
		numberVes = numberVes.replaceAll("\\(", "");
		int osnNum = (int)Double.parseDouble(numberVes);
		int i = 0;
		while (numberVes.charAt(numberVes.length()- i - 1) != '.')
		{
			int numVs = numberVes.charAt(numberVes.length()- i - 1) - '0';
			arrayListVes.add(numVs);
			i++;
		}
		
		int j = 0;
		while (number.charAt(number.indexOf('(') - j - 1) != '.')
		{
			int numPeriod = number.charAt(number.indexOf('(') - j - 1) - '0';
			arrayListDoPeriod.add(numPeriod);
			j++;
		}

		Collections.reverse(arrayListDoPeriod);
		Collections.reverse(arrayListVes);
		
		int numVs = 0;
		for (int z = 0;z < i;z++)
		{
			numVs = numVs + arrayListVes.get(z) * (int) Math.pow(10,i - 1 - z);
		}
		
		int numDoPeriod = 0;
		for (int z = 0;z < j;z++)
		{
			numDoPeriod = numDoPeriod + arrayListDoPeriod.get(z) * (int) Math.pow(10, j - (z + 1));
		}
		
		int raznost = numVs - numDoPeriod;
		int numPeriod = i - j;

		
		int delitel = 0;
		for (int z = 0;z < numPeriod;z++)
		{
			delitel = delitel + 9 * (int) Math.pow(10, numPeriod - (z + 1));
		}
		delitel = delitel * (int) Math.pow(10,j);
		raznost = raznost + osnNum * delitel;
		int Flag = 1;
		while(Flag == 1)
		{
			Flag = 0;
			for (int z = 2;z <= 100;z++)
			{
				if (raznost % z == 0 && delitel % z == 0)
				{
					raznost /= z;
					delitel /= z;
					Flag = 1;
				}
			}
		}
		System.out.println(raznost + "/" + delitel);
	}
	
	public static void zadaniye7()
	{
		System.out.println("");
		System.out.println("Задание №7");
		System.out.println(chet7("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
	}
	
    
	public static String chet7(String str)
	{
		int sum = 0;
		int counter = 0;
		String answer = "";
		long numberPI = Long.parseLong("314159265358979");
		ArrayList<Long> arrayList = new ArrayList<>();
		for (int i = 0;i < 15;i++)
		{
			arrayList.add(numberPI % 10);
			numberPI /= 10;
		}
		Collections.reverse(arrayList);
		for (int i = 0;i < 15;i++)
		{
			if (sum < str.length())
			{
				sum += arrayList.get(i);
				counter += 1;
			}	
		}
		int ots4et = 0;
		for (int i = 0;i < counter;i++)
		{
			for (int j = ots4et;j < ots4et + arrayList.get(i);j++)
			{
				if (j+1 > str.length())
					answer += str.charAt(str.length() - 1);
				else
					answer = answer + str.charAt(j);
			}
			ots4et += arrayList.get(i);
			answer += " ";
		}
		return answer;
	}
	
	public static void zadaniye8()
	{
		System.out.println("");
		System.out.println("Задание №8");
		System.out.println(chet8(3).toString().replaceAll("[^0-9 ]", ""));
	}

	public static ArrayList<String> chet8(int number)
	{
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0;i < (int) Math.pow(2, number);i++)
		{
			String bitNum = Integer.toBinaryString(i);
			if (bitNum.contains("11") == false)
			{
				while (bitNum.length() < number)
				{
					bitNum = "0" + bitNum;
				}
				arrayList.add(bitNum);
			}
		}
		return arrayList;
	}
	
	public static void zadaniye9()
	{
		System.out.println("");
		System.out.println("Задание №9");
		System.out.println(chet9("aabbcd"));
	}
	
	
	public static String chet9(String strInput)
	{
		char[] charArray = strInput.toCharArray();
		ArrayList<Character> arrayList = new ArrayList<>();
		ArrayList<Integer> numberList = new ArrayList<>();
		for (int i = 0;i < strInput.length();i++)
		{
			if (!arrayList.contains(charArray[i]))
			{
				arrayList.add(charArray[i]);
				numberList.add(0);
			}
		}
		
		for (int i = 0;i < strInput.length();i++)
		{
			if (arrayList.contains(charArray[i]))
			{
				char value = charArray[i];
				int index = arrayList.indexOf(value);
				numberList.set(index, numberList.get(index) + 1);
			}
		}
		
		int max1 = Collections.max(numberList);
		int max1N = max1 -1;
		numberList.set(numberList.indexOf(max1),max1N);
		for (int i = 0;i < numberList.size();i++)
		{
			if ((max1N == Collections.max(numberList)) && (max1N == Collections.min(numberList)))
			{
				return "Yes";
			}
		}
		return "No";
		
	}
	
	public static void zadaniye10() throws IOException
	{
		System.out.println("");
		System.out.println("Задание №10");
		ArrayList<Integer> arrayList0 = new ArrayList<>();
		arrayList0.add(1);
		arrayList0.add(6);
		arrayList0.add(5);
		arrayList0.add(4);
		arrayList0.add(8);
		arrayList0.add(2);
		arrayList0.add(3);
		arrayList0.add(7);
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>(chet10(arrayList0));
		System.out.println(arrayList.toString());
	}
	
	public static ArrayList<ArrayList<Integer>> chet10(ArrayList<Integer> arrayList)
	{
		int z = 0;
		ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
		for (int i = 1;i < arrayList.size();i++)
		{
			for (int j = i - 1;j >= 0;j--)
			{
				if (arrayList.get(i) + arrayList.get(j) == 8)
				{
					int maxNum = Math.max(arrayList.get(i), arrayList.get(j));
					int minNum = Math.min(arrayList.get(i), arrayList.get(j));
					ArrayList<Integer> arrayList3 = new ArrayList<>();
					arrayList3.add(minNum);
					arrayList3.add(maxNum);
					arrayList2.add(z,arrayList3);
					z++;
				}
			}
		}
		return arrayList2;
	}
}