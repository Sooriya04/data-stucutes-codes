#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAX 100
int top = -1;

int isEmpty(){
    return top == - 1;
}
int isFull(int n){
    return top == n - 1;
}
void push(int stack[], int size){
    if(isFull(size)){
        printf("Stack OverFlow Error");
    }else{
        int data;
        printf("Enter the element to push : ");
        for(int i = 0; i < size; i++){
            scanf("%d", &data);
            stack[++top] = data;
            printf("%d is pushed to stack", data);
            printf("\n");
        }
        printf("\n");
    }
}
void pop(int stack[]){
    if (isEmpty()){
        printf("Stack Underflow error");
    }else{
        printf("The popped element is %d", stack[top--]);
    }
    printf("\n");
}
void peek(int stack[]){
    if(isEmpty()){
        printf("Stack underflow error");
    }else{
        printf("Top elemet is %d", stack[top]);
    }
    printf("\n");
}
void display(int stack[]){
    if(isEmpty()){
        printf("Stack is empty");
    }else{
        printf("The elements in the stack are ");
        for(int i = 0;i< top;i++){
            printf("%d ", stack[i]);
        }
    }
    printf("\n");
}
int isPlaindrome(char *word){
    char stack[MAX];
    int top = -1;
    int len = 0;
    for(int i = 0; word[i] != '\0';i++){
        stack[++top] = word[i];
        len++;
    }
    for(int i = 0;i < len;i++){
        if(word[i] != stack[top--]){

            return 0;
        }
    }
    return 1;
}
int main(){
    char word[MAX];
    int size;
    printf("Enter the size of the stack : ");
    scanf("%d", &size);
    int stack[size];
    printf("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Application\n6. Exit");
    bool isRun = true;
    while(isRun){
        printf("\n");  
        printf("Enter the choice :");
        int choice;
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            push(stack, size);
            break;
        case 2:
            pop(stack);
            break;
        case 3:
            peek(stack);
            break;
        case 4:
            display(stack);
            break;
        case 5:
            printf("Enter the word to check it is palindrome or not : ");
            scanf("%s", word);
            if(isPlaindrome(word)){
                printf("The given word %s is plaindrome", word);
            }else{
                printf("The given word %s is not plaindrome", word);
            }
            break;
        case 6:
            isRun = false;
            break;
        }
    }
}
