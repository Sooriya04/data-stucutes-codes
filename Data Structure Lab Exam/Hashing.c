#include <stdio.h>

#define SIZE 10  
#define EMPTY -1
#define DELETED -2
int hashTable[SIZE];

void initializeTable() {
    for (int i = 0; i < SIZE; i++) {
        hashTable[i] = EMPTY;
    }
}

int hashFunction(int key) {
    return key % SIZE;
}

void insert(int key) {
    int index = hashFunction(key);
    while (hashTable[index] != EMPTY) {
        index = (index + 1) % SIZE;
    }

    hashTable[index] = key;
    printf("Inserted %d at index %d\n", key, index);
}

void search(int key) {
    int index = hashFunction(key);
    int startIndex = index;
    while (hashTable[index] != EMPTY) {
        if (hashTable[index] == key) {
            printf("Found %d at index %d\n", key, index);
            return;
        }
        index = (index + 1) % SIZE;
        if (index == startIndex) {
            break;
        }
    }
    printf("%d not found in the hash table\n", key);
}

void delete(int key) {
    int index = hashFunction(key);
    int startIndex = index;
    while (hashTable[index] != EMPTY) {
        if (hashTable[index] == key) {
            hashTable[index] = EMPTY;
            printf("Deleted %d from index %d\n", key, index);
            return;
        }
        index = (index + 1) % SIZE;
        if (index == startIndex) {
            break;
        }
    }
    printf("%d not found in the hash table to delete\n", key);
}

void displayTable() {
    printf("Hash Table:\n");
    for (int i = 0; i < SIZE; i++) {
        if (hashTable[i] == EMPTY)
            printf("[%d]: Empty\n", i);
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
