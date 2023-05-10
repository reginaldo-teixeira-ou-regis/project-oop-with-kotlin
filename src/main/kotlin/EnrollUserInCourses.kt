import java.util.Locale

fun enrollUserInCourses(user: User, courses: List<Course>): List<Course> {
  val enrolledCourses = mutableListOf<Course>()
  var answer: String = ""
  do {
    println("\nCursos disponíveis:")
    courses.forEachIndexed { index, course ->
      println("${index + 1} - ${course.name}")
    }

    var selectedCourse: Course? = null
    do {
      print("\nEscolha o número do curso que deseja se inscrever ou digite 0 para sair: ")
      val courseNumber = readlnOrNull()?.toIntOrNull() ?: 0
      if (courseNumber == 0) {
        break
      }
      selectedCourse = courses.getOrNull(courseNumber - 1)
      if (selectedCourse == null) {
        println("\nCurso inválido, por favor escolha um número válido.")
      } else if (selectedCourse.isEnrolled(user)) {
        println("\nVocê está inscrito neste curso.")
        selectedCourse = null
      }
    } while (selectedCourse == null)

    if (selectedCourse != null) {
      selectedCourse.enroll(user)
      enrolledCourses.add(selectedCourse)
      println("\n${user.name} já está inscrito no curso ${selectedCourse.name}.")
    }

    var validAnswer = false
    while (!validAnswer) {
      print("\nDeseja se inscrever em outro curso? (S/N): ")
      answer = readln().uppercase(Locale.getDefault())
      if (answer == "S" || answer == "N") {
        validAnswer = true
      } else {
        println("\nResposta inválida, por favor responda S ou N.")
      }
    }
  } while (answer == "S")

  if (enrolledCourses.isNotEmpty()) {
    println("\nCursos em que você está inscrito:")
    enrolledCourses.forEach { course ->
      println("- ${course.name}")
    }
  } else {
    println("\nVocê não está inscrito em nenhum curso.")
  }
  return enrolledCourses
}
