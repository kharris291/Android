package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MPicture extends Activity implements OnClickListener {

	Button next1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.standm);

		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		next1 = (Button) findViewById(R.id.bCTG);
		next1.setOnClickListener(this);

	}

	public void onClick(View v0) {
		// TODO Auto-generated method stub
		switch (v0.getId()) {
		case R.id.bCTG:
			String setDatamale = "Male picture";
			Intent Savemp = new Intent(this, Savefile.class);
			Bundle backpackmale = new Bundle();
			backpackmale.putString("answer", setDatamale);
			Savemp.putExtras(backpackmale);
			

			startActivity(Savemp);
			finish();

		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent Homep = new Intent(this, MainMenu.class);
		startActivity(Homep);
		finish();
	}

}
