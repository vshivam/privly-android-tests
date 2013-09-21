package ly.priv.mobile.test;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import ly.priv.mobile.Login;
import ly.priv.mobile.PrivlyActivity;
import ly.priv.mobile.Settings;

public class PrivlyActivityFunctionalTest
		extends
			ActivityInstrumentationTestCase2<PrivlyActivity> {

	PrivlyActivity privlyActivity;

	public PrivlyActivityFunctionalTest(Class<PrivlyActivity> activityClass) {
		super(activityClass);
		Log.d("TAG", "INSIDE CONSTRUCTOR");
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		privlyActivity = getActivity();
	}

	public void testStartedIntent() throws Exception {

		Instrumentation mInstr = this.getInstrumentation();
		mInstr.callActivityOnPause(privlyActivity);

		ActivityMonitor settingsMonitor = getInstrumentation().addMonitor(
				Settings.class.getName(), null, false);

		ActivityMonitor loginMonitor = getInstrumentation().addMonitor(
				Login.class.getName(), null, false);

		Settings startedSettingsActivity = (Settings) settingsMonitor
				.waitForActivityWithTimeout(2000);

		Login startedLoginActivity = (Login) loginMonitor
				.waitForActivityWithTimeout(2000);

		assertNotNull(startedSettingsActivity);
		assertNotNull(startedLoginActivity);

	}

}
