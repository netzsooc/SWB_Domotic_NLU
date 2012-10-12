package tokeniser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokeniser {

	/**
	 * @param args
	 * @author NetzSoOc
	 * @version 0.0.1
	 */
	
	public static String join(String[] arr, String conj){
		/**@return String */
		String exit = "";
		for (String item: arr){
			exit = exit.concat(item).concat(conj);
		}
		return exit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] objetos = {
				"foco de la cocina",
				"foco del comedor",
				"foco de la recámara de arriba",
				"foco de la recámara de los niños",
				"recámara principal",
				"foco del estudio"
		};		
		String[] input = {
				"Enciende el foco de la cocina",
				"Enciende el poco la cocina",
				"Entiende el foco la cocina",
				"1,100 del foco de la cocina",
				"100 del foco de la cocina",
				"encender foco de la cocina",
				"función del foco de la cocina al 30%",
				"el foco de la cocina"
		};		
		String[] acciones = {"encend", "apag"};
		
		Pattern MiPat = Pattern.compile("([0-9]{1,3})(%| por ciento)");
		String juntos = join(input, " ").toLowerCase();
		List<String> percents = new ArrayList<String>();
		String[] regreso = new String[5];
		String objeto = null;
		String accion = null;
		String intens = null;
		String diaSem = null;
		String hora = null;

		Arrays.sort(objetos, new MyComparator());
		Matcher m = MiPat.matcher(juntos);
		while(m.find()){
			percents.add(m.group(1));
		}
		if (! percents.isEmpty()){
			Set<String> percentSet = new HashSet<String>(percents);
			
			for (String cant: percentSet){
				int sel = 0;
				if (Collections.frequency(percents, cant) > sel){
					sel = Collections.frequency(percents, cant);
					intens = cant;
				}
			}
		}
		
		for (String objeto1 : objetos){
			if (juntos.contains(objeto1)){
				objeto = objeto1;
				break;				
			}
		}

		int enc = 0;
		int apa = 0;
		
		for (String word: juntos.split(" ")){
			for (String accion1: acciones){
				if (word.startsWith("enciende") || word.startsWith(accion1)){
		
					if (accion1 == "encend" || word.startsWith("enciende"))
						enc ++;
					else
						apa ++;
				}
			}
		}
		
		if (enc == 0 && apa == 0)
			accion = "switch";
		else if (enc > apa )
			accion = "1";
		else if (apa > enc)
			accion = "0";
		
		regreso[0] = accion;
		regreso[1] = objeto;
		regreso[2] = intens;
		regreso[3] = diaSem;
		regreso[4] = hora;
		
		System.out.println(Arrays.toString(regreso));
	}
}
