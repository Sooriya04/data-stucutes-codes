#include <stdio.h>
void insertAnywhere(int arr[], int *size, int position, int element) {
    int i = *size; 
    while (i > position) {
        arr[i] = arr[i - 1];
        i--;
    }
    arr[position] = element;
    (*size)++;
}
int main() {
    int arr[100], size, position, element;
    int i = 0;
    printf("Enter the size of the array: ");
    scanf("%d", &size);

    printf("Enter the elements of the array:\n");
    while (i < size) {
        scanf("%d", &arr[i]);
        i++;
    }
    printf("Enter the position to insert the element: ");
    scanf("%d", &position);

    printf("Enter the element to insert: ");
    scanf("%d", &element);
    insertAnywhere(arr, &size, position, element);
    i = 0;
    printf("Array after insertion:\n");
    while (i < size) {
        printf("%d ", arr[i]);
        i++;
    }
    return 0;
}

