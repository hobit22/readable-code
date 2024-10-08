package cleancode.minesweeper.tobe.minesweeper.board.cell;

public class LandMineCell implements Cell {

    private final CellState cellState = CellState.initialize();

    @Override
    public boolean isLandMind() {
        return true;
    }

    @Override
    public boolean hasLandMindCount() {
        return false;
    }

    @Override
    public CellSnapshot getSnapshot() {
        if (cellState.isOpened()) {
            return CellSnapshot.ofLandMine();
        }
        if (cellState.isFlagged()) {
            return CellSnapshot.ofFlag();
        }
        return CellSnapshot.ofUnchecked();
    }

    @Override
    public void flag() {
        cellState.flag();
    }

    @Override
    public void open() {
        cellState.open();
    }

    @Override
    public boolean isChecked() {
        return cellState.isFlagged();
    }

    @Override
    public boolean isOpened() {
        return cellState.isOpened();
    }
}
