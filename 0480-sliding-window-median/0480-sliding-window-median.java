
class Solution {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    HashMap<Integer, Integer> delayed;

    int maxSize = 0;
    int minSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        minHeap = new PriorityQueue<>();

        delayed = new HashMap<>();

        maxSize = 0;
        minSize = 0;

        double[] result = new double[nums.length - k + 1];

        // Insert first k elements
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }

        result[0] = findMedian();

        // Slide the window
        for (int i = k; i < nums.length; i++) {

            // Add new element
            addNum(nums[i]);

            // Remove outgoing element
            removeNum(nums[i - k]);

            // Find median
            result[i - k + 1] = findMedian();
        }

        return result;
    }

    // Add a number
    public void addNum(int num) {

        prune(maxHeap);

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
            maxSize++;
        }
        else {
            minHeap.add(num);
            minSize++;
        }

        balance();
    }

    // Remove a number using lazy deletion
    public void removeNum(int num) {

        prune(maxHeap);

        delayed.put(
            num,
            delayed.getOrDefault(num, 0) + 1
        );

        if (num <= maxHeap.peek()) {

            maxSize--;

            if (num == maxHeap.peek()) {
                prune(maxHeap);
            }
        }
        else {

            minSize--;

            if (!minHeap.isEmpty() && num == minHeap.peek()) {
                prune(minHeap);
            }
        }

        balance();
    }

    // Remove delayed elements from heap root
    public void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (delayed.containsKey(num)) {

                heap.poll();

                int count = delayed.get(num);

                if (count == 1) {
                    delayed.remove(num);
                }
                else {
                    delayed.put(num, count - 1);
                }
            }
            else {
                break;
            }
        }
    }

    // Balance both heaps
    public void balance() {

        if (maxSize > minSize + 1) {

            prune(maxHeap);

            minHeap.add(maxHeap.poll());

            maxSize--;
            minSize++;

            prune(maxHeap);
        }
        else if (maxSize < minSize) {

            prune(minHeap);

            maxHeap.add(minHeap.poll());

            minSize--;
            maxSize++;

            prune(minHeap);
        }
    }

    // Find median
    public double findMedian() {

        prune(maxHeap);
        prune(minHeap);

        if (maxSize > minSize) {
            return maxHeap.peek();
        }

        return ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

//Brute force:
//  double []temp3 = new double[nums.length];
//         if(nums.length == 1)
//         {
//             temp3[0] = nums[0];
//             return temp3;
//         }

        

//         if(k%2==0)
//         {

//         double[] temp1 = new double[nums.length-k+1];

//         double[] temp2 = new double[k];

//         int j =0;

//         for(int i=0; i<k; i++)
//         {
//             temp2[i] = nums[i];
//         }
//         Arrays.sort(temp2);
//         temp1[j++] = (temp2[1]+temp2[2])/2.0;

//         for(int right=k; right<nums.length; right++)
//         {
//             temp2[0] = nums[right-k+1];
//             temp2[1] = nums[right-k+2];
//             temp2[2] = nums[right-k+3];

//             Arrays.sort(temp2);

//             temp1[j++] = (temp2[1]+temp2[2])/2.0;

//         }
//         return temp1;

//         }

//     else
//         {
//         double[] temp1 = new double[nums.length-k+1];

//         double[] temp2 = new double[k];

//         int j =0;

//         for(int i=0; i<k; i++)
//         {
//             temp2[i] = nums[i];
//         }
//         Arrays.sort(temp2);
//         temp1[j++] = temp2[1];

//         for(int right=k; right<nums.length; right++)
//         {
//             temp2[0] = nums[right-k+1];
//             temp2[1] = nums[right-k+2];
//             temp2[2] = nums[right-k+3];

//             Arrays.sort(temp2);

//             temp1[j++] = temp2[1];

//         }
//         return temp1;
//     }