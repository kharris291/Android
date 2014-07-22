package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class NewGame extends Activity implements OnClickListener {

	CheckBox CBM, CBFM;
	Button BNext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.make_a_charachter);

		initiliaze();

	}

	private void initiliaze() {
		// TODO Auto-generated method stub
		CBM = (CheckBox) findViewById(R.id.cbMale);
		CBFM = (CheckBox) findViewById(R.id.cbFemale);
		CBM.setOnClickListener(this);
		CBFM.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.cbMale:

			Intent a = new Intent(NewGame.this, Male.class);
			startActivity(a);
			break;

		case R.id.cbFemale:
			Intent b = new Intent(NewGame.this, Female.class);
			startActivity(b);

			break;
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
