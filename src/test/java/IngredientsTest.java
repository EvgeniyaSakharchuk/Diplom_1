import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;


@RunWith(Parameterized.class)
public class IngredientsTest {
    private final String name;
    private final float price;
    private final IngredientType type;
    private Ingredient ingredient;
    public IngredientsTest(IngredientType type, String name, float price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
    @Parameterized.Parameters(name ="Type Ingredient:{0}, Name Ingredient: {1}, Price: {2}")
    public static Object[] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }
    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void correctPriceIngredient() {
        Assert.assertEquals("Некорректная цена", price, ingredient.getPrice(), 0);
    }
    @Test
    public void correctNameIngredient() {
        Assert.assertEquals("Некорректное наименование ингредиента", name, ingredient.getName());
    }
    @Test
    public void correctTypeIngredient() {
        Assert.assertEquals("Некорректный тип ингредиента", type, ingredient.getType());
    }
}

