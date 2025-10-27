import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("당신의 키 입력 (Cm) : ");
        float height = kb.nextFloat();

        float standard = (height - 100) * 0.9f;

        System.out.printf("키 %.1f Cm의 표준 체중은 %.1f Kg 입니다.\\n", height, standard);
    }
}
