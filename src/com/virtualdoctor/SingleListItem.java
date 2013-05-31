package com.virtualdoctor;

import com.virtualdoctor.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleListItem extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView txtProduct = (TextView) findViewById(R.id.label);
		 
        Intent i = getIntent();
        // getting attached intent data
        //String product = i.getStringExtra("product");
        // displaying selected product name
       // txtProduct.setText(product);
	}

}
