int main(int argc, const char *argv[])
{
    char *ss = argv[1];
    printf("%s\n",*ss);
    int i;
    for (i = 0; *(ss+i) != '\0'; i++) {
      printf("%s\n",*(ss+i));
    }
    return 0;
}
