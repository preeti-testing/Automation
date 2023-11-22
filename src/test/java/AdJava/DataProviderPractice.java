package AdJava;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	
	@Test(dataProvider = "getData")
	public void readdata(String Name,String Model,int qnt,int price)
	{
		System.out.println(Name+"--"+Model+"---"+qnt+"--"+price);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[3][4];
		
		data[0][0]="samsung";
		data[0][1]="A80";
		data[0][2]=12;
		data[0][3]=12000;	
		
		data[1][0]="iphone";
		data[1][1]="i15";
		data[1][2]=10;
		data[1][3]=20000;
		
		data[2][0]="vivo";
		data[2][1]="v15";
		data[2][2]=5;
		data[2][3]=10000;
		
		return data;
		
		
		
	}
	

}
