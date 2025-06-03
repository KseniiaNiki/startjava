public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaegerOne = new Jaeger();
        jaegerOne.setModelName("Crimson Typhoon");
        jaegerOne.setMark("Mark-4");
        jaegerOne.setOrigin("Китай");
        jaegerOne.setHeight(76.2);
        jaegerOne.setWeight(1722);
        jaegerOne.setSpeed(9);
        jaegerOne.setStrength(8);
        jaegerOne.setArmor(6);
        jaegerOne.setBodyLanguage("Muay Thai triplet");
        System.out.println(jaegerOne.toString());
        jaegerOne.drift();
        jaegerOne.move();
        System.out.println(jaegerOne.scanKaiju());
        jaegerOne.usePlasmacaster();

        Jaeger jaegerTwo = new Jaeger("Gipsy Danger", "Mark-3", "США", 
                79.25, 1980, 7, 8, 6, "Street Fighter");
        System.out.println(jaegerTwo.toString());
        jaegerTwo.drift();
        jaegerTwo.move();
        System.out.println(jaegerTwo.scanKaiju());
        jaegerTwo.usePlasmacaster();
    }
}