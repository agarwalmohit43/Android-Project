package mantoo.com.mantoo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ev1,ev2;
    insertdata insertdataObj;
    outerclass outerclassObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ev1=(EditText) findViewById(R.id.sqlliteinsertuname);
        ev2=(EditText) findViewById(R.id.sqlliteinsertpass);


        //outerclassObj=new outerclass(this);

       insertdataObj=new insertdata(this);
        SQLiteDatabase db=insertdataObj.getWritableDatabase();

    }


    public void sqlliteinsertadduser(View view){

        String username=ev1.getText().toString();
        String password=ev2.getText().toString();
        double amnt=10.5;

        long id= outerclassObj.insertsData(username,password,amnt);
        if(id>0){
            mantoo.com.mantoo.Message.message(this,"Successfull");
        }else{
            mantoo.com.mantoo.Message.message(this,"Un-Successfull");
        }
    }

    public void sqlliteinsertshowdetails(View view){

        String data=outerclassObj.getData();
        if(data.equals(" ")){
            Message.message(this,"No Data");
        }else{
            Message.message(this,data);
        }

    }

}
