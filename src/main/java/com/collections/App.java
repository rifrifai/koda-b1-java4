package com.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		// Thread tugasThread = new Thread(() -> {
		// 	System.out.println("===============================");
		// 	System.out.println("tugas thread berjalan dilayar belakang...");
		// 	System.out.println("===============================");
		// });
		// tugasThread.start();

		Employee muzaki = new Employee("EMP001", "Muzaki", 1000_000);
		Employee anam = new Employee("EMP002", "Anam", 2000_000);
		Employee hasan = new Employee("EMP003", "Hasan", 3000_000);
		
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(muzaki);
		empList.add(anam);
		empList.add(hasan);
		// System.out.println("Account List - Using ArrayList");
		System.out.println("===============================");
		System.out.println("Lambda & Function Interface");
		System.out.println("===============================");
		System.out.println("Tampilkan Employee dengan balance >= 1500_000 dan Urutkan dari yang terbesar");

		// for (Employee e : empList) {
		// 	System.out.println(e.getAccountID() + " - " + e.getName() + " - " + e.getBalance());
		// }
		// empList.forEach(emp -> {
		// 	System.out.println(emp.getAccountID() + " - " + emp.getName() + " - " + emp.getBalance());
		// });

		List<Employee> sortedEmp = empList.stream().sorted(Comparator.comparingLong(Employee::getBalance).reversed()).filter(employee -> employee.getBalance() >= 1500_000).toList();
		sortedEmp.forEach((employee -> System.out.printf("%s : Rp %d%n", employee.getName(), employee.getBalance())));
		System.out.println("===============================");

		System.out.println("Ambil daftar nama");
		List<String> empName = empList.stream().map(Employee::getName).toList();
		System.out.println(empName);
		System.out.println("===============================");

		System.out.println("Cari account berdasarkan ID menggunakan Optional");
		try {
			Employee emp = findAccount(empList, "EMP005").orElseThrow(() -> new NoSuchElementException("ID not found!"));
			System.out.println(emp.getName());
			System.out.println("===============================");

		} catch (NoSuchElementException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("===============================");
		}

		// Map<String, Employee> empMap = new LinkedHashMap<>();
		// empMap.put("A1", muzaki);
		// empMap.put("A2", anam);
		// empMap.put("A3", hasan);
		// System.out.println("Account List - Using Map");
		// empMap.forEach((key, employee) -> {
		// 	System.out.println(employee.getAccountID() + " - " + employee.getName() + " - " + employee.getBalance());
		// });		
		// System.out.println("===============================");

		// Set<Employee> empSet = new HashSet<>();
		// empSet.add(muzaki);
		// empSet.add(hasan);
		// empSet.add(anam);
		// System.out.println("Account List - Using Set");
		// for (Employee e : empSet) {
		// 	System.out.println(e.getAccountID() + " - " + e.getName() + " - " + e.getBalance());
		// }
		// System.out.println("===============================");

		// Queue<Employee> empQue = new ArrayDeque<>();
		// empQue.add(muzaki);
		// empQue.add(hasan);
		// empQue.add(anam);
		// System.out.println("Account List - Using Queue");
		// for (Employee e : empQue) {
		// 	System.out.println(e.getAccountID() + " - " + e.getName() + " - " + e.getBalance());
		// }
		// System.out.println("===============================");
	}

	// Optional
	// ## orElse()

	static Optional<Employee> findAccount(List<Employee> empList, String number) {
		return empList.stream().filter(emp -> emp.getAccountID().equals(number)).findFirst();
	};
}
