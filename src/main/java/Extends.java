//多态向下转型和向上转型的例子，多态转型解决了多态中父类引用不能使用子类特有成员的弊端。
class Extends {
    public static void main(String[] args) {
        Phone p1 = new Nokia();        //向上转型，类型提升
        Nokia no = (Nokia)p1;          //向下转型，强制将父类的引用转换成子类类型，不能将Nokia类型转成Moto或Nexus类型
        no.print();                      //输出结果为Phone---null---0，因为继承了父类的方法

        Phone p2 = new Moto();
        Moto m = (Moto)p2;
        m.print();                    //输出结果为Moto---yellow---1599，方法重写，子类方法覆盖父类方法

        Phone p3 = new Nexus();
        Nexus ne = (Nexus)p3;
        ne.print();
    }
}

class Phone{
    String color;
    int price;

    public void print(){
        System.out.println("Phone---" + color + "---" + price );
    }
}

class Nokia extends Phone{
    String color = "red";
    int price = 1009;

    public void print(){
        System.out.println("Nokia---" + color + "---" + price);
    }
}

class Moto extends Phone{
    String color = "yellow";
    int price = 1599;

    public void print(){
        System.out.println("Moto---" + color + "---" + price);
    }
}

class Nexus extends Phone{
    String color = "black";
    int price = 1999;

    public void print(){
        System.out.println("Nexus---" + color + "---" + price);
    }
}

