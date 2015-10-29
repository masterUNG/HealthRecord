package appewtc.masterung.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyServiceActivity extends AppCompatActivity {

    //Explicit
    private String strUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        //Show User
        showUser();

    }   // onCreate

    public void clickDalySave(View view) {

        Intent objIntent = new Intent(MyServiceActivity.this, RecordActivity.class);
        objIntent.putExtra("Name", strUser);
        startActivity(objIntent);

    }

    private void showUser() {
        strUser = getIntent().getStringExtra("Name");
        TextView userTextView = (TextView) findViewById(R.id.textView11);
        userTextView.setText(strUser);
    }

}   // Main class
