public class complNum {
    double re;
    double im;

    complNum(){
    
    }
    complNum(Double r, Double i) {
        this.im = i;
        this.re = r;
    }

    public  complNum sum(complNum f1, complNum f2) {
        complNum res = new complNum(0.0, 0.0);
        res.re = f1.re + f2.re;
        res.im = f1.im + f2.im;
        return res;
    }
    public  complNum substruct(complNum f1, complNum f2) {
        complNum res = new complNum(0.0, 0.0);
        res.re = f1.re - f2.re;
        res.im = f1.im - f2.im;
        return res;
    }
    public complNum multiply(complNum f1, complNum f2) {
        complNum res = new complNum(0.0, 0.0);
        res.re = f1.re*f2.re - f1.im*f2.im;
        res.im = f1.re*f2.im + f1.im*f2.re;
        return res;
    }
    public  complNum divide(complNum f1, complNum f2) {
        complNum res = new complNum(0.0, 0.0);
        double znam = f2.re * f2.re - f2.im * f2.im;
        res.re = (f1.re*f2.re - f1.im*f2.im)/znam;
        res.im = (f1.re*f2.im + f1.im*f2.re)/znam;
        return res;
    }
    public complNum module(complNum f){
     f.re = Math.sqrt(f.re*f.re+f.im+f.im);
     f.im = 0;
        return f;
    }
    public complNum argum(complNum f){
        f.re = Math.atan(f.im/f.re);
        f.im = 0;
        return f;
    }

}
