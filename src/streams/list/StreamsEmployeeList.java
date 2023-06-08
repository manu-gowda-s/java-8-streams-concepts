package streams.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamsEmployeeList {

	public static void main(String[] args) {

		// Get the List of Employee from EmplyoeeDatabase
		List<Employee> empList = EmployeeDatabase.employeeDatabase();

		// Iterate Employee using Java 8
		 empList.stream().limit(2).forEach(System.out::println);
		 

		// Get all the Employee name where Department = DEV
		List<String> empNames = empList.stream().filter(dept -> dept.getDept().equalsIgnoreCase("Dev"))
				.map(name -> name.getFirstName())
				.collect(Collectors.toList());
		System.out.println("Getting Employee By Dept : " + empNames);
		

		// Get all the Employee name where Department is DEV and City is Bengaluru
		empList.stream().filter(emp -> emp.getDept().equals("DEV") && emp.getWorkLocation().equals("Bengaluru"))
				.distinct()
				.map(name -> name.getFirstName())
				.forEach(System.out::println);
		

		// Count the number of employee whos work location is Mysore
		long mysoreEmp = empList.stream().filter(city -> city.getWorkLocation().equalsIgnoreCase("mysore"))
				.count();
		System.out.println("Total Number of Employees in Mysore is " + mysoreEmp);
		

		// Get the maximum salary
		double maxSal = empList.stream().filter(sal -> sal.getSalary() >= 0)
				.max(Comparator.comparing(Employee::getSalary))
				.get().getSalary();
		System.out.println("The Highest Salary is : " + maxSal);
		

		// Get the minimum Salary of Employee
		double minSal = empList.stream().filter(sal -> sal.getSalary() >= 0)
				.min(Comparator.comparingDouble(Employee::getSalary))
				.get().getSalary();
		System.out.println("The Lowest Salary is : " + minSal);
		

		// Convert Employee Names into Array<String>
		Object[] names = empList.parallelStream().filter(name -> name.getFirstName() != null)
				.toArray();
		System.out.println("The number employess are : " + names.length);
		for (Object ans : names) 
		{
			System.out.println(ans);
		}
		

		// reduce()
		// output : Manu-Tanu-Chaitra-Karle
		Optional<String> empReduceName = empList.stream()
				.map(name -> name.getFirstName())
				.reduce((str1, str2) -> str1 + "-" + str2);
		System.out.println("Reduce FirstNames : " + empReduceName.get());
		

		// Sort the Employee By ID using Comparable in Asen order
		empList.stream().sorted().forEach(System.out::println);

		// Sort Employee Name by Asending order
		empList.stream().filter(sal -> sal.getFirstName() != null)
				.map(n -> n.getFirstName()).sorted()
				.forEach(System.out::println);
		

		// Calulate the SUM of all the Salary
		double sum = empList.stream().filter(s -> s.getSalary() >= 0)
				.mapToDouble(Employee::getSalary)
				.sum();
		System.out.println("Total SUM of Salary is : " + sum);
		

		// calulate the AVG salary of all the Employees
		OptionalDouble avg = empList.stream().filter(s -> s.getSalary() >= 0)
				.mapToDouble(Employee::getSalary)
				.average();
		System.out.println("The AVG salary of all the Employee is : " + avg.getAsDouble());
		

		// // calulate the AVG salary of DEV Department
		OptionalDouble devTeamAvgSalary = empList.stream()
							.filter(dept -> dept.getDept() == "DEV")
							.mapToDouble(Employee::getSalary)
							.average();
		System.out.println("DEV Department Averge Salary is : " + devTeamAvgSalary.getAsDouble());
		

		// count the number of emplyee from DEV Department
		long deptCount = empList.stream()
				.filter(d -> d.getDept().equalsIgnoreCase("dev"))
				.count();
		System.out.println("The total employee in DEV Department are : " + deptCount);
		

		// Sort the List of Employees By Name using Comparator<>
		System.out.println("----- Employee List after Sorting By Name -------");
		Collections.sort(empList, Employee.NAMECOMPARATOR);
		System.out.println(empList);
		

		// Increment Salary of Employee by 20 %
		empList.stream()
			   .filter(sal -> sal.getSalary() >= 0)
			   .forEach(s -> s.setSalary(s.getSalary() * 1.2));
		System.out.println("Salary after Hike of 20%");
		empList.stream().forEach(System.out::println);
		

		// Decrement Salry of Employee by 10 %
		empList.stream()
			   .filter(s -> s.getSalary() >= 0)
			   .forEach(emp -> emp.setSalary(emp.getSalary() * 0.9));
		System.out.println("Salry after 10% decrement to Employees");
		empList.stream().forEach(System.out::println);

	}

}
