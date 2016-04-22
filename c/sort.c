#include <stdio.h>
#include <sort.h>
#define MAXLINE 1000

int main(int argc, const char* argv[])
{
    char linebuf[MAXLINE];
    char maxl[MAXLINE];
    int maxlen = 0;
    int len;
    while ((len = getl(linebuf)) > 0) {
        if (len > maxlen) {
            maxlen = len;
            writeline(maxl, linebuf);
        }    
    }
    maxl[maxlen] = '\0';
    printf("%s\n",maxl);

    int i;
    for (i = 0; i < 40; i++) {
        printf("%d\n",genrnd(10));
    }
    return 0;
}

void writeline(char maxl[], char line[])
{
    int i;
    for (i = 0; (maxl[i] = line[i]) != '\0'; i++)
        ;
}

int getl(char linebuf[])
{
    char c;
    int i;
    for(i = 0; (c = getchar()) != EOF && i < MAXLINE && (c != '\n') ; i++)
        linebuf[i] = c;

    if (c == '\n'){
        linebuf[i] = c;
        i++;
    }

    linebuf[i] = '\0';
    return i;
}
