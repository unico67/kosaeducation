package day3;

public class ForLab8 {

	public static void main(String[] args) {
		String s = "**********";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println(s);
		}

		final char STAR = '*';
		for (int col = 1; col <= 5; col++) {
			for (int row = 0; row < col - 1; row++) {
				System.out.print(' ');
			}
			for (int row = 1; row <= 10; row++) {
				System.out.print(STAR);
			}
			System.out.println();
		}
	}
}
