/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package congresopolitico;

/**
 *
 * @author Eduardo Rivera Geffroy 2SA
 */
public class Gobernador extends Politico{

	public Gobernador(float salarioMin ){
		super( "Gobernador" , salarioMin );
		salarioMensual =  setSalario( salarioMin, norte);
		salarioAnual = salarioMensual*12;
	}
	
	@Override
	public final float setSalario(float salarioMin, boolean norte){
		float salario;
		if ( norte ) {
			salario = salarioMin*550;
		} else {
			salario = salarioMin*520;
		}
		
		return salario;
	}
}
