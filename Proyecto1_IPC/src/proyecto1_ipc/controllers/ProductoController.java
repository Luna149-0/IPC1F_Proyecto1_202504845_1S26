
package proyecto1_ipc.controllers;
import java.awt.Desktop;
//import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import proyecto1_ipc.models.ProductoModel;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ixche
 */
public class ProductoController {
    
    public static ProductoModel[] datosProd= new ProductoModel[100];
    private static final List<String> ventasEnMemoria = new ArrayList<>();
    
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
    
   public String verProductosComoString() {
    StringBuilder sb = new StringBuilder();

    for(ProductoModel prod: datosProd){
        if(prod != null){
            sb.append("------------------\n");
            sb.append("ID: ").append(prod.getId()).append("\n");
            sb.append("Nombre: ").append(prod.getNombre()).append("\n");
            sb.append("Cantidad: ").append(prod.getCantidad()).append("\n");
            sb.append("Categoría: ").append(prod.getCategoria()).append("\n");
            sb.append("Precio: ").append(prod.getPrecio()).append("\n");
            sb.append("------------------\n");
        }
    }

    if(sb.length() == 0) return "No hay productos registrados";
    return sb.toString();
}
    
    public static void generarHTML() throws IOException{
        String fecha = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
        String nombreArchivo = fecha + "_Stock.html";
        Desktop.getDesktop().browse(new File(nombreArchivo).toURI());

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

    public String buscarPorCategoria(String categoria){

    String resultado = "";

    for(ProductoModel prod : datosProd){

        if(prod == null) continue;

        if(prod.getCategoria().equalsIgnoreCase(categoria)){

            resultado += "ID: " + prod.getId()
                    + "\nNombre: " + prod.getNombre()
                    + "\nCategoria: " + prod.getCategoria()
                    + "\nPrecio: " + prod.getPrecio()
                    + "\nCantidad: " + prod.getCantidad()
                    + "\n--------------------\n";
        }
    }

    if(resultado.equals("")){
        return "No se encontraron productos en esa categoria";
    }

    return resultado;
}
    
     public String buscarPorId(int id){

    String resultado = "";

    for(ProductoModel prod : datosProd){

        if(prod == null) continue;

        if(prod.getId()==id){

            resultado += "ID: " + prod.getId()
                    + "\nNombre: " + prod.getNombre()
                    + "\nCategoria: " + prod.getCategoria()
                    + "\nPrecio: " + prod.getPrecio()
                    + "\nCantidad: " + prod.getCantidad()
                    + "\n--------------------\n";
        }
    }

    if(resultado.equals("")){
        return "No se encontraron productos con el id: " +id;
    }

    return resultado;
}

public String eliminarProducto(int id){

    for(int i = 0; i < datosProd.length; i++){

        if(datosProd[i] == null) continue;

        if(datosProd[i].getId() == id){


            datosProd[i] = null;

            return "Producto eliminado correctamente";
        }
    }

    return "Producto no encontrado";
}

public String registrarVenta(int id, int cantidadVendida) throws IOException{

    for (ProductoModel prod : datosProd) {

        if (prod == null) continue;

        if (prod.getId() == id) {

            if (prod.getCantidad() < cantidadVendida) {
                return "No hay suficiente stock";
            }

            int total = prod.getPrecio() * cantidadVendida;

            prod.setCantidad(prod.getCantidad() - cantidadVendida);

            String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

            String venta = id + "," + cantidadVendida + "," + total + "," + fechaHora;

            // Guardar en memoria
            ventasEnMemoria.add(venta);

            return "Venta registrada correctamente";
        }
    }

    return "Producto no encontrado";
}

public static void generarReporteVentas() throws IOException {
    String fecha = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
    String nombreArchivo = fecha + "_Ventas.html";

    Desktop.getDesktop().browse(new File(nombreArchivo).toURI());

    StringBuilder filas = new StringBuilder();

    for (String linea : ventasEnMemoria) {
        String[] datos = linea.split(","); // ID,cantidad,total,fechaHora

        if (datos.length >= 4) {
            String[] fechaHora = datos[3].split(" "); // separar fecha y hora
            filas.append("<tr>")
                 .append("<td>").append(datos[0]).append("</td>")
                 .append("<td>").append(datos[1]).append("</td>")
                 .append("<td>").append(datos[2]).append("</td>")
                 .append("<td>").append(fechaHora[0]).append("</td>")
                 .append("<td>").append(fechaHora[1]).append("</td>")
                 .append("</tr>");
        }
    }

    String html =
            """
            <!doctype html>
            <html lang="es">
            <head>
            <meta charset="utf-8">
            <title>Reporte de Ventas</title>
            </head>
            <body>
            <h1>Reporte de Ventas</h1>

            <table border="1">
            <thead>
            <tr>
            <th>Codigo</th>
            <th>Cantidad</th>
            <th>Total</th>
            <th>Fecha</th>
            <th>Hora</th>
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

}

    

