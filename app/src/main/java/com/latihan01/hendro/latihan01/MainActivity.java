package com.latihan01.hendro.latihan01;

import android.app.DatePickerDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar calendar; //tambahkan class kalender

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //definisi dan casting objek
        final EditText nama = (EditText) findViewById(R.id.etNama);
        final EditText alamat = (EditText) findViewById(R.id.etAlamat);
        final EditText tempat = (EditText) findViewById(R.id.etTempat);
        final EditText tanggal = (EditText) findViewById(R.id.etTanggal);
        final EditText telepon = (EditText) findViewById(R.id.etTelepon);
        final Spinner jKelamin = (Spinner) findViewById(R.id.spJKelamin);
        final Button tambah = (Button) findViewById(R.id.btTambah);
        final Button ulangi = (Button) findViewById(R.id.btUlangi);
        final Button batal = (Button) findViewById(R.id.btBatal);

        calendar = Calendar.getInstance();

        ulangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentView = findViewById(R.id.main_layout_id); //<-------------------
                String pesan = "Test snack bar"; //<-------------------

                final Snackbar snackbar = Snackbar
                        .make(parentView, pesan, Snackbar.LENGTH_LONG);  //<-------------------

                snackbar.show(); //<-----------------------
            }
        });

        //menambahkan fasilitas klik pada tanggal
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view,
                                                  int year,
                                                  int month,
                                                  int dayOfMonth) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, month);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                String format = "dd-MM-yyyy";
                                SimpleDateFormat sdf = new SimpleDateFormat(format);
                                tanggal.setText(sdf.format(calendar.getTime()));
                            }
                        },
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}
