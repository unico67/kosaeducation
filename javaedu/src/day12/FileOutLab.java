package day12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FileOutLab {

	public static void main(String[] args) {
		String path = "C:/Temp";
		File isDir = new File(path);
		if (!isDir.exists()) {
			isDir.mkdirs();
		}
		try (FileWriter writer = new FileWriter("c:/Temp/event.txt");) {
			LocalDate ld = LocalDate.of(2023, 5, 5);
			LocalDate ld2 = LocalDate.of(2023, 6, 6);
			DayOfWeek day = ld.getDayOfWeek();
			DayOfWeek day2 = ld2.getDayOfWeek();
			String korday = day.getDisplayName(TextStyle.FULL, Locale.KOREAN);
			String korday2 = day2.getDisplayName(TextStyle.FULL, Locale.KOREAN);

			writer.write("2023년 5월 5일은 " + korday + "입니다.\n");
			writer.write("2023년 6월 6일은 " + korday2 + "입니다.\n");

			System.out.println("저장이 완료되었습니다.");
		} catch (IOException ioe) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
	}

}
