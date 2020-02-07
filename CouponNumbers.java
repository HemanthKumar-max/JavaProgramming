package com.bridgelabz.fellowship.LogicalPrograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Given N distinct Coupon Numbers, how many random numbers do you need to generate distinct coupon number? This program simulates this random process. b
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.LogicalPrograms.utility.Utility;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CouponNumbers 
{
	public static void main(String[] args) 
	{
		int n=Integer.parseInt(args[0]);
		ArrayList<Integer> list=Utility.collect(n);
		System.out.println("the total coupons collected"+list);
		Integer[] a=new Integer[list.size()];
		for(int i=0;i<a.length;i++)
		{
			a[i]=list.get(i);
		}
		Set<Integer> s=new HashSet<>();
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j] && i!=j)
					s.add(a[j]);
			}
		}
		System.out.println("the repeated coupons are"+s);
	}
}
