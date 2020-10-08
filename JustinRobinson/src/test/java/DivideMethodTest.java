import JUnitAssignment;
import org.junit.*;
public class DivideMethodTest{
	
	@Test(expected = IllegalArgumentException.class)
	public void divideByZeroShouldThrowException(){
		divide(5,0);
	}
}