public class index{

    //FIND ELEMENT IN MOUNTAIN ARRAY
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,6,5,4,3,2};
        int target = 4;
        System.out.println(search(arr , target));
    }
    static int search(int[]arr , int target){
        int peak = mountainarray(arr);
        int do_search = binarysearch(arr,target,0,peak);
        if(do_search!=-1){
            return do_search;
        }
        return binarysearch(arr,target,peak+1,arr.length-1);
    }
    public static int mountainarray(int[] arr){
        int start=0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;

        if(arr[mid]<arr[mid+1]){
            start=mid+1;
        }else if(arr[mid]>arr[mid+1]){
            end=mid;
        }

        return start;
    }
    static int binarysearch(int[] arr,int target,int start ,int end){
        boolean isasc = arr[start]<arr[end];

        while(start<=end){
            int mid = start + (end - start)/2;

            if(arr[mid]==target){
                return mid;
            }
            if(isasc){
                if(target<arr[mid]){
                    end = mid -1 ;
                } else if (target>arr[mid]) {
                    start = mid +1;
                }
            } else  {
                if(target>arr[mid]){
                    end = mid -1 ;
                } else if (target<arr[mid]) {
                    start = mid +1;
                }
            }
        }
        return -1;
    }


    //BINARY SEARCH IN 2D ARRAY
    public static void main(String[] args) {
        int[][] arr = { {1,2,3,4} ,
                        {5,6,7,8} ,
                        {9,10,11,12} ,
                        {13,14,15,16} };
        int target = 9;
        int[] ans = search(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    
    static int[] search(int[][] arr,int target){
        int r = 0;
        int c = arr.length-1;

        while(r < arr.length && c >=0){
            if (arr[r][c] == target){
                return new int[]{r,c};
            }
            if(arr[r][c] < target){
                r++;
            } else if (arr[r][c] > target) {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
    
}