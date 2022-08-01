import java.util.*;

enum Operation{
    SUM{
        public Integer action(int x, int y){ return x + y;}
    },
    SUBTRACT{
        public Integer action(int x, int y){ return x - y;}
    },
    MULTIPLY{
        public Integer action(int x, int y){ return x * y;}
    },
    DIVISION {
        public Integer action(int x, int y) { return x / y;}
    };
    public abstract Integer action(int x, int y);
}

class Calculate {
    private Set<Character> roman_symbol;
    private Set<Character> arabic_symbol;
    private Set<Character> operation;
    private List<Integer> numbers;
    private Operation op;
    private boolean roman;

    public Calculate() {
        roman_symbol = new HashSet<Character>(Arrays.asList('I','V','X','L','C','D','M'));
        arabic_symbol = new HashSet<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        operation = new HashSet<Character>(Arrays.asList('+','-','*','/'));
        numbers = new ArrayList<>();
        roman = false;
    }

    public String AnswerCalculation() throws Exception {
        if (!roman) {
            return op.action(numbers.get(0), numbers.get(1)).toString();
        } else {
            Integer result = op.action(numbers.get(0), numbers.get(1));
            if (result<1) throw new Exception();
            ConvertManager manager = new ConvertManager();
            return manager.ArabicToRoman(result).toString();
        }

    }

    public void ReadExpression(String input) throws Exception {
        String[] tokens = input.split(" ");
        List<String> temp = new ArrayList<>();
        for (int i=0; i < tokens.length; ++i) {
            if (!tokens[i].equals("")) {
                temp.add(tokens[i]);
            }
        }
        if (temp.size() != 3) throw new Exception();
        for (int i = 0; i < 3; ++i) {
            if (operation.contains(temp.get(i).charAt(0))) {
                op = ReadOperation(temp.get(i));
            } else {
                int result = ReadNumber(temp.get(i));
                if (result < 1 || result > 10) throw new Exception();
                numbers.add(result);
            }
        }
    }

    private int ReadNumber(String str) throws Exception {
        int result = 0;
        if (arabic_symbol.contains(str.charAt(0))) {
            if (numbers.size() > 0 && roman) throw new Exception();
            result = Integer.parseInt(str);
        } else if (roman_symbol.contains(str.charAt(0))) {
            if (numbers.size() > 0 && !roman) throw new Exception();
            ConvertManager manager = new ConvertManager();
            roman = true;
            result = manager.RomanToArabic(str);
        } else {
            throw new Exception();
        }
        return result;
    }

    private Operation ReadOperation(String str) throws Exception {
            switch (str) {
                case "+": {
                    return Operation.SUM;
                }
                case "-": {
                    return Operation.SUBTRACT;
                }
                case "*": {
                    return Operation.MULTIPLY;
                }
                case "/": {
                    return Operation.DIVISION;
                }
                default: throw new Exception();
            }
    }
}
