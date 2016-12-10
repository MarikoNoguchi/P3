package edu.mnstate.cw3967me.p3;
/*
manipulate button events in 4 different ways
1.Use onClick attribute within the xml file
2.Use a separate named class as the listener
3.Use an anonymous inner class as the listener
4.Use the current class as the listener

Mariko Noguchi
9/116/2016
 */

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvHello;
    Button btnXml, btnSeparate, btnAnonymous, btnCurrent;
    LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello = (TextView) findViewById(R.id.tvHello);
        btnXml = (Button) findViewById(R.id.btnxml);
        btnSeparate = (Button) findViewById(R.id.btnSeparate);
        btnAnonymous = (Button) findViewById(R.id.btnAnonymous);
        btnCurrent = (Button) findViewById(R.id.btnCurrent);
        linearLayout = (LinearLayout) findViewById(R.id.LinearLayout);

        btnAnonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(Color.WHITE);
                tvHello.setAllCaps(false);
                tvHello.setTextColor(Color.BLUE);
                tvHello.setLines(5);
            }
        });

        ButtonListener buttonListener = new ButtonListener(this);
        btnSeparate.setOnClickListener(buttonListener);

        btnCurrent.setOnClickListener(this);
    }

    public void xml_onClick(View v) {
        linearLayout.setBackgroundColor(Color.BLUE);
        tvHello.setAllCaps(true);
        tvHello.setTextColor(Color.YELLOW);
    }

    @Override
    public void onClick(View v){
        tvHello.setTextAppearance(this, android.R.style.TextAppearance_Large);
        tvHello.setTextColor(Color.RED);
        linearLayout.setBackgroundColor(Color.GREEN);
    }
}


class ButtonListener implements View.OnClickListener{
    MainActivity ma;
    ButtonListener(MainActivity ma){
        this.ma = ma;
    }
    @Override
    public void onClick(View v){
        Toast.makeText(ma, "Button was clicked", Toast.LENGTH_SHORT).show();
    }
}