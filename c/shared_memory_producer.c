#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/mman.h>
#include <sys/stat.h>        /* For mode constants */
#include <fcntl.h>           /* For O_* constants */
#include <sys/shm.h>

#define BUFFER_SIZE 10

int main(int argc, const char *argv[])
{
    const int SIZE = 1024;
    const char *name = "OS";
    int shm_fd; 
    shm_fd = shm_open(name, O_CREAT | O_RDWR, 0666);
    ftruncate(shm_fd, SIZE);
    void *ptr;
    ptr = mmap(0, SIZE, PROT_WRITE, MAP_SHARED, shm_fd, 0);
    char *msg1 = "hello ";
    char *msg2 = "world!";

    sprintf(ptr,"%s",msg1);    
    ptr += strlen(msg1);
    sprintf(ptr,"%s",msg2);    
    ptr += strlen(msg2);

/*    while(1)
        wait();
*/
    return 0;
}
