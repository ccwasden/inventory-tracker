package test;
import org.junit.runners.JUnit4;
import org.junit.runners.model.InitializationError;

import junit.framework.*;

public class TestItem extends TestCase{
	public TestItem(String name){
		super(name);
	}
	public void testSay() {
//        HelloWorld hi = new HelloWorld();
        assertEquals(false, false);
        assertEquals(false, false);
        assertEquals(false, false);
        assertEquals(false, false);
        assertEquals(false, false);
        assertEquals(true, false);
        assertEquals(false, false);
        assertEquals(false, false);
    }
	public static void main(String[] args) {
		try {
			new JUnit4(TestItem.class);
		} catch (InitializationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        junit.textui.TestRunner.run(TestItem.class);
    }
}
