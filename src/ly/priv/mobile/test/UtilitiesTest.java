package ly.priv.mobile.test;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import ly.priv.mobile.Utilities;

public class UtilitiesTest extends AndroidTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		run();
	}

	@SmallTest
	public void isValidEmailTest() {
		assertEquals(false, Utilities.isValidEmail("random text"));
		assertEquals(false, Utilities.isValidEmail("shivam .bitsgoa@gmail.com"));
		assertEquals(false, Utilities.isValidEmail("shivam. bitsgoa@gmail.com"));
		assertEquals(true, Utilities.isValidEmail("shivam.bitsgoa@gmail.com"));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
