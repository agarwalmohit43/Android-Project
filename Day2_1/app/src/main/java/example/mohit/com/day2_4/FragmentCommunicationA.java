package example.mohit.com.day2_4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import example.mohit.com.day2_1.R;

/**
 * Created by MOHIT AGARWAL on 13-07-2017.
 */

public class FragmentCommunicationA extends Fragment implements  View.OnClickListener{

    Button btn;
    int counter=0;
    FragmentComm comm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState==null){
            counter=0;
        }else {
            counter=savedInstanceState.getInt("counter",0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentcomm_a,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        comm=(FragmentComm) getActivity();

        btn=(Button) getActivity().findViewById(R.id.fragmentcommAbtn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
    }

    @Override
    public void onClick(View view) {
        counter++;
        comm.respond("The Buttton was Clicked "+counter+" times");
    }
}
