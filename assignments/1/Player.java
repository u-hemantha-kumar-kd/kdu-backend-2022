package assignments.assignment1;

public class Player {
    public String name;
    public League.IPLTeam team;
    public enum Role{
        BATSMAN,
        WICKETKEEPER,
        ALLROUNDER,
        BOWLER
    }
    public Role role;
    public PlayerStats playerStats;
    public Player(League.IPLTeam team, String name, Role role, PlayerStats playerStats){
        this.team = team;
        this.name = name;
        this.role = role;
        this.playerStats = playerStats;
    }
    public static Role getRoleEnum(String role){
        Role curRole = Role.BOWLER;
        switch(role){
            case "BATSMAN": curRole = Role.BATSMAN; break;
            case "BOWLER": curRole = Role.BOWLER; break;
            case "ALL ROUNDER": curRole = Role.ALLROUNDER; break;
            case "WICKET KEEPER": curRole = Role.WICKETKEEPER; break;
        }
        return curRole;
    }
    public String toString(){
        return name;
    }
}
