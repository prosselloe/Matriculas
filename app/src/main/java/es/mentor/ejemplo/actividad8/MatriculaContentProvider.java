package es.mentor.ejemplo.actividad8;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.content.ContentUris;

/** Definimos un Content Provider para que realice las operaciones con la BD */
public class MatriculaContentProvider extends ContentProvider{

    // matricula del Content Provider
    public static final String PROVIDER_NAME = "es.mentor.ejemplo.actividad8";

    // Definimos la URI del Content Provider
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/matriculas" );

    // Definimos la constante de la operación - Necesario para UriMatcher
    private static final int MATRICULAS = 1;

    // Definimos el UriMatcher
    private static final UriMatcher uriMatcher ;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "matriculas", MATRICULAS);
    }

    // Acceso a la BD
    MatriculasBDAdapter MatriculasBD;

    // Se invoca este método al crear el Content Provider
    @Override
    public boolean onCreate() {
        // Conectamos con la BD
        MatriculasBD = new MatriculasBDAdapter(getContext());
        MatriculasBD.abrir();
        return true;
    }

    // En este sencillo ejemplo no indicamos el tipo de dato ya que se usa únicamente internamente
    @Override
    public String getType(Uri uri) {
        return null;
    }

    // Método que consulta la BD en función de los parámetros: columnas, seleccion, argumentos selección y orden
    @Override
    public Cursor query(Uri uri, String[] columnas, String seleccion, String[] seleccionArgs, String orden) {

        if (uriMatcher.match(uri) == MATRICULAS){
            Cursor c = MatriculasBD.obtenerMatriculas(columnas, seleccion, seleccionArgs, orden);
            // Es necesario indicar la URI de actualización de contenidos para que el
            // cursor pueda refrescar automáticamente los datos - esto se denomina OBSERVADOR
            c.setNotificationUri(getContext().getContentResolver(), CONTENT_URI);
            return c;
        } else {
            return null;
        }
    }

    // Método que borrar registros en función de los parámetros en la BD
    @Override
    public int delete(Uri uri, String seleccion, String[] seleccionArgs) {
        if (uriMatcher.match(uri) == MATRICULAS){
            // Devolvemos los registros afectados por el borrado
            int borrados = MatriculasBD.borraMatriculas(seleccion, seleccionArgs);
            // Notificamos cambio asociado a la uri
            getContext().getContentResolver().notifyChange(uri, null);
            return borrados;
        } else {
            return 0;
        }
    }

    // Método que inserta un registro
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (uriMatcher.match(uri) == MATRICULAS){
            // Creamos un registro
            long id = MatriculasBD.crearMatricula(values);
            // Uri con el resultado de la operación indicando el id del nuevo registro en la lista
            if (id > -1) {
                Uri newUri = ContentUris.withAppendedId(CONTENT_URI, id);
                // Notificamos cambio asociado a la uri
                getContext().getContentResolver().notifyChange(uri, null);
                return newUri;
            } else // Si no se ha podido crear el registro no devolvemos una URI
                return null;
        } else {
            return null;
        }
    }

    // Método que actualiza registros en función de los parámetros
    @Override
    public int update(Uri uri, ContentValues values, String seleccion,
                      String[] seleccionArgs) {
        if (uriMatcher.match(uri) == MATRICULAS){
            int modificados = MatriculasBD.actualizarMatricula(values, seleccion, seleccionArgs);
            // Notificamos cambio asociado a la uri
            getContext().getContentResolver().notifyChange(uri, null);
            return modificados;
        } else {
            return 0;
        }
    }

} // end class
