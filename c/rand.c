#include <stdio.h>

#define BASE 45901;

static unsigned long rand = 11;

/* generate uniformly distributed random variable from 0 to n*/
int genrnd(unsigned int n)
{
    rand = (1103515245*rand) % BASE ;
    return (n*rand)/BASE;       
}
