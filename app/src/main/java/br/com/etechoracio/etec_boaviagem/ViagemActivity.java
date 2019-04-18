package br.com.etechoracio.etec_boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class ViagemActivity extends AppCompatActivity {

    private Button btndataChegada;
    private Button btndataSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem);

        btndataChegada = findViewById(R.id.btndataChegada);
        btndataSaida = findViewById(R.id.btndataSaida);
    }

    private DatePickerDialog.OnDateSetListener datachegada = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            String data = String.valueOf(dia) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(ano);
            btndataChegada.setText(data);
        }
    };
    private DatePickerDialog.OnDateSetListener datasaida = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            String data = String.valueOf(dia) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(ano);
            btndataSaida.setText(data);
        }
    };

    protected Dialog onCreateDialog(int id) {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case R.id.btndataChegada:
                return new DatePickerDialog(this, datachegada, ano, mes, dia);
        }


        switch (id) {
            case R.id.btndataSaida:
                return new DatePickerDialog(this, datasaida, ano, mes, dia);
        }
        return null;
    }

    public void onSelecionarData(View view) {
        showDialog(view.getId());
    }
}
