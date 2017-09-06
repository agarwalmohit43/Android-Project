package mohit.com.jsonfetch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShowDetails extends AppCompatActivity {

    ImageView imageView;
    TextView heading,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        imageView = (ImageView) findViewById(R.id.showdetailsImage);
        heading = (TextView) findViewById(R.id.showdetailsheading);
        desc = (TextView) findViewById(R.id.showdetailsDesc);

        Bundle getBundle = null;
        getBundle = this.getIntent().getExtras();
        String headings = getBundle.getString("heading");
        String descs = getBundle.getString("desc");
        String imgUrl = getBundle.getString("imgUrl");

        heading.setText(headings);
        desc.setText(descs);
        Picasso.with(this).load(imgUrl).into(imageView);
    }
}
