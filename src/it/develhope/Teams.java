package it.develhope;

enum Teams{
    XMEN("XMEN"),
    AVENGERS("AVENGERS"),
    NONAME("NONAME");

    private String teamName;

    private Teams(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }
}