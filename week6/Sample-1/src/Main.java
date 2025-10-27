//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        final int KOREA = 99720;        // 대한민국의 면적
        final int NORTH_KOREA = 122762; // 북한의 면적
        final int USA = 9631418;        // 미국의 면적
        final int JAPAN = 377873;       // 일본의 면적

        float temp1, temp2, temp3;

        temp1 = (float) NORTH_KOREA / KOREA;
        temp2 = (float) USA / KOREA;
        temp3 = (float) JAPAN / KOREA;

        System.out.printf("대한민국의 면적 : %,d ㎢\n", KOREA);
        System.out.printf("북한의 면적 : %,d ㎢\n", NORTH_KOREA);
        System.out.printf("미국의 면적 : %,d ㎢\n", USA);
        System.out.printf("일본의 면적 : %,d ㎢\n", JAPAN);

        System.out.printf("북한은 대한민국에 %.1f 배 입니다.\n", temp1);
        System.out.printf("미국은 대한민국에 %.1f 배 입니다.\n", temp2);
        System.out.printf("일본은 대한민국에 %.1f 배 입니다.\n", temp3);
    }
}