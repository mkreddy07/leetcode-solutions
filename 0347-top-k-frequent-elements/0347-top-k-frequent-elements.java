class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {

        // //Using only HashMap......
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i=0; i<nums.length; i++)
        // {
        //     hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        // }

        // List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hm.entrySet());

        // //sorting in descending order
        // entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // int result[] = new int[k];

        // for(int i=0; i<k; i++)
        // {
        //     result[i] = entryList.get(i).getKey();
        // }
        // return result;
    //}





//Using HashMap and MaxHeap datastructure...
Map<Integer, Integer> hm = new HashMap<>();

for(int num: nums)
{
    hm.put(num, hm.getOrDefault(num, 0)+1);
}

PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(hm.get(b), hm.get(a)));

for(int num: hm.keySet())
{
    pq.add(num);
}
int result[] = new int[k];
for(int i=0; i<k; i++)
{
    result[i] = pq.poll();
}
    return result;
 }
}