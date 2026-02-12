package lab2.problema4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Representa una transacción individual con sus conversiones.
 */
public class Transaccion {
	private String monedaOrigen;
	private double montoOrigen;
	private Map<String, Double> conversiones = new HashMap<>();

	public Transaccion(double monto, String origen) {
		this.montoOrigen = monto;
		this.monedaOrigen = origen;
	}

	public void agregarConversion(String destino, double montoConvertido) {
		conversiones.put(destino, montoConvertido);
	}

	public String getMonedaOrigen() { return monedaOrigen; }
	public double getMontoOrigen() { return montoOrigen; }
	public Map<String, Double> getConversiones() { return conversiones; }
}
