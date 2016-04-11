package arhangel.dim.lections.collections;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by evgeniatveritinova on 18.03.16.
 */
public class MyStack<E> implements Stack<E> {

    private int size = 100;
    private E[] data = (E[]) new Object[size];
    private int curNum = 0;

    public void push(E element) throws StackException {
        if (curNum == size) {
            throw new StackException("stack is full");
        }

        ++curNum;
        data[curNum] = element;
    }

    public E pop() throws StackException {
        if (curNum == 0) {
            throw new StackException("no elements to pop");
        }

        --curNum;
        return data[curNum + 1];
    }

    public E peek() {
        return data[curNum];
    }

    public int getSize() {
        return curNum + 1;
    }

    public boolean isEmpty() {
        if (curNum + 1 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (curNum + 1 == size) {
            return true;
        } else {
            return false;
        }
    }

    // A little bit wrong =( Could you fix it?
    public void pushAll(Collection<E> src) throws StackException {
        for (E el : src) {
            push(el);
        }
    }

    public void popAll(Collection<E> dst) throws StackException {
        for (E el : data) {
            dst.add(pop());
        }
    }

    @Override
    public Iterator<E> iterator() {


        return null;
    }

    public class MyStackIterator<E> implements Iterator<E> {
        int cur = 0;

        @Override
        public boolean hasNext() {

            return cur + 1 <= size;
        }

        @Override
        public E next() {
            return (E) data[++cur];
        }
    }
}
