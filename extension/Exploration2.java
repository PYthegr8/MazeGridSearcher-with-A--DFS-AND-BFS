import java.util.ArrayList;
import java.util.List;

public class Exploration2 {

    public static void main(String[] args) {
        int mazeSize = 20;
        double obstacleDensity = 0.2;
        boolean display = false;
        int delay = 0;

        int totalTrials = 30;

        List<Integer> pathLengthsDFS = conductDFSExperiment(mazeSize, obstacleDensity, totalTrials, display, delay);
        List<Integer> pathLengthsBFS = conductBFSExperiment(mazeSize, obstacleDensity, totalTrials, display, delay);
        List<Integer> pathLengthsAStar = conductAStarExperiment(mazeSize, obstacleDensity, totalTrials, display, delay);
        List<Integer> pathLengthsShortestPath = conductShortestPathExperiment(mazeSize, obstacleDensity, totalTrials, display, delay);
        List<Integer> pathLengthsDiagonalShortestPath = conductDiagonalShortestPathExperiment(mazeSize, obstacleDensity, totalTrials, display, delay);

        // Output the results
        System.out.println("DFS Path Lengths: " + pathLengthsDFS);
        System.out.println("BFS Path Lengths: " + pathLengthsBFS);
        System.out.println("A* Path Lengths: " + pathLengthsAStar);
        System.out.println("Shortest Path Path Lengths: " + pathLengthsShortestPath);
        System.out.println("Diagonal Shortest Path Path Lengths: " + pathLengthsDiagonalShortestPath);
    }

    private static List<Integer> conductDFSExperiment(int mazeSize, double obstacleDensity, int totalTrials, boolean display, int delay) {
        List<Integer> pathLengthsDFS = new ArrayList<>();

        for (int i = 0; i < totalTrials; i++) {
            Maze maze = new Maze(mazeSize, mazeSize, obstacleDensity);
            Cell start = maze.get(0, 0);
            Cell target = maze.get(mazeSize - 1, mazeSize - 1);

            AbstractMazeSearch dfs = new MazeDepthFirstSearch(maze);
            LinkedList<Cell> dfsPath = dfs.search(start, target, display, delay);

            if (dfsPath != null) {
                pathLengthsDFS.add(dfsPath.size());
            }
        }

        return pathLengthsDFS;
    }

    private static List<Integer> conductBFSExperiment(int mazeSize, double obstacleDensity, int totalTrials, boolean display, int delay) {
        List<Integer> pathLengthsBFS = new ArrayList<>();

        for (int i = 0; i < totalTrials; i++) {
            Maze maze = new Maze(mazeSize, mazeSize, obstacleDensity);
            Cell start = maze.get(0, 0);
            Cell target = maze.get(mazeSize - 1, mazeSize - 1);

            AbstractMazeSearch bfs = new MazeBreadthFirstSearch(maze);
            LinkedList<Cell> bfsPath = bfs.search(start, target, display, delay);

            if (bfsPath != null) {
                pathLengthsBFS.add(bfsPath.size());
            }
        }

        return pathLengthsBFS;
    }

    private static List<Integer> conductAStarExperiment(int mazeSize, double obstacleDensity, int totalTrials, boolean display, int delay) {
        List<Integer> pathLengthsAStar = new ArrayList<>();

        for (int i = 0; i < totalTrials; i++) {
            Maze maze = new Maze(mazeSize, mazeSize, obstacleDensity);
            Cell start = maze.get(0, 0);
            Cell target = maze.get(mazeSize - 1, mazeSize - 1);

            AbstractMazeSearch astar = new MazeAStarSearch(maze);
            LinkedList<Cell> astarPath = astar.search(start, target, display, delay);

            if (astarPath != null) {
                pathLengthsAStar.add(astarPath.size());
            }
        }

        return pathLengthsAStar;
    }

    private static List<Integer> conductShortestPathExperiment(int mazeSize, double obstacleDensity, int totalTrials, boolean display, int delay) {
        List<Integer> pathLengthsShortestPath = new ArrayList<>();

        for (int i = 0; i < totalTrials; i++) {
            Maze maze = new Maze(mazeSize, mazeSize, obstacleDensity);
            Cell start = maze.get(0, 0);
            Cell target = maze.get(mazeSize - 1, mazeSize - 1);

            AbstractMazeSearch shortestPath = new ShortestPathSearch(maze);
            LinkedList<Cell> shortestPathResult = shortestPath.search(start, target, display, delay);

            if (shortestPathResult != null) {
                pathLengthsShortestPath.add(shortestPathResult.size());
            }
        }

        return pathLengthsShortestPath;
    }

    private static List<Integer> conductDiagonalShortestPathExperiment(int mazeSize, double obstacleDensity, int totalTrials, boolean display, int delay) {
        List<Integer> pathLengthsDiagonalShortestPath = new ArrayList<>();

        for (int i = 0; i < totalTrials; i++) {
            Maze maze = new Maze(mazeSize, mazeSize, obstacleDensity);
            Cell start = maze.get(0, 0);
            Cell target = maze.get(mazeSize - 1, mazeSize - 1);

            AbstractMazeSearch diagonalShortestPath = new DiagonalShortestPathSearch(maze);
            LinkedList<Cell> diagonalShortestPathResult = diagonalShortestPath.shortest_search(start, target, display, delay);

            if (diagonalShortestPathResult != null) {
                pathLengthsDiagonalShortestPath.add(diagonalShortestPathResult.size());
            }
        }

        return pathLengthsDiagonalShortestPath;
    }
}
