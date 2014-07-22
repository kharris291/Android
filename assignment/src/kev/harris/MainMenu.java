package kev.harris;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends ListActivity {
	
	
	
	String classes[]={"Continues", "NewGame"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MainMenu.this, android.R.layout.simple_list_item_1, classes));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String pos = classes[position];
		try {
			Class<?> nextClass = Class.forName("kev.harris." + pos);

			Intent pageIntent = new Intent(MainMenu.this, nextClass);

			startActivity(pageIntent);
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
		
		
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
