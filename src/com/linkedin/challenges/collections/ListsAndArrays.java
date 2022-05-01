package com.linkedin.challenges.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListsAndArrays {
	private static Integer[] arr = {1,2,3,4,5};
	private static void manipulate() {
		Collection<Integer> list = List.of(arr);
		Collection<Integer> blist = Arrays.asList(arr);
		list.stream().forEach(e -> System.out.format("%d ", e));
		System.out.println();
		blist.stream().forEach(e -> System.out.format("%d ", e));
		System.out.println();
		arr[2] = 23;
		list.stream().forEach(e -> System.out.format("%d ", e));
		System.out.println();
		blist.stream().forEach(e -> System.out.format("%d ", e));
	}
	
	public static void main(String[] args) {
		ListsAndArrays.manipulate();
	}
}
