public class d {
    public static void main(String[] args) {
        int []arr ={12,23,4,23,45,76};
        sort(arr);
     

    }
    public static  void sort(int []arr){
        int n= arr.length;

        for(int i=0;i<n-1;i++){
            for( int j=i+1;j<n-1;j++){
                if (arr[i]<arr[j]) {
                    swap( arr,i,j);
                }
            }
        }
        for(int i=0;i<n-1;i++){
        System.out.println(arr[i]);
        }
        
    }
   public  static void swap( int [] arr,int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
   
}