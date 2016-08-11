package com.kute.app.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.kute.app.R;


public class ShowLocationActivity extends AppCompatActivity {

    private Spinner vehicleList;
    private Button show, cancel;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarShare);
        setSupportActionBar(toolbar);

        vehicleList = (Spinner) findViewById(R.id.itemListSpinner);

        show = (Button) findViewById(R.id.show_button);
        cancel = (Button) findViewById(R.id.cancel_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.train_list, android.R.layout.select_dialog_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleList.setAdapter(adapter);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent share = new Intent(getApplicationContext(),
                        IndividualShowLocationActivity.class);
                Bundle selectedDetails = new Bundle();
                selectedDetails.putString("Selected Vehicle", vehicleList.getSelectedItem().toString());
                share.putExtra("bundle", selectedDetails);
                startActivity(share);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cancelled = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(cancelled);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.sign_out:
                Intent goBack = new Intent(getApplicationContext(), SplashActivity.class);
                startActivity(goBack);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}