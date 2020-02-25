package generics;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.IntFunction;

public class User implements Comparable<User>{
    String name;
    LocalDate birth;

    public User() {
    }

    public User(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public <T> String info(T arg){
        return arg.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(birth, user.birth);
    }

    @Override
    public int hashCode() {
        System.out.println("Obliczam hash: " + Objects.hash(name, birth));
        return Objects.hash(name, birth);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }

    @Override
    public int compareTo(User o) {
        //return name.length() > o.name.length() ? 1 : name.length() < o.name.length() ? -1 : 0;
        if (name.length() > o.name.length()){
            return 1;
        }
        if (name.length() < o.name.length()){
            return -1;
        }
        return 0;
        //lub
        //return Integer.compare(name.length(), o.name.length());
    }
}
