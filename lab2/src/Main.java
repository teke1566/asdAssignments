import data.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50, null));
        employees.add(new Employee(2L, "Benard", "Shaw", LocalDate.of(2019, 4, 3), 197750.00, null));
        employees.add(new Employee(3L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75, LocalDate.of(2019, 11, 4), 1555.50));
        employees.add(new Employee(4L, "Wesley", "Schneider", LocalDate.of(2019, 5, 2), 74500.00, null));

        // Task 1: Print list of all employees in JSON format
        System.out.println("List of all employees:");
        System.out.println(getAllEmployeesJSON(employees));

        // Task 2: Print Monthly Upcoming Enrollees report
        System.out.println("Monthly Upcoming Enrollees report:");
        System.out.println(getMonthlyUpcomingEnrolleesReport(employees));
    }
    //Task 1: Function to get JSON representation of all employees
    private static String getAllEmployeesJSON(List<Employee> employees) {
        // Sort employees by last name ascending and yearly salary descending
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary).reversed())
                .collect(Collectors.toList());

        // Build JSON representation
        StringBuilder json = new StringBuilder("[");
        for (Employee employee : sortedEmployees) {
            json.append(employee.toJSON()).append(",");
        }
        if (!employees.isEmpty()) {
            json.deleteCharAt(json.length() - 1); // Remove trailing comma
        }
        json.append("]");
        return json.toString();
    }

    // Task 2: Function to get Monthly Upcoming Enrollees report in JSON format
    private static String getMonthlyUpcomingEnrolleesReport(List<Employee> employees) {
        // Get current month and next month
        LocalDate currentDate = LocalDate.now();
        LocalDate nextMonthFirstDay = LocalDate.of(currentDate.getYear(), currentDate.getMonth().plus(1), 1);
        LocalDate nextMonthLastDay = nextMonthFirstDay.plusMonths(1).minusDays(1);

        // Filter employees who are qualified for Pension Plan enrollment next month and not enrolled
        List<Employee> upcomingEnrollees = employees.stream()
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isBefore(nextMonthLastDay.plusDays(1)))
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isAfter(nextMonthFirstDay.minusDays(1)))
                .filter(employee -> employee.getPensionPlan() == null)
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList());

        // Build JSON representation
        StringBuilder json = new StringBuilder("[");
        for (Employee employee : upcomingEnrollees) {
            json.append(employee.toJSON()).append(",");
        }
        if (!upcomingEnrollees.isEmpty()) {
            json.deleteCharAt(json.length() - 1); // Remove trailing comma
        }
        json.append("]");
        return json.toString();
    }
}