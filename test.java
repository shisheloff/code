import java.util.Scanner;

public class test {
    public static void main(final String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input z1 complex number: ");
         double re1 = sc.nextDouble();
         double im1 = sc.nextDouble();
         System.out.println("Input z2 complex number: ");
         double re2 = sc.nextDouble();
         double im2 = sc.nextDouble();
        final complNum firstNum = new complNum(re1, im1);
        final complNum secondNum = new complNum(re2, im2);
        final complNum res = new complNum(0.0, 0.0);
        complNum s = res.sum(firstNum, secondNum);
        complNum sbs = res.substruct(firstNum, secondNum);
        complNum d = res.divide(firstNum, secondNum);
        complNum m = res.multiply(firstNum, secondNum);
        System.out.println("sum of z1 and z2 is equaled: "+ s.re + "+" + s.im + "i");
        if(sbs.im>=0){
            System.out.println("substruct of z1 and z2 is equaled: "+ sbs.re + "+" + sbs.im + "i");
        }
        else{
            System.out.println("substruct of z1 and z2 is equaled: "+ sbs.re + "-" + -sbs.im + "i");
        } 
        System.out.println("division result of z1 and z2 is equaled: "+ d.re + "+" + d.im + "i");
        System.out.println("multiply result of z1 and z2 is equaled: "+ m.re + "+" + m.im + "i");
        sc.close();
    }
}
