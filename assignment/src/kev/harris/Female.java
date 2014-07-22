package kev.harris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Female extends Activity implements OnClickListener{

	Button Stand, Choose;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.female);
		initalise();
	}

	private void initalise() {
		// TODO Auto-generated method stub
		Stand = (Button) findViewById(R.id.bstandfm);
		Choose = (Button) findViewById(R.id.bChoosefm);
		Stand.setOnClickListener(this);
		Choose.setOnClickListener(this);
	}

	public void onClick(View v1) {
		// TODO Auto-generated method stub
		switch(v1.getId()){
		case R.id.bstandfm:
			
			Intent ap = new Intent(Female.this,FPicture.class);
			startActivity(ap);
			
			break;
		case R.id.bChoosefm:
			
			Intent bp = new Intent(Female.this,CfPicture.class);
			startActivity(bp);
			
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
