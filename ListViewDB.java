package test1.com.sqlite2listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class ListViewDB extends AppCompatActivity {

    private ArrayList<ModelItem> ModelArrayList;
    private ListView listView;
    ArrayList<ModelItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_db);

        listView = findViewById(R.id.listView);

        DBHandler db= new DBHandler(this);
        listItems =db.getAllItems();

        CustomAdapter adapter = new CustomAdapter(this,listItems);
        listView.setAdapter(adapter);
    }

}