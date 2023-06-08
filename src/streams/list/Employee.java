package streams.list;

import java.util.Comparator;
import java.util.List;

import javax.print.attribute.standard.Compression;

public class Employee implements Comparable<Employee> {

	// This sample Employee POJO class

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private List<String> mobileNumber;
	private String workLocation;
	private double salary;
	private String dept;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, String email, List<String> mobileNumber,
			String workLocation, double salary, String dept) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.workLocation = workLocation;
		this.salary = salary;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(List<String> mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", workLocation=" + workLocation + ", salary=" + salary + ", dept="
				+ dept + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((workLocation == null) ? 0 : workLocation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (workLocation == null) {
			if (other.workLocation != null)
				return false;
		} else if (!workLocation.equals(other.workLocation))
			return false;
		return true;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}

	public static Comparator<Employee> NAMECOMPARATOR = new Comparator<Employee>() {

		@Override
		public int compare(Employee arg0, Employee arg1) {
			// TODO Auto-generated method stub
			return arg0.getFirstName().compareTo(arg1.getFirstName());
		}

	};

}
