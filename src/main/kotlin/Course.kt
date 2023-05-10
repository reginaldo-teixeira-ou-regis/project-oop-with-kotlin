import java.time.LocalDate

enum class Level { BASIC, INTERMEDIARY, ADVANCED }

class User(val name: String) {
  val enrolledCourses = mutableListOf<Course>()
}

data class TechContent(
  val name: String,
  val durationInMinutes: Int = 60,
  val description: String
)

class Course(
  val name: String,
  private val level: Level,
  private val contents: List<TechContent>,
  private val startDate: LocalDate,
  private val endDate: LocalDate,
  private val instructor: Instructor
) {
  private val enrolledUsers = mutableListOf<User>()

  fun addEnrolledUser(user: User) {
    enrolledUsers.add(user)
    println("\n${user.name} se matriculou no curso $name.")
  }

  fun removeEnrolledUser(user: User) {
    enrolledUsers.remove(user)
    println("${user.name} cancelou a matrícula no curso $name.")
  }

  private fun getTotalDuration(): Int {
    return contents.sumOf { it.durationInMinutes }
  }

  fun printEnrolledUsers() {
    println(
      "Usuarios inscritos no curso $name: ${
        enrolledUsers.joinToString(", ") {
          "\n - ${it.name}"
        }
      }"
    )
  }

  fun printLevel() {
    println("\nNivel de dificuldade do curso: $level")
  }

  fun printDuration() {
    println("\nDuração total do curso $name: ${getTotalDuration()} horas")
  }

  fun printDescription() {
    println(
      "\nConteudos inclusos no curso $name: ${
        contents.joinToString(" ") {
          "\n - ${it.name}: " +
          "\n   - Duração: ${it.durationInMinutes} horas" + 
          "\n   - Descrição: ${it.description}"
        }
      }"
    )
    println(
      "\nData inicial: $startDate" +
      "\nData final: $endDate"
    )
    println(
      "\nInformações do instrutor do curso $name: " +
      "\n${instructor.toString()}"
    )
  }

  fun isEnrolled(user: User): Boolean {
    return enrolledUsers.contains(user)
  }

  fun enroll(user: User) {
    enrolledUsers.add(user)
    user.enrolledCourses.add(this)
  }

  fun unenroll(user: User) {
    enrolledUsers.remove(user)
    user.enrolledCourses.remove(this)
  }
}

class Instructor(
  private val name: String,
  private val email: String
) {
  override fun toString(): String {
    return "nome: $name\ne-mail: $email"
  }
}
