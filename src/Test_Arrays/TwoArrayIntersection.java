package Test_Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import Utils.U;

public class TwoArrayIntersection {

	public static void main(String[] args) {
		U.print(intersection(new int[] { 1, 1, 2, 2, 3, 4, 5, 6 }, new int[] { 2, 2, 2, 5, 5, 5, 7, 7, 7 }));
	}

	// Given two arrays, write a function to compute their intersection.
	public static int[] intersection(int[] nums1, int[] nums2) {
		TreeSet<Integer> set = new TreeSet<>();
		TreeSet<Integer> ans = new TreeSet<>();
		for (int i : nums1) {
			set.add(i);
		}
		for (int i : nums2) {
			if (set.contains(i))
				ans.add(i);
		}
		int[] ansArray = new int[ans.size()];
		int count = 0;
		for (int i : ans) {
			ansArray[count++] = i;
		}
		return ansArray;
	}

	// Long ago stupid method
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];

		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				ans.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		int[] ansdata = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			ansdata[i] = ans.get(i);
		}
		return ansdata;

	}

}
