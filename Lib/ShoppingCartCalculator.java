import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
        Method คำนวณราคาของสินค้าภายในตะกร้าสินค้า โดยรหัสสินค้าแบ่งเป็น
        1.NORMAL คำนวณปกติ
        2.BULK โปรโมชั่น ซื้อสินค้า 6 ชิ้่น ขึ้นไปจะมีส่วนลด 10%
        3.BOGO โปรโมชั่นซื้อสินค้า 1 ชิ้น แถม 1 ชิ้น 
        หากตะกร้าสินค้าว่างเปล่าหรือมีค่าเป็น Null การคำนวณราคาจะเป็น 0.0
        หากราคาสินค้าหรือจำนวนสินค้ามีค่าเป็นลบ จะทำการ convert เป็นค่า บวก
        @param items รหัสการซื้อ, ชื่อสินค้า, ราคา, จำนวน
        @return double ราคาสินค้าในตะกร้าที่คำนวณแล้ว
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double prices = 0;
        double quantity;
        double sum  = 0;
        double sum_final = 0;

        if(items == null)
                return 0.0;


        for(int i = 0 ; i < items.size() ; i++){

            prices = items.get(i).price();
            quantity = items.get(i).quantity();

            
            if(prices < 0)
              prices = prices*(-1);
            if(quantity < 0)
              quantity = quantity*(-1);
                
                

            
            
            if(items.get(i).sku().equals("NORMAL")){
                sum = prices*quantity;
                sum_final = sum_final + sum;
            }

             else if(items.get(i).sku().equals("BOGO")){
                    if(items.get(i).quantity() >= 2){
                        sum = prices*quantity;
                        sum_final = sum_final + (sum - (prices*Math.floor(quantity/2))); // Math.floor() ปัดทศนิยมลง
                        
                    }
                    else{
                        sum = prices*quantity;
                        sum_final = sum_final + sum;
                    }
            }

            else if(items.get(i).sku().equals("BULK")){
                    if(items.get(i).quantity() > 6){
                        sum = prices*quantity;
                        sum_final = sum_final + (sum-sum/10);
                    }
                    else{
                        sum = prices*quantity;
                        sum_final = sum_final + sum;
                    }

            }
            
            if(items == null)
                return 0.0;
            


        }

        
        return sum_final;
    }
}