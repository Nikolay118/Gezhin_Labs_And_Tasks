import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Main{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int[] mas = new int[] {8, 6, 33, 100};
		System.out.println(sevenBoom(mas));
		int[] mas_2 = new int[] {5, 6, 7, 8, 9, 9};
		System.out.println(cons(mas_2));
		System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
		System.out.println(noYelling("I just cannot believe it."));
		System.out.println(xPronounce("OMG x box unboxing video x D"));
		int[] mas_3 = new int[] {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
		System.out.println(largestGap(mas_3));
		System.out.println(commonLastVowel("OOI UUI EEI AAI"));
		System.out.println(memeSum(26, 39));
		System.out.println(unrepeated("call 911"));
		System.out.println(chet7(700));
	}

	static int chet7(int number)
	{
		ArrayList<Integer> arrayList = new ArrayList<>();
		int numLen = 0;
		int minNum = 0;
		int copyNum = number;
		while (number > 0)
		{
			int oneNum = number % 10;
			arrayList.add(oneNum);
			numLen += 1;
			number /= 10;
		}

		Collections.sort(arrayList);

		for (int i = 0;i < numLen;i++)
		{
			minNum = minNum + arrayList.get(i) * (int)Math.pow(10,(numLen - i - 1));
		}

		return copyNum - minNum;
		}
	
	static String sevenBoom(int[] mas)
	{
		String rez = new String("there is no 7 in the array");
		for (int i = 0; i <= mas.length - 1; i++)
		{
			String str = String.valueOf(mas[i]);
			if (str.contains("7"))
			{
				rez = "Boom!" ;
				break;
			}
		}
		return rez;
	}

	static Boolean cons(int[] mas)
	{
		boolean Flag = true;
		Arrays.sort(mas);
		int counter = mas[0];
		for (int i = 1; i < mas.length; i++)
		{
			if ((mas[i] != counter + 1))
				Flag = false;
			counter += 1;
		}
		return Flag;
	}

	static String unmix(String str)
	{
		char[] mas = str.toCharArray();
		int counter = 0;
		String rez = new String();
		for (int i = 0; i < mas.length / 2; i++)
		{
			char x = mas[counter + 1];
			mas[counter + 1] = mas[counter];
			mas[counter] = x;
			rez += Character.toString(mas[counter]) + Character.toString(mas[counter + 1]);
			counter += 2;
		}
		if (mas.length % 2 == 1)
			rez += Character.toString(mas[mas.length - 1]);
		return rez;
	}

	static String noYelling(String str)
	{
		String rez = new String();
		String[] mas = str.split(" ");
		String last_word = mas[mas.length - 1];
		char[] chars = last_word.toCharArray();
		int counter = 0;
		if ((chars[chars.length - 1]) == '?')
		{
			for (int i = 0; i < chars.length; i++)
			{
				if ((chars[i]) == '?')
					counter += 1;
			}
			for (int i = 0; i <= chars.length - counter; i++)
			{
				rez += Character.toString(chars[i]);
			}
		}
		if ((chars[chars.length - 1]) == '!')
		{
			for (int i = 0; i < chars.length; i++)
			{
				if ((chars[i]) == '!')
					counter += 1;
			}
			for (int i = 0; i <= chars.length - counter; i++)
			{
				rez += Character.toString(chars[i]);
			}
		}
		else
			rez = mas[mas.length - 1];
		String word = rez;
		rez = new String();
		for (int i = 0; i <= mas.length - 2; i++)
		{
			rez += mas[i] + " ";
		}
		rez += word;
		return rez;
	}
	
	static String xPronounce(String str)
	{
		String rez = new String();
		String[] mas = str.split(" ");
		String word = new String();
		for (int i = 0; i < mas.length; i++)
		{
			if (mas[i].equals("x"))
			{
				mas[i] = "ecks";
			}
			else
				if (mas[i].indexOf("x") == 0)
			        mas[i] = mas[i].replaceFirst("x", "z");
			    mas[i] = mas[i].replaceAll("x", "cks");
		        rez += mas[i] + " ";
	    }
		return rez;
	}
	
	static int largestGap(int[] mas)
	{
		int gap = 0;
		Arrays.sort(mas);
		for (int i = 1; i < mas.length; i++)
		{
			if (mas[i] - mas[i - 1] > gap)
				gap = mas[i] - mas[i - 1];
		}
		return gap;
	}
	
	static int reverseEncoding(int num)
	{
		return 0;
	}
	
	static String commonLastVowel(String str)
	{
		String rez = new String();
		str = str.toLowerCase();
		int[] lettersCount_aeiouy = new int[] {0, 0, 0, 0, 0, 0};
		String[] words = str.split(" ");
		char[] word;
		for (int i = 0; i < words.length; i++)
		{
			word = (words[i].toCharArray());
			if (word[word.length - 1] == 'a')
				lettersCount_aeiouy[0] += 1;
			if (word[word.length - 1] == 'e')
				lettersCount_aeiouy[1] += 1;
			if (word[word.length - 1] == 'i')
				lettersCount_aeiouy[2] += 1;
			if (word[word.length - 1] == 'o')
				lettersCount_aeiouy[3] += 1;
			if (word[word.length - 1] == 'u')
				lettersCount_aeiouy[4] += 1;
			if (word[word.length - 1] == 'y')
			{
				lettersCount_aeiouy[5] += 1;
			}
		}
		
		int[] letters_2 = Arrays.copyOf(lettersCount_aeiouy, 6);
		Arrays.sort(letters_2);
		int max = letters_2[5];

		if (lettersCount_aeiouy[0] == max)
			rez = "a";
		if (lettersCount_aeiouy[1] == max)
			rez = "e";
		if (lettersCount_aeiouy[2] == max)
			rez = "i";
		if (lettersCount_aeiouy[3] == max)
			rez = "o";
		if (lettersCount_aeiouy[4] == max)
			rez = "u";
		if (lettersCount_aeiouy[5] == max)
			rez = "y";
		return rez;
	}
	
	static int memeSum(int a, int b)
	{
		
		String rez = new String();
		String[] memeSum;
		int[] a_raz = new int[Integer.toString(a).length()];
		int[] b_raz = new int[Integer.toString(b).length()];
		int counter = 0;
		while (a > 0)
		{
			a_raz[counter] = a % 10;
			a = a / 10;
			counter += 1;
		}
		
		counter = 0;
		
		while (b > 0)
		{
			b_raz[counter] = b % 10;
			b = b / 10;
			counter += 1;
		}
		
		counter = 0;
		if (a_raz.length >= b_raz.length)
		{
			counter = 0;
			memeSum = new String[a_raz.length];
			for (int i = 0; i < b_raz.length; i++)
			{
				memeSum[counter] = Integer.toString(a_raz[counter] + b_raz[counter]);
				counter += 1;
			}
			for (int i = 0; i < a_raz.length - b_raz.length; i++)
			{
				memeSum[counter] = Integer.toString(a_raz[counter]);
			}
		}
		else
		{
			counter = 0;
			memeSum = new String[b_raz.length];
			for (int i = 0; i < a_raz.length; i++)
			{
				memeSum[counter] = Integer.toString(a_raz[i] + b_raz[i]);
				counter += 1;
			}
			for (int i = 0; i < b_raz.length - a_raz.length; i++)
			{
				memeSum[counter] = Integer.toString(b_raz[counter]);
			}
		}
		
		for (int i = memeSum.length - 1; i >= 0; i--)
		{
			rez += memeSum[i];
		}
		return Integer.parseInt(rez);
	}
	
	static String unrepeated(String str)
	{
		String used = new String();
		String rez = new String();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (!(used.contains(Character.toString(chars[i]))))
			{
				rez += Character.toString(chars[i]);
				used += Character.toString(chars[i]);
			}

		}
		return rez;
	}
}