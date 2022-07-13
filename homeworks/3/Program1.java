package homework3;

import java.util.*;

class Employee{
    String name;
    int salary;
    int equity_share;

    public Employee(String name, int salary, int equity_share){
        this.name = name;
        this.salary = salary;
        this.equity_share = equity_share;
    }

    public String toString(){
        return "{"+ this.name + " "+this.salary + " " + this.equity_share + "}";
    }

    public boolean equals(Employee e)
    {
        if(this == e)
        {
            return true;
        }
        return this.salary - e.salary > 0;
    }
}

public class Program1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Hemanth", 35000, 10000));
        employees.add(new Employee("Rithesh", 30000, 20000));
        employees.add(new Employee("Karthik", 40000, 5000));
        employees.add(new Employee("Ravi", 25000, 2000));
        employees.add(new Employee("Ramu", 50000, 70000));

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Sort Based on Names 2. Sort Based on Salary 3.Sort Based on Equity Share");
        int ch = sc.nextInt();


        //sorting the list using comparator based on the attribute that user selects
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                switch (ch)
                {
                    case 1: return o1.name.compareTo(o2.name);
                    case 2: return o1.salary - o2.salary;
                    default: return o1.equity_share - o2.equity_share;
                }
            }
        });
        System.out.println(employees);

        //second task comparing two employees based on their salaries
        if(employees.get(0).equals(employees.get(1)))
        {
            System.out.println(employees.get(0).name + " has salary more than or equal to "+employees.get(1).name);
        }
        else {
            System.out.println(employees.get(0).name + " has salary less than "+employees.get(1).name);
        }
    }
}
