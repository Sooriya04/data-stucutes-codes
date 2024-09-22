#include <stdio.h>
void insertLast(int arr[], int *size, int element) {
    arr[*size] = element;
    (*size)++;
}
int main() {
    int arr[100], size, element;
    int i = 0; 
    
    printf("Enter the size of the array: ");
    scanf("%d", &size);

    printf("Enter the elements of the array:\n");
    while (i < size) {
        scanf("%d", &arr[i]);
        i++;
    }

    printf("Enter the element to insert at the end: ");
    scanf("%d", &element);
    insertLast(arr, &size, element);
    i = 0; 
    printf("Array after insertion:\n");
    while (i < size) {
        printf("%d ", arr[i]);
        i++;
    }
    return 0;
}

