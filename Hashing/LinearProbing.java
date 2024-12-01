package Hashing;
import java.util.*;
class LinearProbing{
    final static int INSERT = -1;
    final static int DELETE = -2;
    int[] table;
    int top;
    int size;
    LinearProbing(int size){
        this.size = size;
        table = new int[size];
        top = INSERT;
        for(int i = 0;i < size;i++){
            table[i] = INSERT;
        }
    }
    public int hashvalue(int key){
        return key % size;
    }
    public void insert(int key){
        int index = hashvalue(key);
        while(table[index] != INSERT){
            index = (index + 1) % size;
        }
        table[index] = key;
    }
    public Boolean search(int key){
        int index = hashvalue(key);
        int start = index;
        while(table[index] != INSERT){
            if(table[index] == key){
                return true;
            }
            index = (index + 1)%size;
            if(index == start){
                break;
            }
        }
        return false;
    }
    public void delete(int key){
        int index = hashvalue(key);
        int start = index;
        while(table[index] != INSERT){
            if(table[index] == key){
                table[index] = DELETE;
            }
            index = (index + 1) % size;
            if (index == start){
                break;
            }
        }
    }
    public void display(){
        for(int i = 0 ; i < size ; i++){
            if(table[i] == INSERT){
                System.out.println("Index " + i + " No element found");
            }else if(table[i] == DELETE){
                System.out.println("Index " + i + " : Deleted");
            }
            else{
                System.out.println("Index " + i + " : " + table[i]);
            }
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = input.nextInt();
        LinearProbing lp = new LinearProbing(size);
        System.out.println("1. Insert");
        System.out.println("2. Deleted");
        System.out.println("3. Search");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        boolean run = true;
        while(run){
            //System.out.println("");
            System.out.print("Enter the operation : ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element : ");
                    for(int i = 0; i < size; i++){
                        int element = input.nextInt();
                        lp.insert(element);
                    }
                    break;
                case 2:
                    System.out.print("Enter the key to delete : ");
                    int deleteElemet = input.nextInt();
                    lp.delete(deleteElemet);
                    break;
                case 3:
                    System.out.print("Enter the key to search : ");
                    int searchElement = input.nextInt();
                    boolean isFound = lp.search(searchElement);
                    if(isFound){
                        System.out.println("Key is found");
                    }else{
                        System.out.println("Key is not found");
                    }
                    break;
                case 4:
                    System.out.println("Hash Table");
                    lp.display();
                    break;
                case 5:
                run = false;
            }
        }
    }
}