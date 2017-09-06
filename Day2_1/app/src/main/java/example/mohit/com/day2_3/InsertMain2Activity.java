package example.mohit.com.day2_3;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import example.mohit.com.day2_1.R;
import example.mohit.com.day2_2.*;
import example.mohit.com.day2_2.Message;

public class InsertMain2Activity extends AppCompatActivity {

    EditText uname,pass;
    insertmohitoutter obj;
    abcd objj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_main2);
        uname=(EditText) findViewById(R.id.sqlliteinsertuname);
        pass=(EditText) findViewById(R.id.sqlliteinsertpass);

        obj=new insertmohitoutter(this);


        /*objj=new abcd(this);
        SQLiteDatabase db=objj.getWritableDatabase();*/
    }

   public void sqlliteinsertadduser(View view){
        String username=uname.getText().toString();
        String password=pass.getText().toString();

        long id= obj.insertData(username,password);
        if(id>0){
            example.mohit.com.day2_2.Message.message(this,"Successfull");
        }else{
            example.mohit.com.day2_2.Message.message(this,"Un-Successfull");
        }
    }

    public void sqlliteinsertshowdetails(View view){
        String data=obj.getAllData();
        if(data.equals(" ")){
            Message.message(this,"No Data");
        }else{
            Message.message(this,data);
        }
    }
}
