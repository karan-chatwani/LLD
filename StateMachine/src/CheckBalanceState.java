public class CheckBalanceState extends AtmState {
    public CheckBalanceState() {
        System.out.println("Check balance");
    }

    @Override
    public void checkBalance(Atm atm, Card card) {
        System.out.println(card.getBalance());
        cancel(atm);
    }
}
