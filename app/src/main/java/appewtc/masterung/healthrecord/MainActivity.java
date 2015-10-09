package appewtc.masterung.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

    //Intent to SignUp
    public void clickSignUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    private void testAddValue() {

        objUserTABLE.addNewUser("User", "Password", "Name", "Age", "Sex", "Weight", "Height");

    }

    private void createDatabase() {
        objUserTABLE = new UserTABLE(this);
    }

}   // Main Class
