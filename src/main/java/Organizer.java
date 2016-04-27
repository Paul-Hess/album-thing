import java.util.ArrayList;

public class Organizer {
  private String mTitle;
  private String mArtist;
  private static Organizer mFound;
  private static ArrayList<Organizer> instances = new ArrayList<Organizer>();
  private static ArrayList<Organizer> artistInstances = new ArrayList<Organizer>();
  public Organizer(String title, String artist) {
    mTitle = title;
    mArtist = artist;
    instances.add(this);
  }

  public String getTitle(){
    return mTitle;
  }

  public String getArtist() {
    return mArtist;
  }

  public static ArrayList<Organizer> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Organizer findTitle(String title) {

    for (int index = 0; index < instances.size(); index++) {
      Organizer current = instances.get(index);
      if(title.equals(current.getTitle())) {
        mFound = current;
      }
    }
    return mFound;
  }

  public static ArrayList<Organizer> findArtistAlbums(String artist) {
    for (int index = 0; index < instances.size(); index++) {
      Organizer current = instances.get(index);
      if(artist.equals(current.getArtist())) {
        artistInstances.add(current);
      } 
    }
    return artistInstances;
  }


}
