/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data;

/**
 *
 * @author gas
 */
public class SinglyLinkedArrayList {
    
    private final int[] arr = new int[10];
    
    private int first = 2;
    private int head = -1;
    
    public void insert(int el){
        if (head == -1){
            head = 0;
            arr[0] = el;
            arr[1] = -1;
            first = 2;
            arr[3] = -2;
        } else {
            int nextEmpty = arr[first + 1];
            arr[first] = el;
            arr[first + 1] = head;
            head = first;
            if (nextEmpty == -2){
                first += 2;
                arr[first + 1] = -2;
            } else {
                first = arr[nextEmpty];
            }
        }
    }
    
    public int delete(int el){
        int next = head;
        int prev = -1;
        while (next != -1){
            if (arr[next] == el){
                if (next == head){
                    head = arr[next + 1];
                }
                
                if (prev != -1){
                    arr[prev + 1] = arr[next + 1];    
                }
                
                arr[next + 1] = first;
                first = next;
                return el;
            }
            prev = next;
            next = arr[next + 1];
        }
        return -1;
    } 
    
    @Override
    public String toString(){
        String str = "";
        int next = head;
        int[] tmp_arr = new int[arr.length];
        for (int i = 0; i < tmp_arr.length; i++) {
            tmp_arr[i] = -2;
        }
        
        while (next != -1){
            str += arr[next] +" ";
            tmp_arr[next] = arr[next];
            next = arr[next + 1];
        }
        
        next = first;
        while (next != -1 && next != -2){
            tmp_arr[next] = -1;
            next = arr[next + 1];
        }
        
        str += " arr: ";
        
        for (int i = 0; i < arr.length; i++) {
            String label = tmp_arr[i] + "";
            if (tmp_arr[i] == -1){
                label = "*";
            }
            
            if (tmp_arr[i] == -2){
                label = "_";
            }
            
            str +=  label;
        }
        return str;
    }
    
    
}
