package com.example.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		List<String> arg=Arrays.asList("hai","hello","hai","ramesh","ramesh","hi","hi");
        // Initialize frequency table from command line
        for (String a : arg) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
//        System.out.println(m.keySet());
//        System.out.println(m.values());
//        System.out.println(m.entrySet());
        Map<String , Integer> n=new HashMap<String, Integer>();
//        n.put("one", 1);
        n.put("hai", 2);
        n.put("hello", 1);
        n.put("ramesh", 2);
        System.out.println(m.entrySet().containsAll(n.entrySet()));
	}

}
