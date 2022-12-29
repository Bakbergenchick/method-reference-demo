import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {

    public List<Employee> loadFromDB(){
        return IntStream.range(1, 10)
                .mapToObj(value -> new Employee((long) value, "empl" + value, new Random().nextDouble()))
                .collect(Collectors.toList());
    }
}
