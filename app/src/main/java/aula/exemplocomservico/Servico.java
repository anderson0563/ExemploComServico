package aula.exemplocomservico;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Arrays;

public class Servico extends Service {

    IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public Servico getServerInstance() {
            return Servico.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public boolean Anagrama(String palavra1, String palavra2) {

        char word1[] = palavra1.toCharArray();
        char word2[] = palavra2.toCharArray();

        Arrays.sort(word1);
        Arrays.sort(word2);

        return Arrays.equals(word1, word2);
    }
}
