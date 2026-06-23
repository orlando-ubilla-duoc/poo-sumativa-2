package cl.duoc.llanquihuetourapp.model;

import cl.duoc.llanquihuetourapp.excepciones.RutInvalidoException;

public class Rut {

	private String rut;
	private String dv;

	/**
	 * Constructor que recibe un RUT completo (sin puntos, con guion y dígito verificador).
	 * <br/>Valida el formato y comprueba el dígito verificador.
	 * @param rut El RUT completo (ejemplo:"12345678-K")
	 * @throws IllegalArgumentException Si el formato del RUT es inválido o el dígito verificador no coincide con el calculado.
	 * @throws RutInvalidoException Si el RUT es inválido.
	 */
	public Rut(String rut) throws RutInvalidoException {

		this.rut = validateRutFormat(rut);

		String[] partes = rut.split("-");

		if( partes.length<2 ){
			throw new RutInvalidoException("RUT inválido: Debe contener un guion separador.");
		}

		this.dv = validateDVFormat(partes[0]);

		if( !this.dv.equalsIgnoreCase(partes[1]) ){
			throw new RutInvalidoException("RUT "+partes[0]+" inválido: Dígito verificador '"+partes[1]+"' no coincide.");
		}
	}

	/**
	 * Devuelve el RUT completo (sin puntos, con guion y dígito verificador).
	 * @return El RUT completo (ejemplo:"12345678-K")
	 */
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * Valida el formato del RUT completo (sin puntos, con guion y dígito verificador).
	 * @param rut El RUT completo (ejemplo:"12345678-K")
	 * @throws RutInvalidoException Si el formato del RUT no es válido.
	 * @return El RUT completo en mayúsculas.
	 */
	private String validateRutFormat(String rut) throws RutInvalidoException{
		if( rut==null || !rut.matches("[0-9]+-[0-9kK]") ){
			throw new RutInvalidoException("El RUT '" + rut + "' no tiene un formato válido. Debe seguir el patrón XXXXXXXX-Y.");
		}
		return rut.toUpperCase();
	}

	/**
	 * Calcula el dígito verificador para un RUT dado (sin puntos ni guion).
	 * @param rut El RUT sin puntos ni guion (ejemplo:"12345678")
	 * @return El dígito verificador calculado (ejemplo:"K" o "0")
	 */
	private String validateDVFormat(String rut) {
		int suma          = 0;
		int multiplicador = 2;
		for( int i=(rut.length()-1); i>=0; i-- ){
			suma += Character.getNumericValue(rut.charAt(i)) * multiplicador;
			multiplicador++;
			if( multiplicador > 7 ){
				multiplicador = 2;
			}
		}
		int resto = suma % 11;
		int dvCalculado = 11 - resto;
		switch( dvCalculado ){
			case 11:
				return "0";
			case 10:
				return "K";
			default:
				return String.valueOf(dvCalculado);
		}
	}

}