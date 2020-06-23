package basic;

import basic.domain.User;
import org.junit.Test;

import java.util.*;

public class BasicTest {

    int x = 3;
    int y = 4;

    Integer xx = 3;
    Integer yy = 4;

    private static <T> void swap(T x, T y){
        T temp;
        temp = x;
        x = y;
        y = temp;
    }
    private static void swapint(int x, int y){
        int temp;
        temp = x;
        x = y;
        y = temp;
    }
    private static void swapInteger(Integer x, Integer y){
        Integer temp;
        temp = x;
        x = y;
        y = temp;
    }

    /*
    传参方式 && swap方法的测试
    java传参机制是基本数据类型传递值，Object类型是引用传递，
    但其实使用过程中，所有的传参在方法结束时，都不会带到调用他的外层方法中，
    如果在子方法中内容被改变，那是改变了该引用的类中的一个变量，比如可以在方法中重新setValue
    基本数据类型不是Object的子类，其包装类才是
     */
    @Test
    public void test1(){

        System.out.println("x: "+x+"   y:"+y);
        swapint(x,y);
        System.out.println("x: "+x+"   y:"+y);
        swap(x,y);
        System.out.println("x: "+x+"   y:"+y);


        System.out.println("xx: "+xx+"   yy:"+yy);
        swapInteger(xx,yy);
        System.out.println("xx: "+xx+"   yy:"+yy);
        swap(xx,yy);
        System.out.println("xx: "+xx+"   yy:"+yy);

        System.out.println("x==xx ? "+ (x == xx));
        System.out.println("xx.equal(x)? " + (xx.equals(x)));

        String s1 = "s1";
        String s2 = "s2";
        swap(s1,s2);
        System.out.println("s1: "+ s1 + "   s2: "+ s2);

        User user1 = new User();
        user1.setId(1); user1.setName("user111");
        User user2 = new User();
        user2.setId(1); user2.setName("user111");
        System.out.println("user1: "+user1.toString());
        System.out.println("user2: "+user2.toString());
        BasicTest.swap(user1,user2);
        System.out.println("user1: "+user1.toString());
        System.out.println("user2: "+user2.toString());
        System.out.println("user1==user2? " + (user1==user2));
        System.out.println("user1.equals(user2)? " + (user1.equals(user2)));
    }

    /*
     == 和 equals 的验证
     ==：对于引用类，判断地址是否相同，对于基本数据类型，判断值是否相同
     equals：判断所引用的地址中的值是否相同，基本数据类型不能调用此方法
     细节：对于Integer类型，-128~127范围内的数，若值相同则地址也相同
     */
    @Test
    public void test2(){
        Integer a = 100;
        Integer b = 100;
        Integer c = 1000;
        Integer d = 1000;
        Integer e = 17;
        System.out.println("a==b? "+ (a==b));
        System.out.println("a.equals(b)? "+(a.equals(b)));
        System.out.println("c==d? "+ (c==d));
        System.out.println("c.equals(d)? " + (c.equals(d)));
        System.out.println("a==e? "+(a==e));
        System.out.println("a.equals(e)"+(a.equals(e)));
        String s1 = "233";
        String s2 = "233";
        System.out.println("s1==s2? "+(s1==s2));
        System.out.println("s1.equals(s2)? "+ (s1.equals(s2)));
        User user = new User();
        user.hashCode();
        user.equals(null);
    }

    @Test
    public void test3(){
        Map map = new HashMap();
        Map table = new Hashtable();
        Set set = new HashSet();
        map.put(1,"xiaoming");
        map.put(2,"xiaohong");
        map.put(1,"xiaogang");
        for (Object o : map.keySet()) {
            System.out.println(o.toString()+":"+map.get(o));
        }
        set.add("xiaoming1");
        set.add("xiaoming2");
        set.add("xiaoming1");
        for (Object o : set) {
            System.out.println(o.toString());
        }
    }
}
