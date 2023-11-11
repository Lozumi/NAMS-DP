/**
 * HTML Team Formatter
 * @author Lozumi
 * @version 1.0
 *
 * Generate string including tm info by HTML.
 */
public class HTMLTeamFormatter implements TeamFormatter{
    private static HTMLTeamFormatter singletonInstance;

    private HTMLTeamFormatter(){}

    public static synchronized HTMLTeamFormatter getSingletonInstance()
    {
        if(singletonInstance == null)
        {
            singletonInstance = new HTMLTeamFormatter();
        }
        return singletonInstance;
    }
    @Override
    public String formatTeam(Team tm) {
        Student creator = tm.getCreator();
        StringBuilder sb = new StringBuilder();

        // HTML Header
        sb.append("<html>\n\t<body>\n\t\t<center><h2>Team Information</h2><center>\n\t\t");

        // Team Information
        sb.append(String.format("%s %s %s<br>\n\t\tcreator[%s %s %s %s %s %s %s]<br>\n\t\t",
                tm.getTeamId(), tm.getTeamName(), tm.getDepartment(),
                creator.getId(), creator.getName(), creator.getPhoneNo(),
                creator.getEmail(), creator.getStudentNo(),
                creator.getGender() ? "女" : "男", creator.getGrade(), creator.getDepartment()));

        // StudentList
        sb.append("\t\t<h3>StudentList</h3>\n\t\t<blockquote>\n");
        for (Student s : tm.getStudentList()) {
            sb.append(String.format("\t\t\t%s %s %s %s %s %s %s %s<br>\n",
                    s.getId(), s.getName(), s.getPhoneNo(),
                    s.getEmail(), s.getStudentNo(),
                    s.getGender() ? "女" : "男", s.getGrade(), s.getDepartment()));
        }
        sb.append("\t\t</blockquote>\n\t\t<h3>TeacherList</h3>\n\t\t<blockquote>\n");

        // TeacherList
        for (Teacher t : tm.getTeacherList()) {
            sb.append(String.format("\t\t\t%s %s %s %s %s %s<br>\n",
                    t.getId(), t.getName(), t.getPhoneNo(),
                    t.getEmail(), t.getTeacherNo(), t.getDepartment()));
        }

        // HTML Footer
        sb.append("\t\t</blockquote>\n\t</body>\n</html>\n");

        return sb.toString();
    }

}
