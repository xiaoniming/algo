package Tests_String;

import java.util.HashMap;

import Utils.U;

public class L242_IsAnagram {

	public L242_IsAnagram() {
		String s = "abc";
		String t = "bac";
		U.print(isAnagram(s, t));
		U.print(isAnagram1(s, t));
	}

	// My solution using hashmap
	public boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else
				map.put(c, 1);
		}
		for (char c : t.toCharArray()) {
			if (!map.containsKey(c) || map.get(c) <= 0)
				return false;
			if (map.get(c) == 1) {
				map.remove(c);
			} else {
				map.put(c, map.get(c) - 1);
			}
		}

		return map.isEmpty();
	}

	// Others
	// only lower-case are allowed here, capitals will make array out of bond
	public boolean isAnagram1(String s, String t) {
		int[] alphabet = new int[26];
		for (char a : s.toCharArray()) {
			alphabet[a - 'a']++; // use char calculate as array index
		}
		for (char a : t.toCharArray()) {
			alphabet[a - 'a']--;
		}
		for (int i : alphabet) {
			if (i != 0)
				return false;
		}
		return true;
	}

}
