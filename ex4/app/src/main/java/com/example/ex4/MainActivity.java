package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Button offBtn, reBtn;
    Switch check;
    RadioGroup rGroup1;
    RadioButton rdoOreo, rdoPie, rdoQ;
    ImageView imgPet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        check = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoOreo = (RadioButton) findViewById(R.id.RdoOreo);
        rdoPie = (RadioButton) findViewById(R.id.RdoPie);
        rdoQ = (RadioButton) findViewById(R.id.RdoQ);
        offBtn = (Button) findViewById((R.id.OffBtn));
        reBtn = (Button) findViewById((R.id.ReBtn));
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (check.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                    offBtn.setVisibility(View.VISIBLE);
                    reBtn.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    offBtn.setVisibility(View.INVISIBLE);
                    reBtn.setVisibility(View.INVISIBLE);
                }
            }
        });

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoOreo:
                        imgPet.setImageResource(R.drawable.oreo);
                        break;
                    case R.id.RdoPie:
                        imgPet.setImageResource(R.drawable.pie);
                        break;
                    case R.id.RdoQ:
                        imgPet.setImageResource(R.drawable.q);
                        break;
                }
            }
        });

        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rGroup1.clearCheck();
                check.setChecked(false);
                imgPet.setVisibility(View.INVISIBLE);

                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                imgPet.setVisibility(android.view.View.INVISIBLE);
                offBtn.setVisibility(android.view.View.INVISIBLE);
                reBtn.setVisibility(android.view.View.INVISIBLE);
            }
        });

    }

}

