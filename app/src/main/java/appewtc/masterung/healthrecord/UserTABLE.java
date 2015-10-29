package appewtc.masterung.healthrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    //Search User
    public String[] searchUser(String strUser) {

        try {

            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(USER_TABLE,
                    new String[]{COLUMN_ID_USER, COLUMN_USER, COLUMN_PASSWORD, COLUMN_NAME},
                    COLUMN_USER + "=?",
                    new String[] {String.valueOf(strUser)},
                    null, null, null, null);
            if (objCursor != null) {
                if (objCursor.moveToFirst()) {
                    strResult = new String[4];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                }   // if2
            }   // if1

            objCursor.close();
            return strResult;

        } catch (Exception e) {
            return null;
        }

        //return new String[0];
    }


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
