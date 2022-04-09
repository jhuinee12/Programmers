package SecretMap;

import java.util.Arrays;

public class Solution {
	/**
	 * @param n 배열의 크기
	 * @param arr1 첫번째 지도 배열
	 * @param arr2 두번째 지도 배열
	 * @return
	 */
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i=0; i<n; i++){
			// arr[i]와 arr[2]의 or를 저장할 변수 newStr
			String newStr = Integer.toBinaryString(arr1[i] | arr2[i]);
			System.out.println("newStr = " + newStr);
			// newStr의 문자 중 '1'을 '#'으로 변환
			newStr = newStr.replaceAll("1", "#");
			// newStr의 문자 중 '0'을 ' '로 변환
			newStr = newStr.replaceAll("0", " ");
			// newStr의 문자 중 앞 공백 추가
			if (newStr.length() < n) answer[i] = padLeftSpace(newStr, n);
			else answer[i] = newStr;
			System.out.println("answer = " + answer[i]);
		}
		
		return answer;
	}
	
	// 앞 공백 추가 함수
	public String padLeftSpace(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append(' ');
	    }
	    sb.append(inputString);

	    return sb.toString();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] Aarr1 = {9, 20, 28, 18, 11};
		int[] Aarr2 = {30, 1, 21, 17, 28};
		int[] Barr1 = {46, 33, 33 ,22, 31, 50};
		int[] Barr2 = {27 ,56, 19, 14, 14, 10};

		System.out.println(Arrays.toString(sol.solution(5, Aarr1, Aarr2)));
		System.out.println(Arrays.toString(sol.solution(6, Barr1, Barr2)));
	}

}
