import java.util.ArrayList;


public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: มีส่วนลด BOGO ซื้อ 2 ชิ้น และ ส่วนลด BULK ซื้อ 7 ชิ้น และ NORMAL 6 ชิ้น
        ArrayList<CartItem> simpleCart2 = new ArrayList<>();
        simpleCart2.add(new CartItem("BOGO", "Bread", 25.0, 2)); // 25
        simpleCart2.add(new CartItem("BULK", "Milk", 10.0, 7));  //63
        simpleCart2.add(new CartItem("NORMAL", "Candy", 5.0, 6)); //30      
        double total4 = ShoppingCartCalculator.calculateTotalPrice(simpleCart2);
        if (total4 == 118.0) {
            System.out.println("PASSED: Simple cart total is correct (118.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 118.0 but got " + total4);
            failedCount++;
        }

        // Test 5: มีส่วนลด BOGO ซื้อ 1 ชิ้น และ ส่วนลด BULK ซื้อ 6 ชิ้น 
        ArrayList<CartItem> simpleCart3 = new ArrayList<>();
        simpleCart3.add(new CartItem("BOGO", "Bread", 25.0, 1)); // 25
        simpleCart3.add(new CartItem("BULK", "Milk", 10.0, 6));  //60    
        double total5 = ShoppingCartCalculator.calculateTotalPrice(simpleCart3);
        if (total5 == 85.0) {
            System.out.println("PASSED: Simple cart total is correct (85.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 85.0 but got " + total5);
            failedCount++;
        }

        // Test 6: ราคาสินค้าเป็นทศนิยม
        ArrayList<CartItem> simpleCart4 = new ArrayList<>();
        simpleCart4.add(new CartItem("BOGO", "Bread", 20.15, 3)); // 40.3
        simpleCart4.add(new CartItem("BULK", "Milk", 10.5, 7));  //66.15   
        double total6 = ShoppingCartCalculator.calculateTotalPrice(simpleCart4);
        if (total6 == 106.45) {
            System.out.println("PASSED: Simple cart total is correct (106.45)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 106.45.0 but got " + total6);
            failedCount++;
        }

        // Test 7: ราคาสินค้าลบ และ จำนวนสินค้าเป็นลบ
        ArrayList<CartItem> simpleCart5 = new ArrayList<>();
        simpleCart5.add(new CartItem("NORMAL", "Bread", -20, -2)); // 40
        double total7 = ShoppingCartCalculator.calculateTotalPrice(simpleCart5);
        if (total7 == 40) {
            System.out.println("PASSED: Simple cart total is correct (40.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 40.0 but got " + total7);
            failedCount++;
        }



        

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}