package is.ru.hugb;

public class TicTacToe{
    private final int EMPTY = 0;
    private final int X = 1;
    private final int O = 2;

    private int[][] grid;
    private int player;

    public TicTacToe(){
        this.grid = new int[3][3];
        
        this.player = this.X;
    }

    public boolean gameOver(){
        boolean gameover = false;

        // Check row winner
        for (int i = 0; i < 3; ++i){
            if (this.grid[i][0] != this.EMPTY){
                if (this.grid[i][0] == this.grid[i][1] && this.grid[i][0] == this.grid[i][2]){
                    gameover = true;
                }
            }
        }
        
        // Check column winner
        for (int i = 0; i < 3; ++i){
            if (this.grid[0][i] != this.EMPTY){
                if (this.grid[0][i] == this.grid[1][i] && this.grid[0][i] == this.grid[2][i]){
                    gameover = true;
                }
            }
        }

        // Check left dia
        if (this.grid[0][0] != this.EMPTY){
            if (this.grid[0][0] == this.grid[1][1] && this.grid[0][0] == this.grid[2][2]){
                gameover = true;
            }
        }

        return gameover;
    }

    public void doMove(int x, int y){
        this.grid[x][y] = this.player;
        if (this.player == this.X){
            this.player = this.O;
        } else {
            this.player = this.X;
        }
    }
}