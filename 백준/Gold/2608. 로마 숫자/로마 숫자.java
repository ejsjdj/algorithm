import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int romanToArabic(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanMap.get(s.charAt(i));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        
        return result;
    }

    public static String arabicToRoman(int num) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arabicValues.length; i++) {
            while (num >= arabicValues[i]) {
                sb.append(romanNumerals[i]);
                num -= arabicValues[i];
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roman1 = sc.nextLine();
        String roman2 = sc.nextLine();

        int arabic1 = romanToArabic(roman1);
        int arabic2 = romanToArabic(roman2);
        int sum = arabic1 + arabic2;

        System.out.println(sum);
        System.out.println(arabicToRoman(sum));
        
        sc.close();
    }
}