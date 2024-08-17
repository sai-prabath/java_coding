import java.util.*;

class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public void setNoOfRoomsBooked(int noOfRoomsBooked) {
        this.noOfRoomsBooked = noOfRoomsBooked;
    }

    public String getWifiFacility() {
        return wifiFacility;
    }

    public void setWifiFacility(String wifiFacility) {
        this.wifiFacility = wifiFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}

class Solution {
    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String month) {
        int count = 0;
        for (Hotel hotel : hotels) {
            String[] dp = hotel.getDateOfBooking().split("-");
            if (dp[1].equalsIgnoreCase(month)) {
                count += hotel.getNoOfRoomsBooked();
            }
        }
        return count;
    }
    
    public static Hotel searchHotelByWifiOption(Hotel[] hotels, String wifi) {
        ArrayList<Hotel> resHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getWifiFacility().equalsIgnoreCase(wifi)) {
                resHotels.add(hotel);
            }
        }

        // Convert ArrayList to array
        Hotel[] resHotelsArray = resHotels.toArray(new Hotel[0]);

        if (resHotelsArray.length > 1) {
            Arrays.sort(resHotelsArray, (p1, p2) -> Double.compare(p2.getTotalBill(), p1.getTotalBill()));
            return resHotelsArray[1];
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] hotels = new Hotel[4];

        for (int i = 0; i < 4; i++) {
            int hotelId = sc.nextInt();
            sc.nextLine();  // Consume newline
            String hotelName = sc.nextLine();
            String dateOfBooking = sc.nextLine();
            int noOfRoomsBooked = sc.nextInt();
            sc.nextLine();  // Consume newline
            String wifiFacility = sc.nextLine();
            double totalBill = sc.nextDouble();
            sc.nextLine();  // Consume newline
            hotels[i] = new Hotel(hotelId, hotelName, dateOfBooking, noOfRoomsBooked, wifiFacility, totalBill);
        }

        String month = sc.nextLine();
        String wifiOption = sc.nextLine();

        int totRooms = noOfRoomsBookedInGivenMonth(hotels, month);
        if (totRooms == 0) {
            System.out.println("No rooms booked in the given month");
        } else {
            System.out.println(totRooms);
        }

        Hotel secondMaxBill = searchHotelByWifiOption(hotels, wifiOption);
        if (secondMaxBill == null) {
            System.out.println("No such option available");
        } else {
            System.out.println(secondMaxBill.getHotelId());
        }
        sc.close();
    }
}

