import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        String code1=ReadCode.readFile("d:/A.cpp");
        String code2=ReadCode.readFile("d:/C.cpp");

        Transfer transfer1=new Transfer(code1);
        Transfer transfer2=new Transfer(code2);
        System.out.println("总行数： "+transfer1.getArray().length + "\n");
        System.out.println(transfer1.getResult());
        System.out.println(transfer2.getResult());

        LCS lcs = new LCS(transfer1.getArray(), transfer2.getArray(), 0.88);
        int [][]d=lcs.getD();
        double [][]s=lcs.getS();
        int r=lcs.getMCR();

        System.out.println("       S \t\t  D");
//        for(int i=0; i<d.length; i++)
//        {
//            for(int j=0;j <d[0].length; j++)
//                System.out.printf("%.2f ", s[i][j]);
//            System.out.print("\t");
//
//            for(int j=0;j <d[0].length; j++)
//                System.out.print(d[i][j]+" ");
//            System.out.println();
//        }
        System.out.println("最多重复代码行数："+ r );
        System.out.println("最多重复代码行数："+Hungarian.getMCR(d));


        lcs =new LCS(code1.split("\n"), code2.split("\n"), 0.88);
        d=lcs.getD();
        s=lcs.getS();
        r=lcs.getMCR();
//        System.out.println("\n       S \t\t  D");
//        for(int i=0; i<d.length; i++)
//        {
//            for(int j=0;j <d[0].length; j++)
//                System.out.printf("%.2f ", s[i][j]);
//            System.out.print("\t");
//
//            for(int j=0;j <d[0].length; j++)
//                System.out.print(d[i][j]+" ");
//            System.out.println();
//        }
        System.out.println("最多重复代码行数："+ r );
        System.out.println("最多重复代码行数："+Hungarian.getMCR(d));

//        Scanner scanner = new Scanner(System.in);
//        int m, n;
//        m=scanner.nextInt();
//        n=scanner.nextInt();
//        int map[][]=new int [m][n];
//        for(int i=0; i<m; i++)
//            for(int j=0; j<n; j++)
//                map[i][j] = scanner.nextInt();
//        System.out.println(Hungarian.getMCR(map));

//        HashMap<String, String> map=new HashMap<>();
//        map.put("hello", "hello");
//        if(map.containsKey("hello"))
//            System.out.println("hello");
    }
}
