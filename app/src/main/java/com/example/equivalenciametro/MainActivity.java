package com.example.equivalenciametro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botoncalcular, botonlimpiar;
    TextView resultadoequivalencia;
    EditText valormetros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valormetros=(EditText)findViewById(R.id.valormetros);
        resultadoequivalencia=(TextView)findViewById(R.id.resultadoequivalencia);
        botoncalcular=(Button)findViewById(R.id.botoncalcular);
        botoncalcular.setOnClickListener(this);
        botonlimpiar=(Button)findViewById(R.id.botonlimpiar);
        botonlimpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botoncalcular:
                int ingresametros=Integer.valueOf(valormetros.getText().toString());
                if(ingresametros==0){
                    Toast.makeText(this, "Ingrese un valor mayor a cero", Toast.LENGTH_LONG).show();
                }else{
                    double resultadokilometros=ingresametros*1000;
                    double resultadomilimetros=ingresametros*0.001;
                    double resultadocentimetros=ingresametros*0.01;
                    double resultadodecimetros=ingresametros*0.1;

                    resultadoequivalencia.setText("RESULTADO EQUIVALENCIAS:\n " +resultadokilometros +" KILÓMETROS (km)\n"
                    +resultadomilimetros +" MILÍMETROS (mm)\n" +resultadocentimetros +" CENTÍMETROS (cm)\n"
                    +resultadodecimetros +" DECÍMETROS (dm)");
                }
                break;
            case R.id.botonlimpiar:
                resultadoequivalencia.setText("");
                valormetros.setText("");
                break;
        }
    }

}
