import java.util.Map;
import java.util.HashMap;

public class ConvertManager {

    private Map<Character, Integer> roman_char_dict;

    public ConvertManager() {
        roman_char_dict = new HashMap<Character, Integer>();
        roman_char_dict.put('I', 1);
        roman_char_dict.put('V', 5);
        roman_char_dict.put('X', 10);
        roman_char_dict.put('L', 50);
        roman_char_dict.put('C', 100);
        roman_char_dict.put('D', 500);
        roman_char_dict.put('M', 1000);
    }

    public int RomanToArabic(String number) {
        int res = 0;
        for (int i = 0; i < number.length(); i += 1) {
            if (i == 0 || roman_char_dict.get(number.charAt(i)) <= roman_char_dict.get(number.charAt(i - 1)))
                res += roman_char_dict.get(number.charAt(i));
            else
                res += roman_char_dict.get(number.charAt(i)) - 2 * roman_char_dict.get(number.charAt(i - 1));
        }
        return res;
    }

    public String ArabicToRoman(int number) {
        int[] roman_value_list = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char_list = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_value_list.length; i += 1) {
            while (number >= roman_value_list[i]) {
                number -= roman_value_list[i];
                res.append(roman_char_list[i]);
            }
        }
        return res.toString();
    }
}
