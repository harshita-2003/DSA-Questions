import java.util.Arrays;

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


    //Split array largest sum
    public static void main(String[] args) {
        int [] arr = {7,2,5,10,8};
        int [] arr2 = {8,7,12,6,9,7,13,10};
        int m =2;
        int m2 = 4;
        int ans = search(arr,m);
        System.out.println(ans);
        System.out.println(sals(arr2,m));
        System.out.println(sals(arr2,m2));
    }

    static int sals(int[] arr ,int m){
        int start = 0;
        int end   = 0;

        for (int i = 0; i < arr.length; i++) {
            start = Math.max(start,arr[i]);
            end  += arr[i];
        }

        while(start < end){
            int mid = start +(end-start)/2;
            int sum = 0;
            int pieces = 1;

            for(int num : arr){
                if(sum + num > mid){
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }

            if(pieces > m){
                start = mid + 1;
            }else {
                end = sum;
            }
        }

        return end;
    }



    //BUBBLE SORT
    public static void main(String[] args) {
        int[] array = {3 , 1 , 5 , 4 , 2};
        bubble(array);
        System.out.println(Arrays.toString(array));
    }
    
    static void bubble(int[] arr) {
        //n-1 times
        for (int i = 0; i < arr.length; i++) {
            //dec by 1 since it gets sorted from end
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}