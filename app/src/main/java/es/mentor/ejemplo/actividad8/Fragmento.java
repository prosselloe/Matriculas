package es.mentor.ejemplo.actividad8;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Fragmento
public class Fragmento extends Fragment {

    public Fragmento() {
    }

    // En este método indicamos el layout que usaremos para inflar el fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento, container, false);
    }
}
