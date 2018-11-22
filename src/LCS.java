public class LCS
{
    int d[][];
    double s[][];
    int MCR;

    LCS(String []file1, String []file2, double r)
    {
        int m = file1.length;
        int n = file2.length;

        d = new int[m][n];
        s = new double[m][n];

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                s[i][j] = calS(file1[i], file2[j]);
                if(s[i][j] > r)
                    d[i][j]=1;
                else d[i][j] =0;
            }
        MCR = calMCR();
    }

    private int calLCS(String str1, String str2)
    {
        int m=str1.length();
        int n=str2.length();

        int c[][] = new int[m+1][n+1];
        for(int i=0; i<m; i++)
            c[i][0] = 0;
        for(int j=0; j<n; j++)
            c[0][j] = 0;

        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    c[i][j] = c[i-1][j-1]+1;
                else{
                    c[i][j] = c[i-1][j] > c[i][j-1]?c[i-1][j] : c[i][j-1];
                }
            }
        return c[m][n];
    }

    private double calS(String str1, String str2)
    {
        double lcs = calLCS(str1, str2);
        double len = str1.length() < str2.length() ? str2.length():str1.length();
        //System.out.println(str1+" <-> "+str2+"->"+lcs + "  " + lcs/len);
        return lcs/len;
    }

    private int calMCR()
    {
        int m=d.length;
        int n=d[0].length;

        int c[][] = new int[m+1][n+1];

        for(int i=0; i<m; i++)
            c[i][0] = 0;
        for(int j=0; j<n; j++)
            c[0][j] = 0;

        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++)
            {
                if(d[i-1][j-1]==1)
                    c[i][j] = c[i-1][j-1]+1;
                else{
                    c[i][j] = c[i-1][j] > c[i][j-1]?c[i-1][j] : c[i][j-1];
                }
            }
        return c[m][n];
    }

    int [][] getD()
    {
        return d;
    }

    double [][] getS()
    {
        return s;
    }

    int getMCR()
    {
        return MCR;
    }
}
