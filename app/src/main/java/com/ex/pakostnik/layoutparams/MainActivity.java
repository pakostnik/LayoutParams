package com.ex.pakostnik.layoutparams;

import android.net.LinkAddress;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout llMain;
    private Button btnClear;
    private Button btnCreate;
    private RadioGroup rbGroup;
    private EditText etName;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain  = (LinearLayout)findViewById(R.id.llMain);
        rbGroup = (RadioGroup)findViewById(R.id.rgGravity);
        etName  = (EditText)findViewById(R.id.etName);

        btnClear  = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnCreate = (Button)findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreate:
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
                int btnGravity = Gravity.LEFT;
                switch (rbGroup.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                lParams.gravity = btnGravity;

                Button btn = new Button(this);
                btn.setText(etName.getText().toString());
                llMain.addView(btn, lParams);
                break;
            case R.id.btnClear:
                llMain.removeAllViews();
                Toast.makeText(MainActivity.this, "Удалено", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
