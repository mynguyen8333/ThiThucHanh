package com.example.kiemtrathuhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddEmployee extends AppCompatActivity {
    Button btnCreate,btnBack;
    EditText edName,edAge,edDepartment;
    String url="https://60b5d3bbfe923b0017c84b46.mockapi.io/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        btnCreate = findViewById(R.id.btnCreate);
        btnBack = findViewById(R.id.btnBack2);
        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edDepartment = findViewById(R.id.edDepartment);

        btnCreate.setOnClickListener(view->{
            PostApi(url);
        });
        btnBack.setOnClickListener(view->{
            startActivity(new Intent(AddEmployee.this,ShowInfo.class));
        });


    }

    private void PostApi(String url)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url + "person/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddEmployee.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddEmployee.this, "Error by Post Data", Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String ,String> params = new HashMap<>();
                String id = "";
                String name = edName.getText().toString();
                String age = edAge.getText().toString();
                String department = edDepartment.getText().toString();
                params.put("id",id);
                params.put("name",name);
                params.put("age",name);
                params.put("dep",name);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}