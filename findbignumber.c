#include <stdio.h>

int main() {
    int a, b, c;
    printf("Finding the Biggest Number from Three Inputs\n");
    
    printf("Enter the first number: ");
    scanf("%d", &a);

    printf("Enter the second number: ");
    scanf("%d", &b);

    printf("Enter the third number: ");
    scanf("%d", &c);

    if (a > b && a > c) {
        printf("%d is the biggest number\n", a);
    }
    else if (b > a && b > c) {
        printf("%d is the biggest number\n", b);
    }
    else {
        printf("%d is the biggest number\n", c);
    }

    return 0;
}
