public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("player " + name + " not found ");
    }
}
