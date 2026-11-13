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
        if (board.length != 9 || board[0].length != 9) return false;

        HashSet<String> rowHash = new HashSet<>();
        HashSet<String> colHash = new HashSet<>();
        HashSet<String> boxHash = new HashSet<>();

        for (int i=0; i<9; i++)
            for (int j=0; j<9; j++) {
                // check if cell was not empty
                if (board[i][j] == '.') continue;
                // check row
                if (!rowHash.add(i +" "+board[i][j])) return false;
                // check column
                if (!colHash.add(j +" "+ board[i][j])) return false;
                // check every box
                int boxI = (int) i/3;
                int boxJ = (int) j/3;
                if (!boxHash.add(boxI +" "+ boxJ +" "+ board[i][j])) return false;
            }
        return true;
    }
}
