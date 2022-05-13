
package congresopolitico;

/**
 *
 * @author Eduardo Rivera Geffroy 2SA
 */
public class Senador extends Politico{

	public Senador(float salarioMin) {
		super( "Senador" , salarioMin );
		salarioMensual =  setSalario( salarioMin, norte);
		salarioAnual = salarioMensual*12;
	}
	
	@Override
	public final float setSalario(float salarioMin, boolean norte){
		float salario;
		if ( norte ) {
			salario = salarioMin*598;
		} else {
			salario = salarioMin*588;
		}
		
		return salario;
	}
	
}
