package com.test.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("employee1", 8888.88));
		employees.add(new Employee("employee2", 18888.88));

		BigDecimal[] expenses = listToArray(employees, new EmployeeToExpenses());
		for (BigDecimal expense : expenses) {
			System.out.println(expense.toString());
		}
	}

	public static BigDecimal[] listToArray(List<Employee> employees, Function<Employee, BigDecimal> function) {
		BigDecimal[] expenses = null;

		if (null != employees) {
			expenses = new BigDecimal[employees.size()];
			for (int i = 0; i < employees.size(); i++) {
				expenses[i] = function.apply(employees.get(i));
			}
		}

		return expenses;
	}

	/**
	 * Function作用
	 * 
	 * 实现一个”一元函数“，即传入一个值经过函数的计算返回另一个值。
	 * 
	 * @author wang_jun6
	 *
	 */
	static class EmployeeToExpenses implements Function<Employee, BigDecimal> {

		@Override
		public BigDecimal apply(Employee e) {
			return new BigDecimal(String.valueOf(e.getSalary())).multiply(new BigDecimal("1.2"));
		}
	}
}

class Employee {
	String name;

	double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
