import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FindPathInputFileTest {

    @Test
    void test1(){
        String filePath = "maze_test.txt";
        FindPathInputFile maze = new FindPathInputFile(filePath);
        maze.solve(true);
        assertTrue(testSolution(getMaze(filePath), maze.getPath()));
    }

    @Test
    void test2(){
        String filePath = "maze_test2.txt";
        FindPathInputFile maze = new FindPathInputFile(filePath);
        maze.solve(true);
        assertTrue(testSolution(getMaze(filePath), maze.getPath()));
    }
    @Test
    void test3(){
        String filePath = "maze_test3.txt";
        FindPathInputFile maze = new FindPathInputFile(filePath);
        maze.solve(true);
        assertTrue(testSolution(getMaze(filePath), maze.getPath()));
    }

    @Test
    void testShort(){
        String filePath = "maze_test_short.txt";
        FindPathInputFile maze = new FindPathInputFile(filePath);
        maze.solve(true);
        assertTrue(testSolution(getMaze(filePath), maze.getPath()));
        assertEquals(1,maze.getPath().size());
    }

    @Test
    void testImpossible(){
        String filePath = "maze_test_impossible.txt";
        FindPathInputFile maze = new FindPathInputFile(filePath);
        maze.solve(true);
        assertFalse(maze.getPossible());
    }


    public ArrayList<String> getMaze(String filePath){
        ArrayList<String> data = new ArrayList<>();
        try {
            File file = new File(filePath);
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

    public boolean testSolution(ArrayList<String> maze, ArrayList<Character> solution){
        Coordinates position = findStart(maze);
        for (int i = 0;i <solution.size();i++) {
            switch (solution.get(i)) {
                case 'u' -> position.setRow(position.getRow()-1);
                case 'd' -> position.setRow(position.getRow()+1);
                case 'r' -> position.setCol(position.getCol()+1);
                case 'l' -> position.setCol(position.getCol()-1);
            }
            if(maze.get(position.getRow()).charAt(position.getCol()) != '.' && i != solution.size()-1){
                return false;
            }
        }
        return maze.get(position.getRow()).charAt(position.getCol()) == 'X';
    }

    public Coordinates findStart(ArrayList<String> data){
        for(int row=0; row<data.size();row++){
            for(int col = 0; col<data.get(0).length(); col++){
                if(data.get(row).charAt(col) == 'S'){
                    return new Coordinates(row, col);
                }
            }
        }
        return null;
    }
}