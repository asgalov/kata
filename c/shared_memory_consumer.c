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
    shm_fd = shm_open(name, O_RDONLY, 0666);
    void *ptr;
    ptr = mmap(0, SIZE, PROT_READ, MAP_SHARED, shm_fd, 0);

    printf("%s\n", (char *) ptr);
    shm_unlink(name);
    return 0;
}
