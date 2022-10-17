package com.example.sqlite_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextAddress;
    private Button buttonRegister;
    private Button buttonDelete;
    private Button buttonSearch;
    private RadioGroup radioGroupSex;
    private String sex="";
    private DBHelper db;
    private TextView textViewShow;
    private SQLiteDatabase userDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(getApplicationContext(),"users.db",null,1);
        userDataBase = db.getWritableDatabase();

        editTextName = (EditText)findViewById(R.id.editText_name);
        editTextPhone = (EditText)findViewById(R.id.editText_Phone);
        editTextAddress = (EditText)findViewById(R.id.editText_address);
        radioGroupSex = (RadioGroup)findViewById(R.id.radioGroup_sex);

        buttonRegister = (Button)findViewById(R.id.button_register);
        buttonSearch = (Button)findViewById(R.id.button_search);
        buttonDelete = (Button)findViewById(R.id.button_delete);

        textViewShow = (TextView)findViewById(R.id.textView_show);
        textViewShow.setText("");

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSex();
                //將資料存進SQLite的方法
                if(editTextName.length()!=0 && editTextPhone.length()!=0 && editTextAddress.length()!=0 && !sex.equals("")){
                    ContentValues cv = new ContentValues();
                    cv.put("name",editTextName.getText().toString());
                    cv.put("sex",sex);
                    cv.put("address",editTextAddress.getText().toString());
                    cv.put("phone",editTextPhone.getText().toString());
                    userDataBase.insert("users",null,cv);

                    textViewShow.setText("註冊成功");

                }else{
                    Toast.makeText(MainActivity.this, "請完整輸入資訊", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewShow.setText("");
                checkSex();
                if(editTextName.length()!=0) {
                    //從SQLite找資料的方法
                    String name = editTextName.getText().toString();
                    Cursor c = userDataBase.rawQuery("SELECT * FROM users WHERE name = '" + name + "';", null);
                    if (c != null) {
                        c.moveToFirst();
                        for (int i = 0; i < c.getCount(); i++) {
                            String user_id = String.valueOf(c.getInt(0));
                            String user_name = c.getString(1);
                            String user_sex = c.getString(2);
                            String user_address = c.getString(3);
                            String user_phone = c.getString(4);
                            textViewShow.append("id : "+user_id+"\n"+
                                    "name : "+user_name+"\n"+
                                    "sex : "+user_sex+"\n"+
                                    "address : "+user_address+"\n"+
                                    "phone : "+user_phone+"\n\n");
                            c.moveToNext();

                        }
                    }
                }else if(editTextPhone.length()!=0){
                    //從SQLite找資料的方法
                    String phone = editTextPhone.getText().toString();
                     Cursor c = userDataBase.rawQuery("SELECT * FROM users WHERE phone = '" + phone + "';", null);
                    if (c != null) {
                        c.moveToFirst();
                        for (int i = 0; i < c.getCount(); i++) {
                            String user_id = String.valueOf(c.getInt(0));
                            String user_name = c.getString(1);
                            String user_sex = c.getString(2);
                            String user_address = c.getString(3);
                            String user_phone = c.getString(4);
                            textViewShow.append("id : "+user_id+"\n"+
                                    "name : "+user_name+"\n"+
                                    "sex : "+user_sex+"\n"+
                                    "address : "+user_address+"\n"+
                                    "phone : "+user_phone+"\n\n");
                            c.moveToNext();
                        }
                    }
                }else if(sex.equals("male")){
                    //從SQLite找資料的方法
                    Cursor c = userDataBase.rawQuery("SELECT * FROM users WHERE sex = '" + "male"+ "';", null);
                    if (c != null) {
                        c.moveToFirst();
                        for (int i = 0; i < c.getCount(); i++) {
                            String user_id = String.valueOf(c.getInt(0));
                            String user_name = c.getString(1);
                            String user_sex = c.getString(2);
                            String user_address = c.getString(3);
                            String user_phone = c.getString(4);
                            textViewShow.append("id : "+user_id+"\n"+
                                    "name : "+user_name+"\n"+
                                    "sex : "+user_sex+"\n"+
                                    "address : "+user_address+"\n"+
                                    "phone : "+user_phone+"\n\n");
                            c.moveToNext();
                        }
                    }
                }else if(sex.equals("female")){
                    //從SQLite找資料的方法
                    Cursor c = userDataBase.rawQuery("SELECT * FROM users WHERE sex = '" + "female"+ "';", null);
                    if (c != null) {
                        c.moveToFirst();
                        for (int i = 0; i < c.getCount(); i++) {
                            String user_id = String.valueOf(c.getInt(0));
                            String user_name = c.getString(1);
                            String user_sex = c.getString(2);
                            String user_address = c.getString(3);
                            String user_phone = c.getString(4);
                            textViewShow.append("id : "+user_id+"\n"+
                                    "name : "+user_name+"\n"+
                                    "sex : "+user_sex+"\n"+
                                    "address : "+user_address+"\n"+
                                    "phone : "+user_phone+"\n\n");
                            c.moveToNext();
                        }
                    }
                }else if(editTextAddress.length()!=0){
                    String address = editTextAddress.getText().toString();
                    //從SQLite找資料的方法
                    Cursor c = userDataBase.rawQuery("SELECT * FROM users WHERE address = '" + address+ "';", null);
                    if (c != null) {
                        c.moveToFirst();
                        for (int i = 0; i < c.getCount(); i++) {
                            String user_id = String.valueOf(c.getInt(0));
                            String user_name = c.getString(1);
                            String user_sex = c.getString(2);
                            String user_address = c.getString(3);
                            String user_phone = c.getString(4);
                            textViewShow.append("id : "+user_id+"\n"+
                                    "name : "+user_name+"\n"+
                                    "sex : "+user_sex+"\n"+
                                    "address : "+user_address+"\n"+
                                    "phone : "+user_phone+"\n\n");
                            c.moveToNext();
                        }
                    }
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewShow.setText("刪除成功");
                //從SQLite刪除資料的方法
                if(editTextName.length()!=0){
                    userDataBase.delete("users", "name=?", new String[]{editTextName.getText().toString()}); //第一種刪除的寫法
//                    userDataBase.delete("users", "name = " + editTextName.getText().toString(), null);  //第二種刪除的寫法
                }else if(editTextAddress.length()!=0){
                    userDataBase.delete("users","address=?",new String[]{editTextAddress.getText().toString()});
                }else if(editTextPhone.length()!=0){
                    userDataBase.delete("users", "phone = " + editTextPhone.getText().toString(), null);
                }else if(sex.equals("male")){
                    userDataBase.delete("users", "sex = 'male'" , null);
                }else if(sex.equals("female")){
                    userDataBase.delete("users", "sex=?",new String[]{"female"});
                }
            }
        });
    }

    //確認使用者所選擇的性別方法
    public void checkSex(){
        switch (radioGroupSex.getCheckedRadioButtonId()){
            case R.id.radioButton_male:
                sex = "male";
                break;

            case R.id.radioButton_female:
                sex = "female";
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userDataBase.close();
        db.close();
    }


}

