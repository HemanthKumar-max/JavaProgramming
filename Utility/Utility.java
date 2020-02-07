package com.bridgelabz.fellowship.Algorithms.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.Algorithm.CustomizedException;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class Utility<T extends Comparable<? super T>>
{
	/**
	 * Define static function isAnagram() to check whether the two strings are equal or not.
	 * @param s1
	 *     -->String
	 * @param s2
	 *     --->String
	 * @return void
	 */
	
	static Logger logger = LogUtility.getLog();
	public static void  isAnagram(String s1,String s2)  throws CustomizedException
	{
		String a=s1.replaceAll("\\s", "");
		String b=s2.replaceAll("\\s", "");
		boolean status=true;
		if(a.length()!=b.length())//checking if length is equal or not
		{
			status=false;
			throw new CustomizedException("Length of 2 Strings should be equal!!");
		}
		else
		{
			//if equal we are converting string a and b to lowercase to charArray  and storing in charater array
			char[] Arrays1=a.toLowerCase().toCharArray();
			char[] Arrays2=b.toLowerCase().toCharArray();
			Arrays.sort(Arrays1);//sorting the  two arrays using Arrays built in function to sort.
			Arrays.sort(Arrays2);
			status=Arrays.equals(Arrays1, Arrays2);//checking that 2 strings are equal are true.
			if(status)
			{
			
				System.out.println(" s1  and s2 are Anagram");
				
			}
			else
			{
				
				System.out.println("s1 and s2 are not Anagram");
				
			}
		}
		
	}
	
	/**
	 *  Define static function bubblesort(),to sort the integers in ascending orders.
	 * 
	 * @param a
	 *      --->int[]
	 *      
	 * @return void
	 */
	public static void bubblesort(int[] a) 
	{
		
		int n=a.length;
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				if(a[j]>a[j+1])
				{
					
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					
				}
			}
		}
		}
		
	
		
	
	/**
	 *  Define static function printArray(),to print the bubblesort.
	 *  
	 * @param a
	 *      ---->int[]
	 *  @return void    
	 */
	public static void printArray(int[] a)
	{
		int n=a.length;
		System.out.println("the sorted array  using bubblesort is:");
	for(int i=0;i<n;i++)
	{
		
		System.out.println(a[i]);
	}
	System.out.println();
  }
	/**
	 * Define static function primeNumbers(),to prime numbers from the given input of range.
	 * @param low
	 *     --->int
	 *     
	 * @param high
	 *      --->int
	 *      
	 *  @return void    
	 */
	public static void primeNumbers(int low,int high)
	{
		boolean flag=false;
		for(int i=2;i<=low/2;++i) 
		{
			if(low%i==0)
			{
				flag=true;
				break;
			}
		}
		if(!flag)
		    System.out.print(low+" ");
			++low;
	}
	/**
	 * Define static function replaceWithPattern(),to replace all the strings with the given input of strings using regex.
	 * @param str
	 *      --->String
	 * @param s1
	 *       --->String
	 * @param s2
	 *      --->String
	 * @param s3
	 *      --->String
	 * @param s4
	 *      --->String
	 *      
	 * @return String
	 * 
	 */
  public static String replaceWithPattern(String str,String s1,String s2,String s3,String s4){
        
        Pattern ptn = Pattern.compile("<<name>>");
        Matcher mtch = ptn.matcher(str);
        str=mtch.replaceAll(s1);
        
        ptn = Pattern.compile("<<full name>>");
        mtch = ptn.matcher(str);
        str=mtch.replaceAll(s2);
        
        ptn = Pattern.compile("xxxxxxxxxx");
        mtch = ptn.matcher(str);
        str=mtch.replaceAll(s3);
        
        ptn = Pattern.compile("xx/xx/xxxx");
        mtch = ptn.matcher(str);
        str=mtch.replaceAll(s4);
        
        return str;
  }
  /**
   *Define static function insertionsort(),to sort the following strings in ascending order.
   * 
   * @param s
   *     --->String
   * @return void
   */

@SuppressWarnings({ "rawtypes", "unchecked" })
public static void insertionsort(Comparable[] s)
	{
		int n=s.length;
		for(int i=1;i<n;i++)
		{
			Comparable key=s[i];
			int j=i;
			while(j>0 && s[j-1].compareTo(key)>1)
			{
				s[j]=s[j-1];
				j--;
			}
			s[j]=key;
			}	
		}

/**
 * Define static function printArray(),to print the sorted strings in ascending order.
 * 
 * @param a
 *     --->String
 * @return void 
 */

	@SuppressWarnings("rawtypes")
	public static void printArray(Comparable[] a)
	{
		int n=a.length;
		System.out.println("the sorted array of strings using insertion sort are");
	for(int i=0;i<n;i++)
	{
		System.out.println(a[i]);
	}
	System.out.println();
}	
	/**
	 * Define static function magicnum(),to find the number.
	 * 
	 * @param i
	 *      --->int
	 * @param N
	 *      --->int
	 *      
	 * @return int
	 */
	public static int magicnum(int i, int N)
	{
		if((N-i)==1)
		{
			return i;
		}
		
		int mid=(i+N)/2;
		System.out.println("enter yes/no if number lesser/greater than "+mid);
		String a=Inpututility.next();
	    if(a.equalsIgnoreCase("yes"))
	    {
	    	N=mid;
	    	return magicnum(i,N);
	    }
	    else if(a.equalsIgnoreCase("no"))
	    {
	    	i=mid;
	    	return magicnum(i,N);
	    			
	    }
	    else if(N==mid)
	    {
	    	return mid;
	    }
	    else
	    {
	    	System.out.println("invalid number");
	    }

		return i;
	}
	/**
	 * Define static function mergesort(),to sort the strings in ascending order.
	 * 
	 * @param s
	 *     --->String
	 *     
	 * @return void    
	 */
	public static void mergesort(String[] s)
	{
	if(s.length>=2)
	{

	String[] L=new String[s.length/2];
	String[] R=new String[s.length-s.length/2];

    for(int i=0;i<L.length;i++)
	L[i]=s[i];

	for(int j=0;j<R.length;j++)
	R[j]=s[j+s.length/2];

	mergesort(L);
	mergesort(R);
	merge(s,L,R);

	}
	}

    /**
     *  Define static function merge(),to sort the strings in ascending order.
     * @param s
     *     --->String[]
     *     
     * @param L
     *     --->String 
     * @param R
     *     --->String
     * @return void
     */
	public static void merge(String[] s,String[] L,String[] R)
	{
	int a=0;
	int b=0;
	for(int i=0;i<s.length;i++)
	{
		if(b>=R.length|| (a<L.length  && L[a].compareToIgnoreCase(R[b])<0))
		{
			s[i]=L[a];
			a++;
		}
		else
		{
			s[i]=R[b];
		    b++;
	    }
	}   
	}
	/**
	 *  Define static function printArray(),to print the Array of strings.
	 *  
	 * @param s
	 *     --->String
	 * @return void    
	 */
	public static void printArray(String[] s)
	{
	int n=s.length;
	System.out.println("the soorted array are");
	for(int i=0;i<n;i++)
	{
	System.out.println(s[i]);
	}
	System.out.println();
	}
	/**
	 *  Define static function prime(),to find the prime numbers for a given range.
	 *  
	 * @param m
	 *    --->int
	 *    
	 * @param n
	 *     --->int
	 * @return void
	 */
	public static void prime(int m,int n)
	{
		System.out.println("the prime nos between "+m+" and "+n+ " are");
		while(m<n)
		{
			boolean flag=false;
			for(int i=2;i<=m/2;++i) 
			{
				if(m%i==0)
				{
					flag=true;
					break;
				}
			}
			if(!flag)
			
				System.out.print(m+" ");
				++m;
			
	}
	}


   /**
    * Define static function primeAnagrams(),to find the anagrams of number that are prime.
    * @param m
    *     --->int m
    *     
    * @param n
    *     ---->int n
    */
	public static void primeAnagrams(int m,int n) 
	{
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		System.out.println();
		boolean b;
		for (int j = m; j <= n; j++) {
			b = true;
			for (int i = 2; i < j / 2; i++) {
				if (j % i == 0) {
					b = false;
					break;
				}
			}
			if (b)
				ar.add(j);
		}
		System.out.println("prime numbers that are anagram");
		for (int i = 0; i < ar.size(); i++) {
			for (int j = i + 1; j < ar.size(); j++) {
				if (anagram(ar.get(i), ar.get(j)))
				{
					System.out.println(ar.get(i) + "  " + ar.get(j));
				}
			}
		}
	}
	/**
	 * Define static function anagram(), to find the anagrams of 2 numbers
	 * @param n1
	 *      -->int
	 * @param n2
	 *     --->int
	 *     
	 * @return boolean
	 */
	public static boolean anagram(int n1, int n2) {
		int[] n1count = count(n1);
		int[] n2count = count(n2);
		for (int i = 0; i < n2count.length; i++) {
			if (n1count[i] != n2count[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Define static function count(),to find number of anagrams are there in given range. 
	 * @param n
	 *     --->int
	 *     
	 * @return int[]
	 * 
	 */
	public static int[] count(int n) {
		int[] count = new int[10];
		int temp = n;
		while (temp != 0) {
			int r = temp % 10;
			count[r]++;
			temp = temp / 10;
		}
		return count;
	}
	/**
	 * Define static function primePalindrome(),to find the palindrome of numbers that are prime.
	 * @param m
	 *    --->int
	 *    
	 * @param n
	 *      --->int
	 * @return void
	 */
	public static void primePalindrome(int m,int n) 
	{
		System.out.println();
		boolean b;
		for (int j = m; j <= n; j++) {
			b = true;
			for (int i = 2; i < j / 2; i++) {
				if (j % i == 0) {
					b = false;
					break;
				}
			}
			if (b && isPalindrome(j))
				System.out.print(j + " ");
		}
	
	}
	/**
	 * Define static function ispalindrome() to check whether the number is palindrome or not.
	 * @param n
	 *     --->int
	 *     
	 * @return boolean
	 */
	public static boolean isPalindrome(int n)
	{
		int temp = n;
		int sum = 0;
		while (temp != 0) {
			int r = temp % 10;
			sum = sum * 10 + r;
			temp = temp / 10;
		}
		if (sum == n) {
			return true;
		}
		return false;
	}
	/**
	 * Define  function bubblesort(),to sort the string,integer etc in ascending order using generics.
	 *
	 * @param array
	 *        ---->Generic type T[] 
	 * @return void
	 */
	public   void bubbleSort(T[] array)
	{
		int n = array.length;
	    while (n > 0)
	    {
	        int lastModifiedIndex = 0;
	        for (int currentIndex = 1; currentIndex < n; currentIndex++)
	        {
	            // if the item at the previous index is greater than the item at the `currentIndex`, swap them
	            if (((array[currentIndex - 1]).compareTo( array[currentIndex]) > 0))
	            {
	                // swap
	                T temp = array[currentIndex - 1];
	                array[currentIndex - 1] = array[currentIndex];
	                array[currentIndex] = temp;
	                // save the index that was modified
	                lastModifiedIndex = currentIndex;
	            }
	        }
	        // save the last modified index so we know not to iterate past it since all proceeding values are sorted
	        n = lastModifiedIndex;
	    }	
	}
	/**
	 * Define  function insertionsort(),to sort the strings,integers etc in ascending order using generics.
	 * 
	 * @param array
	 *        ---->Generic type T[]
	 * @return void
	 */
	 public void insertionSort(T[] array)
	{
	    // start at the first index and iterate through to the end
	    for (int i = 1; i < array.length; i++)
	    {
	        int currentIndex = i;
	        /*
	         * Check:
	         *      1. that currentIndex is at least 1
	         *      2. that the item directly before the currentIndex is greater than the item at currentIndex
	         *
	         * If both conditions are met, swap the indexes
	         */
	        while (currentIndex > 0 && array[currentIndex - 1].compareTo(array[currentIndex]) > 0)
	        {
	            T temp = array[currentIndex];
	            array[currentIndex] = array[currentIndex - 1];
	            array[currentIndex - 1] = temp;
	            currentIndex--;
	        }
	    }
	}
	 
	/**
	 * Define function mergesort(),to sort the first array and second array.
	 * 
	 * @param array
	 *        --->Generic type T[]
	 *        
	 * @param start
	 *         ---->int
	 *         
	 * @param end
	 *        ---->int
	 * @return void       
	 */
	public  void mergeSort(T[] array, int start, int end)
	 {
	     // base case
	     if (start < end)
	     {
	         // find the middle point
	         int middle = (start + end) / 2;

	         mergeSort(array, start, middle); // sort first half
	         mergeSort(array, middle + 1, end);  // sort second half

	         // merge the sorted halves
	         merge(array, start, middle, end);
	     }
	 }

	 // merges two subarrays of array[].
	/**
	 * Define function merge() to sort the two subarrays.
	 * 
	 * @param array
	 *        ---->Generic type T[]
	 * @param start
	 *        ---->int 
	 * @param middle
	 *         ---->int
	 *         
	 * @param end
	 *        ----->int
	 */
	  @SuppressWarnings("unchecked")
	public void merge(T[] array, int start, int middle, int end)
	 {
		  
	     T[] leftArray  = (T[]) new Comparable[middle - start + 1];
	    T[] rightArray = (T[]) new Comparable[end - middle];

	     // fill in left array
	     for (int i = 0; i < leftArray.length; ++i)
	         leftArray[i] = array[start + i];

	     // fill in right array
	     for (int i = 0; i < rightArray.length; ++i)
	         rightArray[i] = array[middle + 1 + i];

	     /* Merge the temp arrays */

	     // initial indexes of first and second subarrays
	     int leftIndex = 0, rightIndex = 0;

	     // the index we will start at when adding the subarrays back into the main array
	     int currentIndex = start;

	     // compare each index of the subarrays adding the lowest value to the currentIndex
	     while (leftIndex < leftArray.length && rightIndex < rightArray.length)
	     {
	         if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0)
	         {
	             array[currentIndex] = leftArray[leftIndex];
	             leftIndex++;
	         }
	         else
	         {
	             array[currentIndex] = rightArray[rightIndex];
	             rightIndex++;
	         }
	         currentIndex++;
	     }

	     // copy remaining elements of leftArray[] if any
	     while (leftIndex < leftArray.length) array[currentIndex++] = leftArray[leftIndex++];

	     // copy remaining elements of rightArray[] if any
	     while (rightIndex < rightArray.length) array[currentIndex++] = rightArray[rightIndex++];
	 }
	  /***
	   * Define a static function permutations() to find the permutations of a string using iterative method
	   * @param s
	   *      --->String
	   * @return  void
	   */
	  public static void permutationsIterative(String s)
	  {
	  	List<String> l=new ArrayList<String>();
	  	l.add(String.valueOf(s.charAt(0)));
	  	for(int i=1;i<s.length();i++)//finding the value of whole string
	  	{
	  		for(int j=l.size()-1;j>=0;j--)//iterating
	  		{
	  			String str=l.remove(j);
	  			System.out.println("the str is "+str);
	  			for(int k=0;k<=str.length();k++)
	  			{
	  				l.add(str.substring(0,k)+s.charAt(i)+str.substring(k));
	  			}
	  			System.out.println("the list is "+l);
	  		}
	  	}
	  }
	  /**
	   * Define the static function swap() to swap the characters using temp variable.
	   * @param ch
	   *      --->character[]
	   * @param i
	   *      --->int
	   * @param j
	   *      --->int
	   * @return void    
	   */
	  public static void swap(char[] ch,int i,int j)
	  {
	  	char temp=ch[i];
	  	ch[i]=ch[j];
	  	ch[j]=temp;
	  }


      /***
       * Define the static function permutations(),to find the permutations of a string using recursive method.
       * @param ch
       *     --->char[]
       * @param currentindex
       *         --->int
       * @return  void 
       */
	  public static void permutationsRecursive(char[] ch,int currentindex)
	  {
	  	if(currentindex==ch.length-1)
	  	{
	  		System.out.println(String.valueOf(ch));
	  	}
	  	for(int i=currentindex;i<ch.length;i++)
	  	{
	  		swap(ch,currentindex,i);
	  		permutationsRecursive(ch,currentindex+1);
	  		swap(ch,currentindex,i);
	  		
	  	}
	  }
	  
	  
	  
	  
	  
	  
	  
}
