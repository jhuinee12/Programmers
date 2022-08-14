package main.java;

public class Country1234 {
    StringBuilder sb1 = new StringBuilder();

    public String solution(int n) {
        StringBuilder sb2 = new StringBuilder();
        Boolean zero = false;
        int num = 0;
        sb1.delete(0,sb1.length());

        for (char s : div(n).toCharArray())
        {
            num = zero ? Integer.parseInt(String.valueOf(s))-1 : Integer.parseInt(String.valueOf(s));

            if (num > 0)
            {
                sb2.append(num);
                zero = false;
            }
            else if (num == 0)
            {
                sb2.append(4);
                zero = true;
            }
            else
            {
                sb2.append(2);
                zero = true;
            }

        }

        if (sb2.length() > 1 && num==0)
            sb2.deleteCharAt(sb2.length()-1);

        return sb2.reverse().toString();
    }

    public String div (int n) {
        if (n>=3)
        {
            sb1.append(n%3);
            div(n/3);
        }
        else {
            sb1.append(n%3);
        }
        return sb1.toString();
    }

    public static void main(String[] args) {
        Country1234 sol = new Country1234();

        //System.out.println(sol.solution(18));

        for (int i=1; i<100; i++) {
            System.out.println(i + "=>" + sol.solution(i));
        }
    }

}