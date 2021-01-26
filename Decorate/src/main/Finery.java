package main;

public class Finery extends Person{
    protected Person conponent;

    public void Decorate(Person conponent) {//继承现有的服装
        this.conponent = conponent;
    }

    @Override
    public void show() {
        if (conponent != null) {
            conponent.show();
        }
    }
}
