/**
 * @author: Angel Eduardo Martínez Leo Lim
 * @date: 05/31/2019
 */
package serviciosocialfei.dao;

public class ExcepcionSistema extends Exception{
    int codigoError;
    public ExcepcionSistema(String mensaje, int codigoError) {
        super(mensaje);
        this.codigoError = codigoError;
    }
}
