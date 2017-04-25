package com.jay.user.wenspj;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NotificationCompatExtras;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;

    Button btn;
    int sum = 0;
    int hot=0;
    String rt="",temp="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1= (CheckBox) findViewById(R.id.checkBox1);
        checkBox2= (CheckBox) findViewById(R.id.checkBox2);
        checkBox3= (CheckBox) findViewById(R.id.checkBox3);
        checkBox4= (CheckBox) findViewById(R.id.checkBox4);
        checkBox5= (CheckBox) findViewById(R.id.checkBox5);
        editText1= (EditText) findViewById(R.id.editText1);
        editText2= (EditText) findViewById(R.id.editText2);
        editText3= (EditText) findViewById(R.id.editText3);
        editText4= (EditText) findViewById(R.id.editText4);
        editText5= (EditText) findViewById(R.id.editText5);

        btn= (Button) findViewById(R.id.btn);

        Bundle bundle = getIntent().getExtras();
            temp = bundle.getString("et1");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( checkBox1.isChecked() && !("".equals(editText1.getText().toString().trim()))){
                    sum += 50*Integer.parseInt(editText1.getText().toString());
                    hot +=  323.1*Integer.parseInt(editText1.getText().toString());
                    rt += "薯條:"+Integer.parseInt(editText1.getText().toString())+"份,"+(int)(323.1*Integer.parseInt(editText1.getText().toString()))+"大卡\n";
                }

                if ( checkBox2.isChecked() && !("".equals(editText2.getText().toString().trim()))){
                    sum += 69*Integer.parseInt(editText2.getText().toString());
                    hot +=  530*Integer.parseInt(editText2.getText().toString());
                    rt += "漢堡:"+Integer.parseInt(editText2.getText().toString())+"份,"+(int)(530*Integer.parseInt(editText2.getText().toString()))+"大卡\n";
                }
                if (checkBox3.isChecked() &&!( "".equals(editText3.getText().toString().trim()))){
                    sum  += 35*Integer.parseInt(editText3.getText().toString());
                    hot +=  310*Integer.parseInt(editText3.getText().toString());
                    rt += "可樂:"+Integer.parseInt(editText3.getText().toString())+"份,"+(int)(310*Integer.parseInt(editText3.getText().toString()))+"大卡\n";;
                }
                if ( checkBox4.isChecked() && !("".equals(editText4.getText().toString().trim()))){
                    sum += 40*Integer.parseInt(editText4.getText().toString());
                    hot +=  380*Integer.parseInt(editText4.getText().toString());
                    rt += "雞塊:"+Integer.parseInt(editText4.getText().toString())+"份,"+(int)(380.1*Integer.parseInt(editText4.getText().toString()))+"大卡\n";
                }
                if ( checkBox5.isChecked() && !("".equals(editText5.getText().toString().trim()))){
                    sum += 25*Integer.parseInt(editText5.getText().toString());
                    hot +=  150*Integer.parseInt(editText5.getText().toString());
                    rt += "濃湯:"+Integer.parseInt(editText5.getText().toString())+"份,"+(int)(150*Integer.parseInt(editText5.getText().toString()))+"大卡\n";;
                }


                if (sum!=0){
                    rt += "總共:"+hot+"大卡\n"+"需要跑步:"+(int)((hot/792)*60)+"分鐘\n"+"金額:"+Integer.toString(sum)+"元\n";
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("rt",rt);
                    bundle.putString("temp",temp);
                    intent.putExtras(bundle);

                    startActivity(intent);
                    MainActivity.this.finish();
                }
            }
        });

    }




}
