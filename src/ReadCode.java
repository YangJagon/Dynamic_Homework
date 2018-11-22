import java.io.*;

public class ReadCode
{
    static String readFile(String path)
    {
        String str = new String(), tmp;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf8"));
            while((tmp = reader.readLine())!=null)
            {
                int p = tmp.indexOf("//");
                if(p>0)
                    tmp=tmp.substring(0,p);
                tmp = tmp.replaceAll("\\s+$", "");

//                int l1 = tmp.length();
//                tmp=tmp.replaceAll("^\\s+", "");
//                int l2 = tmp.length();
//                Integer struc = l1-l2;
//                if(tmp.length()>0)
//                {
//                    tmp = struc.toString()+tmp;
//                    if(struc<10)
//                        tmp = "0"+tmp;
//                    str += tmp+"\n";
//                }
                if(tmp.length()>0)
                    str += tmp+"\n";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
