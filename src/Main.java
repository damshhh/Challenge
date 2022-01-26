import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.plaf.synth.SynthScrollBarUI;

import java.util.Set;

public class Main {

	public static final String SEPARATOR=";";
	public static final String QUOTE="\"";
	public static  Integer total=0;
	public Integer promedioEdadRacing = 0; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;
		List<Socio> listaSocios = new ArrayList<Socio>();
		
		List<Socio> listaSociosRacing = new ArrayList<Socio>();
		
		List<Socio> listaSociosCasados = new ArrayList<Socio>();
		
		List<Socio> listaSociosRiver = new ArrayList<Socio>();
		
				
		Integer edadPromedioRacing = 0;
		Integer contadorPersonasCasadas = 0;
		Integer contadorPersonas = 0;		
		Integer cantidad = 0;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		try { 
			br = new BufferedReader(new FileReader("archivo/socios.csv")); // leo el archivo
			String line = br.readLine();
	         while (null!=line) {
	            String [] fields = line.split(SEPARATOR);
	            
	            
	            fields = removeTrailingQuotes(fields);
	           
	            
	            Socio socio = new Socio();	// armo un objeto para poder manipular sus atributos y lo seteo con los datos leidos
	            socio.setNombre(fields[0]);
	            socio.setEdad(Integer.parseInt(fields[1]));
	            socio.setEquipo(fields[2]);
	            socio.setEstadoCivil(fields[3]);
	            socio.setNivelEstudios(fields[4]);
	            
	         // empiezo a hacer las comprobaciones que quiera
	            	          
	            										            
	            if(fields[2].equals("Racing")) { //junto a los hinchas de Racing para calcular el promedio de su edad
	            	listaSociosRacing.add(socio);
	            	edadPromedioRacing = edadPromedioRacing + socio.getEdad();
	            	contadorPersonas++;
	            }
	            
	            if(contadorPersonasCasadas<=99){
	            	if(fields[3].equals("Casado") && fields[4].equals("Universitario")){ //junto a los Casados y con Nivel Universitario
	            	listaSociosCasados.add(socio);
	            	contadorPersonasCasadas++;
	            	}
	            }
	            
	            if(fields[2].equals("River")) {	            
	            		listaSociosRiver.add(socio);
	            		cantidad = map.getOrDefault(socio.getNombre(),0);
			            map.put(socio.getNombre(), cantidad+1);            	
	            }
	            
          
	            listaSocios.add(socio); //agrego al socio a una lista de socios universal
	            
	            total++;
	            line = br.readLine();
	         }
	         
	         
	         System.out.println("\nCantidad total de usuarios registrados: " + total+"\n"); //imprimo la cantidad total de usuarios
	         System.out.println("\n-------------------------------------------------\n");
		     System.out.println("El promedio de edad de los socios de Racing es : " + edadPromedioRacing / contadorPersonas); 
		     System.out.println("\n-------------------------------------------------\n");
	         System.out.println("PRIMERAS 100 PERSONAS CASADAS Y UNIVERSITARIOS\n");
	          
	         Collections.sort(listaSociosCasados); //ordeno la listaSociosCasados de menor a mayor segun la edad
	          
	         for(Socio socio : listaSociosCasados) { //y la muestro ordenada
	        	 System.out.println(socio.getNombre()+" | "+ socio.getEdad()+" | "+ socio.getEquipo());

	         }
	         	         
	         System.out.println("\nCantidad de personas en la lista: " + listaSociosCasados.size());  //imprimo la cantidad de gente para verificar que sean las primeras 100 
	         
	         System.out.println("\n--------------------");
	         System.out.println("Hinchas river: " + listaSociosRiver.size()+"\n");
	         System.out.println("Veces que se repite cada nombre: \n");
	         
	         List<Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
	          list.sort(Entry.comparingByValue());
	          list.forEach(System.out::println);
	         
	         System.out.println("\nLos 5 nombres mas comunes entre los hinchas de river son : Martín ,Matías, Nicolás, Luis y Daniel\n-------------------------");
	         
	      } catch (Exception e) {
	        
	      } finally {
	         if (null!=br) {
	            br.close();
	         }
	      }
		}

	private static String[] removeTrailingQuotes(String[] fields) {
		String result[] = new String[fields.length];

	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
	      }
	      return result;
	}
	}


