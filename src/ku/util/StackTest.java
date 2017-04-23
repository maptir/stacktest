package ku.util;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<String> stack;

	@Before
	public void setUp() {
		stack = makeStack(3);
	}

	@Test
	public void testNewStackIsEmpty() {
		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
		assertEquals(0, stack.size());
	}

	@Test(expected = EmptyStackException.class)
	public void testPopEmptyStack() {
		assertTrue(stack.isEmpty());
		stack.pop();
	}

	@Test(expected = IllegalStateException.class)
	public void testPushFullStack() {
		stack.push("a");
		stack.push("a");
		stack.push("a");
		stack.push("a");
	}

	@Test
	public void testPeek() {
		assertNull(stack.peek());
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.peek();
		assertEquals(3, stack.size());
		assertEquals("c", stack.peek());
		assertEquals("c", stack.peek());
		stack.pop();
		assertEquals("b", stack.peek());
		stack.pop();
		assertEquals("a", stack.peek());
		stack.pop();
		assertNull(stack.peek());
	}

	@Test
	public void testPop() {
		stack.push("a");
		assertEquals("a", stack.pop());
		assertEquals(0, stack.size());
		stack.push("b");
		stack.push("c");
		stack.push("d");
		assertEquals(3, stack.size());
		
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(0, stack.size());
	}

	private Stack<String> makeStack(int capacity) {
		return StackFactory.makeStack(capacity);
	}

}
