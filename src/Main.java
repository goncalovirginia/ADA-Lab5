import dataStructures.DiGraph;
import dataStructures.LinkedDiGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] tpl = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		DiGraph tasks = new LinkedDiGraph(tpl[0]);
		
		for (int i = 0; i < tpl[1]; i++) {
			int[] precedence = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			tasks.addEdge(precedence[0], precedence[1]);
		}
		
		int[] solution = solve(tasks, tpl[2]);
		System.out.printf("%d %d\n", solution[0], solution[1]);
	}
	
	private static int[] solve(DiGraph tasks, int limit) {
		int maxTasksInAWeek = 0, hardWeeks = 0;
		int[] tasksPerWeek = tasksPerDepth(tasks);
		
		for (int numTasks : tasksPerWeek) {
			if (numTasks > maxTasksInAWeek) {
				maxTasksInAWeek = numTasks;
			}
			if (numTasks > limit) {
				hardWeeks++;
			}
		}
		
		return new int[] {maxTasksInAWeek, hardWeeks};
	}
	
	private static int[] tasksPerDepth(DiGraph tasks) {
		int[] tasksPerDepth = new int[tasks.numNodes()], taskDepth = new int[tasks.numNodes()];
		
		for (int task : tasks.nodes()) {
			if (tasks.inDegree(task) == 0) {
				tasksPerDepth[0]++;
				for (int successor : tasks.outAdjacentNodes(task)) {
					setDepth(tasks, successor, tasksPerDepth, taskDepth, 1);
				}
			}
		}
		
		return tasksPerDepth;
	}
	
	private static void setDepth(DiGraph employees, int root, int[] employeesPerDepth, int[] employeeDepth, int currentDepth) {
		if (currentDepth <= employeeDepth[root]) {
			return;
		}
		if (employeeDepth[root] > 0) {
			employeesPerDepth[employeeDepth[root]]--;
		}
		
		employeeDepth[root] = currentDepth;
		employeesPerDepth[currentDepth]++;
		
		for (int successor : employees.outAdjacentNodes(root)) {
			setDepth(employees, successor, employeesPerDepth, employeeDepth, currentDepth + 1);
		}
	}
	
}
