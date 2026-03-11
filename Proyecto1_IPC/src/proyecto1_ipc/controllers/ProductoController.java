
package proyecto1_ipc.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    
    public static void generarHTML() throws IOException{
        String fecha = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
        String nombreArchivo = fecha + "_Stock.html";

    StringBuilder filas = new StringBuilder();

    for(ProductoModel m : datosProd){
        if (m == null) continue;

        filas.append("<tr>")
             .append("<td>").append(m.getId()).append("</td>")
             .append("<td>").append(m.getNombre()).append("</td>")
             .append("<td>").append(m.getCantidad()).append("</td>")
             .append("<td>").append(m.getCategoria()).append("</td>")
             .append("<td>").append(m.getPrecio()).append("</td>")
             .append("</tr>");
    }

    String html =
            """
            <!doctype html>
            <html lang="es">
            <head>
            <meta charset="utf-8">
            <title>Reporte de productos</title>
            </head>
            <body>
            <h1>Reporte de productos</h1>

            <table border="1">
            <thead>
            <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Cantidad</th>
            <th>Categoria</th>
            <th>Precio</th>
            </tr>
            </thead>

            <tbody>
            """ +
            filas +
            """
            </tbody>
            </table>

            </body>
            </html>
            """;

    Files.write(Paths.get(nombreArchivo), html.getBytes(StandardCharsets.UTF_8));

    System.out.println("Reporte generado: " + nombreArchivo);
    
    }
    
    
    public String buscarPorNombre(String nombre){

    for(ProductoModel prod : datosProd){

        if(prod == null) continue;

        if(prod.getNombre().equalsIgnoreCase(nombre)){

            return "Producto encontrado\n"
                    + "ID: " + prod.getId()
                    + "\nNombre: " + prod.getNombre()
                    + "\nCategoría: " + prod.getCategoria()
                    + "\nPrecio: " + prod.getPrecio()
                    + "\nCantidad en stock: " + prod.getCantidad();
        }
    }

    return "Producto no encontrado";
}

    }
    

