package example.mohit.com.day2_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import example.mohit.com.day2_2.Message;

/**
 * Created by MOHIT AGARWAL on 07-07-2017.
 */

public class insertmohitoutter {

    insertmohitinner innerobj;

    insertmohitoutter(Context context){
        innerobj=new insertmohitinner(context);
    }

    public long insertData(String name,String password){
        SQLiteDatabase db=innerobj.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(insertmohitinner.NAME,name);
        contentValues.put(insertmohitinner.PASSWORD,password);

        long id= db.insert(insertmohitinner.TABLE_NAME,null,contentValues);

        return id;
    }

    public String getAllData(){
        SQLiteDatabase db=innerobj.getWritableDatabase();

        //select _id,Name,Address from mohittb1

        String[] columns={insertmohitinner.UID,insertmohitinner.NAME,insertmohitinner.PASSWORD};
        Cursor cursor=db.query(insertmohitinner.TABLE_NAME,columns,null,null,null,null,null);

        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){

            //int index=cursor.getColumnIndex(insertmohitinner.UID);
            int custId=cursor.getInt(0);
            String name=cursor.getString(1);
            String password=cursor.getString(2);
            buffer.append(custId+"\t"+name+"\t"+password+"\n");

        }
        return buffer.toString();
    }

    static class insertmohitinner extends SQLiteOpenHelper{
        private Context context;

        private static final String DATABASE_NAME="mohitdb";
        private static final String TABLE_NAME="mohittb1";
        private static final int DATABASE_VERSION=1;//for callig onupgrade we need to change this version

        private static final String UID="_id";
        private static final String NAME="Name";
        private static final String PASSWORD="Password";


        private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255));";
        private static final String DROP_TABLE="DROP TABLE  IF EXISTS "+TABLE_NAME;

        public insertmohitinner(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
            Message.message(context,"Constructor Called");
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            try{
                sqLiteDatabase.execSQL(CREATE_TABLE);
                Message.message(context,"onCreate Called");
            }catch (Exception e){
                //e.printStackTrace();
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            try{
                Message.message(context,"onUpgrade Called");
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);

            }catch (Exception e){
                Message.message(context,""+e);
            }
        }
    }

}
