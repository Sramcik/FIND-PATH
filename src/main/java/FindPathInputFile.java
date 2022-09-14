import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FindPathInputFile extends FindPath{
    private String FilePath;
    protected ArrayList<String> getMaze(){
        ArrayList<String> data = new ArrayList<String>();
        try {
            File file = new File(FilePath);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                  data.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
     public FindPathInputFile(String FilePath){
        this.FilePath= FilePath;
        defineMaze(getMaze());
    }
}

