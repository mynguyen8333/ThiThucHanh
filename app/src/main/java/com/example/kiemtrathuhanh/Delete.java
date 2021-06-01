package com.example.kiemtrathuhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Delete extends AppCompatActivity {
    Button btnyess,btncancer;
    Person person;
    String id;
    String url="https://60b5d3bbfe923b0017c84b46.mockapi.io/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        btnyess = findViewById(R.id.btnYes);
        btncancer = findViewById(R.id.btnCanCer);
        Intent intent = getIntent();
        if(intent!=null){
            person = (Person) intent.getSerializableExtra("key1");
            id = person.getId();
        }

        btncancer.setOnClickListener(view->{
            startActivity(new Intent(Delete.this,ShowInfo.class));
        });

        btnyess.setOnClickListener(view->{
            DeleteApi(url);
        });

    }

    private void DeleteApi(String url)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url + "person/"+ id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Delete.this, "Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Delete.this,ShowInfo.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Delete.this, "Error by Post Data", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}