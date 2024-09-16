public class PricingRoomVisitor implements RoomVistor {
    @Override
    public void visit(SingleRoom singleRoom) {
        singleRoom.price = 10;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        doubleRoom.price = 20;
    }
}
