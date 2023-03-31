public class Player extends Employee {
    private String team;
    private int totalAttempts;
    private int successfulAttempts;
    private Position position;

    private static final int basis = 6500;

    /**
     * Constructs a player.
     * @param firstName player's first name.
     * @param lastName player's last name.
     * @param id player's id.
     * @param seniority player's seniority.
     * @param team player's team.
     * @param totalAttempts player's total attempts.
     * @param successfulAttempts player's successful attempts.
     * @param position player's position.
     */
    public Player(String firstName, String lastName, String id, int seniority,
            String team, int totalAttempts, int successfulAttempts, Position position) {
        super(firstName, lastName, id, seniority);
        this.team = team;
        this.totalAttempts = totalAttempts;
        this.successfulAttempts = successfulAttempts;
        this.position = position;
    }

    public double getSuccessRate() {
        return (successfulAttempts * 100) / totalAttempts;
    }

    public void addAttempts(int attempts) {
        totalAttempts += attempts;
    }

    public void addSuccessfulAttempts(int attempts) {
        successfulAttempts += attempts;
    }

    @Override
    public boolean isExcellent() {
        return getSuccessRate() >= 75.0;
    }

    @Override
    public double calculateSalary() {
        return basis + (getSuccessRate() / 100) * 2000 ;
    }

    @Override
    public String toString() {
        return String.format("%s, Team: %s, %s: %s, , %s: %s Position: %s, Salary: %f", super.toString(), team,
                formatAttempts(true), totalAttempts, formatAttempts(false), successfulAttempts, position, calculateSalary());
    }

    public void printDetails() {
        String details = toString();
        System.out.println(details);
    }

    private String formatAttempts(boolean isTotal) {
        switch (position) {
            case GOALKEEPER:
                return isTotal ? "Total goal attempts" : "Saved goals";
            case DEFENDER:
                return isTotal ? "Total tackles" : "Successful tackles";
            case MIDFIELDER:
                return isTotal ? "Total key passes attempts" : "Successful key passes";
            case FORWARD:
                return isTotal ? "Total goal attempts" : "Scored goals";
        }
        return "";
    }

    public String getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
