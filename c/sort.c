#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>

#define BASE 45901;

static unsigned long rnd = 11;

int lnum(char* buf, int i);
void readlines(char* lines[], char* buf, int size);
void printlines(char* lines[], int ln);
void writelines(char* lines[], int ln);
int llen(char* line);

void quicksort(char* arr[], int b, int e);
int scmp(char* s, char* t);
void swap(char* arr[], int b, int e);
int genrnd(unsigned int n);


int main(int argc, const char* argv[])
{
    int fd = open(argv[1], O_RDONLY, 0);
    int size = lseek(fd, 0, SEEK_END);
    lseek(fd, 0, SEEK_SET);
    char* buf = malloc(size + 1);
    ssize_t  chunk = read(fd, buf, size); 
    close(fd);
    *(buf + size + 1) = EOF;
    int ln = lnum(buf, size + 1);
    char* lines[ln];
    readlines(lines, buf, size + 1);
    quicksort(lines, 0, ln - 1); 
    writelines(lines, ln);
    return 0;
}


int lnum(char* buf, int size)
{
    int lncnt = 0;
    int i;
    for(i = 0; i < size; i++)
        if (*(buf + i) == '\n')
            lncnt++; 
    
    return lncnt;
}


void readlines(char* lines[], char* buf, int size)
{
    int lncnt = 0;
    int i;
    lines[lncnt] = buf;
    lncnt++;
    for(i = 0; i < size; i++){
        if (*(buf + i) == '\n'){
            lines[lncnt] = buf + i + 1;
            lncnt++; 
        }
    }
}


void printlines(char* lines[], int ln)
{
    int i, j;
    for (i = 0; i < ln; i++) {
        j = 0;
        while (*(lines[i] + j) != '\n' && *(lines[i] + j) != EOF ) {
            printf("%c", *(lines[i] + j));    
            j++;
        }
        printf("\n");
    }
}


void writelines(char* lines[], int ln)
{
    int i;
    for (i = 0; i < ln; i++) {
        write(1, lines[i], llen(lines[i]));
    }
}


int llen(char* line)
{
    int len = 0;
    for (len = 0; *(line + len) != '\n' && *(line + len) != EOF; len++)
        ;
    return len + 1;
}


void quicksort(char* arr[], int b, int e)
{
    if (b < e){
        int p = partition(arr, b, e) ;
        quicksort(arr, b, p - 1);
        quicksort(arr, p + 1, e);
    }
}


int partition(char* arr[], int b, int e)
{
    swap(arr, b + genrnd(e - b), b);
    int p = b;
    int i;
    for (i = b + 1; i <= e; i++) {
        if (scmp(arr[i], arr[p])) {
            swap(arr, p + 1, i);
            swap(arr, p + 1, p);
            p++;
        }
    }
    return p;
}


int scmp(char* s, char* t)
{
    int i;
    for (i = 0; (s[i] == t[i]); i++) 
        if (s[i] == '\n') 
            return 1;

    return s[i] - t[i] > 0 ? 0 : 1; 
}


void swap(char* arr[], int b, int e)
{
    char* tmp = arr[b];
    arr[b] = arr[e];
    arr[e] = tmp;
}


/* generate uniformly distributed random variable from 0 to n */
int genrnd(unsigned int n)
{
    rnd = (1103515245*rnd) % BASE ;
    return (n*rnd)/BASE;       
}
