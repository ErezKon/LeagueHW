public class Coach extends Employee {
    private String team;
    private boolean pastPlayer;
    private int championships;

    public Coach(String firstName, String lastName, String id, int seniority, String team, boolean pastPlayer, int championships) {
        super(firstName, lastName, id, seniority);
        this.team = team;
        this.championships = championships;
        this.pastPlayer = pastPlayer;
    }

    @Override
    public String toString() {
        return String.format("%s, Team: %s, Is past player: %s, , Championships won: %d, Salary: %f", super.toString(), team,
                pastPlayer, championships, calculateSalary());
    }

    public void printDetails() {
        String details = toString();
        System.out.println(details);
    }

    @Override
    public double calculateSalary() {
        return basis + 200 * seniority + 500 * championships;
    }

    @Override
    public boolean isExcellent() {
        return championships >= 2;
    }

    public void wonChampionship() {
        championships++;
    }
}
