package cat.udl.eps.ed.practica2.stack;

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
    private Node<E> top;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        this.size = 0;
        this.top = null;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param elem the element to be added
     */
    @Override
    public void push(E elem) {
        Node<E> node = new Node<>(elem, null, top);
        if (top != null) {
            top.prev = node;
        }
        top = node;
        size += 1;
    }


    /**
     * Returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E top() {
        if (top == null) {
            throw new NoSuchElementException("The stack is empty");
        } else {
            return top.element;
        }
    }

    /**
     * Removes the element at the top of the stack.
     *
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public void pop() {
        if (top == null) {
            throw new NoSuchElementException("The stack is empty");
        } else {
            top = top.next;
            size -= 1;
        }
    }

    /**
     * Returns true if the stack is empty, false otherwise.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return this.size;
    }
}
