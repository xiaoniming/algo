package Tests_String;

import Utils.U;

public class ImplementstrStr {

	public ImplementstrStr() {
		U.print(strStr("aa", "a"));
		// TODO Auto-generated constructor stub
	}

	public int strStr(String haystack, String needle) {
		// StringBuilder sb = new StringBuilder(haystack);
		// return sb.indexOf(needle);

		if (needle.length() == 0)
			return 0;
		boolean FLAG = false;
		char[] c = haystack.toCharArray();
		char[] n = needle.toCharArray();
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (c[i] == n[0]) {
				int tmp = i;
				for (int j = 0; j < n.length; j++) {
					if (n[j] != c[tmp++]) {
						FLAG = false;
						break;
					} else if (j == n.length - 1)
						FLAG = true;
				}
				if (FLAG)
					return i;
			}
		}
		return -1;
	}

	public int strStr2(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if ((i + j) >= haystack.length())
					return -1;
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
		}
	}

}
