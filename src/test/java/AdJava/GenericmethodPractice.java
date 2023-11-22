package AdJava;


public class GenericmethodPractice {

	public static void main(String[] args) {
		int sum = add(10,10);//caller/calling method
		System.out.println(sum);
	}

	
	public static int add(int a,int b)//called method
	{
		int c=a+b;
		return c;
	}
	
	
	
	
}

