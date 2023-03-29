package day18;

import java.util.Arrays;
import java.util.Comparator;

class Trainee {
    private final String name;
    private final boolean isMale; // 성별
    private final int hak; // 학년
    private final int ban; // 반
    private final int score;

    public Trainee(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public boolean isMale() {
        return isMale;
    }
    public int getHak() {
        return hak;
    }
    public int getBan() {
        return ban;
    }
    public int getScore() {
        return score;
    }
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }
}
public class StreamLab {
    public static void main(String args[]) {
        Trainee[] sa = new Trainee[]{
                new Trainee("나자바", true, 1, 1, 300),
                new Trainee("김지미", false, 1, 1, 250),
                new Trainee("김자바", true, 1, 1, 200),
                new Trainee("이지미", false, 1, 2, 150),
                new Trainee("남자바", true, 1, 2, 100),
                new Trainee("안지미", false, 1, 2, 50),
                new Trainee("황지미", false, 1, 3, 100),
                new Trainee("강지미", false, 1, 3, 150),
                new Trainee("이자바", true, 1, 3, 200),
                new Trainee("나자바", true, 2, 1, 300),
                new Trainee("김지미", false, 2, 1, 250),
                new Trainee("김자바", true, 2, 1, 200),
                new Trainee("이지미", false, 2, 2, 150),
                new Trainee("남자바", true, 2, 2, 100),
                new Trainee("안지미", false, 2, 2, 50),
                new Trainee("황지미", false, 2, 3, 100),
                new Trainee("강지미", false, 2, 3, 150),
                new Trainee("이자바", true, 2, 3, 200)
        };
        // 모든 문제들은 위의 배열 객체를 가지고 스트림 객체를 만든 다음에 해결한다.
        // (1) Trainee 객체들을 화면에 출력한다.
        System.out.println("(1) 객체들 출력");
        Arrays.stream(sa).forEach(System.out::println);
        System.out.println();
        // (2) 성적이 높은 순으로 Trainee 객체들을 화면에 출력한다.
        System.out.println("(2) 성적이 높은 순 출력");
        Arrays.stream(sa).sorted(Comparator.comparing((Trainee t) -> t.getScore()).reversed()).forEach(System.out::println);
        Arrays.stream(sa).sorted((a, b) -> b.getScore()-a.getScore() ).forEach(System.out::println);
        System.out.println();
        // (3) 성적이 200 이상인 Trainee 객체들을 화면에 출력한다.
        System.out.println("(3) 200 이상 출력");
        Arrays.stream(sa).filter(n -> n.getScore() >= 200).forEach(System.out::println);
        System.out.println();
        // (4) 성적이 200 이상인 수강생들의 인원을 출력한다.
        System.out.println("(4) 200 이상 인원 출력");
        System.out.println(Arrays.stream(sa).filter(n -> n.getScore() >= 200).count() + "명");
        System.out.println();
        // (5) 남학생의 Trainee 객체들을 화면에 출력한다.
        System.out.println("(5) 남학생 출력");
        Arrays.stream(sa).filter(n -> n.isMale()).forEach(System.out::println);
        System.out.println();
        // (6) 남학생의 인원을 출력한다.
        System.out.println("(6) 남학생 인원 출력");
        System.out.println(Arrays.stream(sa).filter(n -> n.isMale()).count() + "명");
        System.out.println();
        // (7) 모든 학생들의 스코어만 출력한다.
        System.out.println("(7) 모든 학생 스코어 출력");
        Arrays.stream(sa).forEach(n -> System.out.println(n.getName() + " : "+n.getScore()));
        System.out.println();
        // (8) 모든 학생들의 스코어 합을 출력한다.
        System.out.println("(8) 모든 학생 스코어 합");
        System.out.println(Arrays.stream(sa).mapToInt(n -> n.getScore()).sum() + "점");
    }
}