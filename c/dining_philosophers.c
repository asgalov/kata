#include <sys/time.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <semaphore.h>

#define RND_MAX_NUMBER 10
#define BASE 45901
#define PHIL_NUM 5

static unsigned long rnd = 11;

sem_t chopstics[PHIL_NUM];
sem_t chopstics_mutex;
sem_t flags_mutex;
char flags[] = {0,0,0,0,0};

int genrnd(unsigned int n);
void *philosopher(int *param);

int main(int argc, const char *argv[])
{
    int i;
    for (i = 0; i < PHIL_NUM; i++) 
        sem_init(&chopstics[i], 0, 1);

    sem_init(&chopstics_mutex, 0, 1);
    sem_init(&flags_mutex, 0, 1);

    pthread_t tid_philosopher[PHIL_NUM] ;
    pthread_attr_t attr;
    pthread_attr_init(&attr);

    for (i = 0; i < PHIL_NUM; i++){ 
        int *phil_id = malloc(sizeof (int));
        *phil_id = i; 
        pthread_create(&tid_philosopher[i], &attr, philosopher, phil_id);
    }

    for (i = 0; i < PHIL_NUM; i++) 
        pthread_join(tid_philosopher[i], NULL);

    for (i = 0; i < PHIL_NUM; i++) 
        sem_destroy(&chopstics[i]);
    
    sem_destroy(&chopstics_mutex);
    sem_destroy(&flags_mutex);

    return 0;
}


void *philosopher(int *param)
{
    int id = *param;
    printf("philosophier %d %s \n", id, " has begun thinking");    
    while(1){
        if (id == 0) {
            sem_wait(&flags_mutex);
            int flag = 1;
            int i;
            for (i = 0; i < PHIL_NUM; i++) 
               flag *= flags[i]; 

            if (flag == 1){
/*                printf("clear flags \n");    */
                for (i = 0; i < PHIL_NUM; i++) 
                    flags[i] = 0; 
            }

            sem_post(&flags_mutex);
        }


        sem_wait(&flags_mutex);
        char had_eaten = flags[id];
        sem_post(&flags_mutex);

        if (!had_eaten){
            struct timeval tv;
            gettimeofday(&tv, NULL);
            int ts1 = tv.tv_usec;
           
            sem_wait(&chopstics_mutex);
            sem_wait(&chopstics[id]);
            sem_wait(&chopstics[(id + 1) % PHIL_NUM]);
            sem_post(&chopstics_mutex);

            gettimeofday(&tv, NULL);
            int ts2 = tv.tv_usec;
            int diff = ts2 - ts1;
            if (diff > 6000){
                printf("philosophier %d %s %d %s \n", id, " is waiting for ", diff, "seconds");    
                exit(-1);
            }

            usleep(1000 + genrnd(10)); 
/*            printf("philosophier %d %s \n", id, " is eating ");    */

            sem_wait(&flags_mutex);
            flags[id] = 1;
            sem_post(&flags_mutex);

            sem_post(&chopstics[id]);
            sem_post(&chopstics[(id + 1) % PHIL_NUM]);
        }
        usleep(1000 + genrnd(10)); 
    }
}

/* generate uniformly distributed random variable from 0 to n*/
int genrnd(unsigned int n)
{
    rnd = (1103515245 * rnd) % BASE ;
    return (n * rnd)/BASE;       
}
