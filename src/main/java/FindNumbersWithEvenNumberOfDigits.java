public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int evenDigitLengthCount = 0;
        for (int num : nums) {
            if (hasEvenDigits(num)) {
                evenDigitLengthCount++;
            }
        }
        return evenDigitLengthCount;
    }

    private boolean hasEvenDigits(int num) {
        return getLengthOfDigit(num) % 2 == 0;
    }

    private int getLengthOfDigit(int num) {
        if (num == 0) return 1;
        if (num < 0) num = Math.abs(num);
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits findNumbersWithEvenNumberOfDigits = new FindNumbersWithEvenNumberOfDigits();
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbersWithEvenNumberOfDigits.findNumbers(nums));
    }
}
