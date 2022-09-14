import org.junit.jupiter.api.Test;


class FindPathInputFileTestTime {

    @Test
    void test(){
        String filePath = "maze_test3.txt";
        time(filePath);
    }

    void time(String filePath){
        long start = System.currentTimeMillis();

        FindPathInputFile maze = new FindPathInputFile(filePath);
        maze.solve(false);

        long end = System.currentTimeMillis();

        System.out.println("Size of maze: "+maze.getSize().getRow()+" x "+maze.getSize().getCol());
        System.out.println("Solve time: "+(end-start)+" ms");
        System.out.println("Number of steps needed: "+maze.getPath().size());
    }

}