main(int argc, char* args[])
{
    if (argc < 2){
        printf("please type filename ");
        exit(-1);
    }
    printf("%d\n",strcmp("abc","abc"));
}

void qsort(char* lines[])
{

}

int strcmp(char* s, char* t)
{
    int i;
    for(i = 0; s[i] == t[i]; i++)
        if (s[i] == '\0')
            return t[i] == '\0' ? 0 : 1;
    return s[i] - t[i] > 0 ? -1 : 1;
}

