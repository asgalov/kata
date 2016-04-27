#include <stdio.h>


void sort(int arr[], int b, int e);
void merge(int arr[], int b, int m, int e);


int main(int argc, const char *argv[])
{
    int size = 10;
    int arr[] = {2,3,5,6,2,1,3,8,0,9};
    sort(arr, 0, size - 1);
    int i;
    for (i = 0; i < size; i++)
        printf(" %d", arr[i]);    
    
    return 0;
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
