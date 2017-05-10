//运动员和教练的案例（下图是思路分析）

/*
    篮球运动员和教练
    乒乓球运动员和教练
    现在篮球运动员和教练要出国访问,需要学习英语
    请根据你所学的知识,分析出来哪些是类,哪些是抽象类,哪些是接口
*/
interface SpeakEnglish {
    public abstract void speak();

}

interface GoAboard{
    public abstract void aboard();
}

abstract class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    //吃饭
    public abstract void eat();
    //睡觉
    public void sleep(){
        System.out.println("Zzz...");
    }
}
//运动员
abstract class Player extends Person {
    public abstract void study();
}
//教练
abstract class Coach extends Person {
    public abstract void teach();
}

//篮球运动员
class BasketballPlayer extends Player implements SpeakEnglish,GoAboard{
    public void eat(){
        System.out.println(getAge() + "岁的" + getName() + "吃鸡腿");
    }

    public void study(){
        System.out.println(getAge() + "岁的" + getName() + "学扣篮");
    }
    @Override
    public void speak(){
        System.out.println(getAge() + "岁的" + getName() + " Say Hello World");
    }

    public void aboard(){
        System.out.println(getAge() + "岁的" + getName() + " Go Aboard");
    }
}
//乒乓运动员
class PingPangPlayer extends Player{
    public void eat(){
        System.out.println(getAge() + "岁的" + getName() + "吃鸡蛋");
    }

    public void study(){
        System.out.println(getAge() + "岁的" + getName() + "学扣球");
    }
}
//篮球教练
class BasketballCoach extends Coach implements SpeakEnglish {
    public void eat(){
        System.out.println(getAge() + "岁的" + getName() + "啃鸡爪");
    }

    public void teach(){
        System.out.println(getAge() + "岁的" + getName() + "教扣篮");
    }

    public void speak(){
        System.out.println(getAge() + "岁的" + getName() + " Say Hello Java");
    }

    public void aboard(){
        System.out.println(getAge() + "岁的" + getName() + " Go Aboard");
    }
}
//乒乓球教练
class PingPangCoach extends Coach{
    public void eat(){
        System.out.println(getAge() + "岁的" + getName() + "吃鸡蛋皮");
    }

    public void teach(){
        System.out.println(getAge() + "岁的" + getName() + "教扣球");
    }
}
class PlayerAndCoach {
    public static void main(String[] args) {
        //篮球运动员
        BasketballPlayer bp = new BasketballPlayer();
        bp.setName("郭艾伦");
        bp.setAge(33);
        bp.eat();
        bp.sleep();
        bp.study();
        bp.speak();
        bp.aboard();
        System.out.println("***********************");
        //篮球教练
        BasketballCoach bc = new BasketballCoach();
        bc.setName("波波维奇");
        bc.setAge(65);
        bc.eat();
        bc.sleep();
        bc.teach();
        bc.speak();
        bc.aboard();
        System.out.println("***********************");
        //多态
        Person p = new BasketballPlayer();
        p.setName("Kobe Bryant");
        p.setAge(33);
        p.eat();
        p.sleep();
        //p.study();
        //p.speak();

        BasketballPlayer bp2 = (BasketballPlayer)p;
        bp2.study();
        bp2.speak();
        bp2.aboard();
        System.out.println("***********************");
    }
}