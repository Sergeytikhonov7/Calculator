
public class Calc {
    public static void main(String argc[]) throws Exception {
        Calculate calculate = new Calculate();
        System.out.println("Введите выражение: ");
        calculate.ReadExpression();
        System.out.println(calculate.AnswerCalculation());
    }

}
