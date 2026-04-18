import java.util.List;

public class dfs {

    public static boolean searchpath(int[][] maze, int x, int y, List<Integer> path) {

        // boundary check
        if (x < 0 || y < 0 || y >= maze.length || x >= maze[0].length)
            return false;

        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }

        if (maze[y][x] == 0) {
            maze[y][x] = 2;

            if (searchpath(maze, x - 1, y, path) ||
                searchpath(maze, x + 1, y, path) ||
                searchpath(maze, x, y - 1, path) ||
                searchpath(maze, x, y + 1, path)) {

                path.add(x);
                path.add(y);
                return true;
            }
        }

        return false;
    }
}