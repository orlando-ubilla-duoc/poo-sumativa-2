package cl.duoc.llanquihuetourapp.excepciones;

/**
 * Excepción personalizada para indicar que un RUT no cumple el formato esperado.
 */
public class RutInvalidoException extends Exception {

	public RutInvalidoException(String mensaje) {
		super(mensaje);
	}

}