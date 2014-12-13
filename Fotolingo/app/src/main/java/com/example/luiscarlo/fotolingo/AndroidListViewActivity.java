package com.example.luiscarlo.fotolingo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AndroidListViewActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // storing string resources into Array
        String[] lista_nombres = getResources().getStringArray(R.array.lista_nombres);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label,lista_nombres));
        ListView lv = getListView();

        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent item;
                // selected item
                String product = ((TextView) view).getText().toString();

               if (product.equals("Montañas")){
                   //Intent i = new Intent(getApplicationContext(), Reto1.class);
                   item = new Intent("com.example.luiscarlo.fotolingo.Reto1");
                   startActivity(item);
               }
               if (product.equals("Gotas de Agua")){
                   item = new Intent("com.example.luiscarlo.fotolingo.Reto2");
                   startActivity(item);
               }
                if (product.equals("Humo")){
                    item = new Intent("com.example.luiscarlo.fotolingo.Reto3");
                    startActivity(item);
                }
                // Launching new Activity on selecting single List Item
                //Intent i = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity
                //i.putExtra("product", product);
            }
        });
    }
}