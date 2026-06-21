public class MovieTicket {
    String title;
    String genre;
    int runningTime;
    int price;
    int ageLimit;
    boolean reserved;

    public MovieTicket(String title, String genre, int runningTime, int price, int ageLimit, boolean reserved) {
        this.title = title;
        this.genre = genre;
        this.runningTime = runningTime;
        this.price = price;
        this.ageLimit = ageLimit;
        this.reserved = reserved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "MovieTicket{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                ", price=" + price +
                ", ageLimit=" + ageLimit +
                ", reserved=" + reserved +
                '}';
    }

}
