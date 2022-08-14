package main.java;

public class CaesarPassword {
    public String CaesarPassword(String s, int n) {
        char[] charArr = s.toCharArray();
        for(int i = 0 ;i < charArr.length; i++) {
            if(charArr[i]==' ')
                continue;
            else if(charArr[i]<='Z'&&charArr[i]>='A'&&charArr[i]+n>'Z')
                charArr[i] = (char) (charArr[i] + n - 26);
            else if(charArr[i]+n>'z')
                charArr[i] = (char) (charArr[i] + n - 26);
            else
                charArr[i] = (char) (charArr[i] + n);
        }

        return new String(charArr);
    }

}
