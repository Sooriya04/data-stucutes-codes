#include <stdio.h>
void insertFirst(int arr[], int *size, int element) {
    int i;
    for (i = *size; i > 0; i--) {
        arr[i] = arr[i - 1];
    }
    arr[0] = element;
    (*size)++;
}

int main() {
    int arr[100], size, element;
    
    printf("Enter the size of the array: ");
    scanf("%d", &size);

    printf("Enter the elements of the array:\n");
    int i;
    for (i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter the element to insert at the beginning: ");
    scanf("%d", &element);

    insertFirst(arr, &size, element);

    printf("Array after insertion:\n");
    for (i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}

