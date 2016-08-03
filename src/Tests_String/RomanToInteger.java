package Tests_String;

import java.util.HashMap;

import Utils.U;

public class RomanToInteger {

	public RomanToInteger() {
		U.print(intToRoman(19));
	}

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int ans = 0;
		char[] cs = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (map.get(cs[i]) < map.get(cs[i + 1]))
				ans -= map.get(cs[i]);
			else
				ans += map.get(cs[i]);
		}
		ans += map.get(cs[s.length() - 1]);
		return ans;

	}

	public String intToRoman(int num) {
		String ans;
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String M[] = { "", "M", "MM", "MMM" };
		ans = M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
		return ans;
	}

}
