#include <stdio.h>
void deleteAnywhere(int arr[], int *size, int position) {
    for (int i = position; i < *size - 1; i++) {
        arr[i] = arr[i + 1];
    }
    (*size)--; 
}
int main() {
    int arr[100], size, position;
    int i = 0; 
    
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    printf("Enter the elements of the array:\n");
    while (i < size) {
        scanf("%d", &arr[i]);
        i++;
    }
    printf("Enter the position to delete the element: ");
    scanf("%d", &position);
    deleteAnywhere(arr, &size, position);
    i = 0; 
    printf("Array after deletion:\n");
    while (i < size) {
        printf("%d ", arr[i]);
        i++;
    }
    return 0;
}

