package main;

public class Client {
    public static void main(String[] args) {
        Person adam = new Person("adam");

        Tshirts a = new Tshirts();
        Suits b = new Suits();
        shoes c = new shoes();

        a.Decorate(adam);
        b.Decorate(a);
        c.Decorate(b);
        c.show();
    }
}
