public class DoubleRoom extends Room {
    @Override
    public void accept(RoomVistor roomVistor) {
        roomVistor.visit(this);
    }
}
