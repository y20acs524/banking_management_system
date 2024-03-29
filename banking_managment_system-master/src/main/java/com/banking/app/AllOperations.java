package com.banking.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.banking.entity.Account;
import com.banking.entity.Branch;
import com.banking.entity.Customer;
import com.banking.entity.Employee;
import com.banking.entity.Loan;
import com.banking.serviceimplementation.AccountServiceImpl;
import com.banking.serviceimplementation.BranchServiceImpl;
import com.banking.serviceimplementation.CustomerServiceImpl;
import com.banking.serviceimplementation.EmployeeServiceImpl;
import com.banking.serviceimplementation.LoanServiceImpl;
import com.banking.services.AccountService;
import com.banking.services.BranchService;
import com.banking.services.CustomerService;
import com.banking.services.EmployeeService;
import com.banking.services.LoanService;

public class AllOperations {

	static BranchService branchService = new BranchServiceImpl();
	static CustomerService customerService = new CustomerServiceImpl();
	static EmployeeService employeeService = new EmployeeServiceImpl();
	static AccountService accountService = new AccountServiceImpl();
	static LoanService loanService = new LoanServiceImpl();

	static Scanner s = new Scanner(System.in);

	// Branch Details
	public static boolean branchInputs() {
		System.out.println("Enter branch id:");
		int branch_id = s.nextInt();

		System.out.println("enter branch name");
		String branch_name = s.next();

		System.out.println("enter branch ifsc-code");
		String ifsc_code = s.next();

		System.out.println("enter branch address");
		String branch_addr = s.next();

		Branch branch = new Branch(branch_id, branch_name, ifsc_code, branch_addr);
		return branchService.savebranch(branch);

	}
	//find branch by Id
	public static Branch findBranchId() {
		s.nextLine();
		System.out.println("enter branch id");
		int id = s.nextInt();
		return branchService.getBranchId(id);
	}
	//get all branch records
	public static List<Branch> findAllBranch() {
		return branchService.getAllBranch();

	}

	public static boolean updateId() {
		System.out.println("enter the id");
		int id = s.nextInt();
		System.out.println("enter branch name");
		String name = s.next();
		System.out.println("enter ifsc-code");
		String ifsc_code = s.next();
		System.out.println("enter address");
		String address = s.next();

		Branch branch = new Branch(id, name, ifsc_code, address);
		return branchService.updateBranchId(branch, id);

	}

	public static boolean deleteId() {
		System.out.println("enter the Id");
		int branchId = s.nextInt();
		return branchService.removeBranchId(branchId);
	}

	public static void branchOperations() {
		System.out.println("Branch Operations:\n" + "1:Insert Branch details:\n" + "2.get the branch details by id:\n"
				+ "3.get all branch details:\n" + "4.update the branch details:\n"
				+ "5.remove the branch details by id");

		System.out.println("enter the input");
		int input = s.nextInt();
		switch (input) {
		case 1:
			branchInputs();
			break;
		case 2:
			findBranchId();
			break;
		case 3:
			findAllBranch();
			break;
		case 4:
			updateId();
			break;
		case 5:
			deleteId();
			break;
		}
	}

	// Employee details
	public static void employeeInputs() {
		System.out.println("enter employee id:");
		int empId = s.nextInt();
		System.out.println("enter employee name:");
		String empName = s.next();
		System.out.println("enter employee salary:");
		double empSalary = s.nextDouble();
		System.out.println("enter employee address");
		String empAddress = s.next();
		System.out.println("enter branch id");
		int branchId = s.nextInt();

		Branch branch = new Branch(branchId);
		Employee emp = new Employee(empId, empName, empSalary, empAddress, branch);
		employeeService.saveEmployee(emp);
	}

	public static Employee findEmployeeId() {
		System.out.println("enter employee Id:");
		int empId = s.nextInt();
		return employeeService.getEmployeeId(empId);

	}

	public static List<Employee> findAllEmployee() {
		return employeeService.getAllEmployee();

	}

	public static boolean updateEmployeeId() {
		System.out.println("enter the id");
		int id = s.nextInt();
		System.out.println("enter employee name");
		String name = s.next();
		System.out.println("enter salary");
		double salary = s.nextDouble();
		System.out.println("enter address");
		String address = s.next();
		System.out.println("enter the branch id");
		int branch_id = s.nextInt();

		Branch branch = new Branch(branch_id);
		Employee emp = new Employee(id, name, salary, address, branch);
		return employeeService.updateEmployeeId(emp, id);

	}

	public static boolean deleteEmployeeId() {
		System.out.println("enter the Id");
		int emp_id = s.nextInt();
		return employeeService.removeEmployeeId(emp_id);
	}

	public static void employeeOperations() {
		System.out
				.println("Enter Employee Operations:\n" + "1.insert employee details:\n" + "2.find by employee by id:\n"
						+ "3.find all employess:\n" + "4.update employee by id:\n" + "5.delete employee by id");

		int enter = s.nextInt();
		switch (enter) {
		case 1:
			employeeInputs();
			break;
		case 2:
			findEmployeeId();
			break;
		case 3:
			findAllEmployee();
			break;
		case 4:
			updateEmployeeId();
			break;
		case 5:
			deleteEmployeeId();
			break;
		}
	}

	// Customer details
	public static boolean customerInputs() {
		System.out.println("Enter customer id:");
		int customer_id = s.nextInt();

		System.out.println("enter customer name");
		String customer_name = s.next();

		System.out.println("enter phone number");
		long phone = s.nextLong();

		System.out.println("enter customer address");
		String customer_addr = s.next();

		System.out.println("enter branch id:");
		int branch_id = s.nextInt();
		Branch branch = new Branch(branch_id);
		Customer customer = new Customer(customer_id, customer_name, phone, customer_addr, branch);
		return customerService.saveCustomer(customer);

	}

	public static Customer findCustomerId() {
		s.nextLine();
		System.out.println("enter customer id");
		int id = s.nextInt();
		return customerService.getCustomerId(id);
	}

	public static List<Customer> findAllCustomers() {
		return customerService.getAllCustomer();

	}

	public static boolean updateCustomerId() {
		System.out.println("enter customer id");
		int id = s.nextInt();
		System.out.println("enter customer name");
		String name = s.next();
		System.out.println("enter phone number");
		long phone = s.nextLong();
		System.out.println("enter address");
		String address = s.next();
		System.out.println("enter branch id");
		int branch_id = s.nextInt();
		Branch branch = new Branch(branch_id);
		Customer customer = new Customer(id, name, phone, address, branch);
		return customerService.updateCustomerId(customer, id);

	}

	public static boolean deleteCustomerId() {
		System.out.println("enter the Id");
		int id = s.nextInt();
		return customerService.removeCustomerId(id);
	}

	public static void customerOperations() {
		System.out.println("Customer Operations:\n" + "1:Insert Customer details:\n"
				+ "2.get the customer details by id:\n" + "3.get all customer details:\n"
				+ "4.update the customer details:\n" + "5.remove the customer details by id");

		System.out.println("enter the input");
		int input = s.nextInt();
		switch (input) {
		case 1:
			customerInputs();
			break;
		case 2:
			findCustomerId();
			break;
		case 3:
			findAllCustomers();
			break;
		case 4:
			updateCustomerId();
			break;
		case 5:
			deleteCustomerId();
			break;
		}
	}

	// Account details
	public static boolean accountInputs() {
		System.out.println("Enter Account no:");
		long accn_no = s.nextLong();

		System.out.println("enter account type");
		String accn_type = s.next();

		System.out.println("enter account date (yyyy/mm/dd)");
		String accn_date = s.next();
		LocalDate date = LocalDate.parse(accn_date);

		System.out.println("enter account balance");
		double accn_balance = s.nextDouble();

		System.out.println("enter customer id:");
		int customer_id = s.nextInt();
		Customer customer = new Customer(customer_id);
		Account account = new Account(accn_no, accn_type, date, accn_balance, customer);
		return accountService.saveAccount(account);

	}

	public static Account findAccountId() {
		s.nextLine();
		System.out.println("enter account no");
		long accn_no = s.nextLong();
		return accountService.getAccountId(accn_no);
	}

	public static List<Account> findAllAccounts() {
		return accountService.getAllAccount();

	}

	public static boolean updateAccountId() {
		System.out.println("enter account number");
		long accn_no = s.nextLong();

		System.out.println("enter account type");
		String accn_type = s.next();

		System.out.println("enter account date(yyyy/mm/dd)");
		String accn_date = s.next();
		LocalDate date = LocalDate.parse(accn_date);

		System.out.println("enter account balance");
		double accn_balance = s.nextDouble();
		System.out.println("enter customer id");
		int cust_id = s.nextInt();
		Customer customer = new Customer(cust_id);
		Account account = new Account(accn_no, accn_type, date, accn_balance, customer);
		return accountService.updateAccountId(account, accn_no);

	}

	public static boolean deleteAccountId() {
		System.out.println("enter account number");
		long accn_no = s.nextLong();
		return accountService.removeAccountId(accn_no);
	}

	public static void accountOperations() {
		System.out.println("Account Operations:\n" + "1:Insert Account details:\n"
				+ "2.get the Account details by id:\n" + "3.get all Account details:\n"
				+ "4.update the Account details:\n" + "5.remove the Account details by id");

		System.out.println("enter the input");
		int input = s.nextInt();
		switch (input) {
		case 1:
			accountInputs();
			break;
		case 2:
			findAccountId();
			break;
		case 3:
			findAllAccounts();
			break;
		case 4:
			updateAccountId();
			break;
		case 5:
			deleteAccountId();
			break;
		}
	}

	// Loan Details
	public static boolean loanInputs() {
		System.out.println("Enter loan id:");
		int loan_id = s.nextInt();

		System.out.println("enter loan type");
		String loan_type = s.next();

		System.out.println("enter loan amount");
		double loan_amount = s.nextDouble();

		System.out.println("enter maximum years");
		int max_years = s.nextInt();

		System.out.println("enter loan date(yyyy/mm/dd)");
		String date = s.next();
		LocalDate loan_date = LocalDate.parse(date);

		System.out.println("enter customer id:");
		int cust_id = s.nextInt();
		Customer customer = new Customer(cust_id);
		Loan loan = new Loan(loan_id, loan_type, loan_amount, max_years, loan_date, customer);
		return loanService.saveLoan(loan);

	}

	public static Loan findLoanId() {
		System.out.println("enter loan id");
		int loan_id = s.nextInt();
		return loanService.getLoanId(loan_id);
	}

	public static List<Loan> findAllLoans() {
		return loanService.getAllLoan();

	}

	public static boolean updateLoanId() {
		System.out.println("enter loan id");
		int loan_id = s.nextInt();
		System.out.println("enter loan type");
		String loan_type = s.next();
		System.out.println("enter loan amount");
		double loan_amount = s.nextDouble();
		System.out.println("enter maximum years of loan");
		int max_years = s.nextInt();
		System.out.println("enter loan date");
		String date = s.next();
		LocalDate loan_date = LocalDate.parse(date);
		System.out.println("enter customer id");
		int cust_id = s.nextInt();
		Customer customer = new Customer(cust_id);
		Loan loan = new Loan(loan_id, loan_type, loan_amount, max_years, loan_date, customer);
		return loanService.updateLoanId(loan, loan_id);

	}

	public static boolean deleteLoanId() {
		System.out.println("enter loan Id");
		int loan_id = s.nextInt();
		return loanService.removeLoanId(loan_id);
	}

	public static void loanOperations() {
		System.out.println("Loan Operations:\n" + "1:Insert Loan details:\n" + "2.get the Loan details by id:\n"
				+ "3.get all Loan details:\n" + "4.update the Loan details:\n" + "5.remove the loan details by id");

		System.out.println("enter the input");
		int input = s.nextInt();
		switch (input) {
		case 1:
			loanInputs();
			break;
		case 2:
			findLoanId();
			break;
		case 3:
			findAllLoans();
			break;
		case 4:
			updateLoanId();
			break;
		case 5:
			deleteLoanId();
			break;
		}
	}

}
