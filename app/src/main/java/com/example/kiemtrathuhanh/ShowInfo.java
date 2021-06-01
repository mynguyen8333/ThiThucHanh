package com.example.kiemtrathuhanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShowInfo extends AppCompatActivity implements OnClickListner{
    RecyclerView rcv_peson;
    Button btnBack;
    ArrayList<Person> mpersons;
    CustomAdapter adt;
    String url="https://60b5d3bbfe923b0017c84b46.mockapi.io/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        rcv_peson = findViewById(R.id.rcv_peson);
        btnBack = findViewById(R.id.btnBack);


        mpersons = new ArrayList<>();
//        mpersons.add(new Person("1","my","13","abc"));
//        mpersons.add(new Person("2","my","13","abc"));
//        mpersons.add(new Person("3","my","13","abc"));

//        adt = new CustomAdapter(mpersons);
//        rcv_peson.setHasFixedSize(true);
//        rcv_peson.setAdapter(adt);
//        rcv_peson.setLayoutManager(new GridLayoutManager(this,1));

        btnBack.setOnClickListener(view->{
            TroLai();
        });
        GetData(url);
    }
    private void TroLai(){
        startActivity(new Intent(ShowInfo.this,Manager.class));
    }
    private void GetData(String url)
    {
        JsonArrayRequest request = new JsonArrayRequest(url+"person", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(ShowInfo.this, "True", Toast.LENGTH_SHORT).show();
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = (JSONObject) response.get(i);
                        String id = obj.getString("id");
                        String name = obj.getString("name");
                        String age = obj.getString("age");
                        String dep = obj.getString("dep");
                        Person person = new Person(id,name,age,dep);
                        mpersons.add(person);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adt = new CustomAdapter(mpersons,ShowInfo.this);
                rcv_peson.setHasFixedSize(true);
                rcv_peson.setAdapter(adt);
                rcv_peson.setLayoutManager(new GridLayoutManager(ShowInfo.this,1));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowInfo.this,"Error make by API server!",Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public void itemClicklistener(Person person) {

    }

    @Override
    public void buttonxoaClick(Person person) {

    }

    @Override
    public void buttonsuaClick(Person person) {
        String id =  person.getId();
        Intent intent = new Intent(ShowInfo.this,UpdateEmployee.class);
        intent.putExtra("key1",person);
        startActivity(intent);
    }
}