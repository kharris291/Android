package kev.harris.noticeboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import kev.harris.noticeboard.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Password extends Activity implements OnClickListener {

	Button checkPass;
	EditText ed;
	TextView tv;

	String content = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.password);
		ReadFromFile("pass.txt").toString();
		initialise();

	}

	private void initialise() {
		// TODO Auto-generated method stub
		checkPass = (Button) findViewById(R.id.BPass);
		checkPass.setOnClickListener(this);
		ed = (EditText) findViewById(R.id.PassCheck);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.BPass:
			String Text = ed.getText().toString().trim();

			if (Text.endsWith(content)) {
				Intent i = new Intent(this, WebScreen.class);
				startActivity(i);
				finish();
			} else {
				ed.setText(null);
				Toast.makeText(Password.this, "Incorrect. Input password again", Toast.LENGTH_SHORT).show();
			}
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

}
