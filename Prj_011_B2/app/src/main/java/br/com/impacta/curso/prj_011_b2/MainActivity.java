package br.com.impacta.curso.prj_011_b2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private TextView tv_vo;

    private Parametro_Abacaxi mParametro_abacaxi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVars();
        initActions();

        // O que sera feito/executado. Quando?
        mParametro_abacaxi = new Parametro_Abacaxi();

        // Filter
        IntentFilter filter = new IntentFilter();
        filter.addAction("ABACAXI");
        filter.addCategory(Intent.CATEGORY_DEFAULT);

        // Nesse somento o somente agora comecar a ouvir o evento
        registerReceiver(mParametro_abacaxi, filter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mParametro_abacaxi);
        //
        super.onDestroy();
    }

    private void initVars() {
        context = getBaseContext();
        //
        tv_vo = (TextView) findViewById(R.id.tv_vo);
    }

    private void initActions() {

    }


    private class Parametro_Abacaxi extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int indice = intent.getIntExtra("indice", -1);

            tv_vo.setText("V.O. Indice=" + String.valueOf(indice));

            Toast.makeText(context,
                    "B2 - Indice " + String.valueOf(indice),
                    Toast.LENGTH_SHORT).show();
        }
    }

}
