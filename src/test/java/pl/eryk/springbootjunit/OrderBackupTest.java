package pl.eryk.springbootjunit;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

class OrderBackupTest {

    private static OrderBackup orderBackup;
    private Order order;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void initializaOrder() throws IOException {
        this.order = new Order();
        orderBackup.appendText("---------------");
    }

    @AfterEach
    void addSeparatorOrder() throws IOException {
        orderBackup.appendText("---------------");
    }


    @Test
    void orderShouldBeBackupToFile() throws IOException {
        Meal meal1 = new Meal("Pizza", 34);
        Meal meal2 = new Meal("Burger", 25);
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //when
        //then
        orderBackup.backupOrder(order);


    }

    @AfterAll
    static void cleanUp() throws IOException {
        orderBackup.closeFile();
    }

}
