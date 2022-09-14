import java.util.ArrayList;
import java.util.Scanner;

public class FindPathInputStdIn extends FindPath{
    protected ArrayList<String> getMaze(){
        String line;
        ArrayList<String> data = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Define maze(Must end with empty line!):");
        do {
            line = scanner.nextLine();
            if (!line.isEmpty()){
                data.add(line);
            }
        }while(!line.isEmpty());
        return data;
    }

    public FindPathInputStdIn(){
        defineMaze(getMaze());
    }
}

