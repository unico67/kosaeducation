package day12;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof Value)
			if (value == ((Value) obj).value)
				result = true;
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "Value [value=" + value + "]";
	}
}

public class EqualsTest3 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		Value v3 = new Value(20);
		System.out.println(v1.equals(null)); // f
		System.out.println(v1.equals(v3)); // f
		System.out.println(v1.equals(v2)); // t
		System.out.println(v1.equals(new Date())); // f

		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		System.out.println(v3.hashCode());
		// HashSet 객체에 v1, v2, v3 를 저장한 후에
		// 저장된 객체들을 출력해 본다.
		HashSet<Value> set = new HashSet<>();
		set.add(v1);
		set.add(v2);
		set.add(v3);

		System.out.println(set);

		for (Value data : set)
			System.out.println(data);

		/*
		 * if (v1.equals(v2)) System.out.println("v1과 v2는 같습니다."); else
		 * System.out.println("v1과 v2는 다릅니다."); v2 = v1; if (v1.equals(v2))
		 * System.out.println("v1과 v2는 같습니다."); else
		 * System.out.println("v1과 v2는 다릅니다.");
		 */
	}
}
