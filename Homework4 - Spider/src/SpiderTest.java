import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.*;


public class SpiderTest {
	
	public static void main (String [] args){
		
			String[] urls = { "http://www.whitworth.edu/cms/", "http://www.espn.com/", "http://www.whitworthpirates.com/landing/index",
					"http://www.nfl.com/", "http://www.nba.com/", "http://www.ncaa.com/", "http://www.athletic.net/", "http://www.un.org/en/index.html"}; 
            threadable[] thrd = new threadable[8];
            Thread[] threads = new Thread[8];
            for (int i = 0; i < 8 ; i++){
            	thrd[i] = new threadable(urls[i]);
            	threads[i] = new Thread(thrd[i]);
            	threads[i].start();
            	try{
            		Thread.sleep(100);
            		System.out.printf("test\n");
            	}catch (InterruptedException ex) {;}
     
      }
            for (int i = 0;i < 8; i++){
            	try{
            	threads[i].join();
            	}catch (InterruptedException ex) {;}
            }
    }
		
		}
	
	

class threadable implements Runnable {
	Map<String, Boolean> Hmap = new HashMap<String, Boolean>();
	public threadable(String seed) {
		 Hmap.put(seed, false);
		
	}
	public void run(){
		int counter = 0;
		String u = getNext();
		for (; counter < 100 && u != null; counter++){
			try {
			URL url = new URL(u);	
		
		BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;

		while ((line = rdr.readLine()) != null) {
			Pattern URL = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
			Matcher match = URL.matcher(line);
			if (match.find() && !Hmap.containsKey(match.group(1))){
				Hmap.put(match.group(1), false);
				System.out.printf(match.group(1));
				System.out.printf("\n");
			} 
			
			}

		}   catch (Exception ex) {
		
		System.out.printf("Oops: %s", ex.getMessage());
}
			u = getNext();
}
		}
	
	public String getNext(){
		for (Map.Entry<String, Boolean> e : Hmap.entrySet()){
			if (e.getValue() == false){
				Hmap.put(e.getKey(), true);
				return e.getKey();
			}
		}return null;
	}
}
