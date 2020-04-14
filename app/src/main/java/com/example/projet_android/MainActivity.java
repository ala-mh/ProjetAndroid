package com.example.projet_android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_android.adapter.ProgrammeListAdapter;
import com.example.projet_android.dao.ProgrammeDAO;
import com.example.projet_android.database.DBHelper;
import com.example.projet_android.model.Programme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //DBHelper dbHelper;
    //Button btnGetData;

    //LinearLayout ProgrammeListView;
    ListView ProgrammeListView;
    List<Programme> listprog=new ArrayList<Programme>();
    ProgrammeDAO progdao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgrammeListView = (ListView) findViewById(R.id.ProgrammeListView);

        progdao= new ProgrammeDAO(getApplicationContext());

        listprog=progdao.getAllProg();

        ProgrammeListAdapter adapter = new ProgrammeListAdapter(this, R.layout.row, listprog);
        ProgrammeListView.setAdapter(adapter);

        /*
         //btnGetData = (Button) findViewById(R.id.BtnGetData);
        //ProgrammeListView = (LinearLayout) findViewById(R.id.ProgrammeListView);

        //dbHelper= new DBHelper(getApplicationContext());
        //dbHelper.createDataBase();
        //listprog=dbHelper.getAllProg();

        for(Programme programme:listprog){
            LayoutInflater inflater =(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View addView = inflater.inflate(R.layout.row,null);
            TextView txtMaladie= (TextView) addView.findViewById(R.id.MaladieView);
            TextView txtDate= (TextView) addView.findViewById(R.id.DataView);
            TextView txtDuree= (TextView) addView.findViewById(R.id.DureeView);

            txtMaladie.setText(programme.getMaladie());
            txtDate.setText(programme.getDate_debut());
            txtDuree.setText(programme.getDuree());

            ProgrammeListView.addView(addView);

        }*/

       /* btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
