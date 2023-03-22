package day13;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
public class ImageIOLab {
	public static void main(String[] args) {
		String path = "C:/iotest/myimage";
		File isDir = new File(path);
		if (!isDir.exists()) {
			isDir.mkdirs();
		}
		try (FileReader reader = new FileReader("c:/iotest/list.txt");
				BufferedReader br = new BufferedReader(reader);){
			
			String arr[];
			String data;

			while (true) {
				data = br.readLine();
				if (data == null)
					break;
				arr = data.split(",");
				URL req = new URL(" "+arr[1]+" ");
				InputStream is = req.openStream();
				String fileName = path+"/"+arr[0]+".jpg";
				FileOutputStream fos = new FileOutputStream(fileName);
				
				int input = 0;
				while (true) {
					input = is.read();
					if (input == -1)
						break;
					fos.write(input);
				}
				fos.close();
			}
			System.out.println("이미지 요청과 저장이 완료되었어용~~");
		} catch (MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		}
	}
}


