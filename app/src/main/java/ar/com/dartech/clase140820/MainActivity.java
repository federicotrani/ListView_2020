package ar.com.dartech.clase140820;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ar.com.dartech.clase140820.models.Producto;

public class MainActivity extends AppCompatActivity {

    private ListView lvProductos;
    private ProductoAdapter adaptador;  // global
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Producto> listaProductos;  // global

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Precios Cuidados");

        lvProductos = findViewById(R.id.lvProductos);

        listaProductos = new ArrayList<>();

        this.cargarDatos();

        adaptador = new ProductoAdapter(listaProductos);

        lvProductos.setAdapter(adaptador);

        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(MainActivity.this, "Clic en elemento "+i, Toast.LENGTH_SHORT).show();
                cargaDetalle(i);
            }
        });

        swipeRefreshLayout = findViewById(R.id.swiperefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // volvemos a llamar metodo que obtiene datos
                cargarDatos();
                // desactivamos indicador de actualizacion
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    private void cargaDetalle(int i){
        Producto producto = adaptador.getItem(i);

        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);

        intent.putExtra("E_ID", producto.getId());
        intent.putExtra("E_PRODUCTO", producto.getNombre());
        intent.putExtra("E_PRECIO", producto.getPrecio());
        intent.putExtra("E_BARCODE", producto.getBarcode());

        startActivity(intent);
    }

    private void cargarDatos(){
        // limpiamos contenido del arreglo de datos
        listaProductos.clear();
        listaProductos.add(new Producto(1,"Jugo Tang 100mg", 15.20f, "EAN123456", 0));
        listaProductos.add(new Producto(2,"Pilas Alcalinas 5u AA", 153.20f, "EAN123456", 0));
        listaProductos.add(new Producto(3,"Gaseosa Coca Cola 1 litro", 30.20f, "EAN123456", 0));
        listaProductos.add(new Producto(4,"Pan Lactal 500 grs", 42.20f, "EAN123456", 0));
        listaProductos.add(new Producto(5,"Aceite Cocinero 1 Litro", 80.20f, "EAN123456", 0));
        listaProductos.add(new Producto(6,"Harina Trigal 500 mgs0", 55.0f, "EAN123456", 0));
        listaProductos.add(new Producto(7,"Yerba Mate Mañanita 500 grs", 80.20f, "EAN123456", 0));
        listaProductos.add(new Producto(8,"Detergente Magistral Lux 250 mls", 80.20f, "EAN123456", 0));
        listaProductos.add(new Producto(9,"Cafe La Morenita 250 mg", 280.20f, "EAN123456", 0));
        listaProductos.add(new Producto(10,"Galletitas Express Pack 3u x 100 grs", 135.20f, "EAN123456", 0));
        listaProductos.add(new Producto(11,"Fideos Don Felipe 250 grs", 80.20f, "EAN123456", 0));
    }

}