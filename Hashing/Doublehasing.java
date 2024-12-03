package Hashing;
import java.util.Scanner;
public class Doublehasing {
    int[] table;
    int size;
    final static int INSERT = -1;
    final static int DELETE = -2;
    Doublehasing(int size){
        this.size = size;
        table = new int[size];
        for(int i = 0 ; i < size ; i++){
            table[i] = -1;
        }
    }
    public int hashOne(int key){
        return key % 13;
    }
    public int hashTwo(int key){
        return 7 - (key % 7);
    }
    public void insert(int key){
        int index = hashOne(key);
        int i = 0;
        while(table[(index + i * hashTwo(key)) % size] !=INSERT && table[(index+ i * hashTwo(key))% size] != DELETE){
            i++;
            if(i == size){
                break;
            }
        }
        table[index + i * hashTwo(key)%size] = key;
    }
    public void delete(int key){
        int index = hashOne(key);
        int i = 0;
        while(table[(index + i * hashTwo(key)) % size]!= INSERT){
            if(table[(index + i * hashTwo(key)) % size] == key){
                table[(index + i * hashTwo(key)) % size] = DELETE;
                return;
            }
            i++;
            if(i == size){
                break;
            }
        }
    }
    public boolean search(int key){
        int index = hashOne(key);
        int i = 0;
        while(table[(index + i * hashTwo(key)) % size] != INSERT){
            if(table[index + i * hashTwo(key) % size] == key){
                return true;
            }
            i++;
            if(i == size){
                break;
            }
        }
        return false;
    }
    public void display(){
        for(int i = 0;i < size; i++){
            if(table[i] == DELETE){
                System.out.println(i + " : key is deleted");
            }else if(table[i] == INSERT){
                System.out.println(i + " :Key is not inserted");
            }else{
                System.out.println(i + " : " + table[i]);
            }
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = input.nextInt();
        Doublehasing dp = new Doublehasing(size);
        System.out.println("1. Insert");
        System.out.println("2. Deleted");
        System.out.println("3. Search");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        boolean run = true;
        while(run){
            System.out.print("Enter the operation : ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the number of elements to be insert : ");
                    int eSize = input.nextInt();
                    System.out.print("Enter the element : ");
                    for(int i = 0; i < eSize; i++){
                        int element = input.nextInt();
                        dp.insert(element);
                    }
                    break;
                case 2:
                    System.out.print("Enter the key to delete : ");
                    int deleteElemet = input.nextInt();
                    dp.delete(deleteElemet);
                    break;
                case 3:
                    System.out.print("Enter the key to search : ");
                    int searchElement = input.nextInt();
                    boolean isFound = dp.search(searchElement);
                    if(isFound){
                        System.out.println("Key is found");
                    }else{
                        System.out.println("Key is not found");
                    }
                    break;
                case 4:
                    System.out.println("Hash Table");
                    dp.display();
                    break;
                case 5:
                run = false;
            }
        }
    }
}
