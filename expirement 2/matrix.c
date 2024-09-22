#include <stdio.h>
#include <stdlib.h>
#define SIZE 4
int i;
typedef struct {
    int** data;
} Matrix;
Matrix* createMatrix() {
    Matrix* matrix = (Matrix*)malloc(sizeof(Matrix));
    matrix->data = (int**)malloc(SIZE * sizeof(int*));
    for (i = 0; i < SIZE; i++) {
        matrix->data[i] = (int*)malloc(SIZE * sizeof(int));
        int j;
        for(j = 0; j < SIZE; j++) {
            matrix->data[i][j] = 0;
        }
    }
    return matrix;
}
void insertElement(Matrix* matrix, int row, int col, int value) {
    if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
        matrix->data[row][col] = value;
    } else {
        printf("Invalid position\n");
    }
}
void deleteElement(Matrix* matrix, int row, int col) {
    if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
        matrix->data[row][col] = 0;
    } else {
        printf("Invalid position\n");
    }
}
int searchElement(Matrix* matrix, int value) {
    for (i = 0; i < SIZE; i++) {
    	int j;
        for (j = 0; j < SIZE; j++) {
            if (matrix->data[i][j] == value) {
                return 1; 
            }
        }
    }
    return 0;
}
void sumAndAverage(Matrix* matrix) {
    int sum = 0, count = 0;
    for (i = 0; i < SIZE; i++) {
    	int j;
        for (j = 0; j < SIZE; j++) {
            sum += matrix->data[i][j];
            if (matrix->data[i][j] != 0) {
                count++;
            }
        }
    }
    printf("Sum: %d, Average: %.2f\n", sum, (count > 0) ? (float)sum / count : 0);
}
void printMatrix(Matrix* matrix) {
    printf("Matrix:\n");
    for (i = 0; i < SIZE; i++) {
    	int j;
        for (j = 0; j < SIZE; j++) {
            printf("%d ", matrix->data[i][j]);
        }
        printf("\n");
    }
}
void deleteMatrix(Matrix* matrix) {
    for (i = 0; i < SIZE; i++) {
        free(matrix->data[i]);
    }
    free(matrix->data);
    free(matrix);
}
int main() {
    Matrix* matrix = createMatrix();
    int choice, row, col, value;

    while (1) {
        printf("1. Insert Element\n");
        printf("2. Delete Element\n");
        printf("3. Search Element\n");
        printf("4. Sum and Average\n");
        printf("5. Print Matrix\n");
        printf("6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter row, column and value: ");
                scanf("%d %d %d", &row, &col, &value);
                insertElement(matrix, row, col, value);
                break;
            case 2:
                printf("Enter row and column to delete: ");
                scanf("%d %d", &row, &col);
                deleteElement(matrix, row, col);
                break;
            case 3:
                printf("Enter value to search: ");
                scanf("%d", &value);
                if (searchElement(matrix, value)) {
                    printf("Element found\n");
                } else {
                    printf("Element not found\n");
                }
                break;
            case 4:
                sumAndAverage(matrix);
                break;
            case 5:
                printMatrix(matrix);
                break;
            case 6:
                deleteMatrix(matrix);
                return 0;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
}

