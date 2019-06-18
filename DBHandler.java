package test1.com.sqlite2listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DBItem";
    private static final String TABLE_NAME = "ItemTab";
    private static final String KEY_COL1 = "KeyCol1";
    private static final String KEY_COL2 = "KeyCol2";
    private static final String KEY_COL3 = "KeyCol3";
    private static final String KEY_COL4 = "KeyCol4";

    public DBHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_COL1 + " INTEGER primary key,"
                + KEY_COL2 + " TEXT,"
                + KEY_COL3 + " TEXT,"
                + KEY_COL4 + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
        Log.d("bXd", "DB Table creation: "+CREATE_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    public ArrayList<ModelItem> getAllItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ModelItem> listItems = new ArrayList<ModelItem>();

        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_NAME,
                new String[] {});

        if (cursor.moveToFirst()) {
            do {
                ModelItem model = new ModelItem();

                model.setCol1( cursor.getString(0));
                model.setCol2( cursor.getString(1));
                model.setCol3( cursor.getString(2));
                model.setCol4( cursor.getString(3));
                listItems.add(model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listItems;
    }


    // Adding new User Details
    public long insertItemDetails(Integer col1, String col2, String col3, String col4){
        long newRowId;
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_COL1, col1);
        cValues.put(KEY_COL2, col2);
        cValues.put(KEY_COL3, col3);
        cValues.put(KEY_COL4, col4);
        // Insert the new row, returning the primary key value of the new row
         newRowId = db.insert(TABLE_NAME,null, cValues);
        db.close();
        return newRowId;
    }

    // Delete Item
    public void DeleteItem(int col1){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_COL1+" = ?",new String[]{String.valueOf(col1)});
        db.close();
    }
    // Update Item Details
    public int UpdateItemDetails(String col2, String col3, String col4, String col1_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_COL2, col2);
        cVals.put(KEY_COL3, col3);
        cVals.put(KEY_COL4, col4);
        int count = db.update(TABLE_NAME, cVals, KEY_COL1+" = ?",new String[]{String.valueOf(col1_id)});
        return  count;
    }
}