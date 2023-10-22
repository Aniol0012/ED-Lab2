package cat.udl.eps.ed.practica2.stack;

import java.util.AbstractCollection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A linked list implementation of a stack.
 * <p>
 * Implements the stack interface using linked nodes.
 *
 * @param <E> the type of elements in the stack
 * @see Stack
 */
public class LinkedStack<E> implements Stack<E> {
    private LinkedList<E> list;

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        this.list = new LinkedList<>();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param elem the element to be added
     */
    @Override
    public void push(E elem) {
        list.addFirst(elem);
    }

    /**
     * Returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E top() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("The stack is empty");
        } else {
            return list.getFirst();
        }
    }

    /**
     * Removes the element at the top of the stack.
     *
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public void pop() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("The stack is empty");
        } else {
            list.removeFirst();
        }
    }

    /**
     * Returns true if the stack is empty, false otherwise.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }
}
