package models;

public class Board {
    public int getSize() {
        return size;
    }

    private int size;
    private Cell[][] cell;

    public Board(int size) {
        this.size = size;
        cell = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cell[i][j] = new Cell();
            }
        }
    }

    public void addPiece(int x, int y, Piece piece) {
        if (cell[x][y].getPiece() != null) {
            return;
        }
        cell[x][y].setPiece(piece);
    }

    public boolean validate(int x, int y) {
        return cell[x][y].getPiece() == null;
    }

    public boolean checkWinner(Piece piece) {
        return checkRowWinner(piece) | checkColumnWinner(piece) | checkDiagnolWinner(piece);
    }

    public boolean checkRowWinner(Piece piece) {
        boolean win = true;
        for (int i = 0; i < size; i++) {
            win = true;
            for (int j = 0; j < size; j++) {
                if (cell[i][j].getPiece() == null || cell[i][j].getPiece() != piece) {
                    win = false;
                    break;
                }
            }
        }
        return win;
    }

    private boolean checkColumnWinner(Piece piece) {
        boolean win = true;
        for (int i = 0; i < size; i++) {
            win = true;
            for (int j = 0; j < size; j++) {
                if (cell[j][i].getPiece() == null || cell[j][i].getPiece() != piece) {
                    win = false;
                    break;
                }
            }
        }
        return win;
    }

    private boolean checkDiagnolWinner(Piece piece) {
        boolean win = true;
        int i = 0, j = 0;
        while (i < size && j < size) {
            if (cell[i][j].getPiece() == null || cell[i][j].getPiece() != piece) {
                win = false;
                break;
            }
            i++;
            j++;
        }
        if (win) return win;
        win = true;
        i = 0;
        j = size - 1;
        while (i < size) {
            if (cell[i][j].getPiece() == null || cell[i][j].getPiece() != piece) {
                win = false;
                break;
            }
            i++;
            j--;
        }
        return win;
    }

    public boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cell[i][j].getPiece() == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
