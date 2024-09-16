public class Main {
    public static void main(String[] args) {
        IRateLimitter rateLimitter=new SlidingWindowRateLimitter(1,1000);
//        System.out.println(rateLimitter.isAllowed("1"));
//        System.out.println(rateLimitter.isAllowed("1"));
//        System.out.println(rateLimitter.isAllowed("2"));
       Thread thread1=new Thread(()->{
           rateLimitter.isAllowed("1");
       });
       thread1.start();
        System.out.println("Hello world!");
    }
}