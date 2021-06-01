package com.example.kiemtrathuhanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ShowInfo extends AppCompatActivity {
    RecyclerView rcv_peson;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        rcv_peson = findViewById(R.id.rcv_peson);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(view->{
            TroLai();
        });
    }
    private void TroLai(){
        startActivity(new Intent(ShowInfo.this,Manager.class));
    }
}