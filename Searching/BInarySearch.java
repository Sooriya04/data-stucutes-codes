class binarySearch{
    public int search(int A[], int n, int key){
        int left = 0;
        int right = n - 1;
        while (left <= right){ //0 < 5
            int mid = (left + right) / 2; //2
            //System.out.println(mid);
            if (key == A[mid]) 
                return mid;
            else if(key < A[mid]) // 96 < 47 - False used to search 15, 21
                right = mid - 1;
            else if(key > A[mid]) // 96 > 47 - True used to search 84, 96
                left = mid + 1; // 2 + 1
        }
        return -1; 
    }
    public static void main(String args[]){
        binarySearch binary = new binarySearch();
        int A[] = {15, 21, 47, 84, 96}; //need to be a sorted array
        int found = binary.search(A, 5, 96);
        System.out.println("Result : "+ found);
    }
}
