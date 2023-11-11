
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
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("Team {\n")
			.append("\tteamId : ").append(team.getTeamId()).append("\n")
			.append("\tteamName : ").append(team.getTeamName()).append("\n")
			.append("\tdepartment : ").append(team.getDepartment()).append("\n")
			.append("\tcreatro {").append("\n")
			.append("\t\tid : ").append(team.getCreator().getId()).append("\n")
			.append("\t\tgender : ").append(team.getCreator().getGender() ? "女" : "男").append("\n")
			.append("\t}\n").append("\tstudentList{\n");
		
		for(Student s : team.getStudentList()) {
			sb.append("\t\tstudent { \n")
				.append("\t\t\tid : ").append(s.getId()).append("\n")
				.append("\t\t\tname : ").append(s.getName()).append("\n")
				.append("\t\t}\n");
		}
		sb.append("\t}\n");
		sb.append("\tteacherList{\n");
		
		for(Teacher t : team.getTeacherList()) {
			sb.append("\t\tteacher { \n")
				.append("\t\t\tid : ").append(t.getId()).append("\n")
				.append("\t\t\tname : ").append(t.getName()).append("\n")
				.append("\t\t}\n");
		}
		sb.append("\t}\n");
		sb.append("}\n");
		
		return sb.toString();
	}

}
