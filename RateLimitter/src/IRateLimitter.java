public interface IRateLimitter {
    boolean isAllowed(String userId);
}
