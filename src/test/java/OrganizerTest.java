import org.junit.*;
import static org.junit.Assert.*;

public class OrganizerTest {
  @After
  public void tearDown() {
    Organizer.clear();
  }

  @Test
  public void OrganizerTest_shouldInstantiateCorrectly_true() {
    Organizer testOrganizer = new Organizer("joey", "funky stuff");
    assertEquals(true, testOrganizer instanceof Organizer);
  }

  @Test
  public void testOrganizer_shouldHavePropertyOfTitle_Sam(){
    Organizer testOrganizer = new Organizer("Sam", "album1");
    assertEquals("Sam", testOrganizer.getTitle());
  }

  @Test
  public void testOrganizer_shouldHavePropertyOfArtist_band(){
    Organizer testOrganizer = new Organizer("Sam", "band");
    assertEquals("band", testOrganizer.getArtist());
  }

  @Test
  public void testOrganizer_shouldListAllAlbums_2() {
    Organizer testOrganizer1 = new Organizer("sam", "stuff");
    Organizer testOrganizer2 = new Organizer("sam", "stoff");
    assertEquals(Organizer.all().size(), 2);
  }

  @Test
  public void testOrganizer_shouldFindSpecificAlbum_this() {
    Organizer testOrganizer1 = new Organizer("sam", "stuff");
    Organizer testOrganizer2 = new Organizer("sam", "stoff");
    Organizer testOrganizer3 = new Organizer("this", "stoff");
    Organizer thisAlbum = Organizer.findTitle("this");
    assertEquals(testOrganizer3.getTitle(), thisAlbum.getTitle());
  }

  @Test
  public void testOrganizer_shouldFindAllAlbumsByArtists_this() {
    Organizer testOrganizer1 = new Organizer("sam", "stuff");
    Organizer testOrganizer2 = new Organizer("sam", "stoff");
    Organizer testOrganizer3 = new Organizer("this", "stoff");
    assertEquals(Organizer.findArtistAlbums("stoff").size(), 2);
  }

  @Test
  public void testOrganizer_shouldNOtFindAllAlbumsThatDontExist_fail() {
    Organizer testOrganizer1 = new Organizer("sam", "stuff");
    Organizer testOrganizer2 = new Organizer("sam", "stoff");
    Organizer testOrganizer3 = new Organizer("this", "stoff");
    assertEquals(Organizer.findArtistAlbums("staff").size(), 0);
  }


}
