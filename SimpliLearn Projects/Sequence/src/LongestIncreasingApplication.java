import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LongestIncreasingApplication {

    private final ArrayList<ArrayList<Integer>> allSeqResult = new ArrayList<>();

    public static void main(String[] args) {


        int n = 10;
        SequenceGenerator sg = new SequenceGenerator(n);
        ArrayList<Integer> sequence = sg.GenerateSequence();
        System.out.print("Input List:");
        for (int i : sequence) {
            System.out.print( i + " ");
        }

        LongestIncreasingApplication lia  = new  LongestIncreasingApplication();
        Integer [] arr = new Integer[sequence.size()];
        int result = lia.execute((Integer[]) sequence.toArray(arr));
        System.out.println("\nLongest seq length:" + result);

        lia.findAllLongestIncreaseSeq(arr);
        ArrayList<Integer> result1 = lia.findLongestIncreaseSeq();
        System.out.println("Longest seq:" + result1);


    }

    public LongestIncreasingApplication(){

    }

    public ArrayList<Integer> findLongestIncreaseSeq() {
        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(ArrayList<Integer> item : allSeqResult){
            int len = item.size();
            if( len > max){
                max = len;
                result = item;
            }
        }
        return result;
    }


    public void findAllLongestIncreaseSeq(Integer[] nums) {

        ArrayList<Integer> tempList = new ArrayList<>();
        int size = nums.length;
        int maxans = 1;
        for (int i = 0; i < size; i++) {
            tempList = new ArrayList<>();
            tempList.add(nums[i]);
            maxans = nums[i];
            for (int z = i+1; z < size; z++) {
                //  System.out.println("z:" + z + " nums[z]:" + nums[z] + " i:" + i + " max:" + maxans +  " nums[i]:" + nums[i]);
                for (int j = z; j < size; j++) {
                    if (nums[j] > maxans) {
                        tempList.add(nums[j]);
                        maxans = nums[j];
                    }
                }
                maxans = nums[i];
                //System.out.println(this + " " + tempList + "\n");
                allSeqResult.add(tempList);
                tempList = new ArrayList<>();
                tempList.add(nums[i]);
            }

        }

    }


    public int execute(Integer[] item){
        return this.findLongestIncreaseSeq(item);

    }

    public int findLongestIncreaseSeq(Integer[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }
}