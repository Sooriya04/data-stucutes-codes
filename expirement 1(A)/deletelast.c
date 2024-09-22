#include <stdio.h>
void deleteLast(int arr[], int *size) {
    (*size)--;
}
int main() {
    int arr[100], size;
    int i = 0;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    printf("Enter the elements of the array:\n");
    while (i < size) {
        scanf("%d", &arr[i]);
        i++;
    }
    deleteLast(arr, &size);
    i = 0;  
    printf("Array after deletion of the last element:\n");
    while (i < size) {
        printf("%d ", arr[i]);
        i++;
    }

    return 0;
}

