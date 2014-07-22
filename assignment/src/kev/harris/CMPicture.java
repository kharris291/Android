package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CMPicture extends Activity implements OnClickListener {

	Button mgame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cmpicture);
		
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		mgame = (Button) findViewById(R.id.BCTGcm);
		mgame.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.BCTGcm:
			
			// set the information 
			// this is to be added onto the Intent as an extra
			// this will be forwarded to the next page for use
			String setDataCustommale = "Custom Male picture";
			Intent Savecm = new Intent(CMPicture.this, Savefile.class);

			Bundle informationForCustomMalePicture = new Bundle();
			informationForCustomMalePicture.putString("answer", setDataCustommale);
			Savecm.putExtras(informationForCustomMalePicture);
			
			
			startActivity(Savecm);
			
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
