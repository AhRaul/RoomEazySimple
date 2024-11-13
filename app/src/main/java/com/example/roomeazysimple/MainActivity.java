package com.example.roomeazysimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbh = new DbHelper();

        dbh.setNewPreparedCategory(); //пробное заполнение базы данных
//        dbh.updatePreparedCategory(); //пробное обновление базы данных
//        dbh.deletePreparedCategory();   //пробное удаление категории
        dbh.getAllKategories();                 //пробное получение базы
//        dbh.updatePreparedCategory(); //пробное обновление базы данных
        dbh.getKategoryById(1);       //пробное получение одной категории
    }
}
