import java.util.Objects;

public class EmployeeDO {
    private Long id;
    private String name;
    private Double salary;

    public EmployeeDO() {
    }

    public EmployeeDO(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDO that = (EmployeeDO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
