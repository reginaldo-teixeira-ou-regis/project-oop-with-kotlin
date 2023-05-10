import java.util.Locale

fun cancelEnrollment(user: User) {
    var unenrollCourse: Course? = null
    while (true) {
        print("\nDeseja cancelar a matrícula em algum curso? (S/N): ")
        val answer = readln().uppercase(Locale.getDefault())
        if (answer == "N") {
            break
        } else if (answer != "S") {
            println("\nResposta inválida, por favor responda S ou N.")
            continue
        }

        println("\nCursos em que você está inscrito:")
        user.enrolledCourses.forEachIndexed { index, course ->
            println("${index + 1} - ${course.name}")
        }

        print("\nEscolha o número do curso que deseja cancelar a matrícula ou digite 0 para sair: ")
        val courseNumber = readln().toIntOrNull() ?: 0
        if (courseNumber == 0) {
            break
        }
        unenrollCourse = user.enrolledCourses.getOrNull(courseNumber - 1)
        if (unenrollCourse == null) {
            println("\nCurso inválido, por favor escolha um número válido.")
        } else {
            unenrollCourse.unenroll(user)
            println("\nMatrícula cancelada no curso ${unenrollCourse.name}.")
        }
    }
}
