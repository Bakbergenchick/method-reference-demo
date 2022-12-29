import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        // anonymous option
        employeeService.loadFromDB()
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        System.out.println(employee);
                    }
                });

        System.out.println();

        // lambda option
        employeeService.loadFromDB()
                .forEach(employee -> System.out.println(employee));

        System.out.println();

        // method reference with custom class
        employeeService.loadFromDB()
                .forEach(MethodReferenceDemo::print);

        // method reference with predefined class
        employeeService.loadFromDB()
                .forEach(System.out::println);

        // From Employee convert to EmployeeDO (Map<O,I> Example)
        List<Object> empDoList = employeeService.loadFromDB()
                .stream()
                .map(new Function<Employee, Object>() {
                    @Override
                    public Object apply(Employee employee) {
                        EmployeeDO employeeDO = new EmployeeDO();
                        employeeDO.setId(employee.getId());
                        employeeDO.setName(employee.getName());
                        employeeDO.setSalary(employee.getSalary());
                        return employeeDO;
                    }
                }).toList();

        System.out.println(empDoList);


        List<EmployeeDO> employeeDOS2 = employeeService.loadFromDB()
                .stream().map(employee -> {
                    EmployeeDO employeeDO = new EmployeeDO();
                    employeeDO.setId(employee.getId());
                    employeeDO.setName(employee.getName());
                    employeeDO.setSalary(employee.getSalary());
                    return employeeDO;
                })
                .toList();
        System.out.println(employeeDOS2);

        List<EmployeeDO> employeeDOS3 = employeeService.loadFromDB()
                .stream()
                .map(employee -> EmployeeMapper.convert(employee))
                .collect(Collectors.toList());
        System.out.println(employeeDOS3);

        List<EmployeeDO> employeeDOS4 = employeeService.loadFromDB()
                .stream()
                .map(EmployeeMapper::convert)
                .collect(Collectors.toList());
        System.out.println(employeeDOS4);


        // Constructor reference
        EmployeeManager employeeManager =() -> new Employee(10L, "334", 34.4);
        employeeManager.getEmployee().EmployeeInfo();

        EmployeeManager employeeManager1 = Employee::new;
        employeeManager1.getEmployee().EmployeeInfo();

    }

    public static void print(Employee employee){
        System.out.println(employee);
    }
}
