import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NameSorter {
	public static void main(String[] args) throws IOException {
		//Initialize the file to be read
		File file = new File("D:\\unsorted-names-list.txt");
		
		//Check if the file exists
		if (file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));

			ArrayList<String> names = new ArrayList<String>();
			String line = "";
			
			//Get all names from the file
			while ((line = br.readLine()) != null) {
				names.add(line);
			}
			br.close();
			
			//Get number of the names
			int numberofname = names.size();
			
			String temp = "";
			
			//Sorting...
			for (int i = 0; i < numberofname; i++) {
				for (int j = 1; j < numberofname; j++) {
					//Use substring to check and sort the name by last name (last word from the name)
					if (names.get(j - 1).substring(names.get(j - 1).lastIndexOf(' ') + 1).compareTo(names.get(j).substring(names.get(j).lastIndexOf(' ') + 1)) > 0) {
						temp = names.get(j - 1);
						names.set(j - 1, names.get(j));
						names.set(j, temp);
					}
				}
			}
			
			//Create the output file
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\sorted-names-list.txt"));
			
			for (String name: names) {
				//Print the result
				System.out.println(name);
				
				//Write the result to the output file
				bw.write(name);
				bw.newLine();
			}
			bw.close();
			
		} else {
			System.out.println("File is not found!");
		}

	}
}
