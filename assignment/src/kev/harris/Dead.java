package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Dead extends Activity implements OnClickListener {

	Button newG;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dead);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		newG = (Button) findViewById(R.id.newperson);
		newG.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.newperson:
			Intent failedgame = new Intent(this, NewGame.class);
			startActivity(failedgame);
			finish();
		}
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent failedgame = new Intent(this, MainMenu.class);
		startActivity(failedgame);
		finish();
	}
	
}
