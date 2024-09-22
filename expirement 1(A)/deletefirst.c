#include <stdio.h>
void deleteFirst(int arr[], int *size) {
    int i = 0;
    while (i < *size - 1) {
        arr[i] = arr[i + 1];
        i++;
    }
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
    deleteFirst(arr, &size);
    i = 0;
    printf("Array after deletion of the first element:\n");
    while (i < size) {
        printf("%d ", arr[i]);
        i++;
    }
    return 0;
}

