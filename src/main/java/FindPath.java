import java.util.ArrayList;

public abstract class FindPath {
    private Character[][] maze;
    private int[][] mazeMap;
    private int sizeRows;
    private int sizeCols;

    private Coordinates sPos;
    private Coordinates xPos;
    private int stepOrder = 1;
    private boolean isPossible = false;
    private boolean solved = false;

    private ArrayList<Character> path = new ArrayList<>();

    abstract protected ArrayList<String> getMaze();
    protected void defineMaze(ArrayList<String> mazeData){
        maze = new Character[mazeData.size()][mazeData.get(0).length()];
        sizeRows = mazeData.size();
        sizeCols = mazeData.get(0).length();

        for(int row=0; row<sizeRows;row++){
            for(int col = 0; col< sizeCols; col++){
                maze[row][col] = mazeData.get(row).charAt(col);
                if(maze[row][col].equals('X')){
                    xPos = new Coordinates(row, col);
                } else if (maze[row][col].equals('S')) {
                    sPos = new Coordinates(row, col);
                }
            }
        }
        mazeMap = new int[sizeRows][sizeCols];
        mazeMap[xPos.getRow()][xPos.getCol()] = 1;
    }

    private void solveMaze(ArrayList<Coordinates> lastSteps) {
        ArrayList<Coordinates> steps = new ArrayList<>();
        stepOrder++;
        for (Coordinates step : lastSteps) {
            doStep(new Coordinates(step.getRow() + 1, step.getCol()), steps);
            doStep(new Coordinates(step.getRow() - 1, step.getCol()), steps);
            doStep(new Coordinates(step.getRow(), step.getCol() + 1), steps);
            doStep(new Coordinates(step.getRow(), step.getCol() - 1), steps);
        }

        if(!steps.isEmpty() && !isPossible)
            solveMaze(steps);
    }

    private void doStep(Coordinates position, ArrayList<Coordinates> steps){
        if(position.getRow() < sizeRows && position.getRow() >= 0 && position.getCol() < sizeCols && position.getCol() >= 0){
            if (maze[position.getRow()][position.getCol()].equals('S')){
                isPossible = true;

            } else if (maze[position.getRow()][position.getCol()].equals('.') && mazeMap[position.getRow()][position.getCol()] == 0){
                mazeMap[position.getRow()][position.getCol()] = stepOrder;
                steps.add(position);
            }
        }
    }

    private void findPath(Coordinates lastPos){
        stepOrder--;
        Coordinates nextPos;
        if (findPathStep(nextPos = new Coordinates(lastPos.getRow()+1, lastPos.getCol()))){
            path.add('d');
        }else if (findPathStep(nextPos = new Coordinates(lastPos.getRow()-1, lastPos.getCol()))){
            path.add('u');
        }else if (findPathStep(nextPos = new Coordinates(lastPos.getRow(), lastPos.getCol()+1))){
            path.add('r');
        }else if (findPathStep(nextPos = new Coordinates(lastPos.getRow(), lastPos.getCol()-1))){
            path.add('l');
        }

        if (stepOrder > 1){
            findPath(nextPos);
        }
    }

    private boolean findPathStep(Coordinates position){
        if(position.getRow() < sizeRows && position.getRow() >= 0 && position.getCol() < sizeCols && position.getCol() >= 0){
            return mazeMap[position.getRow()][position.getCol()] == stepOrder;
        }
        return false;
    }

    public ArrayList<Character> getPath(){
        return path;
    }
    public Boolean getPossible(){
        return isPossible;
    }
    public Coordinates getSize(){
        return new Coordinates(sizeRows, sizeCols);
    }

    public void solve(boolean print){
        if(!solved) {
            ArrayList<Coordinates> step = new ArrayList<>();
            step.add(xPos);
            solveMaze(step);
            findPath(sPos);
            solved = true;
        }
        if (print) {
            if (isPossible)
                System.out.println(path);
            else System.out.println("Error: There si no possible path between Start and Target positions");
        }
    }
}
