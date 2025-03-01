package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    // Database database;
    InMemoryDatabase fakeDatabase;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        // database = new Database(); // We probably don't want to access our real database...
        fakeDatabase = new InMemoryDatabase("Scotty", 17214);
        // recommender = new RecSys();
        recommender = mock(RecSys.class);
        // promoService = new PromoService();
        promoService = mock(PromoService.class);

        // andrewWebService = new AndrewWebServices(database, recommender, promoService);
        andrewWebService = new AndrewWebServices(fakeDatabase, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        // assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));

        when(recommender.getRecommendation("Scotty")).thenReturn("Animal House");
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?

        String testEmail = "test@example.com";
        andrewWebService.sendPromoEmail(testEmail);

        verify(promoService).mailTo(testEmail);
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        verify(promoService, never()).mailTo(anyString());
    }
}
