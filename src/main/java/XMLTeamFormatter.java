/**
 * XML Team Formatter
 * @author Lozumi
 * @version 1.0
 *
 * Generate string including team info by XML.
 */
public class XMLTeamFormatter implements TeamFormatter{
    private static XMLTeamFormatter singletonInstance;

    private XMLTeamFormatter(){}

    public static synchronized XMLTeamFormatter getSingletonInstance()
    {
        if(singletonInstance == null)
        {
            singletonInstance = new XMLTeamFormatter();
        }
        return singletonInstance;
    }

    @Override
    public String formatTeam(Team team) {
        Student creator = team.getCreator();
        StringBuilder sb = new StringBuilder();

        // Team information
        sb.append(String.format("<Team teamId=\"%s\" teamName=\"%s\" department=\"%s\">\n",
                team.getTeamId(), team.getTeamName(), team.getDepartment()));

        // Creator information
        sb.append(String.format("\t<Creator id=\"%s\" name=\"%s\" phoneNo=\"%s\" email=\"%s\" studentNo=\"%s\" gender=\"%s\" grade=\"%s\" department=\"%s\"/>\n",
                creator.getId(), creator.getName(), creator.getPhoneNo(), creator.getEmail(),
                creator.getStudentNo(), creator.getGender() ? "女" : "男", creator.getGrade(), creator.getDepartment()));

        // StudentList
        sb.append("\t<StudentList>\n");
        for (Student student : team.getStudentList()) {
            sb.append(String.format("\t\t<Student id=\"%s\" name=\"%s\" phoneNo=\"%s\" email=\"%s\" studentNo=\"%s\" gender=\"%s\" grade=\"%s\" department=\"%s\"/>\n",
                    student.getId(), student.getName(), student.getPhoneNo(), student.getEmail(),
                    student.getStudentNo(), student.getGender() ? "女" : "男", student.getGrade(), student.getDepartment()));
        }
        sb.append("\t</StudentList>\n");

        // TeacherList
        sb.append("\t<TeacherList>\n");
        for (Teacher teacher : team.getTeacherList()) {
            sb.append(String.format("\t\t<Teacher id=\"%s\" name=\"%s\" phoneNo=\"%s\" email=\"%s\" teacherNo=\"%s\" department=\"%s\"/>\n",
                    teacher.getId(), teacher.getName(), teacher.getPhoneNo(), teacher.getEmail(),
                    teacher.getTeacherNo(), teacher.getDepartment()));
        }
        sb.append("\t</TeacherList>\n");

        // Closing Team tag
        sb.append("</Team>\n");

        return sb.toString();
    }
}
