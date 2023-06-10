import com.techelevator.*;

import org.junit.*;

public class ProductTest {

    private Product drinkProduct;
    private Product chipProduct;
    private Product gumProduct;
    private Product candyProduct;

    @Before
    public void setUp() {
        drinkProduct = new Product("A1", "Coke", 1.5, "Drink", 5);
        chipProduct = new Product("B1", "Chips", 1.0, "Chip", 5);
        gumProduct = new Product("C1", "Gum", 0.5, "Gum", 5);
        candyProduct = new Product("D1", "Candy", 1.25, "Candy", 5);
    }

    @Test
    public void testGetSoundForDrink() {
        String sound = drinkProduct.getSound();
        Assert.assertEquals("Glug Glug, Yum!", sound);
    }

    @Test
    public void testGetSoundForChip() {
        String sound = chipProduct.getSound();
        Assert.assertEquals("Crunch Crunch, Yum!", sound);
    }

    @Test
    public void testGetSoundForGum() {
        String sound = gumProduct.getSound();
        Assert.assertEquals("Chew Chew, Yum!", sound);
    }

    @Test
    public void testGetSoundForCandy() {
        String sound = candyProduct.getSound();
        Assert.assertEquals("Munch Munch, Yum!", sound);
    }
}