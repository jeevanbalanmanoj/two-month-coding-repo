package backtracking;

import java.util.Stack;

class Point {
	public int row;
	public int col;
	public Point(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	@Override
	public String toString() {
		return "Point [row=" + row + ", col=" + col + "]";
	}
	
	
}

public class Maze {
	
	
	private static int[][] maze = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
	private static int nextRows[] = new int[] { 1, 0 };
	private static int nextCols[] = new int[] { 0, 1 };
	private static Stack<Point> path = new Stack<>();
	private static boolean isSafe(int row, int col) {
		return (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 1);
	}

	private static boolean getPath() {
		return getPath(0, 0);
	}

	private static boolean getPath(int row, int col) {
		if ((row == maze.length - 1) && col == maze[0].length - 1)
			return true;
		for (int i = 0; i < nextRows.length; i++) {
			if (isSafe(row + nextRows[i], col + nextCols[i])) {
				if (getPath(row + nextRows[i], col + nextCols[i])) {
					path.push(new Point(row + nextRows[i], col + nextCols[i]));
					return true;
					
				}
			}
		}
		return false;
	}
	public static void main(String args[]) {
		if(getPath()) {
			path.forEach(System.out::println);
		}
		
	}

}
