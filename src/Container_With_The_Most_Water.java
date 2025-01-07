package January;

public class Container_With_The_Most_Water {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
