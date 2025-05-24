public class WolfTest {

    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.sex = "мужской";
        wolfOne.nickame = "Альфа";
        wolfOne.weight = 70;
        wolfOne.age = 3;
        wolfOne.color = "серый";
        System.out.println("Первого волка зовут " + wolfOne.nickame);
        System.out.println("Его характеристики: " + wolfOne.sex + " пол, " + 
                wolfOne.weight + " кг, " + wolfOne.age + " года, " + wolfOne.color + " цвет");
        wolfOne.walk();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}