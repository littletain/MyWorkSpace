package basic;

import org.junit.Test;

public class StringToStringBuilder {
    @Test
    public void work(){
        /*
        String和StringBuilder不能强制互相转化，编译无法通过
        如果通过String->Object->StringBuilder的方式转化，编译能过，但运行时会出错
        正确的转化方式是：
        ```
        String str = stringbuilder.toString();
        StringBuilder sb = new StringBuilder(str);
        ```
         */
        StringBuilder sb = new StringBuilder();
        sb.append("StringBuilder");
        Object obj = sb;
        String str = (String)obj;
        //str = (String)sb;
        //sb = (StringBuilder)str;
        System.out.println(sb);
        System.out.println(str);
        System.out.println(obj);
    }
}
