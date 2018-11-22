import java.util.HashMap;
import java.util.regex.*;

public class Transfer
{
    static final String regex="(char[\\W\\*&]+|bool[\\W\\*&]+|unsigned char[\\W\\*&]+|signed char[\\W\\*&]+|int[\\W\\*&]+|unsigned int[\\W\\*&]+|" +
            "signed int|[\\W\\*&]+short int[\\W\\*&]+|unsigned short int[\\W\\*&]+|signed short int[\\W\\*&]+|long int[\\W\\*&]+|" +
            "signed long int[\\W\\*&]+|unsigned long int[\\W\\*&]+|float[\\W\\*&]+|double[\\W\\*&]+|long double[\\W\\*&]+|" +
            "wchar_t[\\W\\*&]+|string[\\W\\*&]+|void[\\W\\*&]+|class[\\W\\*&]+)(\\w+)";
    static final String nformat= "(^|\\W)(%s)($|\\W)";

    int n=0;
    String code;
    HashMap<String, String> map=new HashMap<String, String>();

    Transfer(String str)
    {
        code=str;
        transerVar();
    }

    String newName()
    {
        n++;
//        if(n>9)
//            return "%"+n;
//        else return "%0"+n;
        return "%";
    }

    void transerVar()
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);

        while(matcher.find())
            if(!map.containsKey(matcher.group(2)))
                map.put(matcher.group(2), newName());

        for(String var : map.keySet())
        {
            String nregex = String.format(nformat, var);
            pattern = Pattern.compile(nregex);
            matcher = pattern.matcher(code);
            while(matcher.find())
                code = code.replace(matcher.group(0), matcher.group(1)+map.get(var)+matcher.group(3));
        }
    }

    String getResult(){
        return code;
    }

    String[] getArray(){
        return code.split("\n");
    }
}