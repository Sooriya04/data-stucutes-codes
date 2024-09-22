#include <stdio.h>
#include <string.h>
#define MAX_STUDENTS 100

struct Student {
    char regNo[20];  // Change regNo to a string
    char name[50];
    float subject1;  
    float subject2;  
    float subject3;  
};

struct Student students[MAX_STUDENTS];
int size = 0;
int i;
void addStudent() {
    if (size < MAX_STUDENTS) {
        printf("Enter registration number: ");
        scanf("%s", students[size].regNo); 
        printf("Enter name: ");
        scanf("%s", students[size].name);
        printf("Enter score for Data Structures: ");
        scanf("%f", &students[size].subject1);
        printf("Enter score for Java: ");
        scanf("%f", &students[size].subject2);
        printf("Enter score for ITOM: ");
        scanf("%f", &students[size].subject3);
        size++;
    } else {
        printf("Cannot add more students. Maximum limit reached.\n");
    }
}

void printStudents() {
    for (i = 0; i < size; i++) {
        printf("Reg No: %s, Name: %s, DS: %.2f, Java: %.2f, ITOM: %.2f\n",
               students[i].regNo, students[i].name,
               students[i].subject1, students[i].subject2, students[i].subject3);
    }
}

void findStudent(char regNo[]) {
    for (i = 0; i < size; i++) {
        if (strcmp(students[i].regNo, regNo) == 0) {  
            printf("Found student: Reg No: %s, Name: %s, DS: %.2f, Java: %.2f, ITOM: %.2f\n",
                   students[i].regNo, students[i].name,
                   students[i].subject1, students[i].subject2, students[i].subject3);
            return;
        }
    }
    printf("Student not found\n");
}

void calculateSumAndAverage(char regNo[]) {
    for (i = 0; i < size; i++) {
        if (strcmp(students[i].regNo, regNo) == 0) {
            float sum = students[i].subject1 + students[i].subject2 + students[i].subject3;
            float average = sum / 3;
            printf("Sum: %.2f, Average: %.2f\n", sum, average);
            return;
        }
    }
    printf("Student not found\n");
}

void deleteStudent(char regNo[]) {
    for (i = 0; i < size; i++) {
        if (strcmp(students[i].regNo, regNo) == 0) {
        	int j;
            for (j = i; j < size - 1; j++) {
                students[j] = students[j + 1];
            }
            size--;
            printf("Student deleted\n");
            return;
        }
    }
    printf("Student not found\n");
}

int main() {
    int choice;
    char regNo[20]; 

    while (1) {
        printf("1. Add Student\n");
        printf("2. Print Students\n");
        printf("3. Find Student\n");
        printf("4. Calculate Sum and Average\n");
        printf("5. Delete Student\n");
        printf("6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                printStudents();
                break;
            case 3:
                printf("Enter registration number to find: ");
                scanf("%s", regNo);
                findStudent(regNo);
                break;
            case 4:
                printf("Enter registration number to calculate sum and average: ");
                scanf("%s", regNo);
                calculateSumAndAverage(regNo);
                break;
            case 5:
                printf("Enter registration number to delete: ");
                scanf("%s", regNo);
                deleteStudent(regNo);
                break;
            case 6:
                return 0;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
}

