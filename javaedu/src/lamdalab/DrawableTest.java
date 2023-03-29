package lamdalab;
/*
구현 클래스명 : 제시된 패키지의 소스들을 수정하고 패키지를 압축하여 제출한다.
                   (소스는 3개)

소스를 보고 람다식으로 변경 가능하다고 판단되는 부분은 변경하여 제출한다. 소스 3개 모두~~~
 */
import java.util.Random;

interface Drawable {
	void draw();
}
public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		Drawable d = null; // 참조하는 객체가 아직 없다.
		if (num == 0)
			d = () -> System.out.println("사각형을 그립니다.");
		else if (num == 1)
			d = () -> System.out.println("원을 그립니다");
		else if (num == 2)
			d = () -> System.out.println("마름모를 그립니다.");
		output(d);
	}
	public static void output(Drawable d) {
		System.out.println("전달된 객체의 클래스명 : " + d.getClass().getName());
		d.draw();
	}
}
