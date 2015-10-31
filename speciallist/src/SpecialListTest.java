import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialListTest {

	@Test
	public void addTest() {
		SpecialList test = new SpecialList();
		//test.add(0, 10);
		System.out.println();
		if (test.length() != 1) {
			fail("The length was not correct");
		}
	}

}
