class i_th_bit_of_a_number
{
    static void ithBit(int n, int i){
        String ans=Integer.toBinaryString(n & (1 << (i - 1))>>(i-1));
        System.out.println(ans);
    }
    //set the ith bit to 1
    static void set_ithBit(int n, int i){
        String ans=Integer.toBinaryString(n | (1 << (i - 1)) | 1);
        System.out.println(ans);
    }
    //reset the ith bit to 0
    static void reset_ithBit(int n, int i){
        String ans=Integer.toBinaryString(n & ~(1 << (i - 1)));
        System.out.println(ans);
    }

    public static void main(String args[]){
        System.out.println("Number : "+Integer.toBinaryString(147));
        ithBit(147,5);  
        set_ithBit(147,5);
        reset_ithBit(147,5);
    }
}
