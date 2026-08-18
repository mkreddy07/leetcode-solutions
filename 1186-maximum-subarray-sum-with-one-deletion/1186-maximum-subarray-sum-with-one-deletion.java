class Solution {
    public int maximumSum(int[] arr) {

        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;

        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            int previousNoDelete = noDelete;
            int previousOneDelete = oneDelete;

            // No deletion
            noDelete = Math.max(
                current,
                previousNoDelete + current
            );

            // One deletion
            if (previousOneDelete == Integer.MIN_VALUE) {
                oneDelete = previousNoDelete;
            } else {
                oneDelete = Math.max(
                    previousNoDelete,
                    previousOneDelete + current
                );
            }

            result = Math.max(
                result,
                Math.max(noDelete, oneDelete)
            );
        }

        return result;
    }
}