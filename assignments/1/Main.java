package assignments.assignment1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    static List<String []> matchesData = new ArrayList<>();
    public static void main(String[] args) {
        try {
            League.buildTeams();
            FileReader file = new FileReader("/home/lenovo/Training/KickdrumJava/src/assignments/assignment1/IPL_2021_data.csv");
            BufferedReader br = new BufferedReader(file);
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                Team currentTeam = League.teamMap.get(League.getTeamEnum(temp[1]));
                PlayerStats currentPlayerStats = new PlayerStats(Integer.parseInt(temp[3]), Integer.parseInt(temp[4]),
                        Integer.parseInt(temp[7]), Double.parseDouble(temp[5]), Double.parseDouble(temp[6]));
                Player currentPlayer = new Player(League.getTeamEnum(temp[1]), temp[0], Player.getRoleEnum(temp[2]), currentPlayerStats);
                currentTeam.addPlayerToTeam(currentPlayer);

                switch(Player.getRoleEnum(temp[2])){
                    case WICKETKEEPER:
                    case BATSMAN:
                        League.batsmen.add(currentPlayer); break;
                    case BOWLER: League.bowlers.add(currentPlayer); break;
                    case ALLROUNDER: League.allRounders.add(currentPlayer); break;
                }
                League.players.add(currentPlayer);
            }
            League.setTeams();
            br.close();
            file.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }

        Main main = new Main();

        System.out.println();
        List<MatchFixtures> matches  = null;

        matches = main.createMatchFixtures();



        for(MatchFixtures matchFixture: matches)
        {
            System.out.println(matchFixture.matchNumber + " " + matchFixture.home_team + " "+ matchFixture.away_team + " " +matchFixture.ground);
        }

        System.out.println();


        System.out.println("Players who have taken atleast 40 wickets in their team: ");
        List<Player> playersWithAtleastFortyWickets = main.getBowlersWithAtleastFortyWickets("MI");
        for(Player player : playersWithAtleastFortyWickets)
        {
            System.out.println(player);
        }
        System.out.println();

        System.out.println("Searching...");
        System.out.println("You might be searching for: "+ main.search("vi"));
        System.out.println();


        System.out.println("Highest Wicket Taker of the team: ");
        System.out.println(main.getHighestWicketTaker("MI"));
        System.out.println();

        System.out.println("Highest Run Scorer of the team: ");
        System.out.println(main.getHighestRunScorer("DC"));
        System.out.println();

        System.out.println();
        System.out.println("Top Three Batsmen of the season: ");
        System.out.println(main.getTopThreeBatsmen());

        System.out.println();
        System.out.println("Top Three Bowlers of the season: ");
        System.out.println(main.getTopThreeBowlers());

        System.out.println();
        System.out.println("Top Three All-Rounders of the season: ");
        System.out.println(main.getTopThreeAllRounders());



        main.predictTwoHighestScoringTeams();

        System.out.println();
        main.nextGenForEachTeam();
    }

    public List<MatchFixtures> createMatchFixtures(){
        List<MatchFixtures>  matches = new ArrayList<>();


        int curNoOfMatch = 0;
        for(League.IPLTeam curHomeTeam: League.IPLTeam.values())
        {
            League.IPLTeam current_home_team = curHomeTeam;
            String ground = current_home_team + "-Home-Ground";
            for(League.IPLTeam curAwayTeam: League.IPLTeam.values())
            {
                if(curHomeTeam != curAwayTeam)
                {
                    curNoOfMatch += 1;
                    League.IPLTeam current_away_team = curAwayTeam;
                    MatchFixtures cur_match_fixture = new MatchFixtures(curNoOfMatch, current_home_team, current_away_team, ground);
                    matches.add(cur_match_fixture);
                }
            }
        }


        try {
            FileWriter fw = new FileWriter("matchFixtures.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            for(MatchFixtures matchFixture : matches)
            {
                bw.write(String.valueOf(matchFixture) + "\n");
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return matches;
    }

    public List<Player> getBowlersWithAtleastFortyWickets(String teamName){
        List<Player> squad = League.teamMap.get(League.getTeamEnum(teamName)).getSquad();
        List<Player> result = new ArrayList<>();
        for(Player player : squad){
            if(player.playerStats.getWickets()>40){
                result.add(player);
            }
        }
        return result;
    }
    public List<Player> search(String name){
        List<Player> result = new ArrayList<>();
        for(Player player : League.players){
            if(player.name.toLowerCase(Locale.ROOT).contains(name))
                result.add(player);
        }
        return result;
    }

    public String getHighestWicketTaker(String teamName)
    {
        List<Player> squad = League.teamMap.get(League.getTeamEnum(teamName)).getSquad();
        Player highestWicketTaker = squad.stream().max(Comparator.comparingInt(player -> player.playerStats.getWickets())).get();
        return String.valueOf(highestWicketTaker);
    }

    public String getHighestRunScorer(String teamName)
    {
        List<Player> squad = League.teamMap.get(League.getTeamEnum(teamName)).getSquad();
        Player highestRunScorer = squad.stream().max(Comparator.comparingInt(player -> player.playerStats.getRuns())).get();
        return String.valueOf(highestRunScorer);
    }

    public List<Player> getTopThreeBatsmen(){
        List<Player> topThreeBatsmen = League.batsmen.stream().sorted(Comparator.comparingInt(player -> -player.playerStats.getRuns())).limit(3).collect(Collectors.toList());
        return topThreeBatsmen;
    }
    public List<Player> getTopThreeBowlers(){
        List<Player> topThreeBowlers = League.bowlers.stream().sorted(Comparator.comparingInt(player -> -player.playerStats.getWickets())).limit(3).collect(Collectors.toList());
        return topThreeBowlers;
    }
    public List<Player> getTopThreeAllRounders(){
        List<Player> topThreeAllRounders = League.allRounders.stream().sorted(Comparator.comparingInt(player -> -(player.playerStats.getRuns())-(player.playerStats.getWickets()*25))).limit(3).collect(Collectors.toList());
        return topThreeAllRounders;
    }



    public void predictTwoHighestScoringTeams(){
        class TeamScore{
            League.IPLTeam team;
            int score=0;
            public String toString(){
                return team+" predictedScore: "+score;
            }
        }
        List<TeamScore> result = new ArrayList<>();
        for(Team team: League.teams){
            int remainingBalls = 120;
            List<Player> players = team.squad.stream()
                    .sorted(Comparator.comparing(player -> -player.playerStats.getStrikeRate())).limit(11)
                    .collect(Collectors.toList());
            TeamScore current = new TeamScore();
            current.team= team.nameOfTheTeam;
            for(Player player: players){
                if(remainingBalls>0) {

                    int ballsFacedOnAverage = (int)(player.playerStats.getRuns() / player.playerStats.getStrikeRate());
                    if(remainingBalls-ballsFacedOnAverage>0)
                    {
                        current.score += player.playerStats.getAverage();
                        remainingBalls -= ballsFacedOnAverage;
                    }
                    else {
                        int proportion = (int) (player.playerStats.getAverage()/ballsFacedOnAverage * remainingBalls);
                        current.score += proportion;
                        remainingBalls = 0;
                    }
                }
            }
            result.add(current);
        }
        System.out.println("Top two highest predicted scoring teams: "+
                result.stream()
                .sorted(Comparator.comparing(team-> -team.score))
                .limit(2)
                .collect(Collectors.toList()));
    }



    public void nextGenForEachTeam(){
        System.out.println("Nextgen Players for each team are: ");
        for(Team team: League.teams) {
            List<Player> teamPlayers = team.squad;
            List<Player> nextGenPlayersOfTheTeam  = new ArrayList<>();
            System.out.print(team.nameOfTheTeam+": ");
            for (Player player : teamPlayers) {
                PlayerStats currentPlayerStats = player.playerStats;
                int matchesPlayed = currentPlayerStats.getTotalMatches();
                if(matchesPlayed<=25 && matchesPlayed > 0) {
                    int minRunsForBatsmen = currentPlayerStats.getRuns() / currentPlayerStats.getTotalMatches();
                    int minWicketsForBowler = currentPlayerStats.getWickets() / currentPlayerStats.getTotalMatches();
                    if(minRunsForBatsmen>=20 || minWicketsForBowler >= 1) nextGenPlayersOfTheTeam.add(player);
                }
            }
            System.out.println(nextGenPlayersOfTheTeam);
        }
    }
}
