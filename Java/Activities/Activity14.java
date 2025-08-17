package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
 
import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) {
		try {
			
			File file = new File("src/main/resources/newfile.txt");
			boolean fStatus = file.createNewFile();

			if (fStatus) {
				System.out.println("File created successfully!");
				FileUtils.writeStringToFile(file, "Some text in a file", Charset.defaultCharset());
			} else {
				System.out.println("File already exists at this path.");
			}

			// Read file
			String fileData = FileUtils.readFileToString(file, Charset.forName("UTF-8"));
			System.out.println("Data in file: " + fileData);

			// Create destination directory
			File destDir = new File("src/main/resources/destDir");
			destDir.mkdirs(); // Ensure directory exists

			// Copy file to destination directory
			FileUtils.copyFileToDirectory(file, destDir);

			// Get file from destination directory
			File newFile = FileUtils.getFile(destDir, "newfile.txt");

			// Read data from new file
			String newFileData = FileUtils.readFileToString(newFile, Charset.forName("UTF-8"));

			// Print data from new file
			System.out.println("Data in new file: " + newFileData);

		} catch (IOException errMessage) {
			System.out.println("An error occurred: " + errMessage.getMessage());
		}
	}
}