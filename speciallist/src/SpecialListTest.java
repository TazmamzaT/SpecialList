import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialListTest {

	@Test
	public void addTest() {
		SpecialList test = new SpecialList();
		test.add(0, 10);
		test.add(1, 20);
		System.out.println();
		if (test.length() != 2 && test.valueAt(0) != 10 && test.valueAt(1) != 20) {
			fail("The length was not correct");
		}
	}
	
	@Test
	public void valueAtTest() {
		SpecialList test = new SpecialList();
		test.add(0, 10);
		test.add(1, 20);
		if (test.valueAt(0) != 10) {
			fail("The value at failed for pos 0 and value 10");
		}
	}

}
