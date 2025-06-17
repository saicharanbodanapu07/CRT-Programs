public class Game{
    int play_count;
    String title;
    int rating;
    String genre;

    public Game(int play_count, String title, int rating, String genre){
        this.play_count = play_count;
        this.title = title;
        this.rating = rating;
        this.genre = genre;
    }

    public void play(){
        play_count++;
        System.out.println("Playing " + title + ". Play count: " + play_count);
    }

    public void friendPlay(){
        if (genre == "Horror") {
            System.out.println(title + " is not Friendly " + genre);
        }
        else {
            System.out.println(title + " is Friendly " + genre);
        }
    }

    public void info(){
        System.out.println("Title: " + title);
        System.out.println("Play Count: " + play_count);
        System.out.println("Rating: " + rating);
        System.out.println("Genre: " + genre);
    }

}