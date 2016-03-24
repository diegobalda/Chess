import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    private int n;
    private Node first;

    private class Node{
        private T item;
        private Node next;
    }

    public Stack(){
        first = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void push(T item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public T pop(){
        if(isEmpty()) throw new RuntimeException("Stack underflow");
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public T peek(){
        if(isEmpty()) throw new RuntimeException("Stack underflow");
        return first.item;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(T item: this)
            s.append(item + " ");
        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
