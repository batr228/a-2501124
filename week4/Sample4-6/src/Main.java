import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        float height;
        float weight;
        final float FEETUNIT = 0.0328084f;
        final float POUNDUNIT = 2.20462f;
        float feet, pound;

        System.out.print("당신의 키 입력 (170.3 Cm) : ");
        height = kb.nextFloat();
        System.out.print("당신의 몸무게 입력 (72.3 Kg) : ");
        weight = kb.nextFloat();

        feet = height * FEETUNIT;
        pound = weight * POUNDUNIT;

        System.out.printf("당신의 키(%.2f Cm)는 %.2f 피트(feet) 입니다.\\n", height, feet);
        System.out.printf("당신의 몸무게(%.2f Kg)는 %.2f 파운드(pound)입니다.\\n", weight, pound);
    }
}