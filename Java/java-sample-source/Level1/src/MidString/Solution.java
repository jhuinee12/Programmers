package MidString;

class Solution {
	public String solution(String s) {
  		String answer = "";
		  
	    int size = s.length();
	    int n = size/2;

	    if(size % 2 == 0)
		    answer = s.substring(n-1,n+1);
	    else
	     answer = s.substring(n,n+1);
	      
	    System.out.println(answer);
	    return answer;
    }
	
    String getMiddle(String word){
        return word.substring((word.length()-1) / 2, word.length()/2 + 1);    
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.getMiddle("abcde"));
		System.out.println(sol.getMiddle("qwer"));
	}

}
