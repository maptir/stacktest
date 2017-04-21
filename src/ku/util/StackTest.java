package ku.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<String> stack;

	@Before
	public void setUp() {
		stack = (Stack<String>) StackFactory.makeStack(2);
	}

	@Test
	public void testNewStackIsEmpty() {
		StackFactory.setStackType(0);
		assertEquals(2, stack.capacity());
		assertEquals(0, stack.size());
		assertEquals(true, stack.isEmpty());
		StackFactory.setStackType(1);
		assertEquals(2, stack.capacity());
		assertEquals(0, stack.size());
		assertEquals(true, stack.isEmpty());
	}

	@Test
	public void test() {
		StackFactory.setStackType(1);
		stack.push("a");
		stack.push("a");
		stack.push("a");
		stack.push("a");
		assertEquals(stack.capacity(), 4);
	}

}
