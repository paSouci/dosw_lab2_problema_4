package lab2.problema4;

import java.util.*;
import java.util.stream.Collectors;

public class App {
	private static void test () {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		List<Transaccion> historial = new ArrayList<>();

		System.out.print("Ingrese número de transacciones: ");
		int n = 0;

		if (sc.hasNextInt()) {
			n = sc.nextInt();
		} else {
			System.out.println("Error: Debe ingresar un número entero.");
			return;
		}

		for (int i = 1; i <= n; i++) {
			System.out.println("\nTransacción " + i + "");

			System.out.print("Ingrese monto: ");
			double monto = sc.nextDouble();

			System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
			String origen = sc.next().toUpperCase();

			System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
			String destinosRaw = sc.next().toUpperCase();

			sc.nextLine();

			String[] destinos = destinosRaw.split(",");
			Transaccion t = new Transaccion(monto, origen);

			for (String d : destinos) {
				String monedaDestino = d.trim(); // Limpia espacios accidentales
				double resultado = Conversor.realizarConversion(monto, origen, monedaDestino);
				t.agregarConversion(monedaDestino, resultado);
			}
			historial.add(t);
		}

		System.out.println("           RESUMEN DE CAJA TOTAL        ");
		historial.forEach(t -> {
			System.out.printf("\nTransacción Original: %.2f %s\n", t.getMontoOrigen(), t.getMonedaOrigen());
			t.getConversiones().forEach((moneda, valor) -> System.out.printf("  -> Convertido a %s: %.2f %s\n", moneda, valor, moneda));
		});

		System.out.println("\nTOTALES POR MONEDA");
		Map<String, Double> totales = historial.stream()
			.flatMap(t -> t.getConversiones().entrySet().stream())
			.collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingDouble(Map.Entry::getValue)
		));

		totales.forEach((moneda, total) ->
				System.out.printf("%s: %.2f %s\n", moneda, total, moneda));
		System.out.println("\n¡Servicio finalizado con éxito!");
	}

	public static void main (String [] args) {
		test();
	}
}
