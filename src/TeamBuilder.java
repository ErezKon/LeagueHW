import java.util.HashSet;
import java.util.Random;

public abstract class TeamBuilder {
    private static final Random rand = new Random();
    private static final int totalPlayers = 15;
    private static final int idLength = 9;


    public static Team createTeam(String name, String fName, String lName) {
        Player[] players = new Player[totalPlayers];
        for (int i = 0; i < totalPlayers; i++) {
            players[i] = new Player(String.format("%s%d",fName, i), String.format("%s%d",lName, i), IdBuilder.randomizeID(),
                    rand.nextInt(5),name, rand.nextInt(25) + 5, rand.nextInt(12) + 1, getPosition(i));
        }
        Coach coach = new Coach(fName, lName, IdBuilder.randomizeID(), rand.nextInt(5), name, true, rand.nextInt(3));
        Manager manager = new Manager(String.format("%s%d", fName, 0), String.format("%s%d", lName, 0), IdBuilder.randomizeID(), rand.nextInt(5));
        return new Team(name, String.format("%s - Stadium", name), players, coach, manager);
    }


    private static Position getPosition(int index) {
        switch (index) {
            case 0:
            case 1:
                return Position.GOALKEEPER;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return Position.DEFENDER;
            case 8:
            case 9:
            case 10:
            case 11:
                return Position.MIDFIELDER;
            case 12:
            case 13:
            case 14:
                return Position.FORWARD;
        }
        return Position.GOALKEEPER;
    }
}
