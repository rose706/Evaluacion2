package com.example.evaluacion2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class BaseDeDatos extends AppCompatActivity {


    EditText edtIdentificacion;
    EditText edtNombres;
    EditText edtApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos);

        edtIdentificacion = (EditText) findViewById(R.id.edtIdentificacion);
        edtNombres = (EditText) findViewById(R.id.edtNombres);
        edtApellidos = (EditText) findViewById(R.id.edtApellidos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_clientes,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_add:

                String ident = edtIdentificacion.getText().toString();
                String nombres = edtNombres.getText().toString();
                String apellidos = edtApellidos.getText().toString();

                if(ident.length() > 0 && nombres.length() > 0 && apellidos.length() > 0){
                     usuarioSQLiteHelper usuario = new usuarioSQLiteHelper(this,"DBClientes", null,1);
                    SQLiteDatabase db = usuario.getWritableDatabase();

                    db.execSQL("INSERT INTO Cliente (Identificacion,Nombres, Apellidos) VALUES('" + ident +",'" + nombres+"','" + apellidos+"'");
                    db.close();
                    Toast.makeText(this,"El usuario se ha creado exitosamente",Toast.LENGTH_SHORT).show();
                    edtIdentificacion.setText("");
                    edtNombres.setText("");
                    edtApellidos.setText("");

                }
                else{
                    Toast.makeText(this,"Debe ingresar todos los datos asociados al usuario.",Toast.LENGTH_SHORT).show();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

