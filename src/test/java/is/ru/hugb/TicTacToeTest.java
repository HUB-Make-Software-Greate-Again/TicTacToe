package is.ru.hugb;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest{
    @Test 
    public void testNewGameIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        assertFalse(game.gameOver());
    }

    @Test 
    public void testDoingASingleMoveIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);

        assertFalse(game.gameOver());
    }

    @Test 
    public void testDoingThreeMovesInARowIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(0, 1);
        game.doMove(0, 2);

        assertFalse(game.gameOver());
    }

    @Test 
    public void testGameIsOverWhenThereIsARow(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(1, 0);
        game.doMove(0, 1);
        game.doMove(2, 0);
        game.doMove(0, 2);

        assertTrue(game.gameOver());
    }

    @Test 
    public void testGameIsOverWhenThereIsAColumn(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(0, 1);
        game.doMove(1, 0);
        game.doMove(0, 2);
        game.doMove(2, 0);

        assertTrue(game.gameOver());
    }

    @Test 
    public void testGameIsOverWhenThereIsADiagonalLeft(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(0, 1);
        game.doMove(1, 1);
        game.doMove(0, 2);
        game.doMove(2, 2);

        assertTrue(game.gameOver());
    }

    @Test 
    public void testGameIsOverWhenThereIsADiagonalRight(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 2);
        game.doMove(0, 0);
        game.doMove(1, 1);
        game.doMove(0, 1);
        game.doMove(2, 0);

        assertTrue(game.gameOver());
    }

    @Test 
    public void testWinnerReturnsOneIfPlayerOneWins(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 2);
        game.doMove(0, 0);
        game.doMove(1, 1);
        game.doMove(0, 1);
        game.doMove(2, 0);
        game.gameOver();

        assertEquals(game.winner(), 1);
    }

    @Test 
    public void testWinnerReturnsTwoIfPlayerTwoWins(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(1, 0);
        game.doMove(0, 1);
        game.doMove(1, 1);
        game.doMove(2, 2);
        game.doMove(1, 2);
        game.gameOver();

        assertEquals(game.winner(), 2);
    }

    @Test 
    public void testWinnerReturnsZeroIfNoWinner(){
        TicTacToe game = new TicTacToe();

        assertEquals(game.winner(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRowBelowZero(){
        TicTacToe game = new TicTacToe();

        game.doMove(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalColumnBelowZero(){
        TicTacToe game = new TicTacToe();
        
        game.doMove(0, -1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRowAboveTwo(){
        TicTacToe game = new TicTacToe();

        game.doMove(3, 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalColAboveTwo(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 3);
    }
}