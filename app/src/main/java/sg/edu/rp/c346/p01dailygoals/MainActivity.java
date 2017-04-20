package sg.edu.rp.c346.p01dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    EditText et;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Daily Goals");

        rg1 = (RadioGroup)findViewById(R.id.rg1);
        rg2 = (RadioGroup)findViewById(R.id.rg2);
        rg3 = (RadioGroup)findViewById(R.id.rg3);
        et = (EditText)findViewById(R.id.editText2);
        btnDone = (Button)findViewById(R.id.button);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(et.getText().toString())) {
                    et.setError("Please provide your reflection.");
                }
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);


                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);


                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);


                String[] result = {rb1.getText().toString(),
                        rb2.getText().toString(), rb3.getText().toString(), et.getText().toString()};
                // Create an intent to start another activity called
                //  DemoActivities (which we would create later)
                Intent i = new Intent(MainActivity.this,
                        resultActivity.class);
                // Pass the String array holding the name & age to new activity
                i.putExtra("result", result);
                // Start the new activity
                startActivity(i);


                SharedPreferences prefs1 = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit1 = prefs1.edit();
                prefEdit1.putInt("rg1",rg1.getCheckedRadioButtonId());
                prefEdit1.commit();

                SharedPreferences prefs2 = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit2 = prefs2.edit();
                prefEdit2.putInt("rg2",rg2.getCheckedRadioButtonId());
                prefEdit2.commit();

                SharedPreferences prefs3 = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit3 = prefs3.edit();
                prefEdit3.putInt("rg3",rg3.getCheckedRadioButtonId());
                prefEdit3.commit();

                SharedPreferences prefs4 = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit4 = prefs4.edit();
                prefEdit4.putString("et1",et.getText().toString());
                prefEdit4.commit();

            }
        });
    }

    protected void onResume() {
        super.onResume();
        SharedPreferences prefs1 = PreferenceManager
                .getDefaultSharedPreferences(this);
        String etVal= prefs1.getString("et1", "");
        et.setText(etVal);

        SharedPreferences prefs2 = PreferenceManager
                .getDefaultSharedPreferences(this);
        Integer rgValue1= prefs2.getInt("rg1", 0);
        rg1.check(rgValue1);

        SharedPreferences prefs3 = PreferenceManager
                .getDefaultSharedPreferences(this);
        Integer rgValue2= prefs3.getInt("rg2", 0);
        rg2.check(rgValue2);

        SharedPreferences prefs4 = PreferenceManager
                .getDefaultSharedPreferences(this);
        Integer rgValue3= prefs4.getInt("rg3", 0);
        rg3.check(rgValue3);

    }
}
