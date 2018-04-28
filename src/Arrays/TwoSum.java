package Arrays;

import java.util.*;

/*
//Given an array of integers, find two numbers such that they add up to a specific target
//number
 */
public class TwoSum {

  public static int [] twoSum(int [] input, int target) {
      Map<Integer, Integer> map = new HashMap();
      for (int i : input) {
          if(map.containsKey(i)) {
              return new int[]{i,map.get(i)};
          }
          map.put(target-i,i);
      }
      return null;
  }

  public static List<Pair> twoSumAllPairs(int [] input, int target){
      Map<Integer, Integer> map = new HashMap();
      List<Pair> li = new ArrayList<>();
      Set<Integer> set = new HashSet<>();
      for (int i : input) {
          if(map.containsKey(i)) {
              if(!set.contains(i)) {
                  li.add(new Pair(i, map.get(i)));
                  set.add(i);
                  set.add(map.get(i));
              }
          }
          map.put(target-i,i);
      }
      return li;
  }

  static class  Pair {
      int a;
      int b;
      Pair(int a, int b){
          this.a=a;
          this.b=b;
      }
  }
  public static void main(String args []) {
      int nums [] = {1,5,3,4,4,4,5,7,9};
      int result [] = twoSum(nums,14);
      if(result != null)
      System.out.println("A Solution is: "+ result[0] + " " + result[1]);
      else System.out.println("No result found");

      List<Pair> li = twoSumAllPairs(nums,10);
      if(li != null && !li.isEmpty()) {
          System.out.println("Num of solutions: " +li.size());
          for(Pair p : li) {
              System.out.println("solutions: " +p.a+" "+p.b);
          }
      }
  }


}
