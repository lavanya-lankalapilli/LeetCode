package TopInterviewQuestions;

class Solution {
    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    visit(visited, grid, i, j);
                }
            }
        }
        return count;
    }

    private void visit(boolean visited[][], char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        visit(visited, grid, i - 1, j);
        visit(visited, grid, i, j - 1);
        visit(visited, grid, i, j + 1);
        visit(visited, grid, i + 1, j);
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
