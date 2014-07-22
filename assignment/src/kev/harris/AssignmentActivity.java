package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AssignmentActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Thread time = new Thread() {
			public void run() {
				try {/* used to make an attempt at a sketchy bit of code */
					sleep(0);//keeps the first page open for around 2 seconds

				} catch (InterruptedException e) {
					e.printStackTrace();

				}finally {
					Intent openOneActivity = new Intent("kev.harris.MAINMENU");
					startActivity(openOneActivity);

				}/* for the try part */
			};// for the time
		};// for the thread
		time.start();
	}
}