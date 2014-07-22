package kev.harris;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;

public class Continues extends Activity implements OnClickListener {

	String content = "";
	String sendingCOntent;

	TextView info;
	Button ContineToGme;

	Intent game = null;

	Calendar c = Calendar.getInstance();

	String sDate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-"
			+ (c.get(Calendar.DAY_OF_MONTH));
	String sDates = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1)+ "-"
			+ (c.get(Calendar.DAY_OF_MONTH)-1);
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.continues);
		
		initilize();

		info.setText(ReadFromFile("game.txt"));

		String man = "Male picture " + sDate;
		String CustomMan = "Custom Male picture " + sDate;
		String girl = "Female picture " + sDate;
		String Woman = "Custom Female Picture " + sDate;
		String man1 = "Male picture " + sDates;
		String CustomMan1 = "Custom Male picture " + sDates;
		String girl1 = "Female picture " + sDates;
		String Woman1 = "Custom Female Picture " + sDates;
		
		
		// find out what information is being displayed so that the program can
		// open the correct game file
		if (man.startsWith(content) ^ content.startsWith(man1)) {
			game = new Intent(this, MainGame.class);
			String now ="Male Picture";
			Bundle trying = new Bundle();
			trying.putString("sendingCOntent", now);
			game.putExtras(trying);

		} else if (CustomMan.startsWith(content)^ content.startsWith(CustomMan1)) {
			game = new Intent(this, MainGame.class);
			String now ="Custom Male Picture";
			Bundle trying = new Bundle();
			trying.putString("sendingCOntent", now);
			game.putExtras(trying);

		} else if (girl.startsWith(content) ^ content.startsWith(girl1)) {
			game = new Intent(this, MainGame.class);
			String now ="Female Picture";
			Bundle trying = new Bundle();
			trying.putString("sendingCOntent", now);
			game.putExtras(trying);
			
		} else if (Woman.startsWith(content) ^ content.startsWith(Woman1)) {
			game = new Intent(this, MainGame.class);
			String now ="Custom Female Picture";
			Bundle trying = new Bundle();
			trying.putString("sendingCOntent", now);
			game.putExtras(trying);
		} else {
			game = new Intent(this, Dead.class);
		}
	}

	String ReadFromFile(String file) {
		// file has the value of the file that is wanted to be opened
		// Read file in Internal Storage
		FileInputStream FileIS;

		// check the size of the file and then continue to add information to a
		// string. this will need a try statement with 2 catches to make sure
		// the file is found and to make sure information is being read
		// correctly
		try {
			FileIS = openFileInput(file);
			byte[] input = new byte[FileIS.available()];
			while (FileIS.read(input) != -1) {
				content += new String(input);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	private void initilize() {
		// TODO Auto-generated method stub

		// declare all values to be used

		info = (TextView) findViewById(R.id.tvinfo);
		info.setTextColor(Color.rgb(0, 0, 0));
		ContineToGme = (Button) findViewById(R.id.bcontinuetogame);
		ContineToGme.setOnClickListener(this);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();

		Intent Homep = new Intent(this, MainMenu.class);

		startActivity(Homep);

		finish();
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.bcontinuetogame:
			startActivity(game);
			finish();

		}
	}

}
