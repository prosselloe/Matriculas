package es.mentor.ejemplo.actividad8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

class MatriculasBDAdapter {

    // Clase interna para declarar las constantes de las columnas = campos
    public static final class Matricula implements BaseColumns
    {
        private Matricula() {}

        // Nombres de las columnas
        public static final String CAMPO_ID = "_id";
        public static final String CAMPO_AUTONOMIA = "autonomia";
        public static final String CAMPO_REGION = "region";
        public static final String CAMPO_PROVINCIA = "provincia";
        public static final String CAMPO_LETRAS = "letras";
        public static final String CAMPO_FPRIMERA = "fprimera";
        public static final String CAMPO_A00 = "a00";
        public static final String CAMPO_A01 = "a01";
        public static final String CAMPO_A02 = "a02";
        public static final String CAMPO_A03 = "a03";
        public static final String CAMPO_A04 = "a04";
        public static final String CAMPO_A05 = "a05";
        public static final String CAMPO_A06 = "a06";
        public static final String CAMPO_A07 = "a07";
        public static final String CAMPO_A08 = "a08";
        public static final String CAMPO_A09 = "a09";
        public static final String CAMPO_A10 = "a10";
        public static final String CAMPO_A11 = "a11";
        public static final String CAMPO_A12 = "a12";
        public static final String CAMPO_A13 = "a13";
        public static final String CAMPO_A14 = "a14";
        public static final String CAMPO_A15 = "a15";
        public static final String CAMPO_A16 = "a16";
        public static final String CAMPO_A17 = "a17";
        public static final String CAMPO_A18 = "a18";
        public static final String CAMPO_A19 = "a19";
        public static final String CAMPO_A20 = "a20";
        public static final String CAMPO_A21 = "a21";
        public static final String CAMPO_A22 = "a22";
        public static final String CAMPO_A23 = "a23";
        public static final String CAMPO_A24 = "a24";
        public static final String CAMPO_A25 = "a25";
        public static final String CAMPO_A26 = "a26";
        public static final String CAMPO_A27 = "a27";
        public static final String CAMPO_A28 = "a28";
        public static final String CAMPO_A29 = "a29";
        public static final String CAMPO_A30 = "a30";
        public static final String CAMPO_A31 = "a31";
        public static final String CAMPO_A32 = "a32";
        public static final String CAMPO_A33 = "a33";
        public static final String CAMPO_A34 = "a34";
        public static final String CAMPO_A35 = "a35";
        public static final String CAMPO_A36 = "a36";
        public static final String CAMPO_A37 = "a37";
        public static final String CAMPO_A38 = "a38";
        public static final String CAMPO_A39 = "a39";
        public static final String CAMPO_A40 = "a40";
        public static final String CAMPO_A41 = "a41";
        public static final String CAMPO_A42 = "a42";
        public static final String CAMPO_A43 = "a43";
        public static final String CAMPO_A44 = "a44";
        public static final String CAMPO_A45 = "a45";
        public static final String CAMPO_A46 = "a46";
        public static final String CAMPO_A47 = "a47";
        public static final String CAMPO_A48 = "a48";
        public static final String CAMPO_A49 = "a49";
        public static final String CAMPO_A50 = "a50";
        public static final String CAMPO_A51 = "a51";
        public static final String CAMPO_A52 = "a52";
        public static final String CAMPO_A53 = "a53";
        public static final String CAMPO_A54 = "a54";
        public static final String CAMPO_A55 = "a55";
        public static final String CAMPO_A56 = "a56";
        public static final String CAMPO_A57 = "a57";
        public static final String CAMPO_A58 = "a58";
        public static final String CAMPO_A59 = "a59";
        public static final String CAMPO_A60 = "a60";
        public static final String CAMPO_A61 = "a61";
        public static final String CAMPO_A62 = "a62";
        public static final String CAMPO_A63 = "a63";
        public static final String CAMPO_A64 = "a64";
        public static final String CAMPO_A65 = "a65";
        public static final String CAMPO_A66 = "a66";
        public static final String CAMPO_A67 = "a67";
        public static final String CAMPO_A68 = "a68";
        public static final String CAMPO_A69 = "a69";
        public static final String CAMPO_A70 = "a70";
        public static final String CAMPO_A71 = "a71";
    }
    // Nombre de la tabla
    public static final String TABLA_BD = "matriculas";

    private Context contexto;
    private SQLiteDatabase basedatos;
    private MatriculasBDHelper bdHelper;

    public MatriculasBDAdapter(Context context) {
        this.contexto = context;
    }

    // Método que abre la BD
    public void abrir() throws SQLException {
        // Abrimos la base de datos en modo escritura
        bdHelper = new MatriculasBDHelper(contexto);
        basedatos = bdHelper.getWritableDatabase();
    }

    // Método que cierra la BD
    public void cerrar() {
        bdHelper.close();
    }

    // Método que crear una matrícula. Devuelve el id del registro nuevo si se ha dado de alta
    // correctamente o -1 si no. Para ello usamos la clase ContentValues
    public long crearMatricula(ContentValues values) {
        // Usamos la función insert del SQLiteDatabase
        return basedatos.insert(TABLA_BD, null, values);
    }

    // Método que actualiza registros
    public int actualizarMatricula(ContentValues values, String selection,
                                String[] selectionArgs) {
        // Usamos la función update del SQLiteDatabase
        return basedatos.update(TABLA_BD, values, selection, selectionArgs);
    }

    // Método que borra registros
    public int borraMatriculas(String selection, String[] selectionArgs) {
        // Usamos la función delete del SQLiteDatabase
        return basedatos.delete(TABLA_BD, selection, selectionArgs);
    }

    // Devuelve un Cursor con la consulta según los argumentos pasados como parámetros
    public Cursor obtenerMatriculas(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return basedatos.query(TABLA_BD, projection,
                selection, selectionArgs, null, null, sortOrder, null);
    }

} // end class
