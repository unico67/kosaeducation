import java.util.Arrays;
class Trainee {
	private final String name;
    private final boolean isMale; // 성별
    private final int hak; // 학년
    private final int ban; // 반
    private final int score;	    

    public Trainee(String name, boolean isMale, int hak, int ban, int score) {
		super();
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
public class Test {	
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
		Arrays.stream(sa).forEach(System.out::println);
		Arrays.stream(sa).sorted((a, b) -> a.getScore() - b.getScore()).forEach(System.out::println);
		Arrays.stream(sa).filter(st -> st.getScore() > 200).forEach(System.out::println);
		System.out.println(Arrays.stream(sa).filter(st -> st.getScore() > 200).count());
		System.out.println(Arrays.stream(sa).filter(st -> st.isMale()).count());
		Arrays.stream(sa).map(st  -> st.getScore()).forEach(System.out::println);
		System.out.println(Arrays.stream(sa).mapToInt(st  -> st.getScore()).average().getAsDouble());
		System.out.println(Arrays.stream(sa).mapToInt(st  -> st.getScore()).sum());
	}
}
