// you are given an array where every elementn is present twice except one element find that element
// a XOR a = 0 
// a XOR 0 = a
class UniqueElement
{
    static int findUnique(int arr[]){
     int ans=0;
     for(int n : arr)
        ans=ans ^ n;
     return ans;   
    }
    public static void main(String args[]){
        int arr[]={2,4,2,4,6,5,3,5,3};
        System.out.println(findUnique(arr));
    }
}
