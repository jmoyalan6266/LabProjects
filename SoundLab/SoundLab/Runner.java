import java.util.Arrays;
public class Runner
{
    public static void main(String[] args) 
    {
        SoundLabProbs test= new SoundLabProbs();
        test.triangle(7);
        System.out.println(test.lastIndexOf(new int[] {8, 2, 4, 6, 8}, 8));
        System.out.println(test.lastIndexOf(new int[] {2, 4, 6, 12}, 8) );
        System.out.println(test.range(new int[] {8, 3, 5, 7, 2, 4}));
        System.out.println(test.range(new int[] {15, 22, 8, 19, 31}));
        System.out.println(test.range(new int[] {100, 5}) );
        System.out.println(test.minDifference(new int[] {4, 8, 6, 1, 5, 9, 4}));
        System.out.println(test.priceIsRight(new int[] {900, 885, 990, 1}, 800));
        System.out.println(test.priceIsRight(new int[] {1500, 1600, 2000, 2500}, 1900));
        System.out.println(test.priceIsRight(new int[] {2000, 3000, 4000, 5000}, 1500));
        System.out.println(Arrays.toString(test.productExceptSelf(new int[] {1, 2, 3, 4})));
    }
}

class SoundLabProbs
{
    public void triangle(int n)
    {

        for (int i=1; i<=n;i++){
            for (int t=0; t < i;t++){
                System.out.print(i);
            }
            System.out.println();
        }

    }

    public int lastIndexOf(int[] nums, int value)
    {
        int lastIndex=-1;
        for (int i=nums.length-1;i >=0 ;i--)
        {
            if(nums[i]==value)
            {
                lastIndex=i;
                break;
            }

        }
        return lastIndex;
    }

    public int range(int[] nums)
    {
        int max=0; 
        for (int i=0;i <nums.length; i++){
            if (nums[i]>max){max=nums[i];}
        }
        int min=max;
        for (int i=0;i <nums.length; i++){
            if (nums[i]<min){min=nums[i];}
        }
        return max-min;

    }

    public int minDifference(int[] nums) 
    {
        int minDif=0;
        int t=0;
        for (int i=0; i <nums.length;i++){
            if (nums[i]>minDif){
                minDif=nums[i];
            }
        }
        for (int i=0; i <nums.length-1;i++){
            t=Math.abs(nums[i]-nums[i+1]);
            if (t<minDif){
                minDif=t;
            }
        }
        return minDif;
    }

    public int priceIsRight(int[] bids, int price)
    {
        int minDif=price;
        int t;
        int tot=0;
        for (int i=0;i<bids.length;i++){
            t=price-bids[i];
            if ((t<minDif)&&(t>=0))
            {minDif=t;
                tot=bids[i];}
        }
        if (minDif<price){
            return tot;
        }
        else {return -1;}

    }

    public int[] productExceptSelf(int[] nums)
    {
        int[] multi= new int[nums.length];
        for(int i=0;i<multi.length;i++){
         multi[i]=1;
        }
        for (int i=0;i < nums.length;i++)
        {
            for (int t=0; t< nums.length;t++)
            {
                if (i==t){
                    }
                else{
                multi[i]*=nums[t];
                }
            }
        }
        return multi;
    }
}
