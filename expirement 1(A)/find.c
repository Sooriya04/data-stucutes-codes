#include <stdio.h>
void findElement(int arr[], int size, int element) {
    int index = 0;
    while (index < size) {
        if (arr[index] == element) { 
            printf("Element found at index: %d\n", index);
            return;
        }
        index++; 
    }
    printf("Element not found\n"); 
}
int main() {
    int arr[100] = {10, 20, 30, 40, 50};
	int i;
	int size = 5; 
    int element;
	printf("\nEnter the element to find : ");
	scanf("%d, ", &element);
    findElement(arr, size, element);
    return 0;
}

