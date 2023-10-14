package TopInterviewQuestions;

class Solution {
    private boolean[][] visited;
    private int count = 0;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visit(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void visit(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'
                || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        visit(grid, i, j - 1);
        visit(grid, i - 1, j);
        visit(grid, i, j + 1);
        visit(grid, i + 1, j);
    }

}

public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}
