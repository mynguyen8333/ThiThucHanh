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

public class UpdateEmployee extends AppCompatActivity {
    EditText edName,edAge,edDep;
    Button btnSave,btnBack;
    Person person;
    String id;
    String url="https://60b5d3bbfe923b0017c84b46.mockapi.io/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);
        edName = findViewById(R.id.edName2);
        edAge = findViewById(R.id.edAge2);
        edDep = findViewById(R.id.edDep2);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack3);

        Intent intent = getIntent();
        if(intent!=null){
            person = (Person) intent.getSerializableExtra("key1");
            id = person.getId();
            edName.setText(person.getName().toString());
            edAge.setText(person.getAge().toString());
            edDep.setText(person.getDep().toString());
        }
        btnSave.setOnClickListener(view->{
            PutApi(url);
        });
        btnBack.setOnClickListener(view->{
            startActivity(new Intent(UpdateEmployee.this,ShowInfo.class));
        });
    }
    private void PutApi(String url)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url + "person/" +id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(UpdateEmployee.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateEmployee.this, "Error by Post Data", Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String ,String> params = new HashMap<>();
                params.put("name",edName.getText().toString());
                params.put("age",edAge.getText().toString());
                params.put("dep",edDep.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}