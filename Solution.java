
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
public class Solution{
	
	public static void main(String args[])
	{
		
		
		//employees.forEach(System.out::println);
	}
	public static List<EmployeeBean> parrallel(int k)
	{
		List<EmployeeBean> employees;
		long startTime=System.currentTimeMilli();
		List<Integer>numbers=Stream.iterate(0,n->n+1).limit(k).collect(Collectors.toList());
		employees=numbers.parallelStream().map(e->EmployeeBean.getRandom(e+"")).collect(Collectors.toList());
		long endTime=System.currentTimeMilli();
		System.out.println("Time taken : " +(endTime-startTime)+" Size : "+employees.size());
		return employees;
	}
	/*
	public static void func1() throws ClassNotFoundException,FileNotFoundException
	{
		func2();
		throw new ClassNotFoundException();
	}
	public static void func2() throws FileNotFoundException
	{
		throw new FileNotFoundException();
	}
	*/
	
}