	/**
	* This class draws .
	* @author Wahab
	* @version 1.2
	*/

	package sb.elpro.utility;

	/**
	 * @author Wahab
	 *
	 */
	public class NumbertoWords {
			public enum hundreds {OneHundred, TwoHundred, ThreeHundred, FourHundred, FiveHundred, SixHundred, SevenHundred, EightHundred, NineHundred}
			public enum tens {Twenty, Thirty, Forty, Fifty, Sixty, Seventy, Eighty, Ninety}
			public enum ones {One, Two, Three, Four, Five, Six, Seven, Eight, Nine}
			public enum denom {Thousand, Lakhs, Crores}
			public enum splNums { Ten, Eleven, Twelve, Thirteen, Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen}
			public static String text = "";
		
		public static String ConvertNumberToWords(long num) throws Exception{
				
			System.out.println("lon num "+num);
			int rem = 0;
			int i = 0;
			while(num > 0)
			{
				if(i == 0){
					rem = (int) (num % 1000);
					printText(rem);
					num = num / 1000;
					i++;
				}
				else if(num > 0)
				{
					rem = (int) (num % 100);
					if(rem > 0)
						text = denom.values()[i - 1]+ " " + text;
					printText(rem);
					num = num / 100;
					i++;
				}
			}
			if(i > 0)
				System.out.println(text);
			else
				text="Zero";
			return text+" only";
		}

		public static void printText(int num) // remainder of number divided by 1000
		{
			if(!(num > 9 && num < 19))
			{
				if(num % 10 > 0) // remainder of num divided by ten
					System.out.println("Step2"+(num % 10 > 0));
					getOnes(num % 10);

				num = num / 10;
				System.out.println("Step3a"+(num));
				System.out.println("Step4"+(num = num / 10));
				if(num % 10 > 0)
					 System.out.println("Step5"+(num % 10 > 0));
					getTens(num % 10);
					System.out.println("Step6"+(num % 10));
				num = num / 10;
				System.out.println("Step8"+(num));
				System.out.println("Step9"+(num = num / 10));
				if(num > 0)
					 System.out.println("Step10"+(num));
					getHundreds(num);
			   
			}
			else
			{
				getSplNums(num % 10);
				System.out.println("Step12"+(num % 10));
			}
		}

		public static void getSplNums(int num)
		{
			 System.out.println("Step13"+(num));
			text = splNums.values()[num]+ " " + text;
			System.out.println("Step15"+(hundreds.values()[num - 1]));
		}

		public static void getHundreds(int num)
		{
			text = hundreds.values()[num - 1]+ " " + text;
			System.out.println("Step11"+((hundreds.values()[num - 1])));
		}

		public static void getTens(int num)
		{
			text = tens.values()[num - 2]+ " " + text;
			System.out.println("Step7"+(tens.values()[num - 2]));
		}

		public static void getOnes(int num)
		{
			text = ones.values()[num - 1]+ " " + text;
			System.out.println("Step3"+(ones.values()[num - 1]));
		}
		
	}
