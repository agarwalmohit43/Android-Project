package example.mohit.com.day2_4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.mohit.com.day2_1.R;

public class FragmentUsingJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_using_java);


        MyFragment_Java frag=new MyFragment_Java();

        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        transaction.add(R.id.fragmentlayoutJavarelativelayout,frag,"javaFrag");
        transaction.commit();
    }
}
