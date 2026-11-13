class Solution {
    /* Algo steps
            1.  Create a Row HashSet<row(0), number(x)> 
                add every number if there was a duplicate return false;
            2.  Create a Column HashSet<column(0), number(x)>
                same thing
            3.  for the 3rd Condition* 
                We Shoul caluclate it's posistion by i and j.
                We will have a 3x3 HashSet< (int) i/3, (int) j/3,number)


        */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;

        boolean[][] rowSeen = new boolean[9][9];
        boolean[][] colSeen = new boolean[9][9];
        boolean[][] boxSeen = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                // Convert char '1'-'9' to index 0-8
                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Check row, column, and 3x3 box
                if (rowSeen[i][num] || colSeen[j][num] || boxSeen[boxIndex][num]) {
                    return false;
                }

                // Mark as seen
                rowSeen[i][num] = true;
                colSeen[j][num] = true;
                boxSeen[boxIndex][num] = true;
            }
        }
        return true;
    }

}
