package assignments.assignment1;

public class MatchFixtures {
    int matchNumber;
    League.IPLTeam home_team;
    League.IPLTeam away_team;
    String ground;



    public MatchFixtures(int matchNumber, League.IPLTeam home_team, League.IPLTeam away_team, String ground){
        this.matchNumber += matchNumber;
        this.home_team = home_team;
        this.away_team = away_team;
        this.ground = ground;
    }

    public String toString(){
        return this.matchNumber + ","+ this.home_team + ","+this.away_team + ","+this.ground;
    }
}
