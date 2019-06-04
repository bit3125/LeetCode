package leetcode.solutions;

public class Q925LongPressedName {

	public boolean isLongPressedName(String name, String typed) {
		if (name == null || typed == null)
			return false;
		if (name.length() > typed.length())
			return false;

		int idxN = 0, idxT = 0;
		while (idxT < typed.length()) {// ***bug:
			if (idxN < name.length() && name.charAt(idxN) == typed.charAt(idxT)) {//***bug:if (idxT < typed.length() &&
			} else if (idxN >= 1 && name.charAt(idxN - 1) == typed.charAt(idxT)) {
				idxN--;
			} else
				break;
			idxN++;
			idxT++;
		}

		return idxN == name.length();
	}

	public static void main(String[] args) {

		Q925LongPressedName q = new Q925LongPressedName();
		String name = "vtkgn";
		String typed = "vttkgnn";
		System.out.println(q.isLongPressedName(name, typed));
	}

}
