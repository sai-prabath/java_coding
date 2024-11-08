import java.util.*;

class Spotify {
    public int id;
    public String name;
    public String stype;
    public double price;
    public String groupsessions;

    public Spotify(int id, String name, String stype, double price, String groupsessions) {
        this.id = id;
        this.name = name;
        this.stype = stype;
        this.price = price;
        this.groupsessions = groupsessions;
    }
}

public class Solution {
    public static double SearchSpotifyAvg(Spotify[] spotifys, String s1, String s2) {
        double res = 0.0;
        int count = 0;
        for (Spotify i : spotifys) {
            if (i.stype.equalsIgnoreCase(s1) && i.groupsessions.equalsIgnoreCase(s2)) {
                res += i.price;
                count++;
            }
        }
        return res / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Spotify[] spotifys = new Spotify[4];
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String stype = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            String groupsessions = sc.nextLine();
            spotifys[i] = new Spotify(id, name, stype, price, groupsessions);
        }
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        double res = SearchSpotifyAvg(spotifys, s1, s2);
        if (res > 0) {
            System.out.println(res);
        } else {
            System.out.println("No such users");
        }
        sc.close();
    }
}

// TCS IPA 7th Nov 2024