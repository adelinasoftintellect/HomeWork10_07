import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		readFile("./files/text.txt");
		String filePath1 = "./files/text1.txt";
		String filePath2 = "./files/text2.txt";

	}

	private static void readFile(String path) {
		try {

			FileReader fileReader = new FileReader(path);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while (bufferedReader.ready()) {
				String line = bufferedReader.readLine();
				int lineNum = 0;
				FileWriter fileStream1 = new FileWriter("./files/text1.txt", true);
				FileWriter fileStream2 = new FileWriter("./files/text2.txt", true);
				BufferedWriter writer1 = new BufferedWriter(fileStream1);
				BufferedWriter writer2 = new BufferedWriter(fileStream2);
				while ((line = bufferedReader.readLine()) != null) {
					lineNum++;
					if (lineNum % 2 != 0) {

						writer1.write(line);
						continue;
					} else if (lineNum % 2 == 0) {
						writer2.write(line);
					}
				}
				writer1.flush();
				writer1.close();
				writer2.flush();
				writer2.close();
			}

			bufferedReader.close();

		} catch (Exception e) {
			System.out.println("Error while reading a file.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
