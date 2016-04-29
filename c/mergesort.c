#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>


void sort(int arr[], int b, int e);
void merge(int arr[], int b, int m, int e);
void *runner(int *param);

int size = 50;
int arr[] = {100,2,3,5,6,2,1,93,88,20,9,12,0,5,96,2,1,3,8,0,9,2,3,5,76,62,14,33,18,10,92,24,33,5,6,2,1,3,8,0,9,11,12,30,43,23,23,22,56,643,34};

int main(int argc, const char *argv[])
{
    pthread_t tid1;
    pthread_t tid2;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    int *arguments1 = malloc(sizeof (int) * 2);
    int *arguments2 = malloc(sizeof (int) * 2);
    int b = 0;
    int e = size - 1;
    int m = (e - b)/2;
    *arguments1 = b;
    *(arguments1 + 1) = m;
    *arguments2 = m + 1;
    *(arguments2 + 1) = e;
    pthread_create(&tid1, &attr, runner, arguments1);
    pthread_create(&tid2, &attr, runner, arguments2);
    pthread_join(tid1, NULL);
    pthread_join(tid2, NULL);
    merge(arr, b, m, e); 
    int i;
    for (i = 0; i < size; i++)
        printf(" %d", arr[i]);    
    
    return 0;
}

void *runner(int *param)
{
    int b = *param;
    int e = *(param + 1);
    printf("thread parameters %d %d", b, e);    
    sort(arr, b, e);
    pthread_exit(0);
}

void sort(int arr[], int b, int e)
{
    if (b < e){
        int m = b + (e - b)/2;
        sort(arr, b, m);
        sort(arr, m + 1, e);
        merge(arr, b, m, e);
   }
}


void merge(int arr[], int b, int m, int e)
{
    int mrgarr[e - b + 1];
    int i = b;
    int j = m + 1;
    int k = 0;
    for (k = 0; k < e - b + 1; k++) {
         if (((arr[i] < arr[j]) && (i <= m )) || (j > e)){
            mrgarr[k] = arr[i];
            i++;
        } else {
            mrgarr[k] = arr[j];
            j++;
        }
    }
    
    for (i = 0; i < e - b + 1; i++)
        arr[b + i] = mrgarr[i];
}
