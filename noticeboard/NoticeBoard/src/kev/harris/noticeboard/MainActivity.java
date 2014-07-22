package kev.harris.noticeboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

	String info, StorageDirectory;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		info = "mastercard";
		StorageDirectory = Environment.getDataDirectory().getPath().toString()
				+ "/data/kev.harris.noticeboard/files";
		
		OutputStream outStream = null;

		File file = new File(StorageDirectory, "/pass.txt");
		file.delete();
		try {
			outStream = new FileOutputStream(file);
			outStream.write(info.getBytes());
			outStream.flush();
			outStream.close();

			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		Thread time = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					

					Intent myIntent = new Intent(
							"kev.harris.noticeboard.Password");
					startActivity(myIntent);
					finish();
				}

			}
		};
		time.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

		super.onBackPressed();
		Intent j = new Intent(Intent.ACTION_MAIN);
		j.addCategory(Intent.CATEGORY_HOME);
		startActivity(j);
		finish();
	}
}
