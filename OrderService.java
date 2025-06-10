// OrderService.java
package com.example.app.service;

import java.util.UUID;

public class OrderService {

    private static final double MIN_ORDER_AMOUNT = 10.00;
    private static final double DISCOUNT_THRESHOLD = 100.00;
    private static final double DISCOUNT_RATE = 0.10;

    /**
     * Processes a new customer order.
     * Validates order details, calculates total, and saves the order.
     * @param customerId The ID of the customer placing the order.
     * @param items A list of product items with quantities.
     * @param shippingAddress The address for shipping.
     * @return A unique order ID.
     */
    public String createOrder(String customerId, List<OrderItem> items, String shippingAddress) {
        // Validation: Customer ID must not be null or empty
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID is required.");
        }

        // Validation: Items list must not be empty
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item.");
        }

        double totalAmount = calculateTotal(items);

        // Validation: Total order amount must be above minimum
        if (totalAmount < MIN_ORDER_AMOUNT) {
            throw new IllegalArgumentException("Order total must be at least $" + MIN_ORDER_AMOUNT);
        }

        // Functional Requirement: Apply discount if total exceeds threshold
        if (totalAmount > DISCOUNT_THRESHOLD) {
            totalAmount -= (totalAmount * DISCOUNT_RATE);
            System.out.println("Discount applied. New total: " + totalAmount);
        }

        // Functional Requirement: Generate a unique order ID
        String orderId = UUID.randomUUID().toString();

        // Functional Requirement: Persist order details to the database
        saveOrderToDatabase(orderId, customerId, items, totalAmount, shippingAddress);

        return orderId;
    }

    private double calculateTotal(List<OrderItem> items) {
        // Functional Requirement: Sum up prices of all items
        return items.stream()
                    .mapToDouble(item -> item.getPrice() * item.getQuantity())
                    .sum();
    }

    private void saveOrderToDatabase(String orderId, String customerId, List<OrderItem> items, double totalAmount, String shippingAddress) {
        // Placeholder for database save logic
        System.out.println("Saving order " + orderId + " for customer " + customerId + " with total " + totalAmount + " to DB.");
    }

    static class OrderItem {
        String productId;
        int quantity;
        double price;

        public OrderItem(String productId, int quantity, double price) {
            this.productId = productId;
            // Validation: Quantity must be positive
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive.");
            }
            this.quantity = quantity;
            // Validation: Price must be positive
            if (price <= 0) {
                throw new IllegalArgumentException("Price must be positive.");
            }
            this.price = price;
        }

        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
    }
}
