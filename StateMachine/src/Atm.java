public class Atm {
    private AtmState atmState;
    private static Atm atm = new Atm();
    private int atmBalance;
    private int fiveHundredNotes;
    private int hundredNotes;

    private Atm() {

    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    public AtmState getAtmState() {
        return atmState;
    }

    public synchronized static Atm getAtmObject() {
        atm.setAtmState(new IdleAtmState());
        return atm;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getFiveHundredNotes() {
        return fiveHundredNotes;
    }

    public void setFiveHundredNotes(int fiveHundredNotes) {
        this.fiveHundredNotes = fiveHundredNotes;
    }

    public int getHundredNotes() {
        return hundredNotes;
    }

    public void setHundredNotes(int hundredNotes) {
        this.hundredNotes = hundredNotes;
    }
}
