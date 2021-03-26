import java.util.Scanner;

public class RatNumbers {
    private int p; //Числитель

    private int q; //Знаменатель

    // /* Getters and Setters
    public int GetP(){
        return this.p;
    }

    public void SetP(int p){
        this.p = p;
    }

    public int GetQ(){
        return this.q;
    }

    public void SetQ(int q){
        this.q = q;
    }
    // */Getters and Setters

    // /*Methods input/output
    public void Input(Scanner scn){
        System.out.println("Введите числитель");
        this.p = scn.nextInt();
        System.out.println("Введите знаменатель");
        this.q = scn.nextInt();
    }
    public void OutPut(){
       if (p % q == 0){
           System.out.println(p / q);
       }
       else{
           if (Math.abs(p) < Math.abs(q)){
               System.out.println(this.p + "/" + Math.abs(this.q));
           }
           else{
               Normalize();
               System.out.println(this.p / this.q + " " +Math.abs(GetChicl()) + "/" + Math.abs(this.q));
           }
       }
    }
    // */ Methods input/output


    //2

    public int GetInt(){
        return (this.p/this.q);
    }

    public int GetChicl(){
        return this.p - (this.q * (this.p/this.q));
    }

    private int SearchNod(int p, int q){
        p  = Math.abs(p);
        q = Math.abs(q);
        int nod = Math.min(p,q);
        while (nod != 1){
            if (p % nod == 0 && q % nod == 0){
                return nod;
            }else{
                nod --;
            }
        }
        return nod;
    }

    public void Normalize(){
        int nod = SearchNod(this.p,this.q);
        this.p = this.p / nod;
        this.q = this.q / nod;
    }

    // /*Constructs
    public RatNumbers(int p, int q){
        this.p = p;
        this.q = q;
    }

    public RatNumbers(){
        this.p = 0;
        this.q = 1;
    }

    public RatNumbers(int integer, int p, int q){
        this.p = integer * q + p;
        this.q = q;
    }

    public RatNumbers(RatNumbers rt){
        this.p = rt.p;
        this.q = rt.q;
    }
    // */Constructors

    //4
    private static int SearchNok(int q1, int q2){
        q1 = Math.abs(q1);
        q2 = Math.abs(q2);
        int res = Math.max(q1,q2);
        while (res != q1*q2){
            if ((res % q1 == 0) && (res % q2 == 0)){
                return res;
            }
            else{
                res++;
            }
        }
        return res;
    }

    public static RatNumbers SumRat(RatNumbers r1, RatNumbers r2){
        RatNumbers res = new RatNumbers();
        if(r1.q != r2.q){
            int nok = SearchNok(r1.q,r2.q);
            res.q = nok;
            res.p = r1.p * (nok/r1.q) + r2.p *(nok / r2.q);
        }
        else{
            res.q = r1.q;
            res.p = r1.p + r2.p;
        }
        res.Normalize();
        return res;
    }


    //Разность
    public static RatNumbers MinRat(RatNumbers r1, RatNumbers r2){
        RatNumbers res = new RatNumbers();
        if(r1.q != r2.q){
            int nok = SearchNok(r1.q,r2.q);
            res.q = nok;
            res.p = r1.p * (nok/r1.q) - r2.p *(nok / r2.q);
        }
        else{
            res.q = r1.q;
            res.p = r1.p - r2.p;
        }
        res.Normalize();
        return res;
    }

    public static RatNumbers MultyRat(RatNumbers r1, RatNumbers r2){
        RatNumbers res = new RatNumbers();
        res.p = r1.p * r2.p;
        res.q = r1.q * r2.q;
        res.Normalize();
        return res;
    }

    // Деление
    private static void SwitchRat(RatNumbers r){
        int buf = r.p;
        r.p = r.q;
        r.q = buf;
    }

    //Деление
    public static RatNumbers DelenieRat(RatNumbers r1, RatNumbers r2){
        RatNumbers res = new RatNumbers();
        SwitchRat(r2);
        res.p = r1.p * r2.p;
        res.q = r1.q * r2.q;
        res.Normalize();
        return res;
    }

    //Равенство

    public static boolean isEqual(RatNumbers r1, RatNumbers r2){
        if (r1.p == r2.p && r1.q == r2.q)
            return true;
        else
            return false;
    }
    //5 Какое число больше?
    public static boolean FirstIsBig(RatNumbers r1, RatNumbers r2){
        double first = r1.p/1.0/r1.q;
        double second = r2.p/1.0/r2.q;
        if (first >= second)
            return true;
        else
            return false;
    }

    public static boolean FirstIsSmall(RatNumbers r1, RatNumbers r2){
        double first = r1.p/1.0/r1.q;
        double second = r2.p/1.0/r2.q;
        if (first <= second)
            return true;
        else
            return false;
    }
}
