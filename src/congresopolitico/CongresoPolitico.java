
package congresopolitico;

import java.util.Scanner;
import java.io.PrintStream;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.ArrayList;

/**
 *
 * @author Eduardo Rivera Geffroy 2SA
 */
public class CongresoPolitico {
	static PrintStream out = new PrintStream(System.out, true, UTF_8);
	
	static Scanner leer = new Scanner(System.in);
	static float salarioMin;
	static int opcion;
	
	static ArrayList<Gobernador> gobernadores = new ArrayList<>();
	static ArrayList<Diputado> diputados = new ArrayList<>();
	static ArrayList<Senador> senadores = new ArrayList<>();
	
	public static void main(String[] args) {
		boolean banderaGob = false, banderaSen = false, banderaDip = false;
		
		out.println("`Bienvenido al sistema de registro del Congreso");
		out.print("Para iniciar, se necesesita que proporcione el salario minimo del año actual: ");
		salarioMin = leer.nextFloat();
		
		
		do {
			out.println("\n\nSeleccione la opcion que desea:");
			out.println("1.- Dar de alta un gobernador");
			out.println("2.- Dar de alta un diputado");
			out.println("3.- Dar de alta un senador");
			out.println("4.- Listar los datos demograficos de los politicos con mejor sueldo");
			out.println("5.- Calcular el promedio del salario mensual de los diputados");
			out.println("6.- Listar los datos demograficos del politico con peor sueldo");
			out.println("7.- Calcular el gasto anual en Mexico para el pago de todos los gobernadores, diputados y senadores");
			out.println("8.- Listar los politicos registrados por orden de apellido");
			out.println("9.- Salir");
			
			System.out.print("Opcion elegida: ");
			opcion = leer.nextInt();
			
			switch ( opcion ) {
				case 1 -> {
					gobernadores.add( new Gobernador( salarioMin ) );
					banderaGob = true;
				}
				
				case 2 -> {
					diputados.add( new Diputado( salarioMin ) );
					banderaDip = true;
				}
				
				case 3 -> {
					senadores.add( new Senador( salarioMin ) );
					banderaSen = true;
				}
				
				case 4 -> {
					if ( banderaGob && banderaDip && banderaSen) { //Comprobacion para saber si se han realizado antes los registros
						politicosMejorPagados();
					} else{
						System.out.println("\nEsta opcion no esta disponible, registre al menos un gobernador, diputado y senador");
					}
				}
				
				case 5 -> {
					if ( banderaGob && banderaDip && banderaSen) {
						promedioDiputados();
					} else{
						System.out.println("\nEsta opcion no esta disponible, registre al menos un gobernador, diputado y senador");
					}
				}
				
				case 6 -> {
					if ( banderaGob && banderaDip && banderaSen) {
						politicosPeorPagados();
					} else{
						System.out.println("\nEsta opcion no esta disponible, registre al menos un gobernador, diputado y senador");
					}
				}
				
				case 7 -> {
					if ( banderaGob && banderaDip && banderaSen) {
						calcularGasto();
					} else{
						System.out.println("\nEsta opcion no esta disponible, registre al menos un gobernador, diputado y senador");
					}
				}
				
				case 8 -> {
					if ( banderaGob && banderaDip && banderaSen) {
						mostrarAlfabeticamente();
					} else{
						System.out.println("\nEsta opcion no esta disponible, registre al menos un gobernador, diputado y senador");
					}
				}
				
				case 9 -> System.out.println("Hasta luego!");
				
				default -> out.println("");
			}
			
		} while ( opcion != 9 );
	}//Fin del metodo Main
	
	public static void politicosMejorPagados(){
		int posicionGob = 0, posicionSen = 0, posicionDip = 0;
		float salarioMax = 0;	
		
		System.out.println("--- LISTA DE POLITICOS MEJOR PAGADOS ---");
		
		for (int i = 0; i < gobernadores.size(); i++) {
			if(gobernadores.get(i).salarioAnual > salarioMax  ){
				salarioMax = gobernadores.get(i).salarioAnual;
				posicionGob = i;
			}
		}
		
		System.out.println("\nGobernador mejor pagado: "+ gobernadores.get(posicionGob).mostrarDatosDemograficos() );
		
		salarioMax=0; //Se reinicia el salario maximo para poder volver a usarlo
		for (int i = 0; i < diputados.size(); i++) {
			if(diputados.get(i).salarioAnual > salarioMax  ){
				salarioMax = diputados.get(i).salarioAnual;
				posicionDip = i;
			}
		}
		
		out.println("\nDiputado mejor pagado: "+ diputados.get(posicionDip).mostrarDatosDemograficos() );
		
		salarioMax=0; 
		for (int i = 0; i < senadores.size(); i++) {
			if(senadores.get(i).salarioAnual > salarioMax  ){
				salarioMax = senadores.get(i).salarioAnual;
				posicionSen = i;
			}
		}
		
		out.println("\nSenador mejor pagado: "+ senadores.get(posicionSen).mostrarDatosDemograficos() );
	}//Fin del metodo politicosMejorPagados
	
	public static void promedioDiputados(){
		float salarioTotal=0, salarioFinal;
		System.out.println("--- CALCULAR PROMEDIO DE SALARIO DE DIPUTADOS ---");
		
		for (int i = 0; i < diputados.size(); i++) {
			salarioTotal += diputados.get(i).salarioMensual;	
		}
		
		salarioFinal = salarioTotal/diputados.size();
		System.out.println("El promedio de salario mensual para diputados es de: "+salarioFinal+" pesos");
	}//Fin del metodo promedioDiputados
	
	public static void politicosPeorPagados(){
		
		System.out.println("\n--- POLITICO PEOR PAGADO ---");
		/*
		Todos los diputados son los peor pagados, asi que habria que buscar 
		solo a los que no sean del norte, ya que todos ellos tendran los salarios
		mas bajos por igual
		*/
		for (int i = 0; i < diputados.size(); i++) {
			if ( diputados.get(i).norte == false ) {
			System.out.println("\nNombre: "+diputados.get(i).nombre+" "+diputados.get(i).apellidos );
			System.out.println("Entidad que representa: "+diputados.get(i).entidad);
			System.out.println("Partido politico: "+diputados.get(i).nombrePartido );
			}
		}
		
	}//Fin del metodo PoliticoPeorPagado
	
	public static void calcularGasto(){
		float salarioTotal=0;
		System.out.println("--- CALCULAR GASTO TOTAL ---");
		
		for (int i = 0; i < gobernadores.size(); i++) {
			salarioTotal += gobernadores.get(i).salarioMensual;	
		}
		
		for (int i = 0; i < senadores.size(); i++) {
			salarioTotal += senadores.get(i).salarioMensual;	
		}
		
		for (int i = 0; i < diputados.size(); i++) {
			salarioTotal += diputados.get(i).salarioMensual;	
		}
		
		System.out.println("El gasto total en salarios al mes es de: "+salarioTotal+" pesos");
	}//Fin del metodo calcularGasto
	
	public static void mostrarAlfabeticamente( ){
		System.out.println("--- MOSTRAR A TODOS LOS POLITICOS DE FORMA ALFABETICA ---");
		gobernadores.sort( (e1, e2) -> e1.apellidos.compareTo( e2.apellidos ) );
		diputados.sort( (e1, e2) -> e1.apellidos.compareTo( e2.apellidos ) );
		senadores.sort( (e1, e2) -> e1.apellidos.compareTo( e2.apellidos ) );
		
		System.out.println("Gobernadores: \n");
		for (int i = 0; i < gobernadores.size(); i++) {
			System.out.println( (i+1) +".- "+ gobernadores.get(i).apellidos+" "+gobernadores.get(i).nombre );
		}
		
		System.out.println("Diputados: \n");
		for (int i = 0; i < diputados.size(); i++) {
			System.out.println( (i+1) +".- "+ diputados.get(i).apellidos+" "+diputados.get(i).nombre );
		}
		
		System.out.println("Senadores: \n");
		for (int i = 0; i < senadores.size(); i++) {
			System.out.println( (i+1) +".- "+ senadores.get(i).apellidos+" "+senadores.get(i).nombre );
		}
		
	}
}
