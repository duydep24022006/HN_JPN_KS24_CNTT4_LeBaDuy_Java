package SS3.src;
public class bai3 {
    public static void maxQuantityOfBooks(String[] names, int[] quantities){
        int maxQuantities=quantities[0];
        for (int i = 0; i < quantities.length; i++) {
            if(maxQuantities<quantities[i]) maxQuantities=quantities[i];
        }
        System.out.printf("Sách có số lượng nhiều nhất (%d):\n",maxQuantities);
        for (int i = 0; i < quantities.length; i++) {
            if(quantities[i]==maxQuantities){
                System.out.printf("- %s\n",names[i]);
            }
        }
    }
    public static void minQuantityOfBooks(String[] names, int[] quantities){
        int minQuantities=quantities[0];
        for (int i = 0; i < quantities.length; i++) {
            if(minQuantities>quantities[i]) minQuantities=quantities[i];
        }
        System.out.printf("Sách có số lượng ít nhất (%d):\n",minQuantities);
        for (int i = 0; i < quantities.length; i++) {
            if(quantities[i]==minQuantities){
                System.out.printf("- %s\n",names[i]);
            }
        }
    }


    public static void main(String[] args) {
        String[] names = {"java basic", "python intro", "c# core", "html css", "reactjs"};
        int[] quantities = {10, 5, 8, 12, 7};
        maxQuantityOfBooks(names,quantities);
        System.out.println("\n----------------");
        minQuantityOfBooks(names,quantities);

    }
}
