package is.ru.hugb;

/**
 * Main game logic class
 */
public class TicTacToe{
    /** 
     * Constant for a cell to be empty
     */
    private final int EMPTY = 0;
    
    /**
     * Constant for player X
     */
    private final int X = 1;

    /**
     * onstant for player O
     */
    private final int O = 2;

    /**
     * 2D array to represent grid
     */
    private int[][] grid;

    /**
     * Current player's turn
     */
    private int player;
    
    /**
     * The winner, 0 if draw
     */
    private int winner;

    /**
     * Boolean to know when game is over
     */
    private boolean gameover;

    /**
     * Counter to count how many moves are left
     */
    private int movesleft;

    /**
     * Constructor
     */
    public TicTacToe(){
        this.grid = new int[3][3];
        
        this.player = this.X;
        this.winner = this.EMPTY;
        this.gameover = false;
        this.movesleft = 9;
    }

    /**
     * Check if game is over
     * @return boolean
     */
    public boolean gameOver(){
        return this.gameover;
    }

    /**
     * Do a move 
     * @param x Row of move from 0-2
     * @param y Column of move from 0-2
     * @return void
     */
    public void doMove(int x, int y){
        this.checkBoundaries(x, y);
        this.checkLegalMove(x, y);

        this.grid[x][y] = this.player;

        this.checkGameOver();

        if (--this.movesleft == 0) this.gameover = true;

        this.nextTurn();
    }

    /**
     * Get which player won
     * @return int - 0 for draw
     */
    public int winner(){
        return this.winner;
    }

    /**
     * Switch current player
     * @return void
     */
    private void nextTurn(){
        this.player = (this.player == this.X ? this.O : this.X);
    }

    /**
     * Check if game is over
     * @return void
     */
    private void checkGameOver(){
        this.checkRows();        
        this.checkCols();
        this.checkDias();
    }

    /**
     * Check diagonal rows for winner
     * @return void 
     */
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

    /**
     * Check rows for winner
     * @return void 
     */
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

    /**
     * Check columns for winner
     * @return void 
     */
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

    /**
     * Check if x or y are within accepted range
     * Throws IllegalArgumentException if x or y are outside of range
     * @param int x ID of row as 0-2
     * @param int y ID of column as 0-2
     * @return void
     */
    private void checkBoundaries(int x, int y){
        if (x < 0 || y < 0 || x > 2 || y > 2){
            throw new IllegalArgumentException("Index is out of bounds");
        }
    }

    /**
     * Check if doing a legal tic tac toe move
     * Throws IllegalArgumentException if x or y are outside of range
     * @param int x ID of row as 0-2
     * @param int y ID of column as 0-2
     * @return void
     */
    private void checkLegalMove(int x, int y){
        if (this.grid[x][y] != this.EMPTY || this.gameOver()){
            throw new IllegalArgumentException(String.format("Fields %d, %d is not empty", x, y));
        }
    }
}