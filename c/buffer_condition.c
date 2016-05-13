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
#define CONSUMER_ID 0
#define PRODUCER_ID 1

static unsigned long rnd = 11;

int buffer[BUFFER_SIZE];
int out = 0;
int in = 0;
int count = 0;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t count_threshold;

void *producer(void *param);
void *consumer(void *param);
int genrnd(unsigned int n);
void printbuf();

int main(int argc, const char *argv[])
{
    pthread_t tid1;
    pthread_t tid2[5];
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_cond_init(&count_threshold, NULL);
    pthread_create(&tid1, &attr, producer, NULL);
    
    int k;
    for (k = 0; k < 5; k++) 
        pthread_create(&tid2[k], &attr, consumer, NULL);

    for (k = 0; k < 5; k++) 
        pthread_join(tid2[k], NULL);

    pthread_join(tid1, NULL);
    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&count_threshold);
    return 0;
}

void *producer(void *param)
{
    printf("start producer...\n");    
    while(1){
        pthread_mutex_lock(&mutex);
        while (count == BUFFER_SIZE)
            pthread_cond_wait(&count_threshold, &mutex);

        int d = genrnd(10);
        in = (in + 1) % BUFFER_SIZE;
        buffer[in] = d;
        count++;
        printf("produce %d ", d);    
        printbuf();

        pthread_cond_broadcast(&count_threshold);
        pthread_mutex_unlock(&mutex);
        usleep(genrnd(10000)); 
    }
}

void *consumer(void *param)
{
    printf("start consumer...\n");    
    while(1){
        pthread_mutex_lock(&mutex);
        while (count == 0)
            pthread_cond_wait(&count_threshold, &mutex);

        out = (out + 1) % BUFFER_SIZE;
        int d = buffer[out];
        buffer[out] = -1;
        count--;
        printf("consume %d ", d);    
        printbuf();

        pthread_cond_signal(&count_threshold);
        pthread_mutex_unlock(&mutex);
        usleep(genrnd(10000)); 
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


/* generate uniformly distributed random variable from 0 to n*/
int genrnd(unsigned int n)
{
    rnd = (1103515245 * rnd) % BASE ;
    return (n * rnd)/BASE;       
}
