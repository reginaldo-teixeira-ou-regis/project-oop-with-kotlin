import java.time.LocalDate

fun main() {
  val content1 = TechContent(
    "Formação Unity 3D Game Developer",
    90,
    "Desenvolva Jogos com Unity, uma ferramenta excepcional e " +
            "mundialmente conhecida quando o assunto é criar jogos."
  )
  val content2 = TechContent(
    "Orbi Web Games Developer",
    63,
    "O bootcamp Orbi Web Games Developer é um programa gratuito " +
            "para quem deseja iniciar a carreira em desenvolvimento de games, " +
            "uma das areas da tecnologia que mais cresce em todo o mundo."
  )
  val content3 = TechContent("Bootcamp TQI Kotlin - Backend Developer",
    112,
    "O Bootcamp TQI Kotlin - Backend Developer é um programa gratuito" +
            " para formação de profissionais que estão iniciando sua carreira e " +
            "buscam mais conhecimento técnico em desenvolvimento back-end."
  )
  val content4 = TechContent("Formação Construct 3 Game Developer",
    50,
    "Desenvolva Jogos com Construct, uma ferramenta excepcional " +
            "para desenvolver jogos, principalmente em 2D."
  )

  val startDate = LocalDate.of(2023, 5, 15)
  val endDate = LocalDate.of(2023, 6, 30)

  val instructor1 = Instructor("Lucas Gomes", "lucas.gomes@dio.me")
  val instructor2 = Instructor("Danilo Souza", "danilo.souza@dio.me")

  val course1 = Course(
    "Desenvolvimento de Motores Para Jogos",
    Level.BASIC,
    listOf(content1, content4),
    startDate,
    endDate,
    instructor1
  )

  val course2 = Course(
    "Desenvolvimento Kotlin",
    Level.INTERMEDIARY,
    listOf(content3),
    startDate,
    endDate,
    instructor2
  )

  val course3 = Course(
    "Desenvolvimento de Jogos Advanced",
    Level.ADVANCED,
    listOf(content1, content2, content4),
    startDate,
    endDate,
    instructor1
  )

  val regex = Regex("^[a-zA-Z]{3,}(\\s[a-zA-Z]{3,})+\$")

  var user1: User? = null
  var user2: User? = null
  var user3: User? = null

  val courses = listOf(course1, course2, course3)

  fun runUserProgram(userNumber: Int, courses: List<Course>) {
    val user = createUser(userNumber)
    enrollUserInCourses(user, courses)
    cancelEnrollment(user)
  }

  runUserProgram(1, courses)
  runUserProgram(2, courses)
  runUserProgram(3, courses)

  fun printCourseInfo(course: Course) {
    course.printEnrolledUsers()
    course.printLevel()
    course.printDuration()
    course.printDescription()
  }

  println("\n---------\n")
  printCourseInfo(course1)
  println("\n---------\n")
  printCourseInfo(course2)
  println("\n---------\n")
  printCourseInfo(course3)
}
