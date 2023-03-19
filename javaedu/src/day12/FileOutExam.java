package day12;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

//temp 경로 있으면 그대로 없으면 만들기
public class FileOutExam {
	public static void main(String[] args) {
		String path = "C:/Temp";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try (FileWriter writer = new FileWriter("C:/Temp/event.txt"); PrintWriter out = new PrintWriter(writer);) {
			LocalDate date = LocalDate.of(2023, 1, 1);
			int y = date.getYear();
			int m = date.getMonthValue();
			int d = date.getDayOfMonth();
			LocalDate date2 = LocalDate.of(2023, 3, 3);
			int y2 = date2.getYear();
			int m2 = date2.getMonthValue();
			int d2 = date2.getDayOfMonth();

			DayOfWeek dow = date.getDayOfWeek();
			DayOfWeek dow2 = date2.getDayOfWeek();

			out.printf("%d년 %d월 %d일은 %s입니다\n", y, m, d, dow.getDisplayName(TextStyle.FULL, Locale.KOREAN));
			out.printf("%d년 %d월 %d일은 %s입니다", y2, m2, d2, dow2.getDisplayName(TextStyle.FULL, Locale.KOREAN));
			System.out.println("저장이 완료되었습니다.");

		} catch (Exception e) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
	}
}
