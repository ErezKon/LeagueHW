import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Team {
    private String name;
    private String stadium;
    private List<Player> players;
    private Coach coach;
    private Manager manager;

    public Team(String name, String stadium, Player[] players) {
        this.name = name;
        this.stadium = stadium;
        this.players = new ArrayList<Player>(Arrays.asList(players));
        this.coach = coach;
    }

    public Team(String name, String stadium, Player[] players, Coach coach) {
        this.name = name;
        this.stadium = stadium;
        this.players = new ArrayList<Player>(Arrays.asList(players));
        this.coach = coach;
    }

    public Team(String name, String stadium, Player[] players, Coach coach, Manager manager) {
        this.name = name;
        this.stadium = stadium;
        this.players = new ArrayList<Player>(Arrays.asList(players));
        this.coach = coach;
        this.manager = manager;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean addManager(Manager manager) {
        if(this.manager != null) {
            return false;
        }
        this.manager = manager;
        return true;
    }

    public boolean addCoach(Coach coach) {
        if(this.coach != null) {
            return false;
        }
        this.coach = coach;
        return true;
    }

    public Player getPlayerById(String id) {
        List<Player> filtered = players.stream()
                .filter(p -> p.getId().equals(id))
                .collect(Collectors.toList());
        if (filtered.size() > 0) {
            return filtered.get(0);
        }
        return null;
    }

    public Player getPlayerByName(String firstName, String lastName) {
        List<Player> filtered = players.stream()
                .filter(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName))
                .collect(Collectors.toList());
        if (filtered.size() > 0) {
            return filtered.get(0);
        }
        return null;
    }

    private String getPrefixTab(boolean withPrefixTab) {
        return getPrefixTab(withPrefixTab, false);
    }
    private String getPrefixTab(boolean withPrefixTab, boolean withHyphen) {
        return withPrefixTab ?
                withHyphen ? "\t - " : "\t" :
                withHyphen ? " - " : "";
    }

    public void print(boolean withPrefixTab) {
        System.out.println(String.format("%sTeam details:", getPrefixTab(withPrefixTab, true)));
        System.out.println(String.format("%s\t - Name: %s", getPrefixTab(withPrefixTab), name));
        System.out.println(String.format("%s\t - Stadium: %s", getPrefixTab(withPrefixTab), stadium));
        System.out.println(String.format("%s\t - Players:", getPrefixTab(withPrefixTab)));
        for (Player player: players) {
            System.out.print(String.format("%s\t\t - ", getPrefixTab(withPrefixTab)));
            player.printDetails();
        }
        if (coach != null) {
            System.out.println(String.format("%s\t - Coach:", getPrefixTab(withPrefixTab)));
            System.out.print(String.format("%s\t\t - ", getPrefixTab(withPrefixTab)));
            coach.printDetails();
        }
        if (manager != null) {
            System.out.println(String.format("%s\t - Manager:", getPrefixTab(withPrefixTab)));
            System.out.print(String.format("%s\t\t - ", getPrefixTab(withPrefixTab)));
            manager.printDetails();
        }
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Coach getCoach() {
        return coach;
    }

    public Manager getManager() {
        return manager;
    }
}
