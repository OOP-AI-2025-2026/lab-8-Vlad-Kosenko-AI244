package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;   // кількість оцінок
    private double total;  // сума оцінок

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        if (reviews == 0) {
            return 0.0;
        }
        return total / reviews;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BookData other) {
        double r1 = this.getRating();
        double r2 = other.getRating();

        int cmp = Double.compare(r2, r1); // інвертуємо порядок

        if (cmp != 0) {
            return cmp;
        }

        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                ", total=" + total +
                ", rating=" + getRating() +
                '}';
    }
}
