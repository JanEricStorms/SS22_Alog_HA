package übung1jan;

public class InterpolationSearch {
        // Returns index of x if it is present in arr[l..
        // r], else return -1
        int interpolationSearch(int arr[], int l, int r, int x)
        {
            if (r >= l) {
                int guess = (x-arr[l])/(arr[r]-arr[l]);

                // If the element is present at the
                // middle itself
                if (arr[guess] == x)
                    return guess;

                // If element is smaller than mid, then
                // it can only be present in left subarray
                if (arr[guess] > x)
                    return interpolationSearch(arr, l, guess - 1, x);

                // Else the element can only be present
                // in right subarray
                return interpolationSearch(arr, guess + 1, r, x);
            }

            // We reach here when element is not present
            // in array
            return -1;
        }

        // Driver method to test above
        public static void main(String args[])
        {
            InterpolationSearch ob = new InterpolationSearch();
            int arr[] = { 2, 3, 4, 10, 40 };
            int n = arr.length;
            int x = 10;
            int result = ob.interpolationSearch(arr, 0, n - 1, x);
            if (result == -1)
                System.out.println("Element not present");
            else
                System.out.println("Element found at index "
                        + result);
        }
    }
    /* This code is contributed by Rajat Mishra */

