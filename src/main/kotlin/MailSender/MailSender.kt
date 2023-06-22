package MailSender

interface MailSender {
    fun sendMail(mail: Mail)

    fun sendFlete(flete: Flete)
}

data class Mail(
    val from: String,
    val to: String,
    val subject: String,
    val content: String
)

data class Flete(
    val direccion: String,
    val nombre: String,
    val dni: String,
    val codigo: String
)