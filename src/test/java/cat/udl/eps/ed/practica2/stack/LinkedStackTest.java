package cat.udl.eps.ed.practica2.stack;


import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    // isEmpty() tests
    @Test
    void isEmpty_on_empty_stack_should_return_true() {
        var emptyStack = new LinkedStack<Integer>();
        assertTrue(emptyStack.isEmpty());
    }

    @Test
    void isEmpty_on_filled_stack_should_return_false() {
        var filledStack = new LinkedStack<Integer>();
        filledStack.push(13);
        filledStack.push(14);
        assertFalse(filledStack.isEmpty());
    }

    // push() tests
    @Test
    void push_on_empty_stack_should_return_1_stack_size() {
        var emptyStack = new LinkedStack<Integer>();
        emptyStack.push(10);
        assertEquals(1, emptyStack.getSize());
    }

    // pop() tests
    @Test
    @SuppressWarnings("all")
    void pop_on_empty_stack_should_throw_nse_exception() {
        var emptyStack = new LinkedStack<Integer>();
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.pop();
        });
    }

    @Test
    void pop_on_filled_stack_should_remove_top_element() {
        var filledStack = new LinkedStack<Integer>();
        filledStack.push(10);
        filledStack.push(11);
        filledStack.pop();
        assertEquals(1, filledStack.getSize());
    }

    // top() tests
    @Test
    void top_on_empty_stack_should_throw_nse_exception() {
        var emptyStack = new LinkedStack<Integer>();
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.top();
        });
    }

    @Test
    void top_on_filled_stack_should_return_top_element() {
        var filledStack = new LinkedStack<Integer>();
        filledStack.push(10);
        filledStack.push(20);
        filledStack.push(30);
        assertEquals(30, filledStack.top());
    }

    @Test
    void top_on_single_element_stack_should_return_top_element_and_stack_non_empty() {
        var singleElementStack = new LinkedStack<Integer>();
        singleElementStack.push(10);
        assertEquals(10, singleElementStack.top());
        assertFalse(singleElementStack.isEmpty());
    }

    @Test
    void top_on_2_element_stack_should_return_second_element_and_stack_non_empty() {
        var stack = new LinkedStack<Integer>();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test
    void top_and_pop_and_top_on_stack_should_second_and_first_element() {
        var stack = new LinkedStack<Integer>();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.top());
        stack.pop();
        assertEquals(10, stack.top());
    }
}
