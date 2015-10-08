package appewtc.masterung.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private UserTABLE objUserTABLE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create & Connected Database
        createDatabase();

        //Test Add Value SQLite
        testAddValue();

    }   // onCreate

    private void testAddValue() {

        objUserTABLE.addNewUser("User", "Password", "Name", "Age", "Sex", "Weight", "Height");

    }

    private void createDatabase() {
        objUserTABLE = new UserTABLE(this);
    }

}   // Main Class
