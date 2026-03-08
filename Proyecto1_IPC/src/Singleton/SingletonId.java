
package Singleton;

/**
 *
 * @author ixche
 */
public class SingletonId {
    private static final SingletonId instancia = new SingletonId();
    private int idProducto = 0;
     public SingletonId(){}
     
     public static SingletonId getInstancia(){
         return instancia;
     }
    
      public int generarId(){
          return idProducto++;
      }
}
