package cleancode.minesweeper.tobe.cell;

public interface Cell {

    boolean isLandMind();

    boolean hasLandMindCount();

    CellSnapshot getSnapshot();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();
}
