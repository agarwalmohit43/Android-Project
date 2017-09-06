package example.mohit.com.day2_1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dbcent31 on 7/4/17.
 */

public class EditextExample extends Activity implements TextWatcher {

    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editext);

        ed=(EditText) findViewById(R.id.editText2);
        ed.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this, "before change", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this, "on change", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        //Toast.makeText(this, "IV1 Gone", Toast.LENGTH_SHORT).show();
        try{
            int val=Integer.parseInt(editable.toString());
            if(val>100){
                editable.replace(0,editable.length(),"100");
            }
        }catch (Exception e){

        }
    }
}
