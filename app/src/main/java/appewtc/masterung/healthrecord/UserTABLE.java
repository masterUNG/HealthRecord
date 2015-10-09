package appewtc.masterung.healthrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 10/8/15 AD.
 */
public class UserTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String USER_TABLE = "userTABLE";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_AGE = "Age";
    public static final String COLUMN_SEX = "Sex";
    public static final String COLUMN_WEIGHT = "Weight";
    public static final String COLUMN_HEIGHT = "Height";
    public static final String COLUMN_EMAIL = "Email";


    public UserTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    //Add New Value to userTABLE
    public long addNewUser(String strUser, String strPassword, String strName,
                           String strAge, String strSex, String strWeight,
                           String strHeight, String strEmail) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER, strUser);
        objContentValues.put(COLUMN_PASSWORD, strPassword);
        objContentValues.put(COLUMN_NAME, strName);
        objContentValues.put(COLUMN_AGE, strAge);
        objContentValues.put(COLUMN_SEX, strSex);
        objContentValues.put(COLUMN_WEIGHT, strWeight);
        objContentValues.put(COLUMN_HEIGHT, strHeight);
        objContentValues.put(COLUMN_EMAIL, strEmail);

        return writeSqLiteDatabase.insert(USER_TABLE, null, objContentValues);
    }



}   // Main Class
