package com.shoppingcart.checkout;

/**
 * @author ${dheeraj.kotha}
 */
public class CheckOutSystem {

    public double calculateCost(Products products){

        String offer = products.getOffer();

        switch (offer) {
            case "Y":
                return calculateCostWithOffer(products);
            case "N":
                return calculateCostWithoutOffer(products);
            default:
                throw new RuntimeException("Invalid offer "+offer);
        }
    }

    public double calculateCostWithOffer(Products products){

        double cost;
        if(products.getApples() % 2 == 0){
            cost = ((products.getApples() / 2) * 0.60);
        }else{
            cost = products.getApples() * 0.60;
        }

        if(products.getOranges() % 3 == 0){
            cost += (products.getOranges() - (products.getOranges() / 3)) * 0.25;
        }else{
            cost += products.getOranges() * 0.25;
        }

        if(products.getBananas() % 2 == 0){
            cost += ((products.getBananas() / 2) * 0.60);
        }else{
            cost += products.getBananas() * 0.60;
        }
        return cost;
    }

    public double calculateCostWithoutOffer(Products products){
        return (products.getApples() * 0.60) + (products.getOranges() * 0.25) + (products.getBananas() * 0.20);
    }
}
