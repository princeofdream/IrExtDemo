package com.vstech.jamesl.irextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.hardware.IConsumerIrExtService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "[JamesL]-Main";
    Button btn_get_ir_stat;
    Button btn_input_ir_ext_key_once;
    Button btn_input_ir_ext_key;
    TextView ir_stat_info;
    static int m_loog;

    ConsumerIrExtManager m_IrExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_get_ir_stat = (Button) this.findViewById(R.id.btn_get_ir_stat);
        btn_input_ir_ext_key_once = (Button) this.findViewById(R.id.btn_input_ir_ext_key_once);
        btn_input_ir_ext_key = (Button) this.findViewById(R.id.btn_input_ir_ext_key);
        ir_stat_info = (TextView) this.findViewById(R.id.ir_stat_info);
        m_loog = 0;
        m_IrExt = new ConsumerIrExtManager(this);
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
                boolean ret = m_IrExt.hasIrEmitter();
                ir_stat_info.append("Test by JamesL Loop: " + m_loog + "irExt available: " + ret + "\n");
                m_loog++;
                Log.i(TAG,"click button!");
            }
        });
        btn_input_ir_ext_key_once.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do_prev_action();
                //mTxInfo.setText(mInfoAray[minfocount].getInfo());
                //ir_stat_info.setText("Test by JamesL");
                m_IrExt.input_ir_ext_key_once("NEC",0x1dcc,0x0010,0);;
                ir_stat_info.append("Test by JamesL Loop: " + m_loog+"\n");
                m_loog++;
                Log.i(TAG,"click button!");
            }
        });
        btn_input_ir_ext_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do_prev_action();
                //mTxInfo.setText(mInfoAray[minfocount].getInfo());
                //ir_stat_info.setText("Test by JamesL");
                m_IrExt.setup_ir_ext_procotol("NEC");
                m_IrExt.input_ir_ext_key(0x1dcc,0x0010,0);
                m_IrExt.input_ir_ext_key(0x1dcc,0x0011,0);
                m_IrExt.input_ir_ext_key(0x1dcc,0x0012,0);
                ir_stat_info.append("Test by JamesL Loop: " + m_loog+"\n");
                m_loog++;
                Log.i(TAG,"click button!");
            }
        });
    }
}
