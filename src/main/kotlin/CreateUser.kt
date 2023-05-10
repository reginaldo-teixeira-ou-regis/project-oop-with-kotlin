fun createUser(userNumber: Int): User {
    val regex = Regex("^[a-zA-Z]{3,}(\\s[a-zA-Z]{3,})+\$")
    var user: User? = null

    do {
        print("\nDigite o nome do usuário $userNumber: ")
        val name = readlnOrNull() ?: ""
        if (regex.matches(name)) {
            user = User(name)
        } else {
            println("\nPor favor, insira o nome no formato correto: (Ex: Lucas Oliveira)")
        }
    } while (user == null)

    return user
}