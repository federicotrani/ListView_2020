package ar.com.dartech.clase140820;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtDetalleProducto, txtDetallePrecio, txtDetalleBarcode;
    private ImageView imgProductoFoto;
    private Button btnDetalleCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setTitle("Precios Ciudados");

        findViews();

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        txtDetalleProducto.setText(extras.getString("E_PRODUCTO"));
        txtDetalleBarcode.setText(extras.getString("E_BARCODE"));
        txtDetallePrecio.setText("$"+String.valueOf(extras.getFloat("E_PRECIO")));


        Picasso.get().load("http://lorempixel.com/400/200/food/"+extras.getInt("E_ID")).into(imgProductoFoto);
    }

    private void findViews(){
        txtDetalleProducto = findViewById(R.id.txtDetalleProducto);
        txtDetallePrecio = findViewById(R.id.txtDetallePrecio);
        txtDetalleBarcode = findViewById(R.id.txtDetalleBarcode);
        imgProductoFoto = findViewById(R.id.imgDetalleFoto);
        btnDetalleCerrar = findViewById(R.id.btnDetalleCerrar);

        btnDetalleCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}