package assignments.assignment1;

public class PlayerStats {
    public int matches;
    public int runs;
    public double average;
    public double strikeRate;
    public int wickets;
    public PlayerStats(int matches, int runs, int wickets, double average, double strikeRate){
        this.matches = matches;
        this.runs = runs;
        this.wickets = wickets;
        this.average = average;
        this.strikeRate = strikeRate;
    }
    public int getTotalMatches() {
        return matches;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public double getAverage() {
        return average;
    }
    public double getStrikeRate() {
        return strikeRate;
    }
}
