#include <stdio.h>
#define EMPTY -1
#define DELETED -2
#define MAX_SIZE 100
int hashTable[MAX_SIZE];
int size;
void initializeTable() {
    printf("Enter the size of the table (max %d): ", MAX_SIZE);
    scanf("%d", &size);

    if (size > MAX_SIZE) size = MAX_SIZE;

    for (int i = 0; i < size; i++) hashTable[i] = EMPTY;
}

int hashFunction(int key) {
    return key % size;
}

void insert(int key) {
    int index = hashFunction(key);
    for (int i = 0; i < size; i++) {
        if (hashTable[index] == EMPTY || hashTable[index] == DELETED) {
            hashTable[index] = key;
            printf("Inserted %d at index %d\n", key, index);
            return;
        }
        index = (index + 1) % size;
    }
    printf("Hash table is full. Cannot insert %d.\n", key);
}

void search(int key) {
    int index = hashFunction(key);

    for (int i = 0; i < size; i++) {
        if (hashTable[index] == EMPTY) break;
        if (hashTable[index] == key) {
            printf("Found %d at index %d\n", key, index);
            return;
        }
        index = (index + 1) % size;
    }
    printf("%d not found in the hash table\n", key);
}

void delete(int key) {
    int index = hashFunction(key);
    for (int i = 0; i < size; i++) {
        if (hashTable[index] == EMPTY) break;
        if (hashTable[index] == key) {
            hashTable[index] = DELETED;
            printf("Deleted %d from index %d\n", key, index);
            return;
        }
        index = (index + 1) % size;
    }
    printf("%d not found in the hash table to delete\n", key);
}

void displayTable() {
    printf("Hash Table:\n");
    for (int i = 0; i < size; i++) {
        if (hashTable[i] == EMPTY)
            printf("[%d]: Empty\n", i);
        else if (hashTable[i] == DELETED)
            printf("[%d]: Deleted\n", i);
        else
            printf("[%d]: %d\n", i, hashTable[i]);
    }
}

int main() {
    int choice, key;

    initializeTable();
    do {
        printf("\n1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit\nEnter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter a number to insert: ");
                scanf("%d", &key);
                insert(key);
                break;
            case 2:
                printf("Enter a number to search: ");
                scanf("%d", &key);
                search(key);
                break;
            case 3:
                printf("Enter a number to delete: ");
                scanf("%d", &key);
                delete(key);
                break;
            case 4:
                displayTable();
                break;
            case 5:
                printf("Exiting the program.\n");
                break;
            default:
                printf("Invalid choice. Try again.\n");
        }
    } while (choice != 5);
    return 0;
}
