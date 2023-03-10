public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        return findMaxConsecutiveOnesAfterPracticing(nums);
    }

    public int findMaxConsecutiveOnesAfterPracticing(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    public int findMaxConsecutiveFirstAttempt(int[] nums) {
        int maxConsecutiveOne = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            }
            //
            else if (maxConsecutiveOne < counter) {
                maxConsecutiveOne = counter;
                counter = 0;
            } else {
                counter = 0;
            }
        }
        if (maxConsecutiveOne < counter) {
            maxConsecutiveOne = counter;
        }
        return maxConsecutiveOne;
    }
}