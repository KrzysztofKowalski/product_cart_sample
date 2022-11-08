package org.example;

/**
 * Tesco gets millions of orders every day with an average basket size of 100 items.
 * Tesco Business has got some regulations around selling products online and in stores. These regulations are mandatory from legal and business perspective to enforce for all order transactions.
 *
 * You are given an order with a list of products with productid, product Category and quantity.
 * And also, Restriction Rules on Qty and Qty/Category.
 *
 * Example:
 *
 * Ordered lines
 *
 * Line-1 -> productid=1, category=Paracetamol, quantity=3
 *
 * Line-2 -> productid=2, category=analgesic, quantity=3
 *
 * Line-3 -> productid=3, category=chocolate, quantity=8
 *
 * Line-4 -> productid=4, category= Paracetamol, quantity=2
 *
 * Business Restriction rules:
 *
 * Cannot buy more than 10 Quantity of any products - BulkBuyLimit
 *
 * Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory
 *
 *
 * Write a restriction rule engine to run the restriction check against the basket and return the status as to MET/BREACHED indicating restriction status for the given restriction rules.
 *
 * For the above given example, the restriction status returned would be MET.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
