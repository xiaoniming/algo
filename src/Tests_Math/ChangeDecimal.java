package Tests_Math;

import java.util.Scanner;

import Utils.U;

//写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
public class ChangeDecimal {

	public ChangeDecimal() {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String str = s.next();
			str = str.substring(2, str.length());
			int dec = Integer.valueOf(str, 16);
			U.print(dec);
			U.print(Integer.toHexString(dec));

		}
		U.print(Integer.valueOf("A", 16));

	}

}
