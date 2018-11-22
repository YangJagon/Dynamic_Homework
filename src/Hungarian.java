public class Hungarian
{
    static private int []left;
    static private int []right;
    static private boolean checkl[];
    static private boolean checkr[];
    static private int m, n;
    static private int map[][];

    static private void findMax(int [][]map)
    {
        Hungarian.map=map;
        m=map.length;
        n=map[0].length;
        left=new int[m];
        right=new int[n];
        checkl = new boolean[m];
        checkr = new boolean[n];
        for(int i=0; i<m; i++)
            left[i]=-1;
        for(int j=0; j<n; j++)
            right[j]=-1;

        for(int i=0; i<m; i++)
        {
            if(left[i]>0)
                continue;

            for(int j=0; j<m; j++)
                checkl[j]=false;
            for(int j=0; j<n; j++)
                checkr[j]=false;
            dfsl(i);
        }
    }

    static private boolean dfsl(int i)
    {
        checkl[i]=true;
        for(int j=0; j<n; j++)
        {
            if(checkr[j] || map[i][j] == 0)
                continue;

            if(right[j] < 0 || dfsr(j))
            {
                left[i]=j;
                right[j]=i;
                return true;
            }
        }
        return false;
    }

    static private boolean dfsr(int j)
    {
        checkr[j]=true;
        if(right[j]<0 || dfsl(right[j]))
            return true;
        return false;
    }

    static int getMCR(int map[][])
    {
        findMax(map);
        int count=0;
        for(int i:left)
            if(i>=0)
                count++;
        return count;
    }
}
