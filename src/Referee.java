public class Referee extends Employee{
    private int errors;
    private int totalGames;

    private static int maxErrors = 0;

    public Referee(String firstName, String lastName, String id, int seniority, int errors, int totalGames) {
        super(firstName, lastName, id, seniority);
        this.errors = errors;
        this.totalGames = totalGames;

        updateMaxErrors();
    }

    private void updateMaxErrors() {
        if (errors > maxErrors) {
            maxErrors = errors;
        }
    }

    public void addErrors(int errors) {
        this.errors += errors;
        updateMaxErrors();
    }

    public void addGames(int games) {
        totalGames += games;
    }

    @Override
    public double calculateSalary() {
        double salary = basis + 30 * totalGames;
        if(errors >= maxErrors) {
            salary -= 500;
        }
        return salary;
    }

    @Override
    public boolean isExcellent() {
        return errors <= (0.5 * maxErrors);
    }

    @Override
    public String toString() {
        return String.format("%s, Errors: %d, , Games: %d, Salary: %d", super.toString(),
                errors, totalGames, calculateSalary());
    }

    public void printDetails() {
        String details = toString();
        System.out.println(details);
    }

    public String getID() {
        return id;
    }
}
