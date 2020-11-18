import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    private static ArrayList<String[]> file;
    public ReadFile(String filename, ArrayList<String[]> file) {
        try {
            this.file = new ArrayList<String[] >();
            read(filename, this.file);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(String filename, ArrayList<String[]> file) throws IOException {
        try {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String line = null;
            while( (line=br.readLine()) != null) {
                String item[] = line.split(",");
                file.add(item);
            }
            br.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    } 
    
    public ArrayList getFile() {
        return this.file;
    }
}