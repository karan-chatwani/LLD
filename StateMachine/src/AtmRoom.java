public class AtmRoom {
    private Atm atm;

    public AtmRoom() {
        atm = Atm.getAtmObject();
        atm.setAtmBalance(2000);
        atm.setFiveHundredNotes(3);
        atm.setHundredNotes(5);
    }

    public static void main(String[] args) {
        AtmRoom atmRoom = new AtmRoom();
        Card card = new Card(3000, 123, "ICIC");
        Atm atm1 = Atm.getAtmObject();
        atm1.getAtmState().enterCard(atm1, card);
        atm1.getAtmState().validatePin(atm1, card, 123);
        atm1.getAtmState().selectOperations(atm1, TransactionType.CASH_WITHDRAWL);
        atm1.getAtmState().cachWithdrawl(atm1,card,200);

        atm1.getAtmState().selectOperations(atm1, TransactionType.CHECK_BALANCE);
        atm1.getAtmState().checkBalance(atm1, card);
    }
}
