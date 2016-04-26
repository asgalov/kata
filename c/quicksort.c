#include <stdio.h>

#define RND_MAX_NUMBER 10
#define BASE 45901;

static unsigned long rand = 11;

void quicksort(int arr[], int b, int e);
int genrnd(unsigned int n);
void swap(int arr[], int b, int e);


int main(int argc, const char *argv[])
{
    int size = 10;
    int arr[] = {2,3,5,6,2,1,3,8,0,9};
    quicksort(arr, 0, size - 1);
    int i;
    for (i = 0; i < size; i++)
        printf(" %d", arr[i]);    
    
    return 0;
}


void quicksort(int arr[], int b, int e)
{
    if (b < e){
        int p = partition(arr, b, e) ;
        quicksort(arr, b, p - 1);
        quicksort(arr, p + 1, e);
    }
}


int partition(int arr[], int b, int e)
{
    swap(arr, b + genrnd(e - b), b);
    int p = b;
    int i;
    for (i = b; i <= e; i++) {
        if (arr[i] < arr[p]) {
            swap(arr, p + 1, i);
            swap(arr, p + 1, p);
            p++;
        }
    }
    return p;
}


void swap(int arr[], int b, int e)
{
    int tmp = arr[b];
    arr[b] = arr[e];
    arr[e] = tmp;
}


/* generate uniformly distributed random variable from 0 to n*/
int genrnd(unsigned int n)
{
    rand = (1103515245*rand) % BASE ;
    return (n*rand)/BASE;       
}
