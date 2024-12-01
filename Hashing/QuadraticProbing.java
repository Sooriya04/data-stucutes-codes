package Hashing;
import java.util.*;
//table[(index + i * i) % size];
public class QuadraticProbing {
    int[] table;
    int size;
    final static int INSERT = -1;
    final static int DELETE = -2;
    QuadraticProbing(int size){
        this.size = size;
        table = new int[size];
        for(int i= 0 ; i < size; i++){
            table[i] = INSERT;
        }
    }
    public int hashvalue(int key){
        return key % size;
    }
    public void insert(int key){
        int index = hashvalue(key);
        int i = 0;
        while(table[(index + i * i) % size] != INSERT){
            i++;
        }
        if(index == size){
            return;
        }
        table[(index + i * i) % size] = key;
    }

    public boolean search(int key){
        int index = hashvalue(key);
        int i = 0;
        int temp = table[(index + i * i) % size];
        while(temp != INSERT){
            int currentIndex = (index + i * i) % size;
            if(table[currentIndex] == key){
                return true;
            }
            i++;
            if(i == size){
                break;
            }
        }
        temp = key;
        return false;
    }
    public void delete(int key){
        int index = hashvalue(key);
        int i = 0;
        int temp = table[(index + i * i) % size];
        while(temp != INSERT){
            if(temp == key){
                temp = DELETE;
                return;
            }
            i++;
            if(i == size){
                break;
            }
        }
        temp = key;
        
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
        QuadraticProbing qp = new QuadraticProbing(size);
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
                    System.out.print("Enter the element : ");
                    for(int i = 0; i < size; i++){
                        int element = input.nextInt();
                        qp.insert(element);
                    }
                    break;
                case 2:
                    System.out.print("Enter the key to delete : ");
                    int deleteElemet = input.nextInt();
                    qp.delete(deleteElemet);
                    break;
                case 3:
                    System.out.print("Enter the key to search : ");
                    int searchElement = input.nextInt();
                    boolean isFound = qp.search(searchElement);
                    if(isFound){
                        System.out.println("Key is found");
                    }else{
                        System.out.println("Key is not found");
                    }
                    break;
                case 4:
                    System.out.println("Hash Table");
                    qp.display();
                    break;
                case 5:
                run = false;
            }
        }
    }
}
//54 78 64 92 34 86 28
