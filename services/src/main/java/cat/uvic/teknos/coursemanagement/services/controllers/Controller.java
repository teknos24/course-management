package cat.uvic.teknos.coursemanagement.services.controllers;

public interface Controller<K, V> {
    String get(K k);
    String get();
    void post(V value);
    void put(K key, V value);
    void delete(K key);
}
