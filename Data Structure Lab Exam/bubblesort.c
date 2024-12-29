#include <stdio.h>
#include <stdlib.h>
void bubblesort(int arr[], int size){
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size - 1 ;j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
void display(int arr[], int size){
    for(int i = 0; i < size; i++){
        printf("%d ", arr[i]);
    }
}
int main(){
    int size;
    printf("Enter the size of the array : ");
    scanf("%d", &size);
    int arr[size];
    printf("Enter the elements in the array : ");
    for(int i = 0; i < size; i++){
        scanf("%d", &arr[i]);
    }
    bubblesort(arr, size);
    printf("Sorted List is : ");
    display(arr, size);
    return 0;
}