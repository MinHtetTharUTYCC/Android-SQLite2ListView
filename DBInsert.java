package test1.com.sqlite2listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DBInsert extends AppCompatActivity {

    EditText col1, col2, col3, col4;
    Button saveBtn;
    long rowID;
    Intent intent;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbinsert);
        col1 = (EditText)findViewById(R.id.txtCol1);
        col2 = (EditText)findViewById(R.id.txtCol2);
        col3 = (EditText)findViewById(R.id.txtCol3);
        col4 = (EditText)findViewById(R.id.txtCol4);
        saveBtn = (Button)findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCol1 = col1.getText().toString();//+"\n";
                String strCol2 = col2.getText().toString();
                String strCol3 = col3.getText().toString();
                String strCol4 = col4.getText().toString();
                DBHandler dbHandler = new DBHandler(DBInsert.this);
                //dbHandler.insertItemDetails(strCol2,strCol3, col4);
                rowID=dbHandler.insertItemDetails(Integer.parseInt(strCol1),strCol2,strCol3,strCol4);

                Toast.makeText(getApplicationContext(), "Details Inserted Successfully:"+rowID,Toast.LENGTH_LONG).show();
            }
        });
    }
}