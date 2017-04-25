package com.jay.user.wenspj;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

   Button button;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    EditText et1;
String tem="",et="";
    int pro=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button) findViewById(R.id.button);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        tv1.setMovementMethod(ScrollingMovementMethod.getInstance());
        tv2.setMovementMethod(ScrollingMovementMethod.getInstance());
        tv3.setMovementMethod(ScrollingMovementMethod.getInstance());
        tv4.setMovementMethod(ScrollingMovementMethod.getInstance());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (!("".equals(et1.getText().toString().trim()))){
                    pro=Integer.parseInt(et1.getText().toString());
                }
               if (pro>0 && pro<5) {
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("et1", et1.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                      et1.setText("");
                      et1.setHint("桌號錯誤!!");
                   }
            }
        });
        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            tem = bundle.getString("rt");
            et = bundle.getString("temp");
            switch (et){
                case "1": et1.setHint("第"+et+"桌(更改)");tv1.setText("         第一桌:\n"+tem);break;
                case "2": et1.setHint("第"+et+"桌(更改)");tv2.setText("         第二桌:\n"+tem);break;
                case "3": et1.setHint("第"+et+"桌(更改)");tv3.setText("         第三桌:\n"+tem);break;
                case "4": et1.setHint("第"+et+"桌(更改)");tv4.setText("         第四桌:\n"+tem);break;
            }

        }

    }

}














