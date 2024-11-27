package com.example.sample;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {

		SortedSet<Integer> nums=  new TreeSet<Integer>();
		nums.add(3);
		nums.add(5);
		nums.add(1);
		nums.add(7);
		nums.add(2);
		
		System.out.println(nums);
		System.out.println(nums.headSet(3));
		System.out.println(nums.tailSet(3));
		System.out.println(nums.first()+ " and "+nums.last());
		System.out.println(nums.subSet(3, 7));
	}

}
