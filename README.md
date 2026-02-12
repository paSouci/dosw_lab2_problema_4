# DOSW Lab 2 - Reto 4

## Integrantes
- Gina Sofia Garcia Zapata
- Juan Diego Patino Munoz

*Descripción:*
El objetivo de este reto fue auditar y rediseñar el sistema de una casa de cambio que anteriormente estafaba a sus clientes usando una tasa de cambio única para todas las divisas. El nuevo sistema permite:

Procesar X cantidad de transacciones de forma secuencial.

Realizar conversiones de una moneda origen a múltiples monedas destino simultáneamente.

Utilizar tasas de cambio reales y competitivas (USD, EUR, JPY, COP).

Generar un reporte consolidado con la sumatoria total por cada divisa convertida.

*Patrón de Diseño*
Comportamiento

*Patrón Utilizado*
Strategy (Estrategia)

*Justificación*
Esto permite que el sistema seleccione el "algoritmo" o la tasa de cambio adecuada dependiendo del par de divisas solicitado. Al separar la lógica de cálculo del flujo de entrada de datos (Scanner), el sistema se vuelve bueno: si las tasas cambian o se agrega una nueva moneda, solo se modifica la estrategia en el Conversor sin alterar el resto del código.

*Cómo lo aplico*
Contexto de Estrategia (Conversor): Clase que contiene el mapa de tasas reales y la lógica de negocio para transformar montos entre divisas usando una base común (USD).

Gestión de Datos (Transaccion): Clase que encapsula la información de cada operación.

Procesamiento Funcional (Streams): Se utilizó flatMap para extraer todas las conversiones de la lista de transacciones y Collectors.

Robustez de Entrada: Se integró una limpieza de búfer mediante sc.nextLine() para permitir ciclos repetitivos de entrada de datos sin errores de desbordamiento en el Scanner.

![input](imagenes/in.jpgen)
![output](imagenes/out.jpgen)
