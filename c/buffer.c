#include <time.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

#define BUFFER_SIZE 10
#define RND_MAX_NUMBER 10
#define BASE 45901
#define SLEEP 1
#define TRUE 1
#define FALSE 0

static unsigned long rnd = 11;

int buffer[BUFFER_SIZE];
int out = 0;
int in = 0;
int busy = FALSE;

void *producer(void *param);
void *consumer(void *param);
int genrnd(unsigned int n);
void printbuf();

int main(int argc, const char *argv[])
{
    pthread_t tid1;
    pthread_t tid2;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_create(&tid1, &attr, producer, NULL);
    pthread_create(&tid2, &attr, consumer, NULL);
    pthread_join(tid1, NULL);
    pthread_join(tid2, NULL);
    return 0;
}

void *producer(void *param)
{
    printf("start producer...\n");    
    while(1){
/*        printf("producer: wait ...\n");    */
        if (!busy && ((in + 1) % BUFFER_SIZE != out)){
/*            busy = TRUE;*/
            int d = genrnd(10);
            in = (in + 1) % BUFFER_SIZE;
            buffer[in] = d;
            printf("produce %d ", d);    
            printbuf();
            busy = FALSE;
        }
        usleep(genrnd(1000));
    }
}

void printbuf()
{
    int i;
    for (i = 0; i < BUFFER_SIZE; i++){
        usleep(100);
        if ((in > out && i > out && i <= in) || (in < out && (i <= in || i > out))){
            printf("%d",buffer[i]);
        } else{
            printf("-");
        }
    }
    printf(" \n");
}

void *consumer(void *param)
{
    printf("start consumer...\n");    
    while(1){
/*        printf("consumer: wait ...\n");    */
        if (!busy && (out != in)){
/*            busy = TRUE;*/
            out = (out + 1) % BUFFER_SIZE;
            int d = buffer[out];
            buffer[out] = -1;
            printf("consume %d ", d);    
            printbuf();
            busy = FALSE;
        }
        usleep(genrnd(1000));
    }
}

/* generate uniformly distributed random variable from 0 to n*/
int genrnd(unsigned int n)
{
    rnd = (1103515245 * rnd) % BASE ;
    return (n * rnd)/BASE;       
}
