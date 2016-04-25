#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define CHUNK_SIZE 32 

void pb(char *buf, int size);

int main(int argc, const char *argv[])
{
    int fd = open(argv[1], O_RDONLY, 0);
    int size = lseek(fd, 0, SEEK_END);
    lseek(fd, 0, SEEK_SET);
    char *buf = malloc(size);
    printf("file descriptor: %d\n", fd);    
    ssize_t  chunk = read(fd, buf, size); 
    printf("read chunk of size %d\n", chunk);    
    pb(buf, size); 
    return 0;
}

void pb(char *buf, int size)
{
    int i;
    for (i = 0; i < size; i++){
        char c = (char) *(buf + i);
        printf("%c", c);    
    }
}
