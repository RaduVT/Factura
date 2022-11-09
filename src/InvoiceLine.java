public class InvoiceLine {
   private int quantity;
   private String item;
   private String description;
   private float unitPrice;
   private float discount;
   public static String LINES =
           "------------------------------------------------------------------------------------------------------";
   private static final String FORMAT_STRING = "| %9s | %10s | %30s | %13s | %8s | %13s |";
   public  static final String HEADER = LINES + "\n" +
           String.format(FORMAT_STRING, "QTY", "Item #", "DESCRIPTION",
                   "UNIT PRICE", "DISCOUNT", "LINE TOTAL") + "\n" + LINES;

   public InvoiceLine( int quantity, String item, String description,
                       float unitPrice, float discount) {
      this.quantity = quantity;
      this.item = item;
      this.description = description;
      this.unitPrice = unitPrice;
      this.discount = discount;
   }

   @Override
   public String toString() {
      String quantityS = Integer.toString(quantity);
      String unitPriceS = Float.toString(unitPrice);
      String discountS = Float.toString(discount);
      double lineTotal = quantity * (unitPrice * ( 1 - (discount/100)));

      String s = String.format(FORMAT_STRING, quantityS, item, description,
                      unitPriceS, discountS + "½", lineTotal);
      return s;
   }
}
