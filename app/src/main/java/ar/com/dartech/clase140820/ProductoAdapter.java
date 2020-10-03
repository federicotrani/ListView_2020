package ar.com.dartech.clase140820;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import ar.com.dartech.clase140820.models.Producto;

public class ProductoAdapter extends BaseAdapter {

    private List<Producto> listaProductos;

    public ProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Producto getItem(int i) {
        return listaProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View view;
        // optimizacion de la vista
        if(convertView==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_productos, parent, false);
        }else
        {
            view = convertView;
        }

        Producto producto = getItem(i);

        ImageView imgProductoImagen = view.findViewById(R.id.imgProductoImagen);
        TextView txtProductoNombre = view.findViewById(R.id.txtProductoNombre);
        TextView txtProductoPrecio = view.findViewById(R.id.txtProductoPrecio);
        TextView txtProductoBarcode = view.findViewById(R.id.txtProductoBarcode);

        txtProductoNombre.setText(producto.getNombre());
        txtProductoBarcode.setText(producto.getBarcode());
        txtProductoPrecio.setText(String.valueOf("$"+producto.getPrecio()));
        // imgProductoImagen.setImageResource(0);
        Picasso.get().load("http://lorempixel.com/400/200/food/"+producto.getId()).into(imgProductoImagen);

        return view;
    }
}
