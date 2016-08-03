package Tests_String;

import java.util.Stack;

import Utils.U;

public class ReverseString {

	public ReverseString() {
		U.print(reverseString2("hello"));
	}

	// My stupid Method
	public String reverseString(String s) {
		if (s == null || s.length() == 0)
			return "";

		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			stack.push(c);
		}

		StringBuilder ans = new StringBuilder();
		while (!stack.isEmpty())
			ans.append(stack.pop());
		return ans.toString();
	}

	// Simplest code
	public String reverseString2(String s) {
		StringBuilder builder = new StringBuilder(s);
		return builder.reverse().toString();

	}

	// quick change using swap method
	public String reverseString3(String s) {
		if (s == null || s.length() == 0)
			return "";
		char[] cs = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char t = cs[i];
			cs[i] = cs[j];
			cs[j] = t;
			i++;
			j--;
		}
		return new String(cs);
	}

}
