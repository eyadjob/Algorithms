package codility;

public class BinaryGap {

    public static int solution(int n) {
        String br = Integer.toBinaryString(n);
        boolean f = true;
        boolean scf = false;
        int mx = 0;
        int tmax = 0;
        for (int i = 0; i < br.length(); i++) {
            if (scf) {
                if (br.charAt(i) == '0') {
                    tmax++;
                } else {
                    if (mx < tmax) {
                        mx = tmax;
                    }
                    tmax = 0;
                    scf = false;
                }
            }
            if (br.charAt(i) == '1') {
                scf = true;
            }
            if (i == (br.length() - 1) && br.charAt(i) == '0') {
                tmax--;
            }
        }
        return mx;
    }


    public static void main(String[] args) {


        System.out.println(solution(20));

        System.out.println(solution(529));

        System.out.println(solution(1041));

        System.out.println(solution(561892));


    }
}
