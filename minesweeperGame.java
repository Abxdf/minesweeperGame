import java.util.*;


class minesweeperGame {
	private int rows;
	private int cols;
	private int mines;
	private char[][] a;
	private int[][] aint;
	private char[][] ques;
	private boolean[][] isopened;
	public  int chances;

	public minesweeperGame(int row, int col, int mine) {
		rows = row;
		cols = col;
		mines = mine;
		a = new char[rows][cols];
		aint = new int[rows][cols];
		ques = new char[rows][cols];
		isopened = new boolean[rows][cols];
		chances=(mines)/2;
		fillZeros();
		fillMines();
		fillTLeft();
		fillTRight();
		fillBRight();
		fillBLeft();
		fillLeft();
		fillCenter();
		fillRight();
		fillTop();
		fillBottom();
		return;

	}

	private void fillZeros() {
		int i, j;
		for (i = 0; i < rows; ++i)
			for (j = 0; j < cols; ++j) {
				a[i][j] = '0';
				aint[i][j] = 0;
				ques[i][j] = '?';
				isopened[i][j] = false;
			}
		return;
	}

	public void fillMines() {
		Random r = new Random();
		int i = 0;
		int count = 0;
		int j = 0;
		while (count < mines) {
			i = r.nextInt(rows);
			j = r.nextInt(cols);

			if (a[i][j] != '*') {
				a[i][j] = '*';
				count++;

			}

		}

		return;
	}

	public void displayasteriks() {
		int i, j;
		for (i = 0; i < rows; ++i) {
			for (j = 0; j < cols; ++j) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		return;
	}

	public void displayques() {
		int i, j;
		for (i = 0; i < rows; ++i) {
			for (j = 0; j < cols; ++j) {
				System.out.print(ques[i][j] + " ");
			}
			System.out.println();
		}
		return;
	}

	public void countMines() {
		int i, j, count = 0;
		for (i = 0; i < rows; ++i)
			for (j = 0; j < cols; ++j)
				if (a[i][j] == '*')
					count++;
		System.out.println("count is " + count);
		return;
	}

	public int mineinabox(char b) {
		if (b == '*')
			return 1;
		else
			return 0;

	}

	public void fillTLeft() {
		aint[0][0] = mineinabox(a[0][1]) + mineinabox(a[1][0])
				+ mineinabox(a[1][1]);
		return;

	}

	public void fillTRight() {
		int k = cols - 1;
		aint[0][k] = mineinabox(a[0][k - 1]) + mineinabox(a[1][k - 1])
				+ mineinabox(a[1][k]);
		return;
	}

	public void fillBLeft() {
		int k = rows - 1;
		aint[k][0] = mineinabox(a[k - 1][0]) + mineinabox(a[k - 1][1])
				+ mineinabox(a[k][1]);
		return;
	}

	public void fillBRight() {
		int k = rows - 1;
		int m = cols - 1;
		aint[k][m] = mineinabox(a[k - 1][m]) + mineinabox(a[k - 1][m - 1])
				+ mineinabox(a[k][m - 1]);

	}

	public void fillBottom() {
		int i, k;
		k = rows - 1;
		for (i = 1; i < cols - 1; ++i) {
			aint[k][i] = mineinabox(a[k - 1][i - 1]) + mineinabox(a[k - 1][i])
					+ mineinabox(a[k - 1][i + 1]) + mineinabox(a[k][i - 1])
					+ mineinabox(a[k][i + 1]);

		}

	}

	public void fillLeft() {
		int i;
		for (i = 1; i < rows - 1; ++i) {
			aint[i][0] = mineinabox(a[i - 1][0]) + mineinabox(a[i - 1][1])
					+ mineinabox(a[i][1]) + mineinabox(a[i + 1][1])
					+ mineinabox(a[i + 1][0]);

		}

	}

	public void fillRight() {
		int k = cols - 1;
		for (int i = 1; i < rows - 1; ++i) {
			aint[i][k] = mineinabox(a[i - 1][k]) + mineinabox(a[i - 1][k - 1])
					+ mineinabox(a[i][k - 1]) + mineinabox(a[i + 1][k])
					+ mineinabox(a[i + 1][k - 1]);

		}

	}

	public void fillTop() {
		int i, k;
		k = 0;
		for (i = 1; i < cols - 1; ++i) {
			aint[k][i] = mineinabox(a[k + 1][i - 1]) + mineinabox(a[k + 1][i])
					+ mineinabox(a[k + 1][i + 1]) + mineinabox(a[k][i - 1])
					+ mineinabox(a[k][i + 1]);

		}

	}

	public void fillCenter() {
		int i, j;
		for (i = 1; i < rows - 1; i++) {
			for (j = 1; j < cols - 1; j++) {
				aint[i][j] = mineinabox(a[i - 1][j - 1])
						+ mineinabox(a[i - 1][j]) + mineinabox(a[i - 1][j + 1])
						+ mineinabox(a[i][j - 1]) + mineinabox(a[i][j + 1])
						+ mineinabox(a[i + 1][j - 1]) + mineinabox(a[i + 1][j])
						+ mineinabox(a[i + 1][j + 1]);

			}
		}

	}

	public void displayint() {
		int i, j;
		for (i = 0; i < rows; ++i) {
			for (j = 0; j < cols; ++j) {
				System.out.print(aint[i][j] + " ");
			}
			System.out.println();
		}
		return;
	}

	public void displayGame() {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (isopened[i][j]) {
					if (mineinabox(a[i][j]) == 0) {
						System.out.print(aint[i][j] + "<-");
						System.out.printf("(%4d,%4d) ",i,j);
					} else {
						System.out.print(aint[i][j] + "<-");
						System.out.printf("(%4d,%4d) ",i,j);
					}

				} else {
					System.out.print(ques[i][j] + "<-");
					System.out.printf("(%3d,%3d) ",i,j);
				}

			}
			System.out.print("\n\n");
		}

	}

	public int open() {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		int j = s.nextInt();
		if (mineinabox(a[i][j]) == 1 ) {
			System.out.println("Game Over :( ");











			System.out.printf("You have %d chances left\n",chances-1);
			return -1;

		} else {
			isopened[i][j] = true;
			return 0;
		}

	}

	public void displaymineinabox() {
		int i, j;
		for (i = 0; i < rows; i++) {
			for (j = 0; j < cols; j++)
				System.out.print(mineinabox(a[i][j]) + " ");

			System.out.println();
		}

	}

	public void destroy() {
		displayasteriks();

	}
}

