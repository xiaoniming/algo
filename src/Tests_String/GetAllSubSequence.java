package Tests_String;

import java.util.ArrayList;
import java.util.List;

//列出所有子序列
public class GetAllSubSequence {

	public static List<String> getAllSubSequence(String arr) {
		List<String> result = new ArrayList<>();
		int arrLength = arr.length();
		int count = (int) Math.pow(2, arr.length());

		for (int i = 1; i < count; i++) {

			String binary = Integer.toBinaryString(i);
			// System.out.println("binary=" + binary);
			int binaryLength = binary.length();
			char[] charArr = new char[arrLength];
			for (int n = 0; n < charArr.length; n++)
				charArr[n] = '0';
			// System.out.println("---");
			// System.out.println(charArr[0]);
			int needZeroNum = arrLength - binaryLength;
			StringBuilder resultString = new StringBuilder(); // 补齐位数
			for (int j = 0; j < needZeroNum; j++) {
				charArr[j] = 0;
			}
			for (int k = 0; k < binaryLength; k++) {
				charArr[needZeroNum + k] = binary.charAt(k);
			}
			for (int m = 0; m < arrLength; m++) {
				if (charArr[m] == '1')
					resultString.append(arr.charAt(m));
			}
			result.add(resultString.toString());
			// System.out.println(resultString);
		}
		return result;
	}

}
