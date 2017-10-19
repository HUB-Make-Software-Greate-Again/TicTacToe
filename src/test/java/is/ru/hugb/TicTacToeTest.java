package is.ru.hugb;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest{
    @Test public void NewGameIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        assertFalse(game.gameOver());
    }

    @Test public void DoingASingleMoveIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);

        assertFalse(game.gameOver());
    }

    @Test public void DoingThreeMovesInARowIsNotGameOver(){
        TicTacToe game = new TicTacToe();

        game.doMove(0, 0);
        game.doMove(0, 1);
        game.doMove(0, 2);

        assertFalse(game.gameOver());
    }
}