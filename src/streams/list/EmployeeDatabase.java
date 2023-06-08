package streams.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EmployeeDatabase {
	
	// This class is used add some sample List of Employee 

	public static List<Employee> employeeDatabase() {
		return Stream.of(
				new Employee(105, "Manu", "Gowda", "mg@gmail.com", Arrays.asList("9876543234", "6754328976"),
						"Bengaluru", 49045, "DEV"),
				new Employee(109, "Tanu", "Gowda", "tg@gmail.com", Arrays.asList("9875432322", "7775554325"),
						"Bengaluru", 59000, "BA"),
				new Employee(100, "Chaitra", "Vinay", "c@gmail.com", Arrays.asList("8885432322", "6665554325"),
						"Mysore", 26000, "Account Executive"),
				new Employee(117, "Karle", "Pie", "kp@gmail.com", Arrays.asList("7775432322", "9975554325"), "Mysore",
						39000, "DEV"),
				new Employee(999, "Anjali", "Angle", "ag@gmail.com", Arrays.asList("7775400322", "9999554325"), "Dharwad",
						39000, "DEV"))
				.collect(Collectors.toList());
	}

}
