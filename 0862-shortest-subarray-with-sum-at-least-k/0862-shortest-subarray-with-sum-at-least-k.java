class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int result = n + 1;

        for (int i = 0; i <= n; i++) {

            // Condition 1:
            // Find a subarray whose sum >= k
            while (!deque.isEmpty()
                    && prefix[i] - prefix[deque.peekFirst()] >= k) {

                result = Math.min(
                    result,
                    i - deque.pollFirst()
                );
            }

            // Condition 2:
            // Maintain increasing prefix sums
            while (!deque.isEmpty()
                    && prefix[i] <= prefix[deque.peekLast()]) {

                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return result == n + 1 ? -1 : result;
    }
}