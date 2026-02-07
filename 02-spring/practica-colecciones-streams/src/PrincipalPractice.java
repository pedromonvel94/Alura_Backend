import java.util.*;
import java.util.stream.Collectors;

public class PrincipalPractice {
    public static void main(String[] args) {
        //Colecciones
        //List, Sirve para ordenacion, permite la duplicidad, y tinen 2 implementaciones (ArrayList y Linked List) y las operaciones mas comunes son (add, remove, contains, get, size)
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Juan");
        nombres.add("Miguel");
        nombres.add("Juan");

        System.out.println(nombres);
        System.out.println(nombres.get(1));

        nombres.remove(0);

        //Set, NO se preocupa por el orde, NO permite duplicidad, implementacion: HashSet, LinkedHashSet, TreeSet
        Set<String> nombresSet = new HashSet<>();

        nombresSet.add("Boligrafo");
        nombresSet.add("Agua");
        nombresSet.add("Gaseosa");
        nombresSet.add("Television");
        nombresSet.add("Control");
        nombresSet.add("Agua");

        System.out.println(nombresSet);

        //Map, Son pares clave valor, no permite claves duplicadas, implementaciones: HashMap, LinkedHashMap, TreeMap, y las operaciones mas comunes son: put, get, remove, containsKey, keySeT
        Map<Integer, String> empleados = new HashMap<>();

        empleados.put(1, "Juan");
        empleados.put(2, "Miguel");
        empleados.put(3, "Juan");
        empleados.put(4, "Miguel");
        empleados.put(1, "Pedro");

        System.out.println(empleados);
        System.out.println(empleados.get(1));

        empleados.put(7, "Alberto");

        System.out.println(empleados);
        System.out.println(empleados.get(7));

        /*Estás desarrollando un sistema para gestionar los nombres de los empleados de una empresa de tecnología. El sistema debe permitir que nuevos empleados sean añadidos a una lista de nombres.
        Tu tarea es crear una lista de cadenas (strings) y agregar los nombres de los empleados "Juan", "María", "Carlos" y “Ana” a esa lista. Luego, imprime la lista para verificar si los nombres fueron añadidos correctamente.
        Salida esperada:
        Lista de empleados: [Juan, Maria, Carlos, Ana]
        */

        List<String> empleadosLista = new ArrayList<>();

        empleadosLista.add("Juan");
        empleadosLista.add("Maria");
        empleadosLista.add("Carlos");
        empleadosLista.add("Ana");

        System.out.println("Lista de empleados: " + empleadosLista);

        /*
        --------------------------------------------------------------------------------------------------
        */
        List<String> empleadosLista2 = List.of("Juan", "Miguel", "Andrea", "Alberto");
        List<String> empleadosLetraA = empleadosLista2.stream()
                .filter(empleado -> empleado.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Lista de empleados: " + empleadosLista2);
        System.out.println("Lista de empleados: " + empleadosLetraA);

        List<Double> valorVentas = List.of(200.0, 4000.0, 50.0);
        List<Double> comision = valorVentas.stream()
                .map(venta -> venta * 0.05)
                .collect(Collectors.toList());
        System.out.println("Valor de ventas: " + valorVentas);
        System.out.println("Lista de comision: " + comision);

        List<Double> comisionFilter = valorVentas.stream()
                .map(venta -> venta * 0.05)
                .filter(valor -> valor > 12.0)
                .collect(Collectors.toList());
        System.out.println("Valor de ventas: " + valorVentas);
        System.out.println("Lista de comision: " + comisionFilter);

        double valorTotalDeVentas = valorVentas.stream()
                .reduce(0.0, Double::sum);

        System.out.println("Valor de ventas: " + valorTotalDeVentas);


    }
}
