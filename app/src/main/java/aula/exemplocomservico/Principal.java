package aula.exemplocomservico;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    Servico servico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_principal_xml);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, Servico.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
    }

    public void onButtonClick(View v) {
        EditText editTexto1 = (EditText) findViewById(R.id.texto1);
        EditText editTexto2 = (EditText) findViewById(R.id.texto2);
        String texto1 = editTexto1.getText().toString();
        String texto2 = editTexto2.getText().toString();

        Toast.makeText(this, servico.Anagrama(texto1, texto2)?"É anagrama":"Não é anagrama", Toast.LENGTH_SHORT).show();
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            Servico.LocalBinder binder = (Servico.LocalBinder) service;
            servico = binder.getServerInstance();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        }
    };


}
