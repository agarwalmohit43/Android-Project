package mohit.com.jsonfetch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String url ="https://simplifiedcoding.net/demos/marvel";

    RecyclerView recyclerView;

    MyCustomAdapter myCustomAdapter;
    ArrayList<ListItem> listItems;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.onSwipe);

        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
//        for(int i=1;i<=10;i++)
//        {
//            ListItem obj =new ListItem("Heading "+(i),"Lorem Ipsum ....","");
//            listItems.add(obj);
//        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });
        getDataFromServer();


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ListItem obj=listItems.get(position);

                Bundle sendInfo = new Bundle();
                sendInfo.putString("heading",obj.getHeading());
                sendInfo.putString("desc",obj.getDesc());
                sendInfo.putString("imgUrl",obj.getImageUrl());

                Intent intent = new Intent(getApplicationContext(),ShowDetails.class);
                intent.putExtras(sendInfo);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

//                Snackbar.make(recyclerView,"You Choose : "+listItems.get(position).getHeading(),5000);
                Toast.makeText(getApplicationContext(),"You Choose : "+listItems.get(position).getHeading(),Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void refreshItems() {
        onItemsLoadComplete();
    }

    private void onItemsLoadComplete() {
        getDataFromServer();
        swipeRefreshLayout.setRefreshing(false);
//        swipeRefreshLayout.setEnabled(false);
    }

    private void getDataFromServer() {
        final ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Loading Data.....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               progressDialog.dismiss();
                try {
//                    JSONObject jsonObject =new JSONObject(response);
                    JSONArray jsonArray = new JSONArray(response.toString());
                    for (int i= 0; i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject =jsonArray.getJSONObject(i);
                        ListItem itemObj = new ListItem(jsonObject.getString("name"),jsonObject.getString("bio"),jsonObject.getString("imageurl"));
                        listItems.add(itemObj);
                    }

                    myCustomAdapter =new MyCustomAdapter(getApplicationContext(),listItems);
                    recyclerView.setAdapter(myCustomAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }


}


