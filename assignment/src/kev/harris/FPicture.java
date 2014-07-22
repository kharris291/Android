package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FPicture extends Activity implements OnClickListener {

	Button cont;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.standf);

		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub

		cont = (Button) findViewById(R.id.BCTGf);

		cont.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.BCTGf:

			String setDataFemale = "Female picture";

			Intent fgame = new Intent(this, Savefile.class);
			Bundle backpack2 = new Bundle();
			backpack2.putString("answer", setDataFemale);
			fgame.putExtras(backpack2);

			startActivity(fgame);
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
