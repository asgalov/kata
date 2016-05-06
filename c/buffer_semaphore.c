#include <time.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <semaphore.h>
#include <fcntl.h>
#include <sys/stat.h>

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

sem_t mutex;
sem_t empty;
sem_t full;


void *producer(void *param);
void *consumer(void *param);
int genrnd(unsigned int n);
void printbuf();


int main(int argc, const char *argv[])
{
    sem_init(&mutex, 0, 1);
    sem_init(&empty, 0, BUFFER_SIZE);
    sem_init(&full, 0, 0);
    pthread_t tid1;
    pthread_t tid2;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_create(&tid1, &attr, producer, NULL);
    pthread_create(&tid2, &attr, consumer, NULL);
    pthread_join(tid1, NULL);
    pthread_join(tid2, NULL);
    sem_destroy(&mutex);
    sem_destroy(&full);
    sem_destroy(&empty);
    return 0;
}


void *producer(void *param)
{
    printf("start producer...\n");    
    while(1){
        sem_wait(&empty);
        sem_wait(&mutex);
        int d = genrnd(10);
        in = (in + 1) % BUFFER_SIZE;
        buffer[in] = d;
        printf("produce %d ", d);    
        printbuf();
        sem_post(&mutex);
        sem_post(&full);
        usleep(genrnd(10000)); 
    }
}


void *consumer(void *param)
{
    printf("start consumer...\n");    
    while(1){
        sem_wait(&full);
        sem_wait(&mutex);
        out = (out + 1) % BUFFER_SIZE;
        int d = buffer[out];
        buffer[out] = -1;
        printf("consume %d ", d);    
        printbuf();
        sem_post(&mutex);
        sem_post(&empty);
        usleep(genrnd(10000)); 
    }
}


void printbuf()
{
    int i;
    for (i = 0; i < BUFFER_SIZE; i++){
        if ((in > out && i > out && i <= in) || (in < out && (i <= in || i > out))){
            printf("%d",buffer[i]);
        } else{
            printf("-");
        }
    }
    printf(" \n");
}


/* generate uniformly distributed random variable from 0 to n*/
int genrnd(unsigned int n)
{
    rnd = (1103515245 * rnd) % BASE ;
    return (n * rnd)/BASE;       
}
