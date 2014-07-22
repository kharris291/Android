package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Male extends Activity implements OnClickListener {

	Button Standm, Choosem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.male);
		
		initalize();
	}

	private void initalize() {
		// TODO Auto-generated method stub
		Standm = (Button) findViewById(R.id.bstandm);
		Choosem = (Button) findViewById(R.id.bChoosem);
		Standm.setOnClickListener(this);
		Choosem.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bstandm:
			
			Intent am = new Intent(Male.this, MPicture.class);
			startActivity(am);
			
			break;
		case R.id.bChoosem:
			Intent bm = new Intent(Male.this,CMPicture.class);
			startActivity(bm);
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
