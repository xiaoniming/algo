package Tests_String;

import java.util.LinkedList;
import java.util.List;

import Utils.U;

//��ȫû�����.... Pathetic

public class L17_LetterCombationOfPhone {

	public L17_LetterCombationOfPhone() {
		U.print(letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {

		// ans ��һ��LinkedList��ÿ��ȡ��ans���Ѿ����ɵ����д𰸣�һ�����������µ�digits[i]��ÿһ����ĸ��Ȼ���ٷŻ�����
		LinkedList<String> ans = new LinkedList<>();
		if (digits == null || digits.length() == 0)
			return ans;
		ans.add("");

		String map[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		for (int i = 0; i < digits.length(); i++) {
			String toAdd = map[digits.charAt(i) - '0']; // Very Smart
			while (ans.peek().length() == i) { // ֹͣ��������ÿһ�����Ѿ����꣬����+1
				String temp = ans.removeFirst(); // ȡ��
				for (char c : toAdd.toCharArray()) {
					ans.add(temp + c);// �������
				}
			}
		}
		return ans;
	}

}
