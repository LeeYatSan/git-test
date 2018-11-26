/**
 *@author
 *LI_Yichen
 *ID: 16130120145
 *e-mail: niuqiao2010@163.com
 */

import java.util.Calendar;

public class cal {

    static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};


    //获取当月最大天数
    static int daysNumOfMonth( Calendar cal) {
        return(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    //获取当月月名
    static String monthName(Calendar cal) {
        return(MONTHS[cal.get(Calendar.MONTH)]);
    }

    cal(){}
    cal(int month,int year){
        Calendar cal= Calendar.getInstance();
        cal.clear();//将日历时间清为初始值
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);

        int days = daysNumOfMonth(cal);
        int starting_day = cal.get(Calendar.DAY_OF_WEEK);//获取本月开始日为星期几
        String month_name = monthName(cal);

        System.out.println(month_name + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        for(int i = 1; i < starting_day; i++)//开始日前全部填空白
            System.out.print("  ");
        for(int i = 1; i <= days; i++){
            if (i < 10)//一位数字日期补空格
                System.out.print(" " + i + " ");
            else
                System.out.print(i + " ");
            if(starting_day == 7){
                System.out.println();//换行
                starting_day = 1;
            }
            else starting_day++;
    }


    public static void main(String[] args) {
        try
        {
            Calendar cal = Calendar.getInstance();
            int i = args.length;
            if(i == 0){
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                cal c = new cal(month,year);
            }
            else if(i == 2){
                if(Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0) {
                    System.out.println("The inputted values must be positive integer!");
                    return;
                }
                if(Integer.parseInt(args[0]) > 12)
                {
                    System.out.println("The legal range of the first value is from 1 to 12!");
                    return;
                }
                int month = Integer.parseInt(args[0]) - 1;
                int year = Integer.parseInt(args[1]);
                cal c = new cal(month, year);
            }
            else
            {
                System.out.println("2 command line arguments are needed!");
                return;
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("The inputted values must be positive integer!");
            return;
        }
    }
}

