package example.mohit.com.day2_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MOHIT AGARWAL on 07-07-2017.
 */

public class mohithelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME="mohitdb";
    private static final String TABLE_NAME="mohittb";
    private static final int DATABASE_VERSION=3;//for callig onupgrade we need to change this version

    private static final String UID="_id";
    private static final String NAME="Name";
    private static final String ADDRESS="Address";


    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+ADDRESS+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE  IF EXISTS "+TABLE_NAME;

    public mohithelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        Message.message(context,"Constructor Called");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Message.message(context,"onCreate Called");
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }catch (Exception e){
            //e.printStackTrace();
            Message.message(context,""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Message.message(context,"onUpgrade Called");
        try{
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Message.message(context,""+e);
        }
    }
}
