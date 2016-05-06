#include <time.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <semaphore.h>

#define READERS_NUM 10
#define WRITERS_NUM 5
#define RND_MAX_NUMBER 10
#define BASE 45901
#define SLEEP 1

static unsigned long rnd = 11;

sem_t mutex;
sem_t rw_mutex;
int read_cnt = 0;
int message; 

void *writer(void *param);
void *reader(void *param);
int genrnd(unsigned int n);


int main(int argc, const char *argv[])
{
    sem_init(&mutex, 0, 1);
    sem_init(&rw_mutex, 0, 1);
    pthread_t tid_writer[WRITERS_NUM] ;
    pthread_t tid_readers[READERS_NUM];
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    int i;
    for (i = 0; i < WRITERS_NUM; i++) 
        pthread_create(&tid_writer[i], &attr, writer, NULL);

    for (i = 0; i < READERS_NUM; i++) 
        pthread_create(&tid_readers[i], &attr, reader, NULL);

    for (i = 0; i < READERS_NUM; i++) 
        pthread_join(tid_readers[i], NULL);

    for (i = 0; i < WRITERS_NUM; i++) 
        pthread_join(tid_writer[i], NULL);

    sem_destroy(&mutex);
    sem_destroy(&rw_mutex);
    return 0;
}


void *writer(void *param)
{
    printf("start writer...\n");    
    while(1){
        sem_wait(&rw_mutex);
        message = genrnd(10);
        printf("write %d\n", message);    
        sem_post(&rw_mutex);
        usleep(genrnd(10000)); 
    }
}


void *reader(void *param)
{
    printf("start reader...\n");    
    while(1){
        sem_wait(&mutex);
        read_cnt++;
        if (read_cnt == 1)
            sem_wait(&rw_mutex);
        sem_post(&mutex);    
       
        printf("read %d\n", message);    

        sem_wait(&mutex);
        read_cnt--;
        if (read_cnt == 0)
            sem_post(&rw_mutex);
        sem_post(&mutex);
        usleep(genrnd(10000)); 
    }
}


/* generate uniformly distributed random variable from 0 to n*/
int genrnd(unsigned int n)
{
    rnd = (1103515245 * rnd) % BASE ;
    return (n * rnd)/BASE;       
}
