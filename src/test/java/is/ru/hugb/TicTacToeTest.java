package is.ru.hugb;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest{
    @Test public void testNewGameIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        assertFalse(game.gameOver());
    }

    @Test public void testDoingASingleMoveIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);

        assertFalse(game.gameOver());
    }

    @Test public void testDoingThreeMovesInARowIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(0, 1);
        game.doMove(0, 2);

        assertFalse(game.gameOver());
    }

    @Test public void testGameIsOverWhenThereIsARow(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(1, 0);
        game.doMove(0, 1);
        game.doMove(2, 0);
        game.doMove(0, 2);

        assertTrue(game.gameOver());
    }
}