
package congresopolitico;

import java.util.Scanner;
import java.io.PrintStream;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 *
 * @author Eduardo Rivera Geffroy 2SA
 */

public abstract class Politico {
	String nombre, apellidos, genero, gradoAcademico, ciudadRes, nombrePartido, entidad;
	int edad, inicioPolitica;
	float salarioMensual, salarioAnual;
	boolean norte;

	public Politico( String puesto, float salarioMin ) {
		PrintStream out = new PrintStream(System.out, true, UTF_8);
		Scanner leer = new Scanner(System.in);
		int opcion;
		
		System.out.println("\n---REGISTRO---");
		System.out.println("-- Datos demograficos del "+puesto+" ---");
		System.out.print("Escriba el nombre del "+puesto+": ");
		nombre = leer.nextLine();
		
		leer.nextLine();
		
		System.out.print("Escriba los apellidos del "+puesto+": ");
		apellidos = leer.nextLine();
		
		System.out.print("Escriba la edad del "+puesto+": ");
		edad = leer.nextInt();
		
		leer.nextLine(); // Los nextLine() sin asignacion limpian el input
		
		System.out.print("Escriba el genero del "+puesto+": ");
		genero = leer.nextLine();
		
		
		leer.nextLine();
		
		System.out.print("Escriba el grado academico del "+puesto+": ");
		gradoAcademico = leer.nextLine();
		
		leer.nextLine();
		
		System.out.print("Escriba la ciudad de residencia del "+puesto+": ");
		ciudadRes = leer.nextLine();
		
		System.out.println("\n---Datos del partido---");
		out.print("En que año se inicio en la politica?: ");
		inicioPolitica = leer.nextInt();
		
		leer.nextLine();
		
		out.print("Nombre del partido politico: ");
		nombrePartido = leer.nextLine();
		
		leer.nextLine();
		
		out.print("Nombre de la entidad representada: ");
		entidad = leer.nextLine();
		
		out.println("La entidad representada se encuentra en la zona norte del pais?");
		out.print("Escriba 1 para Si, 2 para No: ");
		opcion = leer.nextInt();
		
		norte = (opcion == 1); 
		//Si la condicion se cumple norte valdra True, si no, valdra False
	}
	
	public abstract float setSalario(float salarioMin, boolean norte);
	
	public String mostrarDatosDemograficos(){
		return "\nNombre: "+nombre+" "+apellidos+
				"\nEdad: "+edad+
				"\nGenero: "+genero+
				"\nGrado Academico: "+gradoAcademico+
				"\nCiudad de residencia: "+ciudadRes;
	}
}
