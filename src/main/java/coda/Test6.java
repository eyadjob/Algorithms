package coda;

public class Test6 {


//    public static void main(String args[])
//    {
//        double a = 295.04;
//        int  b = 300;
//        byte c = (byte) a;
//        byte d = (byte) b;
//        System.out.println(c + " "  + d);
//    }


//    public static void main(String args[])
//    {
//        int g = 3;
//        System.out.print(++g * 8);
//    }


//    public static void main(String args[])
//    {
//        char array_variable [] = new char[10];
//        for (int i = 0; i < 10; ++i)
//        {
//            array_variable[i] = 'i';
//            System.out.print(array_variable[i] + "" );
//            i++;
//        }
//    }


//    public static void main(String args[])
//    {
//        boolean var1 = true;
//        boolean var2 = false;
//        if (var1)
//            System.out.println(var1);
//        else
//            System.out.println(var2);
//    }


//    public static void main(String args[])
//    {
//        int a[] = {1,2,3,4,5};
//        int d[] = a;
//        int sum = 0;
//        for (int j = 0; j < 3; ++j)
//            sum += (a[j] * d[j + 1]) + (a[j + 1] * d[j]);
//        System.out.println(sum);
//    }


//    public static void main(String args[])
//    {
//        int x;
//        x = 5;
//        {
//            int y = 6;
//            System.out.print(x + " " + y);
//        }
//        System.out.println(x + " " + y);
//    }

//    public static void main(String args[])
//    {
//        int arr[][] = new int[3][];
//        arr[0] = new int[1];
//        arr[1] = new int[2];
//        arr[2] = new int[3];
//        int sum = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < i + 1; ++j)
//                arr[i][j] = j + 1;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < i + 1; ++j)
//                sum += arr[i][j];
//        System.out.print(sum);
//    }


//
//    public static void main(String args[])
//    {
//        int x;
//        x = 10;
//        x = x >> 1;
//        System.out.println(x);
//    }


//    public static void main(String args[])
//    {
//        boolean a = true;
//        boolean b = !true;
//        boolean c = a | b;
//        boolean d = a & b;
//        boolean e = d ? b : c;
//        System.out.println(d + " " + e);
//    }


//    public static void main(String args[])
//    {
//        int var1 = 5;
//        int var2 = 6;
//        int var3;
//        var3 = ++ var2 * var1 / var2 + var2;
//        System.out.print(var3);
//    }


//    public static void main(String args[])
//    {
//        int var1 = 5;
//        int var2 = 6;
//        if ((var2 = 1) == var1)
//            System.out.print(var2);
//        else
//            System.out.print(++var2);
//    }


//    public static void main(String args[])
//    {
//        int sum = 0;
//        for (int i = 0, j = 0; i < 5 & j < 5; ++i, j = i + 1)
//            sum += i;
//        System.out.println(sum);
//    }


//    public static void main(String args[])
//    {
//        int x = 2;
//        int y = 0;
//        for ( ; y < 10; ++y)
//        {
//            if (y % x == 0)
//                continue;
//            else if (y == 8)
//                break;
//            else
//                System.out.print(y + " ");
//        }
//    }


//    public static void main(String args[])
//    {
//        String obj = "hello";
//        String obj2 = "hello";
//        if(obj == "hello")
//            System.out.print(true +" ");
//        else
//            System.out.print(false +" ");
//        if(obj.equals(obj2))
//            System.out.print( "true" +" ");
//        else
//            System.out.print("false" +" ");
//
//    }


//    public static void main(String args[])
//    {
//        char c[]={'a', '1', 'b' ,' ' ,'A' , '0'};
//        for (int i = 0; i < 5; ++i)
//        {
//            if(Character.isDigit(c[i]))
//                System.out.println(c[i]+" is a digit");
//            if(Character.isWhitespace(c[i]))
//                System.out.println(c[i]+" is a Whitespace character");
//            if(Character.isUpperCase(c[i]))
//                System.out.println(c[i]+" is an Upper case Letter");
//            if(Character.isLowerCase(c[i]))
//                System.out.println(c[i]+" is a lower case Letter");
//            i=i+3;
//        }
//    }

    public static void main(String args[])
    {
        double a = 295.04;
        int  b = 300;
        byte c = (byte) a;
        byte d = (byte) b;
        System.out.println(c + " "  + d);
    }

}