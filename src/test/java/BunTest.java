import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class BunTest {

    private int expectedSize;
    private String bunName;
    private int bunPrice;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, "black bun", 100},
                {3, "white bun", 200},
                {3, "red bun", 300}
        });
    }

    public BunTest(int expectedSize, String bunName, int bunPrice) {
        this.expectedSize = expectedSize;
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        List<Bun> availableBuns = database.availableBuns();
        Assert.assertEquals("Количество видов булочек не изменилось", expectedSize, availableBuns.size());

        Bun bun = availableBuns.stream()
                .filter(b -> b.getName().equals(bunName))
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(bun);
        Assert.assertEquals("Стоимость булочки соответствует ожидаемой", bunPrice, bun.getPrice(), 0.001);
    }
}


