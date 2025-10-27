import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int HEART = 65;
        int life;
        int result;

        System.out.printf("당신은 몇년 살았나요?");
        life = keyboard.nextInt();

        result = life * 365 * 24 * 60 * HEART;


        System.out.printf("심장은 분당 %d회 박동합니다.\n",HEART);
        System.out.printf("%d년동안 살았다면 %,d 회 심장박동 했습니다.\n",life,result);
    }
}