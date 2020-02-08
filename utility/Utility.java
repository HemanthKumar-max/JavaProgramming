package com.bridgelabz.fellowship.JunitTesting.utility;



public class Utility 
{
	private Utility()
	{
		//By creating private constructor we can prevent creating objects of utility from outside the class.	
	}
	/***
	 * Define static function dayofweek()
	 * @param m
	 *     --->int
	 * @param d
	 *      --->int
	 * @param y
	 *      --->int
	 * @return int
	 */
	public static int dayofweek(int m,int d,int y)
	{
		int y0=y-(14-m)/12;
		int x=y0+y0/4 - y0/100 + y0/400;
		int m0=m+12*((14-m)/12)-2;
		int d0=(d+x+31*m0/12)%7;
		System.out.println(d0);
		if(d0==0)
		{
			System.out.println("the day is sunday");
		}
		else if(d0==1)
		{
			System.out.println("the day is monday");
		}
		else if(d0==2)
		{
			System.out.println("the day is tuesday");
		}
		else if(d0==3)
		{
			System.out.println("the day is wednesday");
		}
		else if(d0==4)
		{
			System.out.println("the day is thursday");
		}
		else if(d0==5)
		{
			System.out.println("the day is friday");
		}
		else
		{
			System.out.println("the day is saturday");
		}
		return d0;
	}
	/***
	 * Define static function celsius()
	 * @param t
	 *     --->double
	 * @return double
	 */
	public  static double celsius(double t) 
	{
		double c=(t-32)*5/9;
		return c;
	}
	/***
	 * Define static function temperature()
	 * @param c
	 *     --->double
	 * @return double
	 */
	public  static  double temperature(double c) 
	{
		double t=(c*9/5)+32;
		return t;
	}
	/***
	 * Define static function payment()
	 * @param p
	 *     ---->int
	 * @param y
	 *      ---->int
	 * @param r
	 *      ---->int
	 *      
	 * @return  int
	 */
	public static int payment(int p,int y,int r)
	{
		int N=12*y;
		int R=r/(12*100);
		int payment= p*R/1-(1+R)^(-N);
		System.out.println("the payment is "+payment);
		return payment;
	}
	/***
	 * Define static function calculate()
	 * 
	 * @param money
	 *         --->int
	 * @param notes
	 *        ---->int[]
	 * @param i
	 *        ----->int
	 * @param total
	 *       ---->int
	 * @return int
	 */
	public static int calculate(int money,int[] notes,int i,int total)
	{
		int rem;
		if(money==0)
		{
			return -1;
		}
		else
		{
			if(money>=notes[i])
			{
				int calnotes=money/notes[i];
				rem=money%notes[i];
				money=rem;
				total=total+calnotes;
				System.out.println(notes[i] +" notes-->"+calnotes);
			}
			i++;
			return calculate(money,notes,i,total);
		}
	}
	/***
	 * Define static function sqrt()
	 * 
	 * @param t
	 *      --->int
	 *      
	 * @return int 
	 */
	public static int sqrt(int t)
	{
		int c=t;
		@SuppressWarnings("unused")
		int e=1;
		double epilson=1e-15;
		while(Math.abs(t-c/t)>epilson*t)
		{
			t=(c/t + t) / 2;
		}
		return t;
	}
	/***
	 * Define static function binary()
	 * @param n
	 *    --->int
	 * @param x
	 *      --->String
	 * @return String
	 * 
	 */
	public static String  binary(int n,String x)
	{
		while(n>0)
		{
			int a=n%2;
			x=a+x;
			n=n/2;
		}
		System.out.println(x);
		return x;
	}
	/***
	 * Define static function swapnibbles()
	 * @param x
	 *     --->int
	 * @return int
	 */
	public static int swapnibbles(int x)
	{ 
		return ((x & 0x0F) << 4 | (x & 0xF0) >> 4); 	   
	}


}
