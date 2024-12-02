
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.Map;

import java.util.ArrayList;
import java.util.stream.*;
import java.lang.instrument.Instrumentation;
public class Solution{
	
	public static void main(String args[])
	{
		/*
		int n=5_000;
		System.out.println("Program Started");
		
		IntStream.range(0,10).forEach(e->{
			try{
			Thread.sleep(3000);}
			catch(InterruptedException ex)
		{
			System.out.println(ex);
		}
			System.out.println("Program Processing");});
	
		
		System.out.println("Program Ended");
		
		*/
	
		//List<String> stringlist= Arrays.asList("hat","cat","bat","rat","sat","fat");
		//developer branch
		//stringlist.forEach(System.out::println);
		List<EmployeeBean> employees= sequential(100);
		Map<Department,List<String>> map =employees.stream().sorted((a,b)->a.name().compareTo(b.name())).collect(Collectors.groupingBy(EmployeeBean::department,Collectors.mapping(EmployeeBean::name,Collectors.toList())));
		map.keySet().stream().forEach(e->{
			System.out.println(e+" : "+map.get(e));
		});
		List<EmployeeBean> sortedList=sortedList(employees);
		sortedList.forEach(System.out::println);
		//employees.forEach(System.out::println);
	}
	public static  List<EmployeeBean> sortedList(List<EmployeeBean> employeeList)
	{
		return employeeList.stream().sorted((a,b)->b.name().compareTo(a.name())).toList();
	}
	public static List<EmployeeBean> parallel(int k)
	{
		List<EmployeeBean> employees=null;
		long startTime=System.currentTimeMillis();
		/*ForkJoinPool forkJoinPool = new ForkJoinPool(4); // Limit the number of threads
employees = forkJoinPool.submit(() -> Stream.iterate(0,n->n+1).limit(k).parallel()
                                             .map(e -> EmployeeBean.getRandom(e + ""))
                                             .collect(Collectors.toList()))
                        .join();*/
		
			// Limit the number of threads
 Stream.iterate(0,n->n+1).limit(k).parallel().forEach(e->{
	 try{
	 Thread.sleep(100);}
	catch(InterruptedException ex)
		{
			System.out.println(ex);
		}
 });
											 
                        
		
		long endTime=System.currentTimeMillis();
		System.out.println("Time taken : " +(endTime-startTime)+"ms Size : "+(employees!=null?employees.size():0));
		return employees;
	}
	public static List<EmployeeBean> sequential(int k)
	{
		List<EmployeeBean> employees=null;
		long startTime=System.currentTimeMillis();
		
		employees=IntStream.range(0,k).mapToObj(e->EmployeeBean.getRandom(e+"")).collect(Collectors.toList());

		long endTime=System.currentTimeMillis();
		System.out.println("Time taken : " +(endTime-startTime)+"ms Size : "+(employees!=null?employees.size():0));
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
	C:\Users\digvi\OneDrive\Desktop\simple java programs>java -Xmx8g Solution
Time taken : 641781ms Size : 50000000
Time taken : 72943ms Size : 50000000
	*/
	//
	//
}