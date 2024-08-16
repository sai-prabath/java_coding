import java.util.*;

class Laptop{
    int laptopId;
    String brand;
    String osType;
    double price;
    int rating;
    public Laptop(int laptopId, String brand, String osType, double price, int rating){
        this.laptopId=laptopId;
        this.brand=brand; 
        this.osType=osType; 
        this.price=price; 
        this.rating=rating;
    }
}

class Solution{
    public static int countOfLaptopsByBrand(Laptop[] laptops, String brand) {
        int count=0;
        for (Laptop lap : laptops) {
            if((lap.brand).equalsIgnoreCase(brand) && lap.rating>3) {
                count+=1;
            }
        }
        return count;
    }

    public static Laptop[] searchLaptopsByOsType(Laptop[] laptops, String os) {
        ArrayList<Laptop> list = new ArrayList<> ();
        for (Laptop lap : laptops) {
            if ((lap.osType).equalsIgnoreCase(os)) {
                list.add(lap);
            }
        }
        if(list.size ()>0) {
            list.sort ( (o1, o2) -> Integer. compare (o2.laptopId, o1.laptopId)) ;
            Laptop[] ordArr = list.toArray(new Laptop[0]);
            return ordArr;
        }
        else{
            Laptop[] ordArr = {} ;
            return ordArr;
        }
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner (System. in);
        Laptop [] laptops = new Laptop [4];

        for(int i=0;i<4;i++) {
        int laptopId = sc.nextInt () ;
        sc.nextLine();
        String brand = sc.nextLine();
        String osType = sc.nextLine();
        double price = sc.nextDouble ();
        sc.nextLine ();
        int rating = sc.nextInt ();
        sc.nextLine();
        laptops [i] = new Laptop (laptopId, brand, osType, price, rating);
        }

        String brandToSearch = sc.nextLine();
        String osToSearch = sc.nextLine();

        int result1 = countOfLaptopsByBrand(laptops, brandToSearch);
        if (result1==0) {
            System.out.println("The given brand is not available");
        }
        else{
            System.out.println(result1);
        }

        Laptop[] result2 = searchLaptopsByOsType(laptops, osToSearch);
        if (result2.length == 0) {
            System.out.println("The given os is not available");
        }
        else{
            for (Laptop lap : result2) {
                System.out.println(lap.laptopId);
                System.out.println(lap.rating);
            }
        }
        sc.close();
    }
}
