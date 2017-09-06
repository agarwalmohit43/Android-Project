package example.mohit.com.day2_3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import example.mohit.com.day2_2.*;

/**
 * Created by MOHIT AGARWAL on 07-07-2017.
 */

public class abcd extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME="mohitdb";
    private static final String TABLE_NAME="mohittb1";
    private static final int DATABASE_VERSION=1;//for callig onupgrade we need to change this version

    private static final String UID="_id";
    private static final String NAME="Name";
    private static final String PASSWORD="Password";


    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE  IF EXISTS "+TABLE_NAME;

    public abcd(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        example.mohit.com.day2_2.Message.message(context,"Constructor Called");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
            example.mohit.com.day2_2.Message.message(context,"onCreate Called");
        }catch (Exception e){
            //e.printStackTrace();
            example.mohit.com.day2_2.Message.message(context,""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{
            example.mohit.com.day2_2.Message.message(context,"onUpgrade Called");
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch (Exception e){
            example.mohit.com.day2_2.Message.message(context,""+e);
        }
    }
}
