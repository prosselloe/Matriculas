package es.mentor.ejemplo.actividad8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class Actividad8 extends FragmentActivity {

    // Definimos las Vistas que vamos a usar en el proyecto
    private ImageView imageView1;
    private TextView textView2;
    private TextView textView3;
    private EditText editText1;
    private TextView textView5;

    // Definimos las opciones de los nombres en una matriz
    private ArrayList<String> matriculas = new ArrayList<String>();

    // Campos que consultamos de la tabla
    private static final String[] COLUMNAS = new String[] { MatriculasBDAdapter.Matricula.CAMPO_ID,
            MatriculasBDAdapter.Matricula.CAMPO_AUTONOMIA, MatriculasBDAdapter.Matricula.CAMPO_REGION,
            MatriculasBDAdapter.Matricula.CAMPO_PROVINCIA, MatriculasBDAdapter.Matricula.CAMPO_LETRAS,
            MatriculasBDAdapter.Matricula.CAMPO_FPRIMERA };
    // ContentResolver para conectar con la BD
    private ContentResolver cr;
    // URI de destino de las consultas del ContentResolver
    Uri uri;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad8);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // Buscamos los componentes de la pantalla
        final AutoCompleteTextView autoComplete1 = (AutoCompleteTextView) findViewById(R.id.autoComplete1);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText("");
        textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setText("");
        editText1 = (EditText)findViewById(R.id.editText1);
        editText1.setText("");
        textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setText("");

        matriculas.add("Álava");
        matriculas.add("Albacete");
        matriculas.add("Alicante");
        matriculas.add("Almería");
        matriculas.add("Asturias");
        matriculas.add("Avila");
        matriculas.add("Badajoz");
        matriculas.add("Baleares");
        matriculas.add("Barcelona");
        matriculas.add("Burgos");
        matriculas.add("Cáceres");
        matriculas.add("Cadiz ");
        matriculas.add("Cantabria");
        matriculas.add("Castellón");
        matriculas.add("Ceuta");
        matriculas.add("Ciudad Real");
        matriculas.add("Córdoba");
        matriculas.add("Coruña, La");
        matriculas.add("Cuenca");
        matriculas.add("Gerona");
        matriculas.add("Granada");
        matriculas.add("Guadalajara");
        matriculas.add("Guipúzcoa");
        matriculas.add("Huelva");
        matriculas.add("Huesca");
        matriculas.add("Jaén");
        matriculas.add("León");
        matriculas.add("Lérida");
        matriculas.add("Lugo");
        matriculas.add("Madrid");
        matriculas.add("Málaga");
        matriculas.add("Melilla");
        matriculas.add("Murcia");
        matriculas.add("Navarra");
        matriculas.add("Orense");
        matriculas.add("Palencia");
        matriculas.add("Palmas, Las");
        matriculas.add("Pontevedra");
        matriculas.add("Rioja, La");
        matriculas.add("Salamanca");
        matriculas.add("Tenerife");
        matriculas.add("Segovia");
        matriculas.add("Sevilla");
        matriculas.add("Soria");
        matriculas.add("Tarragona");
        matriculas.add("Teruel");
        matriculas.add("Toledo");
        matriculas.add("Valencia");
        matriculas.add("Valladolid");
        matriculas.add("Vizcaya");
        matriculas.add("Zamora");
        matriculas.add("Zaragoza");

        // Creamos un adaptador predefinido de Android con la matriz para dibujar
        // las opciones que se despliegan cuando escribe el usuario en el
        // AutoCompleteTextView
        ArrayAdapter<String> adaptador =  new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, matriculas);

        // Definimos la URI donde conectar con el ContentResolver
        uri = MatriculaContentProvider.CONTENT_URI;
        // Definimos el acceso al contentresolver de la aplicación
        cr = getContentResolver();

        /*
        // Constantes que definen los campos que consultamos
        String[] columnas = new String[] { MatriculasBDAdapter.Matricula.CAMPO_PROVINCIA };
        // Hacemos una consulta de los valores
        Cursor cursor = cr.query(uri,
                columnas,   // Columnas a devolver
                null,       // Condición de la query
                null,       // Argumentos variables de la query
                null);      // Orden de los resultados
        // Si hay registros cargamos la información
        if (cursor.moveToFirst()) {
            do {
                // Obtenemos la información de las columnas
                matriculas.add(cursor.getString(cursor.getColumnIndexOrThrow(
                        MatriculasBDAdapter.Matricula.CAMPO_PROVINCIA)));
            } while (cursor.moveToNext()); // end while
        }
        */

        // A partir de la primera letra se busca el valor
        autoComplete1.setThreshold(1);
        // Asignamos el adaptador al AutoCompleteTextView
        autoComplete1.setAdapter(adaptador);

        // Establecemos el evento OnItemClickListener para actualizar la pantalla
        // cuando el usuario selecciona una opción del AutoCompleteTextView.
        autoComplete1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {

                if (autoComplete1.getText().toString().equals("Álava"))
                    imageView1.setImageResource(R.drawable.alava);
                else
                if (autoComplete1.getText().toString().equals("Albacete"))
                    imageView1.setImageResource(R.drawable.albacete);
                else
                if (autoComplete1.getText().toString().equals("Alicante"))
                    imageView1.setImageResource(R.drawable.alicante);
                else
                if (autoComplete1.getText().toString().equals("Almería"))
                    imageView1.setImageResource(R.drawable.almeria);
                else
                if (autoComplete1.getText().toString().equals("Asturias"))
                    imageView1.setImageResource(R.drawable.asturias);
                else
                if (autoComplete1.getText().toString().equals("Avila"))
                    imageView1.setImageResource(R.drawable.avila);
                else
                if (autoComplete1.getText().toString().equals("Badajoz"))
                    imageView1.setImageResource(R.drawable.badajoz);
                else
                if (autoComplete1.getText().toString().equals("Baleares"))
                    imageView1.setImageResource(R.drawable.baleares);
                else
                if (autoComplete1.getText().toString().equals("Barcelona"))
                    imageView1.setImageResource(R.drawable.barcelona);
                else
                if (autoComplete1.getText().toString().equals("Burgos"))
                    imageView1.setImageResource(R.drawable.burgos);
                else
                if (autoComplete1.getText().toString().equals("Cáceres"))
                    imageView1.setImageResource(R.drawable.caceres);
                else
                if (autoComplete1.getText().toString().equals("Cadiz"))
                    imageView1.setImageResource(R.drawable.cadiz);
                else
                if (autoComplete1.getText().toString().equals("Cantabria"))
                    imageView1.setImageResource(R.drawable.cantabria);
                else
                if (autoComplete1.getText().toString().equals("Castellón"))
                    imageView1.setImageResource(R.drawable.castellon);
                else
                if (autoComplete1.getText().toString().equals("Ceuta"))
                    imageView1.setImageResource(R.drawable._ceuta);
                else
                if (autoComplete1.getText().toString().equals("Ciudad Real"))
                    imageView1.setImageResource(R.drawable.ciudad_real);
                else
                if (autoComplete1.getText().toString().equals("Córdoba"))
                    imageView1.setImageResource(R.drawable.cordoba);
                else
                if (autoComplete1.getText().toString().equals("Coruña, La"))
                    imageView1.setImageResource(R.drawable.la_coruna);
                else
                if (autoComplete1.getText().toString().equals("Cuenca"))
                    imageView1.setImageResource(R.drawable.cuenca);
                else
                if (autoComplete1.getText().toString().equals("Gerona"))
                    imageView1.setImageResource(R.drawable.gerona);
                else
                if (autoComplete1.getText().toString().equals("Granada"))
                    imageView1.setImageResource(R.drawable.granada);
                else
                if (autoComplete1.getText().toString().equals("Guadalajara"))
                    imageView1.setImageResource(R.drawable.guadalajara);
                else
                if (autoComplete1.getText().toString().equals("Guipúzcoa"))
                    imageView1.setImageResource(R.drawable.guipuzcoa);
                else
                if (autoComplete1.getText().toString().equals("Huelva"))
                    imageView1.setImageResource(R.drawable.huelva);
                else
                if (autoComplete1.getText().toString().equals("Huesca"))
                    imageView1.setImageResource(R.drawable.huesca);
                else
                if (autoComplete1.getText().toString().equals("Jaén"))
                    imageView1.setImageResource(R.drawable.jaen);
                else
                if (autoComplete1.getText().toString().equals("León"))
                    imageView1.setImageResource(R.drawable.leon);
                else
                if (autoComplete1.getText().toString().equals("Lérida"))
                    imageView1.setImageResource(R.drawable.lerida);
                else
                if (autoComplete1.getText().toString().equals("Lugo"))
                    imageView1.setImageResource(R.drawable.lugo);
                else
                if (autoComplete1.getText().toString().equals("Madrid"))
                    imageView1.setImageResource(R.drawable.madrid);
                else
                if (autoComplete1.getText().toString().equals("Málaga"))
                    imageView1.setImageResource(R.drawable.malaga);
                else
                if (autoComplete1.getText().toString().equals("Melilla"))
                    imageView1.setImageResource(R.drawable._melilla);
                else
                if (autoComplete1.getText().toString().equals("Murcia"))
                    imageView1.setImageResource(R.drawable.murcia);
                else
                if (autoComplete1.getText().toString().equals("Navarra"))
                    imageView1.setImageResource(R.drawable.navarra);
                else
                if (autoComplete1.getText().toString().equals("Orense"))
                    imageView1.setImageResource(R.drawable.orense);
                else
                if (autoComplete1.getText().toString().equals("Palencia"))
                    imageView1.setImageResource(R.drawable.palencia);
                else
                if (autoComplete1.getText().toString().equals("Palmas, Las"))
                    imageView1.setImageResource(R.drawable.las_palmas);
                else
                if (autoComplete1.getText().toString().equals("Pontevedra"))
                    imageView1.setImageResource(R.drawable.pontevedra);
                else
                if (autoComplete1.getText().toString().equals("Rioja, La"))
                    imageView1.setImageResource(R.drawable.la_rioja);
                else
                if (autoComplete1.getText().toString().equals("Salamanca"))
                    imageView1.setImageResource(R.drawable.salamanca);
                else
                if (autoComplete1.getText().toString().equals("Tenerife"))
                    imageView1.setImageResource(R.drawable.tenerife);
                else
                if (autoComplete1.getText().toString().equals("Segovia"))
                    imageView1.setImageResource(R.drawable.segovia);
                else
                if (autoComplete1.getText().toString().equals("Sevilla"))
                    imageView1.setImageResource(R.drawable.sevilla);
                else
                if (autoComplete1.getText().toString().equals("Soria"))
                    imageView1.setImageResource(R.drawable.soria);
                else
                if (autoComplete1.getText().toString().equals("Tarragona"))
                    imageView1.setImageResource(R.drawable.tarragona);
                else
                if (autoComplete1.getText().toString().equals("Teruel"))
                    imageView1.setImageResource(R.drawable.teruel);
                else
                if (autoComplete1.getText().toString().equals("Toledo"))
                    imageView1.setImageResource(R.drawable.toledo);
                else
                if (autoComplete1.getText().toString().equals("Valencia"))
                    imageView1.setImageResource(R.drawable.valencia);
                else
                if (autoComplete1.getText().toString().equals("Valladolid"))
                    imageView1.setImageResource(R.drawable.valladolid);
                else
                if (autoComplete1.getText().toString().equals("Vizcaya"))
                    imageView1.setImageResource(R.drawable.vizcaya);
                else
                if (autoComplete1.getText().toString().equals("Zamora"))
                    imageView1.setImageResource(R.drawable.zamora);
                else
                if (autoComplete1.getText().toString().equals("Zaragoza"))
                    imageView1.setImageResource(R.drawable.zaragoza);

                /*
                String letras[] = { "VI", "AB, ALB*", "A", "AL", "O", "AV", "BA", "PM, IB, BA*", "B", "BU",
                        "CC, CAC*", "CA", "S", "CS, CAS*", "CE*", "CR", "CO", "C", "CU", "GE, GI*", "GR", "GU",
                        "SS", "H", "HU", "J", "LE", "L", "LU", "M", "MA", "ML*", "MU", "PA, NA*", "OR, OU*",
                        "P", "GC, TE*", "PO", "LO, LR*", "SA", "TF, TE*", "SG, SEG*", "SE", "SO", "T", "TE, TER*",
                        "TO", "V", "VA", "BI", "ZA", "Z" };
                */

                String letras[] = { "VI\n03/02/1906", "AB, ALB*\n12/06/1908", "A\n21/12/1907", "AL\n20/12/1907", "O\n23/06/1911",
                        "AV\n01/07/1908", "BA\n10/07/1903", "PM, IB, BA*\n31/10/1900", "B\n30/06/1910", "BU\n27/02/1908",
                        "CC, CAC*\n18/11/1900", "CA\n04/02/1903", "S\n20/03/1901", "CS, CAS*\n03/04/1902", "CE*\n14/10/1922",
                        "CR\n08/11/1907", "CO\n21/06/1904", "C\n16/12/1902", "CU\n08/08/1911", "GE, GI*\n02/08/1907", "GR\n23/06/1904",
                        "GU\n16/08/1907", "SS\n10/08/1901", "H\n26/09/1912", "HU\n14/07/1906", "J\n15/01/1907", "LE\n20/07/1907",
                        "L\n29/08/1907", "LU\n20/08/1904", "M\n19/08/1907", "MA\n10/08/1907", "ML*\n12/04/1917", "MU\n05/03/1908",
                        "PA, NA*\n29/06/1907", "OR, OU*\n10/09/1906", "P\n03/07/1908", "GC, TE*\n17/02/1902", "PO\n14/08/1903",
                        "LO, LR*\n13/12/1905", "SA\n07/12/1900", "TF, TE*\n17/02/1902", "SG, SEG*\n27/08/1910", "SE\n23/10/1907",
                        "SO\n22/08/1908", "T\n26/11/1907", "TE, TER*\n28/08/1908", "TO\n30/10/1906", "V\n30/04/1902", "VA\n28/01/1908",
                        "BI\n23/02/1902", "ZA\n24/08/1907", "Z\n05/07/1905" };

                // En el parámetro position Android se indica la posición de la opción seleccionada
                // Mostramos el origen y significado. ¡Ojo! No coindice con el índice de la matriz
                // por eso buscamos el índice que corresponde al nombre que ha escrito el usuario
                String textoSeleccionado = (String) listView.getItemAtPosition(position);

                // textView2.setText(Html.fromHtml("Letras (<sup>*RD 16/06/26, etc.)</sup>:\nFecha primera matrícula: "));
                textView2.setText("Letras Provinciales*: \nFecha primera matrícula: ");
                textView3.setText(letras[matriculas.indexOf(textoSeleccionado)]);
                editText1.requestFocus();

                /*
                // Constantes que definen los campos que consultamos
                String[] columnas = new String[] { MatriculasBDAdapter.Matricula.CAMPO_PROVINCIA,
                        MatriculasBDAdapter.Matricula.CAMPO_LETRAS, MatriculasBDAdapter.Matricula.CAMPO_FPRIMERA };
                // Hacemos una consulta de la provincia
                // Toast.makeText(getApplicationContext(), "provincia = '" +
                //         autoComplete1.getText().toString() + "'", Toast.LENGTH_LONG).show();
                Cursor cursor = cr.query(uri,
                        columnas,   // Columnas a devolver
                        "provincia = '" + autoComplete1.getText().toString() + "'",   // Condición de la query
                        null,       // Argumentos variables de la query
                        null);      // Orden de los resultados
                // Si hay matriculas mostramos la información
                if (cursor.moveToFirst()) {
                    // Obtenemos la información de las columnas
                    textView1.setText("Letras: " + cursor.getString(
                            cursor.getColumnIndexOrThrow(MatriculasBDAdapter.Matricula.CAMPO_LETRAS)));
                    textView2.setText("Fecha primera matrícula: " + cursor.getString(
                            cursor.getColumnIndexOrThrow(MatriculasBDAdapter.Matricula.CAMPO_FPRIMERA)));
                }
                */

            }
        }); // end setOnItemClickListener

        ((Button) findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogoAlerta dialogo = new DialogoAlerta();
                dialogo.show(fragmentManager, "tagAlerta");
            }
        });

        ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://es.wikipedia.org/wiki/Matr%C3%ADculas_automovil%C3%ADsticas_de_Espa%C3%B1a" +
                                "#Sistema_provincial_num%C3%A9ricol"));
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.sme-matriculas.es/up1.html"));
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (autoComplete1.getText().toString().equals(""))
                    autoComplete1.setError("ERROR: es obligatorio indicar el campo provincia.");
                else if (editText1.getText().toString().equals(""))
                    editText1.setError("ERROR: es obligatorio indicar el campo número.");
                else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Matrícula seleccionada: " +
                            textView3.getText().toString().substring(0, 2) + "·" +
                            editText1.getText().toString(), Toast.LENGTH_LONG);
                    // Indicamos el posicionamiento
                    toast1.setGravity(Gravity.CENTER,0,0);
                    toast1.show();

                    Integer numeros[] = { 2, 4, 5, 6, 6, 7, 22, 41, 53, 67, 73, 103, 141, 182, 232, 244, 254, 262,
                            265, 273, 403, 587, 682, 1229, 1807, 2351, 3120, 3597, 4175, 4845, 5192, 5379, 5576,
                            5930, 6427, 6809, 7045, 7063, 7091, 7096, 7139, 7182, 7224, 7285, 7334, 7370, 7435,
                            7537, 7670, 7728, 7754, 7816, 8162, 8962, 10347, 12772, 18727, 25004, 31315, 35269,
                            40462, 48596, 58326, 67982, 77536, 87327, 100142, 112339, 124331, 138762, 154697, 167861 };

                    int numero = Integer.parseInt(editText1.getText().toString());
                    if (numero == 1)
                        textView5.setText("Fecha de matrículación: " +
                                textView3.getText().toString().substring(
                                textView3.getText().toString().length() -10,
                                textView3.getText().toString().length()));
                    else {
                        int any = 0;
                        // Buscamos el primer año con la última matricula superior a la seleccionada
                        while (numero > numeros[any] && any < numeros.length) any++;
                        // Prevenimos un desbondamiento en el índice del array.
                        if (any == 0) any++;
                        // Matriculaciones en el año hasta la matricula seleccionada.
                        int matriculaciones_hasta = numero - numeros[any - 1];
                        // Total de matriculaciones en el año.
                        int matriculaciones_total = numeros[any] - numeros[any - 1];
                        Float pordia = matriculaciones_total / 360f;
                        // Prevenimos una posible división por cero.
                        if (pordia <= 0) pordia = 1f;
                        int dias = Math.round(matriculaciones_hasta / pordia);
                        int mes = dias / 30;
                        int dia = dias - mes * 30;
                        // Prevenimos dia cero a principios de los meses de enero y finales de los meses de diciembre.
                        if (dia == 0 && dias > (360-30)) dia = 30;
                        else if (dia == 0) dia = 1;
                        if (mes < 12) mes++;
                        // Prevenimos dias mayores de 28 en febrero.
                        if (mes == 2 && dia > 28) dia = 28;

                        /*
                        Toast.makeText(getApplicationContext(),"matriculaciones_hasta: " + matriculaciones_hasta +
                                ", matriculaciones_total" + matriculaciones_total + ", pordia: " + pordia + ", dias: " + dias,
                                Toast.LENGTH_LONG).show();
                        */

                        textView5.setText(String.format("Fecha de matrículación: %1$02d/%2$02d/%3$04d",
                                dia, mes, any + 1900));
                    }
                }
            }
        });

    } // end on Create

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad8, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_mapa) {
            intent = new Intent(Actividad8.this, MapaProvincias.class);
            uri = intent.getData();
            startActivity(intent);
            return true;
        } else
        if (id == R.id.action_acercade) {
            AcercaDe dialogo = new AcercaDe();
            dialogo.show(fragmentManager, "tagAlerta");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
