import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        String workerName = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base sallary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        
        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            System.out.println("Enter contract number #"+ i + "data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate =  (Date) sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuesPerHour = sc.nextDouble();
            System.out.print("Duration(Hours): ");
            int hours = sc.nextInt();
            HourContract hourContract = new HourContract(contractDate, valuesPerHour, hours);
            worker.addContract(hourContract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/yyyy): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("income for " + monthAndYear + ": "+ String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
