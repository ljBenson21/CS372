import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class ReadFile {
	String path;
	
	public ReadFile(String filePath){
		path = filePath;
	}
	
	public String[] OpenFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numlines = 100;
		String[] text = new String[numlines];
		String text2;
		for (int i = 0; i < numlines; i++){
			text[i] = textReader.readLine();
			/*while (text[i] != null ){
				Pattern name = Pattern.compile("(circle)");
				Pattern ID = Pattern.compile(": (.*? )");
				Matcher match2 = ID.matcher(text[i]);
				if (match2.find())
					System.out.printf("ID: %s\n", match2.group(1));
				Matcher match = name.matcher(text[i]);
				//if (match.find())
				//	System.out.printf("name: %s", match.group(1));
			}*/
			
			if (text[i] == null)
				break;
		}
		textReader.close();
		return text;
	}
	
	
}
