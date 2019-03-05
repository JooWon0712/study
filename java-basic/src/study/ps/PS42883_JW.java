package study.ps;

public class PS42883_JW {

    public static void main(String[] args) {
//        String number = "1924";
//        int k = 2;
//        String number = "1231234";
//        int k = 3;
        String number = "4177252841";
        int k = 4;

        // 4시간동안 풀었는데 틀림..
        String result = Solution(number, k);
        System.out.println(result);
    }

    private static String Solution(String number, int k) {

        int resultLength = number.length() - k;
        var numberList = number.split("");

        int max = 0;
        for (int i = 0; i < numberList.length; i++) {
            for (int j = i+1; j <= k+1; j++) {
                int subStringEnd = (j+resultLength-1);
                int result = Integer.parseInt(numberList[i]+number.substring(j, subStringEnd));

                if (max < result) {
                   max = result;
                }
//                System.out.print("i >> "+i+"j >> "+j+" , resultLength >> "+subStringEnd);
                System.out.println(" result >> "+result);
            }
        }
        return String.valueOf(max);
    }
}
