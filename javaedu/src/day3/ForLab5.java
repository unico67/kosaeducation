package day3;

public class ForLab5 {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 8) + 3;
		int num2 = (int) (Math.random() * 3) + 1;

		char c;
		if (num2 == 1)
			c = '*';
		else if (num2 == 2)
			c = '$';
		else
			c = '#';

		for (int i = 0; i < num1; i++) {
			System.out.print(c);
		}
	}
}
