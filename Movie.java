public class Movie {
    String name;
    float rating;
    String duration;
    Movie(String name,float rating,String duration){
        this.name=name;
        this.rating=rating;
        this.duration=duration;
    }
    void details(){
        System.out.println("Movie name:"+name);
        System.out.println("Movie rating:"+rating);
        System.out.println("Movie duration:"+duration);
    
    if(rating >= 9 ){
         System.out.println("Movie is hit");
    }System.out.println("--------------------");
    }
    
    
    public static void main(String[] args) {
        Movie m1 =new Movie ("Gangubhai",9.5f,"2h:30min");
        Movie m2 =new Movie ("ArjunReddy",9.5f,"2h:45min");
        m1.details();
        m2.details();
    }
}

