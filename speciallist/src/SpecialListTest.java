import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Test;

public class SpecialListTest {
	

//	@Test
//	public void addTest() {
//		SpecialList test = new SpecialList();
//		test.add(0, 0);
//		test.add(1, 1);
//		test.add(2, 3);
//		test.add(1, 5);
//		test.add(1, 5);
//		for (int i = 0; i < test.length(); i++) {
//			System.out.println(test.valueAt(i));
//		}
//		System.out.println();
//	}
//	
//	@Test
//	public void omitTest() {
//		SpecialList test = new SpecialList();
//		test.add(0, 0);
//		test.add(1, 1);
//		test.add(2, 2);
//		test.add(3, 1);
//		test.omit(2);
//		for (int i = 0; i < test.length(); i++) {
//			System.out.println(test.valueAt(i));
//		}
//	}
	
//Test
//	public void moveTest() {
//		int[] stuff = {12,17,50,17,46};
//		int[] actual = {12,17,46,50};
//		SpecialList test = new SpecialList();
//		for (int i = 0; i < 5; i++) {
//			test.add(i, stuff[i]);
//		}
//		test.move();
//		for ()
//	}
	
	@Test
	public void moveTest() {
		SpecialList test = new SpecialList();
		test.add(0 , 0);
		test.add(1 , 5);
		test.add(2 , 2);
		test.move();
		for (int i = 0; i < test.length(); i++) {
			//System.out.println(test.valueAt(i));
		}
	}
	
	@Test
	public void lengthTest() {
		SpecialList test = new SpecialList();
		
	}

}
