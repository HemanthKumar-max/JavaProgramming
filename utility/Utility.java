package com.bridgelabz.fellowship.Functional.utility;


import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Utility 
{
	private Utility()
	{
		//By creating private constructor we can prevent creating objects of utility from outside the class.
	}
	/***
	 * Define static function distance()
	 * 
	 * @param x
	 *     ---->int
	 * @param y
	 *     ---->int
	 * @return double
	 */
	public static double distance(int x,int y)
	{
		double distance;
		distance=Math.sqrt(Math.pow(x*x+y*y, 2)*1.0);
		return distance;
	}
	/***
	 * Define static function quadratic()
	 * 
	 * @param delta
	 *        ----->int
	 * @param a
	 *        ------>int
	 * @param b
	 *        ---->int
	 * @param c
	 *       ----->int
	 * @return void
	 */
	public static void quadraticEquation(int delta,int a ,int b,int c)
	{
		int x1=(int) ((-b + Math.sqrt(delta))/(2*a));
		int x2=(int) ((-b - Math.sqrt(delta))/(2*a));
		System.out.println(x1);
		System.out.println(x2);


		int temp=(a*x1*x2)+(b*x1)+c;//computing the value of temp using given formula
		System.out.println("the temp is"+temp);
	}
	/***
	 * Define static function Sumofthree()
	 * 
	 * @param arr
	 *      --->int[]
	 * @param size
	 *      ---->int
	 * @return void
	 */
	public static void Sumofthree(int[] arr,int size)
	{
		int count=0;
		System.out.println("the distinct elements are:");
		for(int i=0;i<size-2;i++)
		{
			for(int j=i+1;j<size-1;j++)
			{
				for(int k=j+1;k<size;k++)
				{
					if(arr[i]+arr[j]+arr[k]==0)
					{
						count++;
						System.out.println(arr[i]+","+arr[j]+","+arr[k]);
					}
				}
			}

		}
		System.out.println("the  no of distinct elements are"+count);
	}
	/***
	 * Define static function print()
	 * @param a 
	 *       --->double[]
	 *       
	 * @throws FileNotFoundException
	 *                   --->Exception
	 * @throws UnsupportedEncodingException
	 *                   ----->Exception
	 * @return void
	 * 
	 */                  
	public static void print2DArray(double[][] a)  
	{
				
		try(PrintWriter p=new PrintWriter(new OutputStreamWriter(System.out,"UTF-8"))) 
		{
			int m=a.length;
			int n=a[0].length;
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					p.println(a[i][j]);
				}
				System.out.println();
			}
		} 
		catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
	}
		
    /***
	 * Define static function findwindchill()
	 * 
	 * @param t
	 *      --->double
	 * @param v
	 *      ---->double
	 *  @return void
	 */
	public static void findwindchill(double t,double v)
	{                             
		double w=35.74+0.6215*t+(0.4275*t-35.75)*Math.pow(v,0.16);
		System.out.println("the given temperature"+t);
		System.out.println("the given speed"+v);
		System.out.println("the windchill"+w);

	}
}

