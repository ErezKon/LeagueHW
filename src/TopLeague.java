import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Represents the top league.
 *
 */
public class TopLeague {
    private static final Random rand = new Random();
    private List<Team> teams;
    private List<Game> games;
    private List<Referee> referees;
    private List<Employee> employees;

    private HashMap<Integer, HashSet<Integer>> refereeAssignDic = new HashMap<>();

    /**
     * Constructs the top league,
     *
     */
    public TopLeague() {
        teams = new ArrayList<>();
        employees = new ArrayList<>();
        games = new ArrayList<>();
        referees = new ArrayList<>();

        createTeams();
        createReferees();
        assignGames();
    }

    private void createReferees(){
        for (int i = 0; i < 20; i++) {
            Referee ref = new Referee(String.format("ref%d", i + 1), String.format("ref%d", i + 1),
                    IdBuilder.randomizeID(), rand.nextInt(8), 0, 0);
            referees.add(ref);
            employees.add(ref);
        }
    }

    private void createTeams() {
        teams.add(createHBS());
        teams.add(TeamBuilder.createTeam("Macabbi Noobs", "noob", "boob"));
        teams.add(TeamBuilder.createTeam("Beitar Noobs", "noob", "boob"));
        teams.add(TeamBuilder.createTeam("MS Noobs", "noob", "boob"));
        teams.add(TeamBuilder.createTeam("Hapoel Noobs", "noob", "boob"));
        teams.add(TeamBuilder.createTeam("Noobs FC", "noob", "boob"));

        for (Team team: teams) {
            employees.addAll(team.getPlayers());
            employees.add(team.getCoach());
            employees.add(team.getManager());
        }
    }

    /**
     * Yalla Hapoel, Championship ama yaamik!
     *
     * @return Hapoel Beer Sheva
     */
    private Team createHBS() {
        Player[] hbsPlayers = new Player[]{
                new Player("Omri", "Glazer", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 49, 30, Position.GOALKEEPER),
                new Player("Ariel", "Harush", IdBuilder.randomizeID(), 2, "Hapoel Beer Sheva", 7, 3, Position.GOALKEEPER),
                new Player("Miguel", "Vitor", IdBuilder.randomizeID(), 6, "Hapoel Beer Sheva", 75, 68, Position.DEFENDER),
                new Player("Eyad", "Abu Abid", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 60, 40, Position.DEFENDER),
                new Player("Helder", "Lopes", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 56, 45, Position.DEFENDER),
                new Player("Or", "Dadia", IdBuilder.randomizeID(), 3, "Hapoel Beer Sheva", 40, 20, Position.DEFENDER),
                new Player("Eytan", "Tibi", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 62, 47, Position.DEFENDER),
                new Player("Sagiv", "Jehezkel", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 12, 5, Position.DEFENDER),
                new Player("Ramsey", "Safury", IdBuilder.randomizeID(), 3, "Hapoel Beer Sheva", 17, 12, Position.MIDFIELDER),
                new Player("Dor", "Micha", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 26, 21, Position.MIDFIELDER),
                new Player("Shai", "Elias", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 9, 5, Position.MIDFIELDER),
                new Player("Roi", "Gordana", IdBuilder.randomizeID(), 4, "Hapoel Beer Sheva", 14, 9, Position.MIDFIELDER),
                new Player("Tomer", "Hemed", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 13, 9, Position.FORWARD),
                new Player("Rotem", "Hatuel", IdBuilder.randomizeID(), 2, "Hapoel Beer Sheva", 22, 16, Position.FORWARD),
                new Player("Itay", "Shechter", IdBuilder.randomizeID(), 1, "Hapoel Beer Sheva", 5, 2, Position.FORWARD),
        };
        Coach hbsCoach = new Coach("Elyaniv", "Barda", IdBuilder.randomizeID(), 10, "Hapoel Beer Sheva", true, 1);
        Manager hbsManager = new Manager("Guy", "Primor", IdBuilder.randomizeID(), 1);

        Team hbs = new Team("Hapoel Beer Sheva", "Toto Turner", hbsPlayers, hbsCoach, hbsManager);

        return hbs;
    }

    private Date createDate(String date, String time) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm")
                    .parse(String.format("%s %s", date, time));
        }
        catch(Exception ex) {
            return new Date();
        }
    }

    private Referee[] assignReferees(int round) {
        if(!refereeAssignDic.containsKey(round)) {
            refereeAssignDic.put(round, new HashSet<Integer>());
        }
        Referee[] refs = new Referee[4];
        for (int i = 0; i < 4; i++) {
            int refIndex;
            do {
                refIndex = rand.nextInt(referees.size());
            } while(refereeAssignDic.get(round).contains(refIndex));
            refereeAssignDic.get(round).add(refIndex);
            Referee ref = referees.get(refIndex);
            refs[i] = ref;
            ref.addGames(1);
        }
        return refs;
    }

    public void assignGames() {
        games.add(new Game(createDate("01/04/23", "15:00"), teams.get(0), teams.get(1), assignReferees(1)));
        games.add(new Game(createDate("01/04/23", "18:00"), teams.get(2), teams.get(3), assignReferees(1)));
        games.add(new Game(createDate("01/04/23", "20:00"), teams.get(4), teams.get(5), assignReferees(1)));

        games.add(new Game(createDate("08/04/23", "15:00"), teams.get(0), teams.get(2), assignReferees(2)));
        games.add(new Game(createDate("08/04/23", "18:00"), teams.get(1), teams.get(4), assignReferees(2)));
        games.add(new Game(createDate("08/04/23", "20:00"), teams.get(3), teams.get(4), assignReferees(2)));

        games.add(new Game(createDate("15/04/23", "15:00"), teams.get(0), teams.get(3), assignReferees(3)));
        games.add(new Game(createDate("15/04/23", "18:00"), teams.get(1), teams.get(5), assignReferees(3)));
        games.add(new Game(createDate("15/04/23", "20:00"), teams.get(2), teams.get(4), assignReferees(3)));

        games.add(new Game(createDate("22/04/23", "15:00"), teams.get(0), teams.get(4), assignReferees(4)));
        games.add(new Game(createDate("22/04/23", "18:00"), teams.get(1), teams.get(3), assignReferees(4)));
        games.add(new Game(createDate("22/04/23", "20:00"), teams.get(2), teams.get(5), assignReferees(4)));

        games.add(new Game(createDate("29/04/23", "15:00"), teams.get(0), teams.get(5), assignReferees(5)));
        games.add(new Game(createDate("29/04/23", "18:00"), teams.get(1), teams.get(2), assignReferees(5)));
        games.add(new Game(createDate("29/04/23", "20:00"), teams.get(3), teams.get(4), assignReferees(5)));

        games.add(new Game(createDate("06/05/23", "18:00"), teams.get(1), teams.get(0), assignReferees(6)));
        games.add(new Game(createDate("06/05/23", "20:00"), teams.get(3), teams.get(2), assignReferees(6)));
        games.add(new Game(createDate("06/05/23", "15:00"), teams.get(5), teams.get(4), assignReferees(6)));

        games.add(new Game(createDate("13/05/23", "18:00"), teams.get(2), teams.get(0), assignReferees(7)));
        games.add(new Game(createDate("13/05/23", "20:00"), teams.get(4), teams.get(1), assignReferees(7)));
        games.add(new Game(createDate("13/05/23", "15:00"), teams.get(5), teams.get(3), assignReferees(7)));

        games.add(new Game(createDate("20/05/23", "18:00"), teams.get(3), teams.get(0), assignReferees(8)));
        games.add(new Game(createDate("20/05/23", "20:00"), teams.get(5), teams.get(1), assignReferees(8)));
        games.add(new Game(createDate("20/05/23", "15:00"), teams.get(4), teams.get(2), assignReferees(8)));

        games.add(new Game(createDate("27/05/23", "18:00"), teams.get(4), teams.get(0), assignReferees(9)));
        games.add(new Game(createDate("27/05/23", "20:00"), teams.get(3), teams.get(1), assignReferees(9)));
        games.add(new Game(createDate("27/05/23", "15:00"), teams.get(5), teams.get(2), assignReferees(9)));

        games.add(new Game(createDate("03/06/23", "18:00"), teams.get(5), teams.get(0), assignReferees(10)));
        games.add(new Game(createDate("03/06/23", "20:00"), teams.get(2), teams.get(1), assignReferees(10)));
        games.add(new Game(createDate("03/06/23", "15:00"), teams.get(4), teams.get(3), assignReferees(10)));
    }
}
