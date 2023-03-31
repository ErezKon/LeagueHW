public abstract class Employee extends Person{
    protected int seniority;
    protected static final int basis = 4500;

    /**
     * Constructs an employee.
     *
     * @param firstName The employee's first name.
     * @param lastName The employee's last name.
     * @param id The employee's ID.
     * @param seniority The employee's seniority.
     */
    public Employee(String firstName, String lastName, String id, int seniority) {
        super(firstName, lastName, id);
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return String.format("%s, seniority: %d", super.toString(), seniority);
    }

    public void printDetails() {
        String details = toString();
        System.out.println(details);
    }

    public abstract double calculateSalary();
}
