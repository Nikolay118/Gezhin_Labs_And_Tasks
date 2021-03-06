import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


class Main{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		System.out.println(sameLetterPattern("FFFF", "ABCD"));
		System.out.println(spiderVSFly("C4", "C2"));
		System.out.println(digitsCount(544456));
		String[] words = new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
		System.out.println(totalPoints(words, "tossed"));
		int[] mas = new int[] {3, 5, 7, 10, 15};
		System.out.println(longestRun(mas));
		String[] mas_2 = new String[] {"53%", "79%"};
		System.out.println(takeDownAverage(mas_2));
		System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
		System.out.println(maxPossible(8732, 1000));
		System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
		System.out.println(isNew(231));
		

		
	}
	
	static boolean sameLetterPattern(String str1, String str2)
	{
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		int len = str1.length();
		int[] array1 = new int[len];
		int[] array2 = new int[len];
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		
		int counter = 1;
		for (int i = 0; i < len; i++)
			if (!(map1.containsKey(chars1[i])))
			{
				map1.put(chars1[i], counter);
				array1[i] = map1.get(chars1[i]);
				counter += 1;
			}
			else
			{
				array1[i] = map1.get(chars1[i]);
			}
		counter = 1;
		for (int i = 0; i < len; i++)
			if (!(map2.containsKey(chars2[i])))
			{
				map2.put(chars2[i], counter);
				array2[i] = map2.get(chars2[i]);
				counter += 1;
			}
			else
			{
				array2[i] = map2.get(chars2[i]);
			}
		return Arrays.equals(array1, array2);
	}
	
	static String spiderVSFly(String spider, String fly)
	{
		String aStr = new String("ABCDEFGH");
		String bStr = new String("BCDEFGHA");
		String cStr = new String("CDEFGHAB");
		String dStr = new String("DEFGHABC");
		String eStr = new String("EFGHABCD");
		String fStr = new String("FGHABCDE");
		String gStr = new String("GHABCDEF");
		String hStr = new String("HABCDEFG");
		
		String rez = new String();
		
		char spiderLine = spider.charAt(0);
		int spiderRad = Integer.parseInt(Character.toString(spider.charAt(1)));
		
		char flyLine = fly.charAt(0);
		int flyRad = Integer.parseInt(Character.toString(fly.charAt(1)));
		
		int radDiff = 0;
		
		boolean withoutTransition = false;
		
		int rad = spiderRad;
		
		if (spiderLine == 'A')
		{
			if (aStr.indexOf(flyLine) < 4)
				radDiff = aStr.indexOf(flyLine) - aStr.indexOf(spiderLine);
			else
				radDiff = 8 - (aStr.indexOf(flyLine) - aStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rez += "A" + 0 + "-";
				rad = 1;
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if (radDiff < 4)
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(aStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 1; i < radDiff; i++)
					{
						rez += Character.toString(aStr.charAt(aStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
		
		if (spiderLine == 'B')
		{
			if (bStr.indexOf(flyLine) < 4)
				radDiff = bStr.indexOf(flyLine) - bStr.indexOf(spiderLine);
			else
				radDiff = 8 - (bStr.indexOf(flyLine) - bStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rez += "A" + 0 + "-";
				rad = 1;
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if (radDiff < 4)
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(bStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 1; i < radDiff; i++)
					{
						rez += Character.toString(bStr.charAt(bStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
		
		if (spiderLine == 'C')
		{
			if (cStr.indexOf(flyLine) < 4)
				radDiff = cStr.indexOf(flyLine) - cStr.indexOf(spiderLine);
			else
				radDiff = 8 - (cStr.indexOf(flyLine) - cStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rez += "A" + 0 + "-";
				rad = 1;
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if ((radDiff < 4) )
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(cStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 1; i < radDiff; i++)
					{
						rez += Character.toString(cStr.charAt(cStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
		
		if (spiderLine == 'D')
		{
			if (dStr.indexOf(flyLine) < 4)
				radDiff = dStr.indexOf(flyLine) - dStr.indexOf(spiderLine);
			else
				radDiff = 8 - (dStr.indexOf(flyLine) - dStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rez += "A" + 0 + "-";
				rad = 1;
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if ((radDiff < 4))
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(dStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 1; i < radDiff; i++)
					{
						System.out.println(dStr.length());
						System.out.println(i);
						rez += Character.toString(dStr.charAt(dStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
		
		if (spiderLine == 'E')
		{
			if (eStr.indexOf(flyLine) < 4)
				radDiff = eStr.indexOf(flyLine) - eStr.indexOf(spiderLine);
			else
				radDiff = 8 - (eStr.indexOf(flyLine) - eStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rez += "A" + 0 + "-";
				rad = 1;
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if (radDiff < 4)
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(eStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 1; i < radDiff; i++)
					{
						rez += Character.toString(eStr.charAt(eStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
		
		if (spiderLine == 'F')
		{
			if (fStr.indexOf(flyLine) < 4)
				radDiff = fStr.indexOf(flyLine) - fStr.indexOf(spiderLine);
			else
				radDiff = 8 - (fStr.indexOf(flyLine) - fStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rez += "A" + 0 + "-";
				rad = 1;
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if (radDiff < 4)
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(fStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 1; i < radDiff; i++)
					{
						rez += Character.toString(fStr.charAt(fStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
		
		if (spiderLine == 'G')
		{
			if (gStr.indexOf(flyLine) < 4)
				radDiff = gStr.indexOf(flyLine) - gStr.indexOf(spiderLine);
			else
				radDiff = 8 - (gStr.indexOf(flyLine) - gStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rad = 1;
				rez += "A" + 0 + "-";
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if (radDiff < 4)
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(gStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 1; i < radDiff; i++)
					{
						rez += Character.toString(gStr.charAt(gStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
		
		if (spiderLine == 'H')
		{
			if (hStr.indexOf(flyLine) < 4)
				radDiff = hStr.indexOf(flyLine) - hStr.indexOf(spiderLine);
			else
				radDiff = 8 - (hStr.indexOf(flyLine) - hStr.indexOf(spiderLine));
			if (0.77 * radDiff * flyRad >= 2 * flyRad)
				withoutTransition = true;
			
			if (withoutTransition == true)
			{
				for (int i = 0; i < spiderRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				rez += "A" + 0 + "-";
				rad = 1;
				for (int i = 1; i < flyRad; i++)
				{
					rez += Character.toString(flyLine) + rad + "-";
					rad += 1;
				}
				rez += flyLine + Integer.toString(rad);
			}
			else
			{
				for (int i = 0; i < spiderRad - flyRad; i++)
				{
					rez += Character.toString(spiderLine) + rad + "-";
					rad -= 1;
				}
				int ind = 0;
				if (radDiff < 4)
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(hStr.charAt(i)) + rad + "-";
					}
				}
				else
				{
					for (int i = 0; i < radDiff; i++)
					{
						rez += Character.toString(hStr.charAt(hStr.length() - i)) + rad + "-";
					}
				}
				rez += Character.toString(flyLine) + rad;
			}
		}
	return rez;
	}	
	
	static int  digitsCount(int num)
	{
		int counter = 1;
		num = num / 10;
		if (num == 0)
		{
			return counter;
		}
		counter += digitsCount(num);
		return counter;
	}
	
	static int totalPoints(String[] words, String finalWord)
	{
		int score = 0;
		char[] charsFinalWord = finalWord.toCharArray();
		char[] charsWord;
		boolean Flag;
		HashMap<Character, Integer> mapFinalWord = new HashMap<>();
		HashMap<Character, Integer> mapWord = new HashMap<>();
		
		for (int i = 0; i < 6; i++)
		{
			if (mapFinalWord.containsKey(charsFinalWord[i]))
				mapFinalWord.put(charsFinalWord[i], mapFinalWord.get(charsFinalWord[i]) + 1);
			else
				mapFinalWord.put(charsFinalWord[i], 1);
		}
		
		for (int i = 0; i < words.length; i++)
		{
		    mapWord.clear();
		    charsWord = words[i].toCharArray();
		    Flag = true;
		    for (int j = 0; j < charsWord.length; j++)
			{
				if (mapWord.containsKey(charsWord[j]))
					mapWord.put(charsWord[j], mapWord.get(charsWord[j]) + 1);
				else
					mapWord.put(charsWord[j], 1);
				
				if (mapFinalWord.containsKey(charsWord[j]) == false)
					Flag = false;
				else
				{
					if (mapWord.get(charsWord[j]) > mapFinalWord.get(charsWord[j]))
						Flag = false;
				}
				}
			
			int len = words[i].length();
			if (Flag == true)
			{
				if (len == 3)
					score += 1;
				if (len == 4)
					score += 2;
				if (len == 5)
					score += 3;
				if (len == 6)
					score += 54;
			}
		}
		return score;
	}
	
	static int longestRun(int[] mas)
	{
		int maxRun = 1;
		int anyRun = 1;
		for (int i = 0; i < mas.length - 1; i++)
		{
			if ((mas[i + 1] == mas[i] + 1) || (mas[i + 1] == mas[i] - 1))
				anyRun += 1;
			else
				anyRun = 1;
			if (anyRun > maxRun)
				maxRun = anyRun;
		}
		return maxRun;
	}
	
	static String takeDownAverage(String[] args)
	{
		int sum = 0;
		int kol = args.length;
		String a = new String();
		for (int i = 0; i < args.length; i++)
		{
			
			a = args[i].replaceAll("%", "");
			sum += Integer.parseInt(a);
		}
		int ans = Math.round(((sum - 5 * kol) * (kol + 1) - sum * kol) / kol);
		return Integer.toString(ans);
	}
	
	static String rearrange(String str)
	{
		HashMap<Integer, String> numberAndNewWord = new HashMap<>();
		String[] words = str.split(" ");
		int number;
		String rez = new String();
		String word2;
		for (int i = 0; i < words.length; i++)
		{
			char[] word = words[i].toCharArray();
			for (int j = 0; j < word.length; j++)
			{
				if ("123456789".contains(String.valueOf(word[j])))
				{
					number = Integer.valueOf(String.valueOf(word[j]));
					numberAndNewWord.put(number, words[i]);
					break;
				}
			}
		}
		for (int i = 1; i < words.length + 1; i++)
		{
			if (i == words.length)
				rez += numberAndNewWord.get(i);
			else
				rez += numberAndNewWord.get(i) + " ";
		}
		rez = rez.replaceAll("1", "");
		rez = rez.replaceAll("2", "");
		rez = rez.replaceAll("3", "");
		rez = rez.replaceAll("4", "");
		rez = rez.replaceAll("5", "");
		rez = rez.replaceAll("6", "");
		rez = rez.replaceAll("7", "");
		rez = rez.replaceAll("8", "");
		rez = rez.replaceAll("9", "");
		return rez;
	}

	static int maxPossible(int a, int b)
		{
		int rez = 0;
		int counter = 0;
		int[] a_raz = new int[Integer.toString(a).length()];
		while (a != 0)
		{
			a_raz[counter] = a % 10;
			a = a / 10;
			counter += 1;
		}		
		for(int i = 0; i < a_raz.length / 2; i++)
		{
		    int temp = a_raz[i];
		    a_raz[i] = a_raz[a_raz.length - i - 1];
		    a_raz[a_raz.length - i - 1] = temp;
		}		
		counter = 0;
		int[] b_raz = new int[Integer.toString(b).length()];
		while (b > 0)
		{
			b_raz[counter] = b % 10;
			b = b / 10;
			counter += 1;
		}		
		Arrays.sort(b_raz);		
		for(int i = 0; i < b_raz.length / 2; i++)
		{
		    int temp = b_raz[i];
		    b_raz[i] = b_raz[b_raz.length - i - 1];
		    b_raz[b_raz.length - i - 1] = temp;
		}		
		counter = 0;
		for (int i = 0; i < a_raz.length; i++)
		{
			if (counter == b_raz.length)
				break;
			if (a_raz[i] < b_raz[counter])
			{
				a_raz[i] = b_raz[counter];
				counter += 1;
			}
		}		
		counter = a_raz.length - 1;		
		for (int i = 0; i < a_raz.length; i++)
		{
			rez += a_raz[i] * Math.pow(10, counter);
			counter -= 1;
		}
		return rez;
	}
	
	static String timeDifference(String cityA, String time, String cityB)
	{
		time = time.replaceAll(",", "");
		ArrayList<String> months = new ArrayList<String>();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
		
		String rez = new String();
		HashMap<String, int[]> cityAndTimeDif = new HashMap<>();
		cityAndTimeDif.put("Los Angeles", new int[] {-8, 0});
		cityAndTimeDif.put("New York", new int[] {-5, 0});
		cityAndTimeDif.put("Caracas", new int[] {-4, -30});
		cityAndTimeDif.put("Buenos Aires", new int[] {-3, 0});
		cityAndTimeDif.put("London", new int[] {0, 0});
		cityAndTimeDif.put("Rome", new int[] {1, 0});
		cityAndTimeDif.put("Moscow", new int[] {3, 0});
		cityAndTimeDif.put("Tehran", new int[] {3, 30});
		cityAndTimeDif.put("New Delhi", new int[] {5, 30});
		cityAndTimeDif.put("Beijing", new int[] {8, 0});
		cityAndTimeDif.put("Canberra", new int[] {10, 0});
		
		HashMap<String, Integer> monthAndDays = new HashMap<>();
		monthAndDays.put("January", 31);
		monthAndDays.put("February", 28);
		monthAndDays.put("March", 31);
		monthAndDays.put("April", 30);
		monthAndDays.put("May", 31);
		monthAndDays.put("June", 30);
		monthAndDays.put("July", 31);
		monthAndDays.put("August", 31);
		monthAndDays.put("September", 30);
		monthAndDays.put("October", 31);
		monthAndDays.put("November", 30);
		monthAndDays.put("December", 31);
		
		String month = time.split(" ")[0];
		int date = Integer.valueOf(time.split(" ")[1]);
		int year = Integer.valueOf(time.split(" ")[2]);
		int hour = Integer.valueOf((time.split(" ")[3]).split(":")[0]);
		int minute = Integer.valueOf((time.split(" ")[3]).split(":")[1]);
		
		int newHour = hour + cityAndTimeDif.get(cityB)[0] - cityAndTimeDif.get(cityA)[0];
		int newMinute = (minute + cityAndTimeDif.get(cityB)[1] - cityAndTimeDif.get(cityA)[1]) % 60;
		newHour += newMinute / 60;
		int newDate = date;
		String newMonth = new String();
		newMonth = month;
		int newYear = year;
		
		if (newHour >= 24)
		{
			newDate = date + newHour / 24;
			newHour = newHour - 24 * (newHour / 24);
		}
		if (newDate >= monthAndDays.get(month))
		{
			newMonth = months.get((months.indexOf(month) + 1) % 12);
			newDate = newDate % monthAndDays.get(month);
			if (((months.indexOf(month) + 1) == 12) && (months.indexOf(newMonth) + 1) == 1)
					newYear += 1;
		}
		
		String hourString = new String();
		if (newHour < 10)
			hourString = "0" + Integer.toString(newHour);
		else
		{
			hourString = Integer.toString(newHour);
		}
		String minuteString = new String();
		if (newMinute < 10)
			minuteString = "0" + Integer.toString(newMinute);
		else
			minuteString = Integer.toString(minute);
		return String.format("%d-%s-%d %s:%s", newYear, months.indexOf(newMonth) + 1, newDate, hourString, minuteString);
	}
	
	static boolean isNew(int a)
	{
		int b = a;
		boolean flag = true;
		int counter = 0;
		int[] a_raz = new int[Integer.toString(a).length()];
		while (a != 0)
		{
			a_raz[counter] = a % 10;
			a = a / 10;
			counter += 1;
		};		
		for(int i = 0; i < a_raz.length / 2; i++)
		{
		    int temp = a_raz[i];
		    a_raz[i] = a_raz[a_raz.length - i - 1];
		    a_raz[a_raz.length - i - 1] = temp;
		}
		int x;
		for (int i = 0; i < a_raz.length; i++)
		{
			
			for (int j = 0; j < a_raz.length; j++)
			{
				x = a_raz[i];
				int[] new_mas = a_raz.clone();
				if (i != j)
				{
					new_mas[i] = new_mas[j];
					new_mas[j] = x;
					counter = new_mas.length - 1;	
					int number = 0;
					for (int f = 0; f < new_mas.length; f++)
					{
						number += new_mas[f] * Math.pow(10, counter);
						counter -= 1;
					}
					if ((new_mas[0] != 0) && (number < b))
						flag = false;
				}
			}
		}
		return flag;
	}
}