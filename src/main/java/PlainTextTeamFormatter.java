/**
 * Plain Text Team Formatter
 * @author Lozumi
 * @version 1.0
 *
 * Generate string including team info by plain text.
 */
public class PlainTextTeamFormatter implements TeamFormatter {
	private static PlainTextTeamFormatter singletonInstance;

	private PlainTextTeamFormatter() {}

	public static synchronized PlainTextTeamFormatter getSingletonInstance() {
		if(singletonInstance == null) {
			singletonInstance = new PlainTextTeamFormatter();
		}
		return singletonInstance;
	}

	@Override
	public String formatTeam(Team team) {
		StringBuilder sb = new StringBuilder();
		sb.append("Team {\n")
				.append(String.format("\tteamId : %s\n", team.getTeamId()))
				.append(String.format("\tteamName : %s\n", team.getTeamName()))
				.append(String.format("\tdepartment : %s\n", team.getDepartment()))
				.append("\tcreator {\n")
				.append(String.format("\t\tid : %s\n", team.getCreator().getId()))
				.append(String.format("\t\tgender : %s\n", team.getCreator().getGender() ? "女" : "男"))
				.append("\t}\n\tstudentList {\n");

		for (Student s : team.getStudentList()) {
			sb.append("\t\tstudent { \n")
					.append(String.format("\t\t\tid : %s\n", s.getId()))
					.append(String.format("\t\t\tname : %s\n", s.getName()))
					.append("\t\t}\n");
		}
		sb.append("\t}\n\tteacherList {\n");

		for (Teacher t : team.getTeacherList()) {
			sb.append("\t\tteacher { \n")
					.append(String.format("\t\t\tid : %s\n", t.getId()))
					.append(String.format("\t\t\tname : %s\n", t.getName()))
					.append("\t\t}\n");
		}
		sb.append("\t}\n}\n");

		return sb.toString();
	}


}
