package sorting;

class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[left..middle]
    // Second subarray is arr[middle+1..right]
    void merge(int arr[], int left, int middle, int right)
    {
        // Find sizes of two subarrays to be merged
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        // Create temp arrays
        int LeftArray[] = new int[leftArraySize];
        int RightArray[] = new int[rightArraySize];

        // Copy data to temp arrays
        for (int i = 0; i < leftArraySize; ++i)
            LeftArray[i] = arr[left + i];
        for (int j = 0; j < rightArraySize; ++j)
            RightArray[j] = arr[middle + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < leftArraySize && j < rightArraySize) {
            if (LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            }
            else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of Left[] if any
        while (i < leftArraySize) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of Right[] if any
        while (j < rightArraySize) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int left, int right)
    {
        if (left < right) {

            // Find the middle point
            int m = left + (right - left) / 2;

            // Sort first and second halves
            sort(arr, left, m);
            sort(arr, m + 1, right);

            // Merge the sorted halves
            merge(arr, left, m, right);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code


}