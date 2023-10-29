public interface Queue<E> {
    void add(E item);
    E poll();
    E peek();
    boolean isEmpty();
}
