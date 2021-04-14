package quotes;

import java.util.ArrayList;
import java.util.List;

class Quotes {
    private    ArrayList<String> tags;
    private    String author;
    private    String likes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private    String text;

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return String.format(" %s Said: %s ", this.getAuthor(),this.getText());
    }
}
