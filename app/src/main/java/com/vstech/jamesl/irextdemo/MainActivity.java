package com.vstech.jamesl.irextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "[JamesL]-Main";
    Button btn_get_ir_stat;
    TextView ir_stat_info;
    static int m_loog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_get_ir_stat = (Button) this.findViewById(R.id.btn_get_ir_stat);
        ir_stat_info = (TextView) this.findViewById(R.id.ir_stat_info);
        m_loog = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_get_ir_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do_prev_action();
                //mTxInfo.setText(mInfoAray[minfocount].getInfo());
                //ir_stat_info.setText("Test by JamesL");
                ir_stat_info.append("Test by JamesL Loop: " + m_loog+"\n");
                m_loog++;
                Log.i(TAG,"click button!");
            }
        });
    }
}
