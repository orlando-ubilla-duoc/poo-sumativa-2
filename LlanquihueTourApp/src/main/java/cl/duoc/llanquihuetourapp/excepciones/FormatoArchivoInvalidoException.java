package cl.duoc.llanquihuetourapp.excepciones;

/**
 * Excepción personalizada para indicar que un archivo no cumple el formato esperado.
 */
public class FormatoArchivoInvalidoException extends Exception {

	public FormatoArchivoInvalidoException(String mensaje) {
		super(mensaje);
	}

}