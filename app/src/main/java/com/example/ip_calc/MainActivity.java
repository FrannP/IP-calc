package com.example.ip_calc;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button racun=findViewById(R.id.racun);
        TextView ispis=findViewById(R.id.ispis);
        TextView test=findViewById(R.id.test);
        EditText ipadresa=findViewById(R.id.ipadresa);
        EditText maska=findViewById(R.id.maska);
        racun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adresa=ipadresa.getText().toString();//početna adresa
                String rezadresa="";
                String subnet=maska.getText().toString();
                int sub2=Integer.parseInt(subnet);
                String bin="";
                for(int i=0; i<4; i++)
                {
                    /*bin+=Integer.toBinaryString(Integer.parseInt(adresa.substring(0,a)));//binarni zapis
                    adresa=adresa.replace(adresa.substring(0,a),"");
                    rezadresa+=adresa;*/
                }
                test.setText(adresa);
                String zamjena="";
                for(int i=0; i<32-sub2; i++)
                {
                    zamjena+="0";
                }
                String netadresa=bin.substring(0,sub2-1)+zamjena;//binarna net
                int[] br=new int[4];//novi brojevi
                for(int i=0; i<4; i++)
                {
                    br[i]=Integer.parseInt(netadresa.substring(0,7),2);
                    netadresa.replace(netadresa.substring(0,7),"");
                }
                double hostovi=Math.pow(2,32-sub2);//ukupan broj hostova
                ispis.setText("Broj hostova:"+hostovi+ System.getProperty("line.separator")+
                        "Broj korisnih hostova: "+(hostovi-2)+ System.getProperty("line.separator")+
                        "Network adresa: "+br[0]+"."+br[1]+"."+br[2]+"."+br[3]+"."+System.getProperty("line.separator")+
                        "Broadcast adresa: "+br[0]+"."+br[1]+"."+br[2]+"."+(br[3]+hostovi-1)+".");

            }
        });
    }


}