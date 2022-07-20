package assignments.assignment1;

import java.util.*;
public class Team {
    public League.IPLTeam nameOfTheTeam;
    public List<Player> squad;
    public Team(League.IPLTeam name){
        this.nameOfTheTeam = name;
        squad = new ArrayList<Player>();
    }
    public void addPlayerToTeam(Player player){
        squad.add(player);
    }
    public List<Player> getSquad() {
        return squad;
    }
}
