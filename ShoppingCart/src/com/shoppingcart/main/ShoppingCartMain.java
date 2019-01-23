package com.shoppingcart.main;

import com.shoppingcart.checkout.CheckOutSystem;
import com.shoppingcart.checkout.Products;

import java.util.Scanner;

/**
 * @author ${dheeraj.kotha}
 */
public class ShoppingCartMain {

    public static void main(String[] args) {
        getCheckoutProducts();
    }

    public static void getCheckoutProducts(){

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter whether Buy 2 get 1 exists ?(Y/N)");
        String offer = in.next();

        boolean offerValidation = validateOffer(in, offer);

        if(offerValidation){
            getCheckoutProducts();
        }

        System.out.println("Please enter number of apples ?");
        double apples = in.nextDouble();

        System.out.println("Please enter number of oranges ?");
        double oranges = in.nextDouble();

        System.out.println("Please enter number of bananas ?");
        double bananas = in.nextDouble();

        Products product = new Products();
        product.setApples(apples);
        product.setOranges(oranges);
        product.setOffer(offer);
        product.setBananas(bananas);

        CheckOutSystem checkOutSystem = new CheckOutSystem();
        double costWithoutOffer = checkOutSystem.calculateCost(product);

        System.out.println("Total Cost is "+costWithoutOffer);
        System.out.println();
        System.out.println();

        System.out.println("Next Customer");

        getCheckoutProducts();

    }

    private static boolean validateOffer(Scanner in, String offer) {
        if(!offer.contains("Y") && !offer.contains("N")){
            System.out.println("Offer you entered is invalid.");
            return true;
        }else {
            return false;
        }
    }

}
