package kev.harris;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainGame extends Activity {

	TextView questions;

	private Context ContextForMenus;

	String info = null;// for information going coming to this class

	String content = null; // for information going to another class

	Button b1,b2,b3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		ContextForMenus = this;
		// see what information has been sent and from that see which layout the
		// game will be
		//initialize();
		Intent intent = getIntent();
		info = intent.getStringExtra("sendingCOntent");

		if (info.contentEquals("Male Picture")) {
			setContentView(R.layout.normalmgame);
			content = "Male picture";
			
		}
		if (info.contentEquals("Custom Male Picture")) {
			setContentView(R.layout.differentmgame);
			content = "Custom male picture";
		}
		if (info.contentEquals("Female Picture")) {
			setContentView(R.layout.normalfmgame);
			content = "Female picture";
		}
		if (info.contentEquals("Custom Female Picture")) {
			setContentView(R.layout.differentfmgame);
			content = "Custom female picture";

		}

	}
/*
	private void initialize() {
		// TODO Auto-generated method stub
		b1= (Button) findViewById(R.id.custommalehead);
		Calendar c = Calendar.getInstance();
		int Hour = c.get(Calendar.HOUR_OF_DAY);
		if (Hour > 9 && Hour < 18) {
			
			b1.setBackgroundResource(Color.BLUE);

		}
		else{
			b1.setBackgroundResource(Color.LTGRAY);

		}
	}
*/
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.question:
			QuestionMenu();
			return true;

		case R.id.feed:
			FeedingOptions();
			break;

		case R.id.exit:
			// set the information
			// this is to be added onto the Intent as an extra
			// this will be forwarded to the next page for use

			Intent Savemp = new Intent(this, Savefile.class);
			Bundle backpackmale = new Bundle();
			backpackmale.putString("answer", content);
			Savemp.putExtras(backpackmale);

			startActivity(Savemp);
			finish();

		}

		return false;

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		// set the information
		// this is to be added onto the Intent as an extra
		// this will be forwarded to the next page for use

		Intent Savemp = new Intent(this, Savefile.class);
		Bundle backpackmale = new Bundle();
		backpackmale.putString("answer", content);
		Savemp.putExtras(backpackmale);

		startActivity(Savemp);
		finish();
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(id);
	}

	private int Informationselected = 0;
	private String ListItemSelectedReply = null; // add buffer value
	private int donealready = 0;
	private int feedalready = 0;

	private void QuestionMenu() {

		AlertDialog.Builder builder = new AlertDialog.Builder(ContextForMenus);
		builder.setTitle("Question list");

		final CharSequence[] QuestionList = { "How are you?",
				"Are you hungry?", "Do you love me?", "What's up?",
				"How are the other occupants treating you?", "What date is it",
				"Do you have the time?" };

		builder.setSingleChoiceItems(QuestionList, Informationselected,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// set to ListItemSelectedReply instead of
						// Informationselected
						// the ListItemSelectedReply will show the reply

						if (which == 0) {
							if (donealready == 0) {
								ListItemSelectedReply = ("I'm still ok. You just asked me this");

							} else {
								ListItemSelectedReply = ("I'm fine thanks for asking");
								donealready = 0;

							}
						} else if (which == 1) {
							if (donealready == 1) {
								ListItemSelectedReply = ("Still hungry. You should feed me");

							} else {
								ListItemSelectedReply = ("starving");
								donealready = 1;
							}
						} else if (which == 2) {
							if (donealready == 2) {
								ListItemSelectedReply = ("Someone's needy...");

							} else {
								ListItemSelectedReply = ("With all my pixels :)");
								donealready = 2;
							}

						} else if (which == 3) {
							if (donealready == 3) {
								ListItemSelectedReply = ("Just chilling. Might invite some other apps over");

							} else {
								ListItemSelectedReply = ("nm. ty for asking");
								donealready = 3;
							}

						} else if (which == 4) {
							if (donealready == 4) {
								ListItemSelectedReply = ("Making friends is hard but we're getting closer :)");

							} else {
								ListItemSelectedReply = ("They're ok to me but we're getting closer :)");
								donealready = 4;
							}

						} else if (which == 5) {
							Calendar c = Calendar.getInstance();
							String sDate = c.get(Calendar.DAY_OF_MONTH) + "-"
									+ (c.get(Calendar.MONTH) + 1) + "-"
									+ (c.get(Calendar.YEAR));
							if (donealready == 5) {
								ListItemSelectedReply = ("Come on.. I just told you but it's " + sDate);

							} else {

								ListItemSelectedReply = (sDate);
								donealready = 5;
							}

						}

						else if (which == 6) {
							if (donealready == 6) {
								ListItemSelectedReply = ("Seriously? It's just there");

							} else {
								ListItemSelectedReply = ("Just look at the top of the screen lazy");
								donealready = 6;
							}
						}

					}
				})
				.setCancelable(false)
				// can not click back
				.setPositiveButton("choose",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(ContextForMenus,
										ListItemSelectedReply,
										Toast.LENGTH_SHORT).show();

								Informationselected = which;
							}
						});

		AlertDialog Dialonginfo = builder.create();
		Dialonginfo.show();
	}

	private void FeedingOptions() {

		AlertDialog.Builder builder = new AlertDialog.Builder(ContextForMenus);
		builder.setTitle("Food Options");

		final CharSequence[] QuestionList = { "Fish", "Chocolate",
				"Sunday Dinner", "Double Chese Burger", "Veggie Dinner",
				"Fanta", "Tofu" };

		builder.setSingleChoiceItems(QuestionList, Informationselected,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// set to ListItemSelectedReply instead of
						// Informationselected
						// the ListItemSelectedReply will show the reply

						if (which == 0) {
							if (feedalready == 0) {
								ListItemSelectedReply = ("Seriously? Please don't ever give me that");

							} else {
								ListItemSelectedReply = ("That was disgusting");
								feedalready = 0;
							}

						} else if (which == 1) {
							if (feedalready == 1) {
								ListItemSelectedReply = ("Delicious");

							} else {
								ListItemSelectedReply = ("That was tasty");
								feedalready = 1;
							}

						} else if (which == 2) {
							if (feedalready == 2) {
								ListItemSelectedReply = ("That's amazing!!!");

							} else {
								ListItemSelectedReply = ("More of those please");
								feedalready = 2;
							}

						} else if (which == 3) {
							if (feedalready == 3) {
								ListItemSelectedReply = ("I love those burgers");
							} else {
								ListItemSelectedReply = ("That burger was amazing");
								feedalready = 3;
							}

						} else if (which == 4) {

							if (feedalready == 4) {
								ListItemSelectedReply = ("Veg..? Again..?");
							} else {
								ListItemSelectedReply = ("It's ok but meat is better");
								feedalready = 4;
							}

						} else if (which == 5) {

							if (feedalready == 5) {
								ListItemSelectedReply = ("That was tasty");
							} else {
								ListItemSelectedReply = ("That's a drink not food but good guess. I was thirsty");
								feedalready = 5;
							}
						}

						else if (which == 6) {

							if (feedalready == 6) {
								ListItemSelectedReply = ("If it had flavour it'd be better but is tasteless");

							} else {
								ListItemSelectedReply = ("Thats not even food -_-");
								feedalready = 6;
							}
						}

					}
				})
				.setCancelable(false)
				// can not click back
				.setPositiveButton("choose",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(ContextForMenus,
										ListItemSelectedReply,
										Toast.LENGTH_SHORT).show();

								Informationselected = which;
							}
						});

		AlertDialog Dialonginfo = builder.create();
		Dialonginfo.show();
	}

		
}