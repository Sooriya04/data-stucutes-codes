public class LinearSearch{
    public int linearSearch(int A[], int n, int key){
        int index = 0;
        while(index < n){
            if(A[index] == key){
                return index;
            }
            index += 1;
        }
        return -1;
    }
    public static void main(String args[]){
        LinearSearch search = new LinearSearch();
        int A[] = {84, 24, 47, 96, 15};
        int found = search.linearSearch(A, 5, 96);
        System.out.println("Result : " + found);
        
    }
}