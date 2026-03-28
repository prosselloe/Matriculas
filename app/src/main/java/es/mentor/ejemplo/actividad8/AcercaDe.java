package es.mentor.ejemplo.actividad8;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AcercaDe extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder ventana =
                new AlertDialog.Builder(getActivity());
        ventana.setIcon(android.R.drawable.ic_dialog_info);
        ventana.setTitle("Acerca de");
        ventana.setMessage("Matriculas Provinciales #\nNuméricas de España v1.0\n" +
                "Web: prosselloe.wordpress.com\n" +
                "E-mail: prosselloe@gmail.com\n" +
                "© prosselloe 2019");
        return ventana.create();
    }
}