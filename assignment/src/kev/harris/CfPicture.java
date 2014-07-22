package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CfPicture extends Activity implements OnClickListener {

	Button fgame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// set the content view
		setContentView(R.layout.cfpicture);
		// initialize the variables for linking to the button in the xml file
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		fgame = (Button) findViewById(R.id.BCTGcf);// button to continue to the
													// save page.
		fgame.setOnClickListener(this);
	}

	public void onClick(View vv) {
		// TODO Auto-generated method stub

		// set the information 
		// this is to be added onto the Intent as an extra
		// this will be forwarded to the next page for use
		String setDataCustomFemale = "Custom Female Picture";

		Intent CustomFemalePictureInfo = new Intent(this, Savefile.class);
		
		Bundle Fileinformation = new Bundle();
		Fileinformation.putString("answer", setDataCustomFemale);
		CustomFemalePictureInfo.putExtras(Fileinformation);
		
		
		startActivity(CustomFemalePictureInfo);
		
		finish();

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