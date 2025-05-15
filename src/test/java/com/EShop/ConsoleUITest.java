package com.EShop;
import com.EShop.cart.Cart;
import com.EShop.cart.CartItem;
import com.EShop.cart.CartItemCreator;
import com.EShop.cart.CartService;
import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;
import com.EShop.product.Product;
import com.EShop.product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleUITest {

    Product laptop;
    Product tv;
    List<Product> productList;
    ProductService productService;
    Cart cart;
    CartItemCreator cartItemCreator;
    ConsoleUI consoleUI;
    CartItem laptopItem;
    CartItem tvItem;
    Checkout checkout;
    Customer customer;
    List <Discount> discounts;
    CartService cartService;

    @BeforeEach
    public void setUp() {
        laptop = new Product(1,"Laptop", "Macbook", "Electronic", 10000.00);
        tv = new Product(2,"TV","Samsung", "Electronic", 2000.00);

        productList= new ArrayList<>();
        productList.add(laptop);
        productList.add(tv);

        productService = new ProductService(productList);
        cartItemCreator = new CartItemCreator(productService);

        laptopItem = new CartItem(laptop, 1);
        tvItem = new CartItem(tv, 1);
        cart = new Cart(new ArrayList<>());
        customer = new Customer(0);
        discounts = List.of(new TenPercent(), new TwentyPercent());
        cartService = new CartService(productService, cartItemCreator, cart);


        checkout = new Checkout(customer,cart,discounts);

        consoleUI =new ConsoleUI(cart,cartItemCreator,productService, checkout, cartService, discounts, customer, productList);
    }

    @Test
    void getWelcomeMessageTest() {
        String welcomeMessage = consoleUI.getWelcomeMessage();
        assertEquals("Welcome to STI Bakery", welcomeMessage);
    }

    @Test
    void getAllProductsTest(){

        assertEquals(2, productList.size());
        assertEquals("Laptop", productList.get(0).getArticle());

    }

    @Test
    @DisplayName("Test showing  products in the Cart")
    void showCart() {
        cart.addToCart(laptopItem);
        cart.addToCart(tvItem);

        assertEquals(laptopItem, cart.getCartItemList().get(0));
        assertEquals(tvItem, cart.getCartItemList().get(1));

    }

    @Test
    void options() {
        String options = consoleUI.options();
        assertEquals("\nWhat do you want to do next? \n" +
                "1) View products\n" +
                "2) Add product to cart \n" +
                "3) Remove product from cart \n" +
                "4) View cart summary \n" +
                "5) Check balance \n" +
                "6) Add balance \n" +
                "7) Checkout", options);
    }


    @Test
    void processInputCase1() {
        int fakeInput = 1;
        boolean result= consoleUI.processInput(fakeInput);
        assertTrue(result);
    }

    @Test
    void processInputCase2() {
        int fakeInput = 2;
        boolean result= consoleUI.processInput(fakeInput);
        assertTrue(result);
    }

   @Test
    void processInputCase3() {
        int fakeInput = 3;
        boolean result= consoleUI.processInput(fakeInput);
        assertTrue(result);
    }


}