public class Main {
    public static void main(String[] args) {
        final int RADIUS = 6378137;
        final int KOREA = 99720;
        final double PI = 3.141592;
        double surface;
        double result;

        surface = 4 * PI * RADIUS * RADIUS / 1000;
        result = KOREA / surface * 100;


        System.out.printf("지구의 반지름은 %,d \u339E 입니다.\n",RADIUS / 1000);
        System.out.printf("지구의 표면적은 %,.0f \u33a2 입니다.\n",surface);
        System.out.printf("대한민국의 면적은 %,d \u33a2 입니다.\n",KOREA);
        System.out.printf("대한민국은 지구의 %.8f %% 입니다.\n",result);
    }
}