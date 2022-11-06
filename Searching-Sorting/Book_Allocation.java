import java.io.*;
import java.util.*;
class Book_Allocation
{
    //function to check if it is possible to allocate the books such that the 
    //maximum number of pages assigned to any student is numPages
    static boolean isPossible(int arr[], int n, int students, int curr_min_pages)
    {
        int cntStudents = 1;
        int currPages= 0;

        // iterate over all the books
        for (int i = 0; i < n; i++)
        {

            if (arr[i] > curr_min_pages) // if book has more pages than curr_min_pages
                return false;

            if (currPages + arr[i] > curr_min_pages) // if u cannot allot nay more books to curr student
            {		
                //Increment student count by '1'
                cntStudents++;	
                /* assign current book to next student and update currPages */
                currPages = arr[i];	
                /* If count of students becomes greater than given no. of students, return False*/
                if (cntStudents > students)
                    return false;

            }
            /* Else assign this book to current student and update curSum */
            else
                currPages += arr[i];
        }
        return true;
    }

    // method to find minimum pages
    static int findPages(int arr[], int n, int m)
    {
        long sum = 0;
        int min=Integer.MAX_VALUE;
        /* If number student is more than number of books */
        if (n < m)
            return -1;

        /* Count total number of pages */
        for (int i = 0; i < n; i++)
        {   min=Math.min(min,arr[i]);
            sum += arr[i];
        }

        /* Initialize start with min pages and end with sum */
        int start = min, end = (int) sum;
        int result = Integer.MAX_VALUE;

        /* Traverse until start <= end , binary search */
        while (start <= end)
        {
            /* Check if it is possible to distribute books by using mid as current maximum */
            int mid = (start + end) / 2;
            if (isPossible(arr, n, m, mid))
            {
                result = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int arr[] = {10,20,30,40};
        int m = 2; //No. of students
        int n=4;
        System.out.println("The minimum value of the maximum number of pages in book allocation is " +findPages(arr,n, m));
    }
}
