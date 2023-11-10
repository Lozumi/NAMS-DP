import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 用户子系统类
 *
 * @author "ChenJing"
 * @version 1.0
 *
 */
public class UserSubSystem {
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private Team team;

	private TeamFormatter teamFormatter;

	/**
	 * Initialize instance variable team
	 */
	private UserSubSystem() {
		loadTeam();
	}

	/**
	 * Starts the application
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		UserSubSystem userSubSystem = new UserSubSystem();
		userSubSystem.run();
	}

	/**
	 * Present the user with a menu of options and execute the selected task
	 *
	 * @throws IOException
	 */
	private void run() throws IOException {
		// TODO:
	}

	/**
	 * Change the current formatter by updating the instance variable teamFormatter
	 * with the object specified in the parameter formatter
	 *
	 * @param formatter
	 */
	private void setTeamFormatter(TeamFormatter formatter) {
		// TODO:
	}

	/**
	 * Display a menu of options and verifies the user's choice
	 *
	 * @return
	 * @throws IOException
	 */
	private int getChoice() throws IOException {
		int input;
		do {
			try {
				stdErr.println();
				stdErr.print("[0] Quit\n" + "[1] Display team (Plain Text)\n" + "[2] Display team (HTML)\n"
						+ "[3] Display team (XML)\n" + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 3 >= input) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	/**
	 * Initialize the team object
	 */
	private void loadTeam() {
		Student creator = new Student("stu_01", "小明", "13025631489", "425@nwpu.deu.cn", "2020136924", false, "大二",
				"软件学院");
		team = new Team("team_01", "蒙的都队", "软件学院", creator);
		team.addStudent(new Student("stu_02", "小红", "13139149932", "22152@qq.com", "2021223112", true, "大二", "软件学院"));
		team.addStudent(
				new Student("stu_03", "小张", "19623145264", "22362@163.com", "2021996996", false, "大一", "计算机学院"));
		team.addTeacher(new Teacher("tea_01", "肖老师", "15304114352", "xiao@nwpu.edu.cn", "01342", "软件学院"));
	}

	/**
	 * Display the team information in the standard output using the method
	 * teamFormatter.formatTeam() to obtain the team information in the current
	 * format
	 */
	private void displayTeam() {
		// TODO:
	}

}
