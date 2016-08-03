package Tests_String;

import Utils.U;

/**
 * Write a function that takes a string as input and reverse only the vowels .
 * 
 * Example 1: Given s = "hello", return "holle".
 **/
public class L345_ReverseVowels {

	public L345_ReverseVowels() {

		U.print(reverseVowels("Aa"));
	}

	public String reverseVowels(String s) {
		if (s == null || s.length() == 0)
			return "";
		char[] c = s.toCharArray();
		String vowels = "aeiouAEIOU"; // both lower-case and capitals!!!
		int i = 0, j = c.length - 1;
		char tmp;
		while (i < j) {
			while (i < j && !vowels.contains(c[i] + ""))
				i++;
			while (i < j && !vowels.contains(c[j] + ""))
				j--;
			if (i < j) {
				tmp = c[i];
				c[i] = c[j];
				c[j] = tmp;
				i++; // Mark here!
				j--; // after exchange , move the pointer forward
			}
		}
		return new String(c);
	}
}
