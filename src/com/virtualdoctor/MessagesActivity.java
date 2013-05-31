package com.virtualdoctor;

//import com.project.virtual.doctor.R;
import com.virtualdoctor.R;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MessagesActivity extends ListActivity {
	 /** Called when the activity is first created. */
	
	//private ListView listView1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.messages_layout);
    //storing string resources into Array
        String[] adobe_products = getResources().getStringArray(R.array.adobe_products);
 
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, adobe_products));
       
    }
}
