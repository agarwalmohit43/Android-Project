package example.mohit.com.day2_2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.mohit.com.day2_1.R;

public class SqlMain2Activity extends AppCompatActivity {

    mohithelper obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_main2);
        obj=new mohithelper(this);
        SQLiteDatabase sqLiteDatabase=obj.getWritableDatabase();
    }
}
