package mvc.model;

import java.util.HashMap;
import java.util.Map;

public class CartSession {
    private Map<Integer, CartItem> items = new HashMap<>();

    public void addItem(ProductEntity product, int quantity) {
        CartItem item = items.get(product.getId());
        if (item == null) {
            item = new CartItem(product, quantity);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
        items.put(product.getId(), item);
    }

    public void updateItem(int productId, int quantity) {
        CartItem item = items.get(productId);
        if (item != null) {
            item.setQuantity(quantity);
            if (quantity <= 0) {
                items.remove(productId);
            }
        }
    }

    public void removeItem(int productId) {
        items.remove(productId);
    }

    public double getTotalAmount() {
        return items.values().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }
}
