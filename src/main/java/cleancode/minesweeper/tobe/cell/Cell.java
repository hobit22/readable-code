package cleancode.minesweeper.tobe.cell;

public interface Cell {

    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

    boolean isLandMind();

    boolean hasLandMindCount();

    String getSign();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();
}
