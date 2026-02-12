package lab2.problema4;

import java.util.*;
import java.util.stream.Collectors;

public class Conversor {
	private static final Map<String, Double> TASAS_A_USD = Map.of(
		"USD", 1.0,
		"EUR", 1.08,
		"JPY", 0.0066,
		"COP", 0.00025
	);

	public static double realizarConversion(double monto, String origen, String destino) {
		if (!TASAS_A_USD.containsKey(origen) || !TASAS_A_USD.containsKey(destino)) {
			return 0;
		}
		double montoEnUSD = monto * TASAS_A_USD.get(origen);
		return montoEnUSD / TASAS_A_USD.get(destino);
	}
}
