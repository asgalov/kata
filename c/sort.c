#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>

#define BASE 45901;

static  long rnd = 11;

long lnum(char* buf, long i);
void readlines(char **lines, char* buf, long size);
void printlines(char **lines, long ln);
void writelines(char **lines, long ln);
int llen(char* line);

void quicksort(char **arr, long b, long e);
long partition(char **arr, long b, long e);
int scmp(char* s, char* t);
void swap(char **arr, long b, long e);
int genrnd(int n);


int main(int argc, const char* argv[])
{
    int fd = open(argv[1], O_RDONLY, 0);
    long size = lseek(fd, 0, SEEK_END);
    lseek(fd, 0, SEEK_SET);
    char *buf = malloc(size + 1);
    ssize_t  chunk = read(fd, buf, size); 
    close(fd);
    *(buf + size + 1) = EOF;
    long ln = lnum(buf, size + 1);
    char **linesptr = malloc(sizeof *linesptr * ln);
    readlines(linesptr, buf, size + 1);
    quicksort(linesptr, 0, ln - 1); 
    writelines(linesptr, ln);
    return 0;
}


long lnum(char *buf, long size)
{
    long lncnt = 0;
    long i;
    for(i = 0; i < size; i++)
        if (*(buf + i) == '\n')
            lncnt++; 
    
    return lncnt;
}


void readlines(char **lines, char *buf, long size)
{
    long lncnt = 0;
    long i;
    *(lines + lncnt) = buf;
    lncnt++;
    for(i = 0; i < size; i++){
        if (*(buf + i) == '\n'){
            *(lines + lncnt) = (buf + i + 1);
            lncnt++; 
        }
    }
}

void writelines(char **lines, long ln)
{
    long i;
    for (i = 0; i < ln; i++) {
        write(1, *(lines+i), llen(*(lines+i)));
    }
}


int llen(char *line)
{
    int len = 0;
    for (len = 0; *(line + len) != '\n' && *(line + len) != EOF; len++)
        ;
    return len + 1;
}


void quicksort(char **arr, long b, long e)
{
    if (b < e){
        long p = partition(arr, b, e);
        quicksort(arr, b, p - 1);
        quicksort(arr, p + 1, e);
    }
}


long partition(char **arr, long b, long e)
{
    swap(arr, b + genrnd(e - b), b);
    long p = b;
    long i;
    for (i = b + 1; i <= e; i++) {
        if (scmp(*(arr + i), *(arr + p))) {
            swap(arr, p + 1, i);
            swap(arr, p + 1, p);
            p++;
        }
    }
    return p;
}


int scmp(char *s, char *t)
{
    int i;
    for (i = 0; (s[i] == t[i]); i++) 
        if (s[i] == '\n') 
            return 1;

    return s[i] - t[i] > 0 ? 0 : 1; 
}


void swap(char **arr,  long b,  long e)
{
    char *tmp = *(arr + b);
    *(arr + b) = *(arr + e);
    *(arr + e) = tmp;
}


/* generate uniformly distributed random variable from 0 to n */
int genrnd( int n)
{
    rnd = (1103515245*rnd) % BASE ;
    return (n*rnd)/BASE;       
}
