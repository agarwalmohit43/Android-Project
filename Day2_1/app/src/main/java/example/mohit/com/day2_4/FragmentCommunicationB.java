package example.mohit.com.day2_4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.mohit.com.day2_1.R;

/**
 * Created by MOHIT AGARWAL on 13-07-2017.
 */

public class FragmentCommunicationB extends Fragment {

    TextView text;
    String data="";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentcomm_b,container,false);

        if(savedInstanceState==null){
            data="";
        }else{
            data=savedInstanceState.getString("datas","Yehh");
            TextView text=(TextView) view.findViewById(R.id.fragmentcommbText);
            text.setText(data);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        text=(TextView) getActivity().findViewById(R.id.fragmentcommbText);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("datas",data);
    }

    public void changeText(String Data){
        this.data=Data;
        text.setText(data);
    }
}
