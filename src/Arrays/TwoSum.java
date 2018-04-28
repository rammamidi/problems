package Arrays;

import java.util.*;

/*
1) Given an array of integers, find two numbers such that they add up to a specific target
number
2) find all unique pairs
3) find a pair if the array is sorted (binary search or two pointer solution)
 */
public class TwoSum {

    public static int[] twoSum(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : input) {
            if (map.containsKey(i)) {
                return new int[]{i, map.get(i)};
            }
            map.put(target - i, i);
        }
        return null;
    }

    public static List<Pair> twoSumAllPairs(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap();
        List<Pair> li = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : input) {
            if (map.containsKey(i)) {
                if (!set.contains(i)) {
                    li.add(new Pair(i, map.get(i)));
                    set.add(i);
                    set.add(map.get(i));
                }
                continue;
            }
            map.put(target - i, i);
        }
        return li;
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static int[] twoSumSorted(int[] nums, int target) {

        for (int i : nums) {

            if (binarySearch(nums, i, target)) {
                return new int[]{i, target - i};
            }

        }
        return null;
    }



  private static boolean binarySearch(int []nums,int i, int target){
          int left=0,right=nums.length -1;
          int mid= (left+right)/2;

          while(left<right) {
              if(nums[mid]==target-i) return true;
              if(nums[mid]<target-i){
                  left=mid+1;
              }else {
                  right=mid-1;
              }
              mid=(left+right)/2;
          }
          return false;
      }

  public static void main(String args []) {
      int nums [] = {1,3,1,3,2,2,2,2};
      int result [] = twoSum(nums,4);
      if(result != null)
      System.out.println("A Solution is: "+ result[0] + " " + result[1]);
      else System.out.println("No result found");

      List<Pair> li = twoSumAllPairs(nums,4);
      if(li != null && !li.isEmpty()) {
          System.out.println("Num of solutions: " +li.size());
          for(Pair p : li) {
              System.out.println("solutions: " +p.a+" "+p.b);
          }
      }

      int input [] = {1,2,3,4,5,6};
      result = twoSumSorted(input,7);
      if(result != null)
          System.out.println("A Solution for sorted array is: "+ result[0] + " " + result[1]);
      else System.out.println("No result found");
  }


}
