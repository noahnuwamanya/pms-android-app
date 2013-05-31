package com.virtualdoctor;
import com.virtualdoctor.R;
import com.virtualdoctor.library.UserFunctions;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class Homeactivity extends Activity {
	
	
	UserFunctions userFunctions;
	Button btnLogout;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Homeactivity.this);
        
        // Setting Dialog Title
        alertDialog.setTitle("Chat");
 
        // Setting Dialog Message
        alertDialog.setMessage("Choose A Person To Chat With");
 
        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);
 
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("COUNSELLOR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
            Intent i = new Intent(getApplicationContext(), MessageActivity.class);
			startActivity(i);
            // Write your code here to invoke YES event
            Toast.makeText(getApplicationContext(), "You are now chatting with a counsellor", Toast.LENGTH_SHORT).show();
            }
        });
 
        // Setting Negative "NO" Button
        alertDialog.setNeutralButton("DOCTOR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	Intent i = new Intent(getApplicationContext(), NewsFeedActivity.class);
				startActivity(i);
            // Write your code here to invoke NO event
            Toast.makeText(getApplicationContext(), "You are now chatting with a doctor", Toast.LENGTH_SHORT).show();
            dialog.cancel();
            }
        });
        
     // Setting patient "NO" Button
        alertDialog.setNegativeButton("PATIENT", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	Intent i = new Intent(getApplicationContext(), FriendsActivity.class);
				startActivity(i);
            // Write your code here to invoke NO event
            Toast.makeText(getApplicationContext(), "You are now chatting with a patient", Toast.LENGTH_SHORT).show();
            dialog.cancel();
            }
        });
 
        // Showing Alert Message
        
       
     // Check login status in database
        userFunctions = new UserFunctions();
        if(userFunctions.isUserLoggedIn(getApplicationContext())){
        	setContentView(R.layout.dashboard_layout);
        	//setContentView(R.layout.news_feed_layout);
        	btnLogout = (Button) findViewById(R.id.btnLogout);
        	
        	btnLogout.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View arg0) {
    				// TODO Auto-generated method stub
    				userFunctions.logoutUser(getApplicationContext());
    				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
    	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	        	startActivity(login);
    	        	// Closing dashboard screen
    	        	finish();
    			}
    		});
            /**
             * Creating all buttons instances
             * */
        	
            // Dashboard News feed button
            Button btn_newsfeed = (Button) findViewById(R.id.btn_news_feed);
            
            // Dashboard Friends button
            Button btn_friends = (Button) findViewById(R.id.btn_friends);
            
            // Dashboard Messages button
            Button btn_messages = (Button) findViewById(R.id.btn_messages);
            
            // Dashboard Places button
           //Button btn_places = (Button) findViewById(R.id.btn_places);
            
            // Dashboard Events button
            Button btn_events = (Button) findViewById(R.id.btn_events);
            
            // Dashboard Photos button
           // Button btn_photos = (Button) findViewById(R.id.btn_photos);
            
            
            
            /**
             * Handling all button click events
             * */
            
            // Listening to News Feed button click
            btn_newsfeed.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				Intent i = new Intent(getApplicationContext(), NewsFeedActivity.class);
    				startActivity(i);
    			}
    		});
            
           // Listening Friends button click
            btn_friends.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				Intent i = new Intent(getApplicationContext(), FriendsActivity.class);
    				startActivity(i);
    			}
    		});
            
            // Listening Messages button click
            btn_messages.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				//alertDialog.show(); 
    				Intent i = new Intent(getApplicationContext(), MessageActivity.class);
    				startActivity(i);
    			}
    		});
            
            // Listening to Places button click
            
            /*btn_places.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				Intent i = new Intent(getApplicationContext(), PlacesActivity.class);
    				startActivity(i);
    			}
    		});*/
            
            // Listening to Events button click
            btn_events.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				Intent i = new Intent(getApplicationContext(), CustomizedListView.class);
    				startActivity(i);
    			}
    		});
            
            // Listening to Photos button click
            /*btn_photos.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				// Launching News Feed Screen
    				Intent i = new Intent(getApplicationContext(), PhotosActivity.class);
    				startActivity(i);
    			}
    		});*/
            
            
        	//btnLogout = (Button) findViewById(R.id.btnLogout);
        	/*
        	btnLogout.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View arg0) {
    				// TODO Auto-generated method stub
    				userFunctions.logoutUser(getApplicationContext());
    				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
    	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	        	startActivity(login);
    	        	// Closing dashboard screen
    	        	finish();
    			}
    		});
        	*/
        }
        else{
        	// user is not logged in show login screen
        	Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dashboard screen
        	finish();
        }
        
        
      
    }
}