public class Manager extends Employee {

    public Manager(String firstName, String lastName, String id, int seniority) {
        super(firstName, lastName, id, seniority);
    }

    @Override
    public double calculateSalary() {
        return basis * 3 + seniority * 500;
    }

    @Override
    public boolean isExcellent() {
        return seniority >= 4;
    }

    @Override
    public String toString() {
        return String.format("%s, Seniority: %d, Salary: %f", super.toString(), seniority, calculateSalary());
    }

    public void printDetails() {
        String details = toString();
        System.out.println(details);
    }
}
