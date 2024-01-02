public class BaseProblem {
    public static void main(String[] args) {
        int n = 125;
        StringBuilder Ternary = new StringBuilder();
        int answer = 0;
        while (n>0) {
            Ternary.append(n % 3);
            n = n / 3;
        }

        System.out.println(Ternary);
        for (int i = Ternary.length() - 1, j = 0; i >= 0; i--, j++) {
            int a = Ternary.charAt(i) - '0';
            answer += (int) (a * (Math.pow(3, j)));
        }
        System.out.println(answer);
    }
}
