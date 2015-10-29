package appewtc.masterung.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordActivity extends AppCompatActivity {

    //Explicit
    private TextView showTimeTextView;
    private String currentTimeString, sleepString;
    private Spinner sleepSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        //Bind Widget
        bindWidget();

        //Show Time
        showTime();

        //Create Sleep Spinner
        createSleepSpinner();

    }   // onCreate

    public void clickSaveRecord(View view) {



    }




    private void createSleepSpinner() {

        final String[] strSleep = {"0-3 ชั่วโมง", "3-6 ชั่วโมง", "6-9 ชั่วโมง", "9-12 ชั่วโมง", "12-15 ชั่วโมง"};

        ArrayAdapter<String> sleepAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strSleep);
        sleepSpinner.setAdapter(sleepAdapter);
        sleepSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sleepString = strSleep[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sleepString = strSleep[0];
            }
        });
    }

    private void showTime() {

        DateFormat objDateFormat = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");
        Date currentDate = new Date();
        currentTimeString = objDateFormat.format(currentDate);
        showTimeTextView.setText(currentTimeString);
    }

    private void bindWidget() {
        showTimeTextView = (TextView) findViewById(R.id.txtShowTime);
        sleepSpinner = (Spinner) findViewById(R.id.spinner);
    }

}   // Main Class
