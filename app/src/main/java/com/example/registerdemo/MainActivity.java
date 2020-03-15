package com.example.registerdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CharSequence[] ahItem=new CharSequence[]{"编程",
            "电竞","辩论","写作","追剧","听歌"};
    private boolean[] ahCheckItems=new boolean[]{false,false,false,false,false,false};

    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private RadioGroup radioGroup;
    private Button btn1;
    private Button btn2;
    String edit1;
    String edit2;
    String edit3;
    String rg;
    String ah;
    int index;
    String[] gjs=new String[]{"中国大陆", "中国香港", "中国台湾", "中国澳门"};
    String gj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.ed1);
        ed2=(EditText) findViewById(R.id.ed2);
        ed3=(EditText) findViewById(R.id.ed3);
        radioGroup=findViewById(R.id.rg);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    edit1=ed1.getText().toString();
                    if(edit1.length()<8){
                        Toast.makeText(MainActivity.this,"请输入大于8位用户名!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ed2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    edit2=ed2.getText().toString();
                    if(edit2.length()<6||edit2.length()>16){
                        Toast.makeText(MainActivity.this,"请输入6到16位的密码",Toast.LENGTH_SHORT).show();
                    }
                    if(edit2.equals(edit3)){
                        Toast.makeText(MainActivity.this,"两次输入密码不一致！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ed3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    edit3=ed3.getText().toString();
                    if(edit2.equals(edit3)){
                        Toast.makeText(MainActivity.this,"两次输入密码不一致！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId==R.id.rb1){
                    rg="男";
                }else{
                    rg="女";
                }
            }
        });
    }


    public void zcClick(View view) {
        if(ed1.getText()==null||
                ed2.getText()==null||
                rg==null||ah==null||gj==null){
            Toast.makeText(MainActivity.this,"请继续完善您的信息QWQ",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"注册成功！\n用户名："+edit1+"\n密码："+edit2+"\n性别："+rg+"\n爱好："+ah+"\n籍贯："+gj,Toast.LENGTH_LONG).show();
        }
    }

    public void qxClick(View view) {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        edit1=null;
        edit2=null;
        edit3=null;
        rg=null;
        ah=null;
        gj=null;
    }

    public void ahClick(View view) {
        AlertDialog dialog;
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("请选择您的兴趣爱好")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(ahItem, ahCheckItems,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                ahCheckItems[which]=isChecked;
                            }
                        })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer stringBuffer=new StringBuffer();
                        for(int i=0;i<=ahCheckItems.length-1;i++){
                            if(ahCheckItems[i]){
                                stringBuffer.append(ahItem[i]).append(" ");
                            }
                        }
                        if(stringBuffer!=null){
                            ah=stringBuffer.toString();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog=builder.create();
        dialog.show();
    }

    public void gjClick(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("请选择籍贯")
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(new String[]{"中国大陆", "中国香港", "中国台湾", "中国澳门"}, index, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        index=which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gj=gjs[index];
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
