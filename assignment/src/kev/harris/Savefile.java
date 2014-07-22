package kev.harris;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Savefile extends Activity implements OnClickListener {

	TextView tvSave, tvDate;
	Button bSave, bcon, bexit;
	String info, StorageDirectory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save);

		initialize();
		// get the information from the class sending it and put it into a
		// string for use
		Intent intent = getIntent();
		info = intent.getStringExtra("answer");
		tvSave.setText(info);

		Calendar c = Calendar.getInstance();

		String sDate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-"
				+ (c.get(Calendar.DAY_OF_MONTH));
		tvDate.setText(sDate);
		String p = sDate.toString();

		info = info + " " + p;

	}

	private void initialize() {
		// TODO Auto-generated method stub
		// initialize all the variables used in the program here. it will help
		// to keep track of what they are meant to do

		// tvSave is used for showing the user what is being saved
		tvSave = (TextView) findViewById(R.id.TVsave);

		// bSave is used to save the infromation in tvSave
		bSave = (Button) findViewById(R.id.bSave);
		bSave.setOnClickListener(buttonSaveOnClickListener);
		// buttonSaveOnClickListener is a method through which i will be saving
		// information to a file
		StorageDirectory = Environment.getDataDirectory().getPath().toString()
				+ "/data/kev.harris/files";
		// StorageDictory is used to get the path to the data directory where
		// the info will be saved
		bSave.setText("Save to game.txt");

		// bcon is used to continue onto the game
		bcon = (Button) findViewById(R.id.bcontinuetohome);
		bcon.setOnClickListener(this);

		// bexit is used for exiting the program after saving
		bexit = (Button) findViewById(R.id.Bexit);
		bexit.setOnClickListener(this);
		// tvDate is used to hold the current date
		tvDate = (TextView) findViewById(R.id.tvDate);

	}

	Button.OnClickListener buttonSaveOnClickListener = new Button.OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			OutputStream outStream = null;

		
			File file = new File(StorageDirectory, "/game.txt");
			file.delete();
			try {
				outStream = new FileOutputStream(file);
				outStream.write(info.getBytes());
				outStream.flush();
				outStream.close();

				Toast.makeText(Savefile.this, "Saved", Toast.LENGTH_LONG)
						.show();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(Savefile.this, e.toString(), Toast.LENGTH_LONG)
						.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(Savefile.this, e.toString(), Toast.LENGTH_LONG)
						.show();
			}

		}

	};


	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent Homep = new Intent(this, MainMenu.class);
		startActivity(Homep);
		finish();
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bcontinuetohome:
			Intent Homep = new Intent(this, Continues.class);

			startActivity(Homep);
			break;
		case R.id.Bexit:
			Intent j = new Intent(Intent.ACTION_MAIN);
			j.addCategory(Intent.CATEGORY_HOME);
			startActivity(j);
			finish();
		}

	}

}