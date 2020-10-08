package JUnitAssignment;
public class DivideMethod{
	public static int divide(int a, int b){
		if(b == 0){
			throw new IllegalArgumentException("Cannot divide by 0");
		}
		else{
			return (int)a/b;
		}
	}
	public static void main(String[] args){
		System.out.println(divide(2,1));
		System.out.println(divide(1,0));
	}
}