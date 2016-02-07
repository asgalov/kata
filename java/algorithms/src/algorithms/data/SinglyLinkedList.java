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
public class SinglyLinkedList<K> {

    private Link head = null;
    
    private class Link {
        
        public Link next;
        public final K element;

        public Link(K el, Link next) {
            this.element = el;
            this.next = next;
        }
    }
    
    public boolean isIn(K el){
        if (head == null){
            return false;
        }
        
        Link l = head;
        while (l.next != null){
            if (el.equals(l.next.element)){
                return true;
            }
            l = l.next;
        }
        return false;
    }

    public void insert(K el){
        if (head == null){
            head = new Link(el, null);
        } else{
            head = new Link(el, head);
        }
        System.out.println("insert "+el.toString());
        System.out.println("list:  "+this.toString());            
    }
    
    public K delete(K el){
        Link l = head;
        Link prev = head;
        while (l.next != null){
            if (el.equals(l.next.element)){
                K element = l.next.element;
                prev.next = l.next.next;
                return element;
            }
            prev = l;   
            l = l.next;
        }   
        return null;
    }
    
    public void reverse(){
        Link p = null;
        Link l = head;
        Link t = null;
        while (l != null){
            t = l.next;
            l.next = p;
            p = l;
            l = t;
        }
        head = p;
    }
        
    @Override
    public String toString(){
        Link l = head;
        String str = "";
        while (l != null){
            str += l.element.toString()+" ";
            l = l.next;
        }
        return str;
    }
    
}