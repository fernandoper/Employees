package application;

import entities.Department;
import entities.Address;
import entities.Employee;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do departamento: ");
        String deptName = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        sc.nextLine();

        Department department = new Department(deptName, payDay);

        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String phone = sc.nextLine();

        Address address = new Address(email, phone);
        department.setAddress(address);

        System.out.print("Quantos funcionarios tem o departamento? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i=1; i<=n; i++) {
            System.out.println("Dados do funcionario " + i + ":");
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Salario: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee emp = new Employee(name, salary);

            department.addEmployee(emp);
        }

        showReport(department);

        sc.close();
    }

    private static void showReport(Department department) {
        System.out.println("FOLHA DE PAGAMENTO: ");
        System.out.println("Departamento " + department.getName() + " = R$ " + String.format("%.2f", department.payroll()));
        System.out.println("Pagamento realizado no dia " + department.getPayDay());
        System.out.println("Funcionarios:");
        for (Employee emp : department.getEmployees()) {
            System.out.println(emp);
        }
        System.out.println("Para dúvidas favor entrar em contato: " + department.getAddress().getEmail());
    }
}
