public class Main {
    public static void main(String[] args) {
        EvictionPolicy<String> evictionPolicy = new LruEvictionPolicy();
        Storage<String, Integer> storage = new HashmapStorage<>(2);
        Cache<String, Integer> cache = new Cache<>(evictionPolicy, storage);
        cache.put("karan", 1);
        cache.put("laxman", 2);
        System.out.println(cache.get("karan"));
        System.out.println(cache.get("laxman"));
        cache.put("puneet", 3);
        System.out.println(cache.get("karan"));
        System.out.println(cache.get("laxman"));
        cache.put("pop", 4);
        System.out.println(cache.get("puneet"));

        System.out.println("Hello world!");
    }
}