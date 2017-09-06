package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by dbcent31 on 7/4/17.
 */

public class SecondPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }

    public void btncalls(View view){
        Intent intent,chooser=null;
        if(view.getId()==R.id.maps)
        {
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));
            chooser=Intent.createChooser(intent,"Launch Maps");
            startActivity(chooser);


        }else if(view.getId()==R.id.sendImage){

            Uri imageurl=Uri.parse("android.resource://example.mohit.com.day2_1/drawable/"+R.drawable.ic_launcher);
            intent=new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,imageurl);
            intent.putExtra(Intent.EXTRA_TEXT,"Hey see this");
            chooser=Intent.createChooser(intent,"Send Image");
            startActivity(chooser);


        }else if(view.getId()==R.id.sendEmail){
            intent=new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String to[]={"agarwalmohit43@gmail.com","agarwaljain43@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Welcome");
            intent.putExtra(Intent.EXTRA_TEXT,"Welocme to Email Api");
            intent.setType("message/rfc822");
            chooser=Intent.createChooser(intent,"Send Email");
            startActivity(chooser);

        }else if(view.getId()==R.id.sendImagesFromExt){
            File pictures= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String[] listofPictures=pictures.list();
            Uri uri=null;
            ArrayList<Uri> alImg=new ArrayList<Uri>();
            for(String img:listofPictures){
                //Toast.makeText(this,img.toString()+"/"+img,Toast.LENGTH_SHORT).show();
                uri=Uri.parse("file://"+img.toString()+"/"+img);
                alImg.add(uri);
            }
            intent=new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,alImg);
            chooser=Intent.createChooser(intent,"Send Multiple Images");
            startActivity(chooser);
        }else {
            Toast.makeText(this,"Mohit Agarwal",Toast.LENGTH_LONG).show();
        }

    }
}
