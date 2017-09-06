package mohit.com.jsonfetch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by MOHIT AGARWAL on 06-09-2017.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>{

    Context context;
    LayoutInflater inflater;
    ArrayList<ListItem> dataList;

    public MyCustomAdapter(Context context, ArrayList<ListItem> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.customrow,parent,false);

        MyViewHolder holder =new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.heading.setText(dataList.get(position).getHeading());
        holder.desc.setText(dataList.get(position).getDesc());

//        For loading image
        Picasso.with(context).load(dataList.get(position).getImageUrl()).into(holder.imageView);

//        OnClickListener On items clicked linearLayout

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You Choose : "+dataList.get(position).getHeading(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView heading,desc;
        ImageView imageView;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            heading = (TextView) itemView.findViewById(R.id.textViewheading);
            desc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewImage);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.customLinearLayout);
        }
    }
}
