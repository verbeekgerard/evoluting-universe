package eu.luminis.domain;

public class Stats {
    private int totalStarved;
    private int totalCollisions;
    private int totalWandered;
    private int totalDiedOfAge;
    private String avgHealth;
    private String best;

    public Stats(int totalStarved, int totalCollisions, int totalWandered, int totalDiedOfAge, String avgHealth, String best) {
        this.totalStarved = totalStarved;
        this.totalCollisions = totalCollisions;
        this.totalWandered = totalWandered;
        this.totalDiedOfAge = totalDiedOfAge;
        this.avgHealth = avgHealth;
        this.best = best;
    }

    public Stats(){}

    public String getBest() {
        return this.best;
    }
    public void setBest(String best) {
        this.best = best;
    }
    public String getAvgHealth() {
        return this.avgHealth;
    }
    public void setAvgHealth(String avgHealth) {
        this.avgHealth = avgHealth;
    }
    public int getTotalDiedOfAge() {
        return this.totalDiedOfAge;
    }
    public void setTotalDiedOfAge(int totalDiedOfAge) {this.totalDiedOfAge = totalDiedOfAge;}
    public int getTotalWandered() {
        return this.totalWandered;
    }
    public void setTotalWandered(int totalWandered) {
        this.totalWandered = totalWandered;
    }
    public int getTotalCollisions() {
        return this.totalCollisions;
    }
    public void setTotalCollisions(int totalCollisions) {
        this.totalCollisions = totalCollisions;
    }
    public int getTotalStarved() {
        return this.totalStarved;
    }
    public void setTotalStarved(int totalStarved) {
        this.totalStarved = totalStarved;
    }

    public String toString() {
        return "avg. health:\t" + this.avgHealth + "\t" + "totalCollisions:\t" + this.totalCollisions + "\t" + "totalStarved:\t" + this.totalStarved + "\t" + "totalWandered:\t" + this.totalWandered + "\t" + "totalDiedOfAge:\t" + this.totalDiedOfAge + "\t" + "best:\t" + this.best + "\t";
    }
}
