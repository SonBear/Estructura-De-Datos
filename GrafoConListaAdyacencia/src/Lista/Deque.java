package Lista;

public interface Deque<T> {

    public int size();

    public boolean isEmpty();

    public void insertFirst(T e);

    public void insertLast(T e);

    public T removeFirst() throws DequeEmptyException;

    public T removeLast() throws DequeEmptyException;

    public T first() throws DequeEmptyException;

    public T last() throws DequeEmptyException;

    public T get(int i) throws Exception;

    public T remove(int i) throws Exception;

    public boolean find(T element) throws Exception;

    public T remove(T elemento) throws Exception;
}
