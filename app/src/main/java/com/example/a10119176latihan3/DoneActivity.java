package com.example.a10119176latihan3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//Muhammad Fauzan Fadhlulbarr | 08 Mei 2022 | IF10k | 10119176
public class DoneActivity extends AppCompatActivity {

    @BindView(R.id.txtDoneTitle)
    TextView txtNama;
    @BindString(R.string.activation_beres)
    String beres;
    @BindString(R.string.activation_sudah_bisa)
    String sudahBisa;
    @BindString(R.string.activation_setiap)
    String setiap;
    @BindString(R.string.activation_buat)
    String buat;

    public static final String ID_EXTRA_MSG_EXIT = "com.example.a10119199latihan3.MSG_EXIT";

    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        ButterKnife.bind(this);
        bindExtra();
    }

    private void bindExtra() {
        //Menampung value yang dilempar dari BiodatActivity
        Intent intent = getIntent();
        name = intent.getStringExtra(com.example.a10119176latihan3.BiodataActivity.ID_EXTRA_MSG);
        // Mengeset nama sesuai dengan data nama yang dilempar menjadi satu kesatuan kalimat
        txtNama.setText(beres+" "+name+" "+sudahBisa+" "+name+" "+setiap+" "+name+" "+buat);
    }

    @OnClick(R.id.btnDoneNext)
    public void selesai(View view) {
        //Mengeset agar ketika menekan tombol Oke, Aplikasi ngeclose
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(ID_EXTRA_MSG_EXIT, true);
        startActivity(intent);
    }
}