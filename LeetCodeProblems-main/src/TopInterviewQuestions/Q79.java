class Solution {
        boolean visited[][];

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        visited[i][j] = true;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int d = 0; d < dir.length; d++) {
            if (exist(board, word, i + dir[d][0], j + dir[d][1], k + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
