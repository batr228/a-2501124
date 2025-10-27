import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int salary, bonus;
        int total, tax;

        System.out.print("월급 입력 : ");
        salary = kb.nextInt();
        System.out.print("보너스 입력 : ");
        bonus = kb.nextInt();

        total = salary + bonus;
        tax = (int) (total * 0.08f);
        tax = (tax / 10) * 10;

        System.out.printf("본봉은 %,d 원\\n", salary);
        System.out.printf("보너스는 %,d 원\\n", bonus);
        System.out.printf("총 수입액 = %,d 원\\n", total);
        System.out.printf("세금 : %,d 원\\n", tax);
        System.out.printf("실 입금액 = %,d 원\\n", total - tax);
    }
}
