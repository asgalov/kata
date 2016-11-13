/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalsort;

/**
 *
 * @author gas
 */
public class ConcurrencyTest {

    static class SummingThread extends Thread {
        int lo; int hi; int[] arr;
        int answer = 0;
        SummingThread(int[] a, int l, int h) {
            this.arr = a;
            this.lo = l;
            this.hi = h;
        }
        
        @Override
        public void run(){
            for (int i = 0; i < arr.length; i++) {
                answer += arr[i];
            }
        }
    }

    
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[10000000];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            
            arr[i] = (int) (5 - 10*Math.random());
            sum += arr[i];
        }
        int len = arr.length;
        
        SummingThread[] threads = new SummingThread[4];
        //суммируем массив параллельно в 4 нитях:
        for(int i = 0; i < 4; i++){
            threads[i] = new SummingThread(arr, i*len/4, (i+1)*len/4);
            threads[i].start();
        }
        int answer = 0;
        for(int i = 0; i < 4; i++){ // объединяем результаты
            threads[i].join();
            answer += threads[i].answer;
        }
        System.out.println("sum "+sum+" answer = "+answer);
    }

}
