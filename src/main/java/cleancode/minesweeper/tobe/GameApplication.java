package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gameLevel.Advanced;
import cleancode.minesweeper.tobe.gameLevel.Beginner;
import cleancode.minesweeper.tobe.gameLevel.GameLevel;
import cleancode.minesweeper.tobe.gameLevel.Middle;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Advanced();

        Minesweeper minesweeper = new Minesweeper(gameLevel);
        minesweeper.run();
    }

}