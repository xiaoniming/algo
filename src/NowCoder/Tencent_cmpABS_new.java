package NowCoder;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Tencent_cmpABS_new {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N, data;
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		while (scanner.hasNext()) {
			N = scanner.nextInt();
			hashmap.clear();
			for (int i = 0; i < N; i++) {
				data = scanner.nextInt();
				if (hashmap.containsKey(data)) {
					hashmap.put(data, hashmap.get(data) + 1);
				} else {
					hashmap.put(data, 1);
				}
			}
			minMax(hashmap);
		}
		scanner.close();
	}

	// arr[][0] is number to compare, arr[][1] is count of this number
	public static void minMax(HashMap<Integer, Integer> map) {
		int[][] arr = sortMap(map);
		int minAbs = Integer.MAX_VALUE, minPair = 0, maxAbs = 0, maxPair = 0;
		// when all number are the same
		if (arr.length == 1) {
			minAbs = 0;
			minPair = arr[0][1] * (arr[0][1] - 1) / 2;
			maxAbs = 0;
			maxPair = minPair;
		} else {
			// calculate max
			maxAbs = arr[arr.length - 1][0] - arr[0][0];
			maxPair = arr[arr.length - 1][1] * arr[0][1];
			// calculate min
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][1] > 1) {
					if (minAbs > 0) {
						minPair = 0;
					}
					minAbs = 0;
					minPair += arr[i][1] * (arr[i][1] - 1) / 2;
					continue;
				}
				if (i == 0) {
					continue;
				}
				if (minAbs < arr[i][0] - arr[i - 1][0]) {
					continue;
				}
				if (minAbs > arr[i][0] - arr[i - 1][0]) {
					minAbs = arr[i][0] - arr[i - 1][0];
					minPair = 1;
				} else if (minAbs == arr[i][0] - arr[i - 1][0]) {
					minPair += 1;
				}
			}
		}
		System.out.println(minPair + " " + maxPair);
		// System.out.println("min " + minAbs + ": " + minPair + " pairs");
		// System.out.println("max " + maxAbs + ": " + maxPair + " pairs");
	}

	/**
	 * sort map by its key, using Collections.sort(list, Comparator)
	 */
	public static int[][] sortMap(HashMap<Integer, Integer> map) {
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		List<Entry<Integer, Integer>> sortList = new LinkedList<Entry<Integer, Integer>>(entrySet);
		Collections.sort(sortList, new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// increase sort by key
				return o1.getKey().compareTo(o2.getKey());
			}

		});
		int[][] sorted = new int[sortList.size()][2];
		int count = 0;
		for (Entry<Integer, Integer> e : sortList) {
			sorted[count][0] = e.getKey();
			sorted[count][1] = e.getValue();
			count++;
		}
		return sorted;
	}

}
