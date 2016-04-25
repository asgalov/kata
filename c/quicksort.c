#include <stdio.h>

#define RND_MAX_NUMBER 10
#define BASE 45901;

static unsigned long rand = 11;

void quicksort(int arr[], int begin, int end, int pv);
int genrnd(unsigned int n);
void swap(int arr[], int b, int e);

int main(int argc, const char *argv[])
{
    int size = 40;
    int arr[size];
    int i;
    for (i = 0; i < size; i++)
        arr[i] = genrnd(RND_MAX_NUMBER);

    quicksort(arr, 0, size - 1, arr[size / 2]);
    for (i = 0; i < size; i++)
        printf(" %d", arr[i]);    
    
    return 0;
}


void quicksort(int arr[], int begin, int end, int pv)
{
    if (begin == end)
        return ;

    int b = begin;
    int e = end;
    while (b < e) {
        while (arr[b] < pv)
            b++;

        while (arr[e] >= pv)
            e--;

        swap(arr, b, e);
    }

    quicksort(arr, begin, e, arr[begin + (e - begin)/2]);
    quicksort(arr, b, end, arr[b + (end - b)/2]);
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
