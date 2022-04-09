package MakeADecimal;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        /* i = 0���� nums�� ũ����� for�� (ù��° ����) */
        for (int i=0; i<nums.length-2; i++) {
            /* j = 0���� nums�� ũ����� for�� (�ι�° ����) */
        	for (int j=i+1; j<nums.length-1; j++) {
        		/* k = 0���� nums�� ũ����� for�� (����° ����) */
            	for (int k=j+1; k<nums.length; k++) {
        			int sum = nums[i] + nums[j] + nums[k];
        			int count = 0;
        			for (int z=2; z<sum; z++) {
        				if (sum % z == 0) count++;
        			}
                			
        			if (count == 0) answer++;
        		}
        	}
        }

        return answer;
    }

	public static void main(String[] args) {
		int nums1[] = {1,2,3,4};
		int nums2[] = {1,2,7,6,4};
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(nums1));
		System.out.println(sol.solution(nums2));
	}

}
