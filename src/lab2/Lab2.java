package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) {
		
		
		Scanner scanner = null;
		try {
			System.out.printf("Search for word: ");
			scanner = new Scanner(System.in);
			String searchForWord = scanner.nextLine().toLowerCase();
			
			System.out.printf("in path: ");
			String path = scanner.nextLine();

			File startingFolder; 
			

			if(path.equals("") || path.equals(" ")) {
				startingFolder = new File("c:\\temp\\");
			} else {
				startingFolder = new File(path);
			}
			
			System.out.println("Starting search for \"" + searchForWord + "\" in folder: " + startingFolder.getCanonicalPath());
			fileCrawler(startingFolder, searchForWord);
			

		} catch (Exception e) {
			System.out.println("FEL!");
		} finally {
			scanner.close();
		}
		return;
	}
	

	public static void fileCrawler(File file, String searchForWord) {

		/*
		 * If path is a file
		 */
		if (file.isFile()) {
			Scanner fileSearcher = null;
			try {
				fileSearcher = new Scanner(file);
				int i = 0;
				while (fileSearcher.hasNext()) {
					i++;
					if (searchForWord.equals(fileSearcher.next().toLowerCase())) {
						try {
							System.out.println(("Ord nummer " + i + " i filen: " + file.getCanonicalPath()));
							// break if only printing once;
							//
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				fileSearcher.close();
			}
			/*
			 * If path is a directory
			 */
		} else if (file.isDirectory()) {

			File[] folderContents = file.listFiles();

			for (int i = 0; i < folderContents.length; i++) {
				File f = folderContents[i];
				fileCrawler(f, searchForWord);
			}

		}

	}

}
