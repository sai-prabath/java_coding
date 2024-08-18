import java.util.*;

class Player {
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;
    
    public Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getRuns() {
        return runs;
    }

    public String getPlayerType() {
        return playerType;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
}

class Solution {
    
    public static int findPlayerWithLowestRuns(Player[] players, String type) {
        int minRuns = Integer.MAX_VALUE;
        boolean found = false;
        
        for (Player player : players) {
            if (player.getPlayerType().equalsIgnoreCase(type)) {
                found = true;
                if (player.getRuns() < minRuns) {
                    minRuns = player.getRuns();
                }
            }
        }
        
        return found ? minRuns : 0;
    }

    public static Player[] findPlayerByMatchType(Player[] players, String matchType) {
        List<Player> matchedPlayers = new ArrayList<>();
        
        for (Player player : players) {
            if (player.getMatchType().equalsIgnoreCase(matchType)) {
                matchedPlayers.add(player);
            }
        }
        
        if (matchedPlayers.isEmpty()) {
            return null;
        }
        
        matchedPlayers.sort((p1, p2) -> Integer.compare(p2.getPlayerId(), p1.getPlayerId()));
        
        return matchedPlayers.toArray(new Player[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];

        for (int i = 0; i < 4; i++) {
            int playerId = sc.nextInt();
            sc.nextLine(); // to consume the newline after the integer
            String playerName = sc.nextLine();
            int runs = sc.nextInt();
            sc.nextLine(); // to consume the newline after the integer
            String playerType = sc.nextLine();
            String matchType = sc.nextLine();
            
            players[i] = new Player(playerId, playerName, runs, playerType, matchType);
        }

        String playerTypeToSearch = sc.nextLine();
        String matchTypeToSearch = sc.nextLine();

        int minRuns = findPlayerWithLowestRuns(players, playerTypeToSearch);

        if (minRuns > 0) {
            System.out.println(minRuns);
        } else {
            System.out.println("No such player");
        }

        Player[] resultPlayers = findPlayerByMatchType(players, matchTypeToSearch);

        if (resultPlayers != null) {
            for (Player player : resultPlayers) {
                System.out.println(player.getPlayerId());
            }
        } else {
            System.out.println("No Player with given matchType");
        }
        
        sc.close();
    }
}