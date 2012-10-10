package tokeniser;

import java.util.Arrays;

public class Tokeniser {

	/**
	 * @param args
	 */
	public int compare(String o1, String o2) {  
	      if (o1.length() > o2.length()) {
	         return 1;
	      } else if (o1.length() < o2.length()) {
	         return -1;
	      }
	      return o1.compareTo(o2);
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
				"función del foco de la cocina",
				"el foco de la cocina"
		};
		Arrays.sort(objetos, new MyComparator());
		boolean flag = false;

		for (String objeto: objetos){
			for (String comando: input){
				
				if (comando.contains(objeto)){
					flag = true;
					break;
				}
				
			}
			if (flag){
				break;
			}
		}
				
	}

}
