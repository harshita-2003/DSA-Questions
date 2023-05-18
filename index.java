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
}