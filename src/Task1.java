import java.util.Scanner;

public class Task1 {

    public static  RatNumbers [] mas = new RatNumbers[5];

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        RatNumbers frn = new RatNumbers();
        RatNumbers srn = new RatNumbers();

        System.out.println("1 число");
        frn.Input(scn);
        frn.OutPut();
        System.out.println("2 число");
        srn.Input(scn);
        srn.OutPut();

        System.out.println("Числители:");
        System.out.println("1-ый: " + frn.GetP() + ", 2-ой: " + srn.GetP());

        System.out.println("Сумма знаменателей: ");
        System.out.println(frn.GetQ() + srn.GetQ());

        if (frn.GetP() > srn.GetP()){
            System.out.println("Число у которого больше числитель: ");
            frn.OutPut();
        }else if (frn.GetP() < srn.GetP()){
            System.out.println("Число у которого больше числитель: ");
            srn.OutPut();
        }else{
            System.out.println("У этих чисел равны числители");
        }

        //2

        System.out.println("Output: ");
        frn.OutPut();
        srn.OutPut();

        //3
        RatNumbers firstRat = new RatNumbers(4,3);
        RatNumbers secondRat = new RatNumbers(5,1,7);
        RatNumbers thirdRat = new RatNumbers(firstRat);
        System.out.println("3 task: ");
        firstRat.OutPut();
        secondRat.OutPut();
        thirdRat.OutPut();

        firstRat.SetP(5);
        firstRat.SetQ(firstRat.GetQ() * 3);
        secondRat.SetP(secondRat.GetP() - 2);
        thirdRat.SetP(thirdRat.GetP() + 10);
        thirdRat.SetQ(thirdRat.GetQ() * 10);

        System.out.println("Print after upgrade: ");
        firstRat.OutPut();
        secondRat.OutPut();
        thirdRat.OutPut();

        //4
        System.out.println("sum 1 and 2: ");
        RatNumbers res1 =  RatNumbers.SumRat(firstRat,secondRat);
        res1.OutPut();

        System.out.println("1 num - 2 = : ");
        RatNumbers res2 = RatNumbers.MinRat(firstRat,secondRat);
        res2.OutPut();

        System.out.print("1 num * 2 num = " );
        RatNumbers res3 = RatNumbers.MultyRat(firstRat,secondRat);
        res3.OutPut();

        System.out.println("1 num / 2 num: ");
        RatNumbers res4 = RatNumbers.DelenieRat(firstRat,secondRat);
        res4.OutPut();

        //Равенство
        System.out.println("Равны ли первое и второе число? " + RatNumbers.isEqual(firstRat,secondRat));

        //5

        System.out.println(RatNumbers.FirstIsBig(firstRat,secondRat));

        //6

        for (int i = 0; i < mas.length; i++) {
            System.out.println("Введите числитель " + (i +1) + " числа");
            int f = scn.nextInt();
            System.out.println("Введите знаменатель " + (i +1) + " числа");
            int s = scn.nextInt();

            mas[i] = new RatNumbers(f,s);
        }
        //6/8 + 2/3 + 4/9 + 7/12 + 14/45
        RatNumbers sumRat = RatNumbers.SumRat(mas[0],mas[1]);
        RatNumbers sumRat2 = RatNumbers.SumRat(mas[2],mas[3]);
        RatNumbers resSum = RatNumbers.SumRat(sumRat,sumRat2);
        resSum = RatNumbers.SumRat(resSum,mas[4]);
        System.out.println("Сумма всех чисел равна: ");
        resSum.OutPut();

        // Multy
        RatNumbers multy1 = RatNumbers.MultyRat(mas[0],mas[1]);
        RatNumbers multy2 = RatNumbers.MultyRat(mas[2],mas[3]);
        RatNumbers multyRes = RatNumbers.MultyRat(multy1,multy2);
        multyRes = RatNumbers.MultyRat(multyRes,mas[4]);
        System.out.println("Произведение всех чисел: ");
        multyRes.OutPut();

        //min
        RatNumbers min = new RatNumbers(Integer.MAX_VALUE,Integer.MAX_VALUE);
        for (int i = 0; i < mas.length; i++) {
            boolean small = true;
            for (int j = 0; j < mas.length; j++) {
                if (RatNumbers.FirstIsSmall(mas[i],mas[j]) && small)
                    small = true;
                else
                    small = false;

            }
            if (small){
                min =mas[i];
                break;
            }
        }
        System.out.println("Наименьший: ");
        min.OutPut();

        //max
        RatNumbers max = new RatNumbers(Integer.MIN_VALUE,Integer.MIN_VALUE);
        for (int i = 0; i < mas.length; i++) {
            boolean small = true;
            for (int j = 0; j < mas.length; j++) {
                if (RatNumbers.FirstIsBig(mas[i],mas[j]) && small)
                    small = true;
                else
                    small = false;

            }
            if (small){
                max =mas[i];
                break;
            }
        }
        System.out.println("Наибольший: ");
        max.OutPut();

        RatNumbers LastRes = RatNumbers.MinRat(max,min);
        System.out.println("Разность между макс и мин: ");
        LastRes.OutPut();
    }
}
