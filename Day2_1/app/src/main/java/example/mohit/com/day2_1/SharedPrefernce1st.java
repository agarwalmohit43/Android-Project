package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefernce1st extends Activity {

    EditText uname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefernce1st);

        uname=(EditText) findViewById(R.id.SharedPrefernce1stuname);
        pass= (EditText) findViewById(R.id.SharedPrefernce1stpass);
    }

    public void SharedPrefernce1stsave(View view){

        SharedPreferences sp=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("uname",uname.getText().toString());
        editor.putString("Pass",pass.getText().toString());

        editor.commit();

        Toast.makeText(this, "Data was saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void SharedPrefernce1stnext(View view){


        Intent in=new Intent(this,SharedPrefernce2nd.class);
        startActivity(in);
    }
}
