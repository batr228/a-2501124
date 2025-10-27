import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int op1, op2;   //Data
        int result1, result2;   //정보
        int result3;   //정보



        System.out.printf("첫 번째 수를 입력 (분자) : ");
        op1 = keyboard.nextInt();
        System.out.printf("두 번째 수를 입력 (분모) : ");
        op2 = keyboard.nextInt();



        result1 = op1 / op2;   //몫 (정수)
        result2 = op1 % op2;   //나머지
        result3 = op1/op2;   //몫 (실수)
    }
}