package model;

import java.util.Date;

public class Team {

    private int teamID;
    private int tournamentID;
    private String teamName;
    private int leaderUserID;
    private Date createdAt;

    public Team() {
    }

    public Team(int teamID, int tournamentID, String teamName, int leaderUserID, Date createdAt) {
        this.teamID = teamID;
        this.tournamentID = tournamentID;
        this.teamName = teamName;
        this.leaderUserID = leaderUserID;
        this.createdAt = createdAt;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getLeaderUserID() {
        return leaderUserID;
    }

    public void setLeaderUserID(int leaderUserID) {
        this.leaderUserID = leaderUserID;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
