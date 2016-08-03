package Utils;

public class U {

	public static void print(int[] num) {
		for (int i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void print(char[] num) {
		for (char i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void print(byte[] num) {
		for (byte i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void print(Integer[] num) {
		for (Integer i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void print(long[] num) {
		for (long i : num)
			System.out.println(i + " ");

	}

	public static <T> void print(T num) {
		System.out.println(num);
	}

	public static <T> void print(T... num) {
		for (T data : num) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

}
