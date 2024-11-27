package com.example.sample;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {

		SortedMap<Integer,String> a=new TreeMap<Integer, String>();
		a.put(18, "R");
		a.put(13, "M");
		a.put(1, "A");
		a.put(7, "G");
		a.put(4, "D");
		
		System.out.println(a);
		System.out.println("First key: "+a.firstKey());
		System.out.println("Last key: "+a.lastKey());
		System.out.println("Before key-7: "+a.headMap(7));
		System.out.println("After key-7 :"+a.tailMap(7));
		System.out.println("Between 1 and 7: "+a.subMap(1, 7));
	}

}
