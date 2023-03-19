package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CopyExam {

	public static void main(String[] args) {
		FileReader reader = null;
		LocalDate ld = LocalDate.now();
		int yearNum = ld.getYear();
		int monthNum = ld.getMonthValue();
		int dateNum = ld.getDayOfMonth();
		FileWriter writer = null;
		String path = String.format("c:/iotest/sample_%d_%d_%d.txt", yearNum, monthNum, dateNum);
		try {
			writer = new FileWriter(path, true);
			reader = new FileReader("c:/iotest/sample.txt");
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				char ch = (char) data;
				writer.write(ch);
			}
			System.out.print("저장이 완료되었습니다.");
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				System.out.println("처리하는 동안 오류가 발생했습니다. ");
			}
		}

	}

}
