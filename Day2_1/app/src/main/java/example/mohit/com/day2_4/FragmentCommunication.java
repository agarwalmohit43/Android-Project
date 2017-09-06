package example.mohit.com.day2_4;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import example.mohit.com.day2_1.R;

public class FragmentCommunication extends Activity implements FragmentComm {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);


    }

    @Override
    public void respond(String data) {

        FragmentManager manager=getFragmentManager();
        FragmentCommunicationB fm2=(FragmentCommunicationB) manager.findFragmentById(R.id.fragmentcomm2);
        fm2.changeText(data);
    }
}
