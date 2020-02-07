package com.bridgelabz.fellowship.basicCoreprograms.Utility;

public class Utility 
{
	private Utility()
	{
		//By creating private constructor we can prevent creating objects of utility from outside the class.
	}
	/***
	 * Define static function helloUser() 
	 * 
	 * @param name
	 *        ---->String
	 * @return void
	 */
	public static void helloUser(String name) 
	{
		String s= "hello <<Username>> .How are you";
		String a=s.replace("<<Username>>",name);
		System.out.println(a);
	}
	/***
	 *  Define static function primefactors() 
	 * 
	 * @param n
	 *      --->int
	 * @return void
	 */
	public static void primefactors(int n) 
	{
		for(int i=2;i<n;i++)
		{
			while(n%i==0)
			{
				System.out.println(i);
				n=n/i;
			}
		}
		if(n>2)
		{
			System.out.println(n);
		}
	}
	/***
	 * Define static function Flipcoin()
	 * 
	 * @param n
	 *       --->int 
	 * @return String
	 */
	public  static String flipcoin(int n)
	{
		int heads=0;
		int tails=0;
		int count=1;
		double randomval;
		while(count<=n)
		{
			randomval=Math.random();
			System.out.println(randomval);
			if(randomval<0.5)
			{
				heads++;
				System.out.println("the no of heads is "+heads);
			}
			else
			{
				tails++;
				System.out.println("the no of tails are"+tails);
			}
			count++;
		}
		System.out.println("no of heads "+heads);
		System.out.println("no of flips"+n);
		int headper=(heads*100)/n;


		System.out.println("no of tails "+tails);
		System.out.println("no of flips"+n);
		int tailsper=(tails*100)/n;


		return headper+" ,"+tailsper;

	}
	/***
	 * Define static function leapyear()
	 * 
	 * @param year
	 *       ---->int
	 * @return int
	 */
	public static int leapyear(int year)
	{
		boolean leap=false;
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
					leap=true;
				else
					leap=false;
			}
			else
			{
				leap=true;
			}
		}
		else
		{
			leap=false;
		}
		if(leap)
		{
			System.out.println("the year is leap year:"+year);
		}
		else
		{
			System.out.println("the year is not leap year:"+year);
		}
		return year;
	}
	/***
	 * Define static function powerof2()
	 * 
	 * @param n
	 *    ----> int
	 *    
	 * @return void
	 */
	public static void  powerof2(int n)
	{
		int i=0;
		int power=1;
		while(i<=n)
		{
			System.out.println("2 ^"+i+ "="+power);
			power=power*2;
			i++;
		}
	}
	/***
	 * Define static function harmonic()
	 * 
	 * @param n
	 *      ------>int
	 *      
	 * @return float
	 */
	public static float harmonic(int n)
	{
		float harmonic=1;
		for(int i=2;i<=n;i++)
		{
			harmonic=harmonic+(float)1/i;
		}
		return harmonic;

	}
}

