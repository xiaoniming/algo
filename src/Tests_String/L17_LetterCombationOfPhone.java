package Tests_String;

import java.util.LinkedList;
import java.util.List;

import Utils.U;

//完全没想出来.... Pathetic

public class L17_LetterCombationOfPhone {

	public L17_LetterCombationOfPhone() {
		U.print(letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {

		// ans 是一个LinkedList，每次取出ans中已经生成的所有答案，一个个加上最新的digits[i]的每一个字母，然后再放回链表
		LinkedList<String> ans = new LinkedList<>();
		if (digits == null || digits.length() == 0)
			return ans;
		ans.add("");

		String map[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		for (int i = 0; i < digits.length(); i++) {
			String toAdd = map[digits.charAt(i) - '0']; // Very Smart
			while (ans.peek().length() == i) { // 停止条件就是每一个都已经加完，长度+1
				String temp = ans.removeFirst(); // 取出
				for (char c : toAdd.toCharArray()) {
					ans.add(temp + c);// 逐个加上
				}
			}
		}
		return ans;
	}

}
