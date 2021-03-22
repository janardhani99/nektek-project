package com.example.nektekproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class FotoActivity extends AppCompatActivity {

    ArrayList<Integer> mImageIds = new ArrayList<Integer>(Arrays.asList(
       R.drawable.foto1,R.drawable.foto2, R.drawable.foto3, R.drawable.foto4, R.drawable.foto5,
       R.drawable.foto6, R.drawable.foto7, R.drawable.foto8, R.drawable.foto9, R.drawable.foto10,
       R.drawable.foto12,R.drawable.foto13
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        GridView gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(new FotoAdaptor(mImageIds, this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = mImageIds.get(position);

                ShowDialogBox(item_pos);
            }
        });
    }

    public void ShowDialogBox(int item_pos) {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);

        TextView Image_name = dialog.findViewById(R.id.txt_image_name);
        ImageView Image = dialog.findViewById(R.id.img);
        Button btn_fullview = dialog.findViewById(R.id.btn_fullview);
        Button btn_close = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        int index = title.indexOf("/");
        String name = title.substring(index+1, title.length());
        Image_name.setText(name);

        Image.setImageResource(item_pos);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_fullview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(FotoActivity.this, FullViewActivity.class);
                i.putExtra("img_id", item_pos);
                startActivity(i);
            }
        });

        dialog.show();

    }
}