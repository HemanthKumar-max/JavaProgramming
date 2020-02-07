package com.bridgelabz.fellowship.LogicalPrograms.utility;

import java.util.ArrayList;

public class Utility 
{
	private Utility()
	{
		//By creating private constructor we can prevent creating objects of utility from outside the class.
	}
	/***
	 * Define static function collect()
	 * @param n
	 *     --->int
	 * @return Arraylist<Integer>
	 */
	public static ArrayList<Integer>  collect(int n) 
	{
		ArrayList<Integer> al=new ArrayList<>();
		boolean[] iscollected=new boolean[n];
		@SuppressWarnings("unused")
		int count=0;
		int distinct=0;
		System.out.println("the generated coupon is");
		while(distinct<n)
		{


			int value=getcoupon(n);
			System.out.println(value);
			al.add(value);
			count++;
			if(!iscollected[value])
			{
				distinct++;
				iscollected[value]=true;
			}
		}
		System.out.println("thw  no of distinct coupons collected is"+distinct);
		return  al;

	}
	/***
	 * Define static function getcoupon()
	 * @param n
	 *     --->int
	 * @return int
	 */
	public static int getcoupon(int n) 
	{
		return (int) (Math.random()*n);
	}
	/***
	 * Define static function gambler()
	 * @param stake
	 *       --->int
	 * @param goal
	 *       --->int
	 * @param trials
	 *       --->int
	 * @return void
	 */
	public static void gambler(int stake,int goal,int trials) 
	{
		int bet=0;
		int wins=0;
		for(int t=0;t<trials;t++)
		{
			int cash=stake;
			while(cash>0 && cash<goal)
			{
				bet++;
				if(Math.random()<0.5)
				{
					cash++;
				}
				else
				{
					cash--;
				}
			}
			if(cash==goal)
			{
				wins++;
			}
		}
		System.out.println(wins+" matches won  in no of  "+trials);
		System.out.println("percentage of game won"+100.0*wins/trials);
		System.out.println("average bets"+1.0*bet/trials);

	}
	/***
	 * Define static function start()
	 * @param start
	 *        ---->long
	 * @return long
	 */
	public  static long  start(long start)
	{
		start=System.currentTimeMillis();
		System.out.println("the start time is"+start);
		return start;
	}
	/***
	 * Define static function stop()
	 * @param stop
	 *      ---->long
	 * @return long
	 */
	public  static long stop(long stop)
	{
		stop=System.currentTimeMillis();
		System.out.println("the stop time is"+stop);
		return stop;
	}
	/***
	 * Define static function elapsedTime()
	 * @param start1
	 *        ----->long
	 * @param stop1
	 *        ---->long
	 * @return  double
	 */
	public  static double elapsedTime(long start1,long stop1)
	{
		long elapsed = stop1-start1;
		return elapsed;
	}






}



