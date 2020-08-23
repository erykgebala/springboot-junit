package pl.eryk.springbootjunit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyBeforeTestExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("MyBeforeTestExtension..... before each");
    }
}
