package model;

import java.util.Date;

public class TeamMember {

    private int teamMemberID;
    private int teamID;
    private int userID;
    private Date joinedAt;

    public TeamMember() {
    }

    public TeamMember(int teamMemberID, int teamID, int userID, Date joinedAt) {
        this.teamMemberID = teamMemberID;
        this.teamID = teamID;
        this.userID = userID;
        this.joinedAt = joinedAt;
    }

    public int getTeamMemberID() {
        return teamMemberID;
    }

    public void setTeamMemberID(int teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Date joinedAt) {
        this.joinedAt = joinedAt;
    }
}
