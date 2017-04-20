package sg.edu.rp.c346.p01dailygoals;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    TextView tvQn1;
    TextView tvQn2;
    TextView tvQn3;
    TextView tvQn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvQn1 = (TextView)findViewById(R.id.textViewQn1);
        tvQn2 = (TextView)findViewById(R.id.textViewQn2);
        tvQn3 = (TextView)findViewById(R.id.textViewQn3);
        tvQn4 = (TextView)findViewById(R.id.textViewQn4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        getSupportActionBar().setTitle("Summary");

        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] result = i.getStringArrayExtra("result");
        // Get the TextView object

        // Display the name and age on the TextView
        tvQn1.setText("Read up on materials before class : " + result[0] + "\n");
        tvQn2.setText("Arrive on time so as not to miss important part of lesson : " + result[1] + "\n");
        tvQn3.setText("Attempt the problem myself : " + result[2] + "\n");
        tvQn4.setText("Reflection : " + result[3]);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
