package is.ru.hugb;


public class TicTacToe{
    private final int EMPTY = 0;
    private final int X = 1;
    private final int O = 2;

    private int[][] grid;
    private int player;
    private int winner;
    private boolean gameover;
    private int movesleft;

    public TicTacToe(){
        this.grid = new int[3][3];
        
        this.player = this.X;
        this.winner = this.EMPTY;
        this.gameover = false;
        this.movesleft = 9;
    }

    public boolean gameOver(){
        return this.gameover;
    }

    public void doMove(int x, int y){
        this.checkBoundaries(x, y);
        this.checkLegalMove(x, y);

        this.grid[x][y] = this.player;

        this.checkGameOver();

        if (--this.movesleft == 0) this.gameover = true;

        this.nextTurn();
    }

    public int winner(){
        return this.winner;
    }

    private void nextTurn(){
        this.player = (this.player == this.X ? this.O : this.X);
    }

    private void checkGameOver(){
        this.checkRows();        
        this.checkCols();
        this.checkDias();
    }

    private void checkDias(){
        // Check left diagonal
        if (this.grid[0][0] == this.player){
            if (this.grid[0][0] == this.grid[1][1] && this.grid[0][0] == this.grid[2][2]){
                this.gameover = true;
                this.winner = this.player;
            }
        }

        // Check right diagonal
        if (this.grid[2][0] == this.player){
            if (this.grid[0][2] == this.grid[1][1] && this.grid[0][2] == this.grid[2][0]){
                this.gameover = true;
                this.winner = this.player;
            }
        }
    }

    private void checkRows(){
        for (int i = 0; i < 3; ++i){
            if (this.grid[i][0] == this.player){
                if (this.grid[i][0] == this.grid[i][1] && this.grid[i][0] == this.grid[i][2]){
                    this.gameover = true;
                    this.winner = this.player;
                }
            }
        }
    }

    private void checkCols(){
        for (int i = 0; i < 3; ++i){
            if (this.grid[0][i] == this.player){
                if (this.grid[0][i] == this.grid[1][i] && this.grid[0][i] == this.grid[2][i]){
                    this.gameover = true;
                    this.winner = this.player;
                }
            }
        }
    }

    private void checkBoundaries(int x, int y){
        if (x < 0 || y < 0 || x > 2 || y > 2){
            throw new IllegalArgumentException("Index is out of bounds");
        }
    }

    private void checkLegalMove(int x, int y){
        if (this.grid[x][y] != this.EMPTY || this.gameOver()){
            throw new IllegalArgumentException(String.format("Fields %d, %d is not empty", x, y));
        }
    }
}