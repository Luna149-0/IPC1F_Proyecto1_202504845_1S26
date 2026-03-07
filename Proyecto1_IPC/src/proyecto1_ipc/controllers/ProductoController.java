
package proyecto1_ipc.controllers;

import proyecto1_ipc.models.ProductoModel;

/**
 *
 * @author ixche
 */
public class ProductoController {
    
    public static ProductoModel[] datosProd= new ProductoModel[100];
    
    
    public void agregarProducto(int id, String nombre, int cantidad, String categoria, int precio){
      
        //A;adir datos al arreglo
        for(int i=0; i<datosProd.length; i++){
            if(datosProd[i] == null){
                ProductoModel prod=new ProductoModel();
                
                prod.setId(id);
                prod.setNombre(nombre);
                prod.setCantidad(cantidad);
                prod.setCategoria(categoria);
                prod.setPrecio(precio);
                datosProd[i] = prod;
                System.out.println("Se agrego el producto con id "+ id+ " exitosamente");
                
                return;
            }
        }
    }
    
    public void verProductos(){
        for(ProductoModel prod: datosProd){
            System.out.println("------------------");
            System.out.println(prod.getId());
            System.out.println(prod.getNombre());
            System.out.println(prod.getCantidad());
            System.out.println(prod.getCategoria());
            System.out.println(prod.getPrecio());
            System.out.println("------------------");
        }
    }
}
