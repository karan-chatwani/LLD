package models;

public class Player {
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    private String playerId;
    private Piece piece;

    public Player(String playerId, Piece piece) {
        this.playerId = playerId;
        this.piece = piece;
    }
}
