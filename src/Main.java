import java.util.Scanner;

public class Main {
    public static void main(String argc[]) throws Exception {
        System.out.println("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) throws Exception {
        Calculate calculate = new Calculate();
        calculate.ReadExpression(input);
        return calculate.AnswerCalculation();
    }

}
