package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Create a Slot of 10 to store Chain of Numbers that belong to each Slot to efficiently search a number from a given set of number b
  
 **/

/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.bridgelabz.fellowship.InputUtility.InputUtility;

public class Hashingfunction {

	@SuppressWarnings("rawtypes")
	LinkedList[] order = new LinkedList[11];
	public static final String path = "F:\\testout1.txt";
	public static final String file = "F:\\testout1Example.txt";
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> Hashingfunction() throws IOException {
		try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
			ArrayList<String> al = new ArrayList<>();
			while (buffer.ready()) {
				al.add(buffer.readLine());
			}

			System.out.println("enter the keyword ALL to display all numbers from the file  ");
			String press = InputUtility.next();
			if (press.equals("all")) {
				String[] s = new String[al.size()];
				for (int j = 0; j < al.size(); j++) {
					s[j] = al.get(j);
					System.out.println(s[j]);

				}
				int size = s.length;
				int[] a = new int[size];// converting string[] to integer[] array
				for (int i = 0; i < size; i++) {
					a[i] = Integer.parseInt(s[i]);
				}
				System.out.println("the integer  array" + Arrays.toString(a));

				Map<Integer, ArrayList<Integer>> hm = new HashMap<>();
				for (int i = 0; i < a.length; i++) {

					int rem = a[i] % 11;
					System.out.println("the rem isn " + rem+" for ");
					if (order[rem] == null) {
						order[rem] = new LinkedList();
						order[rem].add(a[i]);
					}
					else 
					{
						order[rem].add(a[i]);
					}
				}
				for (int i = 0; i < 11; i++) {
					if (order[i] != null) {
						ArrayList al1 = order[i].display();
						hm.put(i, al1);
					}
						Set<Entry<Integer, ArrayList<Integer>>> st = hm.entrySet();
						try(FileWriter f=new FileWriter(file))
						{
						for (Map.Entry<Integer, ArrayList<Integer>> me : st) {
							System.out.println("---------------------");
							System.out.println("Slot number:"+me.getKey() +   ":"   +me.getValue());
							
							f.write("Slot number:"+me.getKey() +   ":"   +me.getValue());
						}
						System.out.println("file has been writtened!!");
						}
						
							catch(IOException e)
							{
							e.printStackTrace();
							}
					}
				}
			}
		}
	

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, CustomizedException {
		Hashingfunction h = new Hashingfunction();
	}

}

