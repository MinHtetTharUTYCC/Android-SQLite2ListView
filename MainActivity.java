package test1.com.sqlite2listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnView , btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnView = (Button) findViewById(R.id.btnView);
        btnEdit = (Button) findViewById(R.id.btnEdit);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpTo = new Intent(MainActivity.this, ListViewDB.class);
                startActivity(jumpTo);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpTo = new Intent(MainActivity.this, DBInsert.class);
                startActivity(jumpTo);
            }
        });

    }
}
