import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 用户子系统类
 *
 * <p>该类实现了一个简单的用户子系统，用于使用不同格式展示团队信息。
 *
 * @author ChenJing, Lozumi
 * @version 1.1
 */
public class UserSubSystem {
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);
	private Team team;

	private TeamFormatter teamFormatter;

	/**
	 * 初始化成员变量 team
	 */
	private UserSubSystem() {
		loadTeam();
	}

	/**
	 * 启动应用程序
	 *
	 * @param args 操作系统进程启动参数
	 * @throws IOException 不支持 IO 操作时抛出该异常
	 */
	public static void main(String[] args) throws IOException {
		UserSubSystem userSubSystem = new UserSubSystem();
		userSubSystem.run();
	}

	/**
	 * 向用户展示一个选项菜单，并执行用户选择的任务
	 *
	 * @throws IOException 不支持 IO 操作时抛出该异常
	 */
	private void run() throws IOException {
		while (true) {
			try {
				int userChoice = getChoice();
				switch (userChoice) {
					case 0:
						stdErr.println("感谢使用！");
						return;
					case 1:
						setTeamFormatter(PlainTextTeamFormatter.getSingletonInstance());
						break;
					case 2:
						setTeamFormatter(HTMLTeamFormatter.getSingletonInstance());
						break;
					case 3:
						setTeamFormatter(XMLTeamFormatter.getSingletonInstance());
						break;
					default:
						stdErr.println(userChoice + " 是无效的操作代码。");
						break;
				}
				displayTeam();
				Thread.sleep(400); // println 方法是异步的，因此选项菜单可能在团队信息完全显示之前显示。简单休眠一小段时间以避免这种情况。
			} catch (IOException exception) {
				stdErr.println("异常: " + exception.getMessage());
			} catch (InterruptedException interruptedException) {
				stdErr.println("操作被中断。");
			}
		}
	}

	/**
	 * 通过更新 formatter 参数指定的对象来更改当前 formatter
	 *
	 * @param formatter 用于格式化团队字符串的指定 formatter
	 */
	private void setTeamFormatter(TeamFormatter formatter) {
		teamFormatter = formatter;
	}

	/**
	 * 显示选项菜单并验证用户的选择
	 *
	 * @return 用户输入的选项代码
	 * @throws IOException 不支持 IO 操作时抛出该异常
	 */
	private int getChoice() throws IOException {
		int userChoice;
		do {
			try {
				stdErr.println();
				stdErr.print("""
                        [0] 退出
                        [1] 显示团队 (纯文本)
                        [2] 显示团队 (HTML)
                        [3] 显示团队 (XML)
                        请选择>\s""");
				stdErr.flush();

				userChoice = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= userChoice && 3 >= userChoice) {
					break;
				} else {
					stdErr.println("无效的选择:  " + userChoice);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return userChoice;
	}

	/**
	 * 初始化 team 对象
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
	 * 使用 teamFormatter.formatTeam() 方法在标准输出中显示团队信息
	 */
	private void displayTeam() {
		stdOut.println(teamFormatter.formatTeam(team));
	}
}