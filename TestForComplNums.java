import java.util.Scanner;

public class TestForComplNums {
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
         System.out.println("What you want to calculate? Choose one of this:sum(1),substruct(2),multiply(3),div(4),module(5),arg(6).");
        int choice = sc.nextInt();
        switch(choice){
            case 1: 
                complNum s = res.sum(firstNum, secondNum);
                System.out.println("sum of z1 and z2 is equaled: "+ s.re + "+" + s.im + "i");
                break;
            
            case 2:
                complNum sbs = res.substruct(firstNum, secondNum); 
                if(sbs.im>=0){
                    System.out.println("substruct of z1 and z2 is equaled: "+ sbs.re + "+" + sbs.im + "i");
                    break;
                }
                else{
                    System.out.println("substruct of z1 and z2 is equaled: "+ sbs.re + "-" + (-sbs.im) + "i");
                    break;
                } 

            case 3:
                complNum m = res.multiply(firstNum, secondNum);
                System.out.println("multiply result of z1 and z2 is equaled: "+ m.re + "+" + m.im + "i");
                break;
                
            case 4:
                complNum d = res.divide(firstNum, secondNum);
                System.out.println("division result of z1 and z2 is equaled: "+ d.re + "+" + d.im + "i");
                break;
            
            case 5: 
                complNum mod1 = res.module(firstNum);
                complNum mod2 = res.module(secondNum);
                System.out.println("Module for first num is: " + mod1.re);
                System.out.println("Module for second num is: " + mod2.re);
                break;
            
            case 6:
                complNum arg1 = res.argum(firstNum);
                complNum arg2 = res.argum(secondNum);
                System.out.println("arg for first num is: " + arg1.re);
                System.out.println("arg for second num is: " + arg2.re);
                break;
            
            default: System.out.println("problema");  break;
        }
       /* complNum s = res.sum(firstNum, secondNum);
        complNum sbs = res.substruct(firstNum, secondNum);
        complNum d = res.divide(firstNum, secondNum);
        complNum m = res.multiply(firstNum, secondNum);
        complNum mod = res.module(firstNum);
        complNum arg = res.argum(secondNum);
        System.out.println(mod.re);
        System.out.println(arg.re);
        System.out.println("sum of z1 and z2 is equaled: "+ s.re + "+" + s.im + "i");
        if(sbs.im>=0){
            System.out.println("substruct of z1 and z2 is equaled: "+ sbs.re + "+" + sbs.im + "i");
        }
        else{
            System.out.println("substruct of z1 and z2 is equaled: "+ sbs.re + "-" + -sbs.im + "i");
        } 
        System.out.println("division result of z1 and z2 is equaled: "+ d.re + "+" + d.im + "i");
        System.out.println("multiply result of z1 and z2 is equaled: "+ m.re + "+" + m.im + "i");*/
        sc.close();
    }
}
