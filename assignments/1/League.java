package assignments.assignment1;
import java.util.*;
public class League {
    public enum IPLTeam{
        CSK,
        DC,
        KKR,
        MI,
        PBKS,
        RCB,
        RR,
        SRH
    }

    public static List<Team> teams;
    public static Map<IPLTeam,Team> teamMap = new HashMap<IPLTeam,Team>();
    public static List<Player> players = new ArrayList<>();
    public static List<Player> batsmen = new ArrayList<>();
    public static List<Player> bowlers = new ArrayList<>();
    public static List<Player> allRounders = new ArrayList<>();
    public static IPLTeam getTeamEnum(String teamName){
        IPLTeam team = null;
        switch(teamName){
            case "CSK": team = IPLTeam.CSK; break;
            case "DC": team = IPLTeam.DC; break;
            case "KKR": team = IPLTeam.KKR; break;
            case "MI": team = IPLTeam.MI; break;
            case "PBKS": team = IPLTeam.PBKS; break;
            case "RCB": team = IPLTeam.RCB; break;
            case "RR": team = IPLTeam.RR; break;
            case "SRH": team = IPLTeam.SRH; break;
        }
        return team;
    }
    public static void buildTeams(){
        teamMap = new HashMap<>();
        teamMap.put(IPLTeam.CSK,new Team(IPLTeam.CSK));
        teamMap.put(IPLTeam.DC,new Team(IPLTeam.DC));
        teamMap.put(IPLTeam.KKR,new Team(IPLTeam.KKR));
        teamMap.put(IPLTeam.MI,new Team(IPLTeam.MI));
        teamMap.put(IPLTeam.PBKS,new Team(IPLTeam.PBKS));
        teamMap.put(IPLTeam.RCB,new Team(IPLTeam.RCB));
        teamMap.put(IPLTeam.RR,new Team(IPLTeam.RR));
        teamMap.put(IPLTeam.SRH,new Team(IPLTeam.SRH));
    }
    public static void setTeams(){
        teams = new ArrayList<Team>(teamMap.values());
    }
}
