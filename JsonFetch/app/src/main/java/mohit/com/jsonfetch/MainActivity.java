package mohit.com.jsonfetch;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

}
