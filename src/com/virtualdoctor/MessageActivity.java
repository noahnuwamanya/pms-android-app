package com.virtualdoctor;

import java.util.ArrayList;
import java.util.Random;

import android.R;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * MessageActivity is a main Activity to show a ListView containing Message items
 * 
 * @author Adil Soomro
 *
 */
public class MessageActivity extends ListActivity {
	/** Called when the activity is first created. */

	ArrayList<Message> messages;
	AwesomeAdapter adapter;
	EditText text;
	static Random rand = new Random();	
	static String sender;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.virtualdoctor.R.layout.main);
		
		text = (EditText) this.findViewById(com.virtualdoctor.R.id.text);
		
		sender = Utility.sender[rand.nextInt( Utility.sender.length-1)];
		this.setTitle(sender);
		messages = new ArrayList<Message>();

		messages.add(new Message("Hello", true));
		messages.add(new Message("Hello there how may help you", false));
		messages.add(new Message("I don't feel ok today", true));
		messages.add(new Message("Sorry about that have you taken your medicine", false));
		//messages.add(new Message("you say!", true));
		//messages.add(new Message("oh thats great. how are you showing them", false));
		

		adapter = new AwesomeAdapter(this, messages);
		setListAdapter(adapter);
		//addNewMessage(new Message("mmm, well, using 9 patches png to show them.", true));
	}
	public void sendMessage(View v)
	{
		String newMessage = text.getText().toString().trim(); 
		if(newMessage.length() > 0)
		{
			text.setText("");
			addNewMessage(new Message(newMessage, true));
			new SendMessage().execute();
		}
	}
	private class SendMessage extends AsyncTask<Void, String, String>
	{
		@Override
		protected String doInBackground(Void... params) {
			try {
				Thread.sleep(2000); //simulate a network call
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.publishProgress(String.format("%s started writing", sender));
			try {
				Thread.sleep(2000); //simulate a network call
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.publishProgress(String.format("%s has entered text", sender));
			try {
				Thread.sleep(3000);//simulate a network call
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			return Utility.messages[rand.nextInt(Utility.messages.length-1)];
			
			
		}
		@Override
		public void onProgressUpdate(String... v) {
			
			if(messages.get(messages.size()-1).isStatusMessage)//check wether we have already added a status message
			{
				messages.get(messages.size()-1).setMessage(v[0]); //update the status for that
				adapter.notifyDataSetChanged(); 
				getListView().setSelection(messages.size()-1);
			}
			else{
				addNewMessage(new Message(true,v[0])); //add new message, if there is no existing status message
			}
		}
		@Override
		protected void onPostExecute(String text) {
			if(messages.get(messages.size()-1).isStatusMessage)//check if there is any status message, now remove it.
			{
				messages.remove(messages.size()-1);
			}
			
			addNewMessage(new Message(text, false)); // add the orignal message from server.
		}
		

	}
	void addNewMessage(Message m)
	{
		messages.add(m);
		adapter.notifyDataSetChanged();
		getListView().setSelection(messages.size()-1);
	}
}