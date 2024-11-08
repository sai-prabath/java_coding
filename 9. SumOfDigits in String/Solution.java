import java.util.*;

public class Solution {
    public static int chkDigit(char c) {
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
            return Character.getNumericValue(c);
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            int val = chkDigit(str.charAt(i));
            if(val > 0){
                count+=val;
            }
        }

        if(count<15){
            System.out.println(count);
        }
        else{
            System.out.println("No Digits");
        }
        sc.close();
    }
}

// TCS IPA 7th Nov 2024