package es.mentor.ejemplo.actividad8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MatriculasBDHelper extends SQLiteOpenHelper {
    // Definimos el nombre y la versión de la BD
    private static final String BD_MATRICULA = "bdmatriculas.db";
    private static final int BD_VERSION = 1;
    // Fichero raw para la creación de la BD
    private InputStream ficheroraw;

    // SQL que crea la base de datos
    // Es muy importante usar el campo _id
    private static final String BD_CREAR =
            "CREATE TABLE matriculas (_id INTEGER PRIMARY KEY, autonomia TEXT, region TEXT, provincia TEXT, letras TEXT, fprimera TEXT, " +
                    "a00 INTEGER, a01 INTEGER, a02 INTEGER, a03 INTEGER, a04 INTEGER, a05 INTEGER, a06 INTEGER, a07 INTEGER, a08 INTEGER, a09 INTEGER, " +
                    "a10 INTEGER, a11 INTEGER, a12 INTEGER, a13 INTEGER, a14 INTEGER, a15 INTEGER, a16 INTEGER, a17 INTEGER, a18 INTEGER, a19 INTEGER, " +
                    "a20 INTEGER, a21 INTEGER, a22 INTEGER, a23 INTEGER, a24 INTEGER, a25 INTEGER, a26 INTEGER, a27 INTEGER, a28 INTEGER, a29 INTEGER, " +
                    "a30 INTEGER, a31 INTEGER, a32 INTEGER, a33 INTEGER, a34 INTEGER, a35 INTEGER, a36 INTEGER, a37 INTEGER, a38 INTEGER, a39 INTEGER, " +
                    "a40 INTEGER, a41 INTEGER, a42 INTEGER, a43 INTEGER, a44 INTEGER, a45 INTEGER, a46 INTEGER, a47 INTEGER, a48 INTEGER, a49 INTEGER, " +
                    "a50 INTEGER, a51 INTEGER, a52 INTEGER, a53 INTEGER, a54 INTEGER, a55 INTEGER, a56 INTEGER, a57 INTEGER, a58 INTEGER, a59 INTEGER, " +
                    "a60 INTEGER, a61 INTEGER, a62 INTEGER, a63 INTEGER, a64 INTEGER, a65 INTEGER, a66 INTEGER, a67 INTEGER, a68 INTEGER, a69 INTEGER, " +
                    "a70 INTEGER, a71);";

            // "CREATE TABLE vehiculos (_id INTEGER PRIMARY KEY, marca TEXT, modelo TEXT, matricula	TEXT, diesel TEXT, gasolina	TEXT, bastidor TEXT, " +
            //         "cilindrada TEXT, cvf TEXT, fmatricula DATE);";

    // Contructor de la clase
    public MatriculasBDHelper(Context context) 	{
        super(context, BD_MATRICULA, null, BD_VERSION);
        ficheroraw = context.getResources().openRawResource(R.raw.bdmatriculas);
    }

    // Método invocado por Android si no existe la BD
    @Override
    public void onCreate(SQLiteDatabase database) {
        // Creamos la estructura de la BD
        // database.execSQL(BD_CREAR);

        String texto = null;
        try
        {
            BufferedReader brin = new BufferedReader(new InputStreamReader(ficheroraw));
            while (true) {
                texto = brin.readLine();
                // Si ya no hay más líneas que leer hemos acabado de leer el fichero
                if (texto == null) break;
                database.execSQL(texto);
            } // end while
            ficheroraw.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero de recurso de aplicación");
        }
    }

    // Método invocado por Android si hay un cambio de versión de la BD
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {
        // Eliminamos la BD y la volvemos a crear otra vez
        database.execSQL("DROP TABLE IF EXISTS matriculas");
        onCreate(database);
    }
}
