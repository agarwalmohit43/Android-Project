package example.mohit.com.day2_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPrefernce2nd extends ActionBarActivity {

    TextView unametext,passtext;
    public static final String Default="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefernce2nd);

        unametext=(TextView) findViewById(R.id.SharedPrefernce2nduname);
        passtext=(TextView) findViewById(R.id.SharedPrefernce2ndpass);
    }

    public void SharedPrefernce2ndLoad(View view){

        SharedPreferences sp=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String uname=sp.getString("uname",Default);
        String pass=sp.getString("Pass",Default);

        if(uname.equals(Default) || pass.equals(Default)){

            Toast.makeText(this,"No Data Was Found",Toast.LENGTH_SHORT).show();

        }else{
            unametext.setText(uname);
            passtext.setText(pass);

            Toast.makeText(this,"Data was loaded successfully",Toast.LENGTH_SHORT).show();
        }
    }

    public void SharedPrefernce2ndprevious(View view){
        Intent in=new Intent(this,SharedPrefernce1st.class);
        startActivity(in);
    }
}
