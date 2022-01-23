package aithammou.badr.listview.Sqllitte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import aithammou.badr.listview.R;

public class DatabaseAdapter {

    DBHelper helper;
    SQLiteDatabase db;
    Context context;

    public DatabaseAdapter( Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
        this.context = context;
    }

    public SimpleCursorAdapter populateListViewFromDb(){

        String columns[] = {DBHelper.key_post, DBHelper.key_title,DBHelper.key_desc};
        Cursor cursor = db.query(DBHelper.Table_NAME,columns,null,null,null,null,null,null);
        String[] fromFieldNames = new String[]{
                DBHelper.key_post,DBHelper.key_title,DBHelper.key_desc
        };
        int[] toViewIDs = new int[]{R.id.id,R.id.titre,R.id.desc};
        SimpleCursorAdapter contactAdapter = new SimpleCursorAdapter(
                context,
                R.layout.layout_item_home,
                cursor,
                fromFieldNames,
                toViewIDs
        );
        return contactAdapter;
    }




    public static class DBHelper extends SQLiteOpenHelper {


        private static final String DBNAME="login.db";
        private static final String Table_NAME = "post";
        // when you do change the structure of the database change the version number from 1 to 2
        private  static final String key_post ="id";
        private static final String key_img = "img";
        private static final String key_title = "title";
        private static final String key_desc = "desc";
        private static final String key_time = "time";
        private static final String key_eva = "eva";
        private static final String CREATE_TABLE = " create table " + Table_NAME + " ( " + key_post + "integer primary key autoincrement,"
                + key_title + "text," + key_desc + "text)" ;
        private static final String DROP_TABLE = " drop table if exists " + Table_NAME;
        private Context context;



        public DBHelper( Context context) {
            super(context, "login.db", null, 1);
            this.context = context;
            Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table users(username TEXT primary key,password TEXT)");
            try{
                db.execSQL(CREATE_TABLE);
                Toast.makeText(context, "onCreate called", Toast.LENGTH_SHORT).show();
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists users");
            try{
                Toast.makeText(context, "onUpgrade called", Toast.LENGTH_SHORT).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }

        public Boolean insertData(String username,String password){

            SQLiteDatabase db= this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("username",username);
            values.put("password",password);

            long result= db.insert("users",null,values);
            if(result==-1) return false;
            else
                return true;
        }

        public Boolean checkusername(String username){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from users where username=?",new String[] {username});
            if (cursor.getCount()>0)
                return true;
            else
                return false;
        }

        public Boolean checkusernamepassword(String username,String password){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from users where username=? and password=?",new String[] {username,password});
            if (cursor.getCount()>0)
                return true;
            else
                return false;
        }




    }
}
