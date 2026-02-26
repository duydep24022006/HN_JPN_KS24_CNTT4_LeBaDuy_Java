package SS10.Bai4;

interface RemoteControl {

    void powerOn();

    default void checkBattery() {
        System.out.println("Pin ổn định");
    }
}