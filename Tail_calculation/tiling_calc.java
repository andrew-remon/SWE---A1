import java.util.Scanner;

public class tiling_calc {
   
    public static void main() {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter Wide of Floor:");
        int n = input.nextInt();

        System.out.printf("\nEnter Hight of Floor:");
        int m = input.nextInt();

        System.out.printf("\nEnter Wide of Tail:");
        int a = input.nextInt();

        System.out.printf("\nEnter Hight of Tail:");
        int b = input.nextInt();

        int x = Math.ceilDiv(n,a);
        int y = Math.ceilDiv(m,b);
        
        System.out.printf("\nThe Minimum number of Tails to cover the whole Floor even if you want to Split some Tails\n %d\n\n",x*y);
        System.out.println("Do you want to know Total Coast?[1/0]");
        int yes = input.nextInt();
        if(yes==1) {
            System.out.printf("Enter Cost of Tail:");
            int Coast = input.nextInt();
            System.out.printf("Total Coast:%d\n",y*x*Coast);
            return;
        }
        System.out.printf("OK\n");
    }
}
