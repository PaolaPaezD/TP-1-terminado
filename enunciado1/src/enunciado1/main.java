package enunciado1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

import ipe.utils.OrderMode;
import ipe.utils.OrderedMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\7 Tecnica\\Desktop\\vita.txt");
		Scanner sc;
		HashMap<String, Integer> contador = new HashMap<String, Integer>();
		// Hashmap es una estructura que vincula una llave con un valor
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {

				String Linea = sc.nextLine();
				String palabra = "";

				for (int i = 0; i < Linea.length(); i++) {
					char c = Linea.charAt(i);
					if (c >= 'A' && c <= 'Z') {
						c -= 'A' - 'a';
						// con esto se pasa mayusculas a minusculas para que sean todas iguales,
						// para que cumpla con la consgina de que "sea insdistinto" el uso de
						// mayusculas o minusculas
					}

					if (c >= 'a' && c <= 'z') {
						palabra += c;
					} else if (!palabra.isEmpty()) {

						// cantidad de veces que aparece la palabra(linea de abajo)
						int cantidad = 1;
						if (contador.containsKey(palabra)) {

							cantidad += contador.get(palabra);

						}
						contador.put(palabra, cantidad);
						System.out.println(palabra + "  :" + cantidad);
						palabra = "";
					}

				}
			}
			ArrayList<Integer> valores = new ArrayList<Integer>();
			ArrayList<String> palabras = new ArrayList<String>();

			// ORDENAR MAYOR A MENOR
			LinkedHashMap<String, Integer> contadorOrdenado =  OrderedMap.sortMapByValue(contador,OrderMode.DESCENDING);
			System.out.println(contadorOrdenado);
			System.out.println(contador);
			int i = 1;
			for (Map.Entry<String, Integer> entry : contadorOrdenado.entrySet()) {
				if (i <= 10) {
					String key = entry.getKey();
					Integer value = entry.getValue();
					
					System.out.println(i + "\t"+key+ "\t"+value);
					i++;

				} else {
					break;
				}

			}


			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}


