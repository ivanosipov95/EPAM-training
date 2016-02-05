package javase04.t04;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Film implements Serializable {

    private String title;
    private Actor[] actors;

    public Film(String title, Actor[] actors) {
        this.title = title;
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }
}
