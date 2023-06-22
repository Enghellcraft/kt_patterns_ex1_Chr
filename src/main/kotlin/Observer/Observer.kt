package Observer

import MailSender.Flete
import MailSender.Mail
import MailSender.MailSender
import Regalo.Regalo
import Usuarios.Persona

interface ObserverAccion {
    fun notificar(persona: Persona, regalo: Regalo)
}

class ObserverMailSender(var mailSender: MailSender): ObserverAccion{
    override fun notificar(persona: Persona, regalo: Regalo) {
        val mailOrigen: String = "anonimo@polonorte.com"
        mailSender.sendMail(
            Mail(
                from = mailOrigen,
                to = "${persona.direEmail}",
                subject = "Regalo",
                content = "${regalo.nombreRegalo}"
            )
        )
    }
}

class ObserverFletes(var mailSender: MailSender): ObserverAccion{
    override fun notificar(persona: Persona, regalo: Regalo) {
        mailSender.sendFlete(
            Flete(
                direccion = "${persona.direccion}",
                nombre = "${persona.nombre}",
                dni = "${persona.dni}",
                codigo = "${regalo.regaloId}"
            )
        )
    }
}


class ObserverModificarMonto(var mailSender: MailSender): ObserverAccion {
    override fun notificar(persona: Persona, regalo: Regalo) {
        val mailOrigen: String = "anonimo@polonorte.com"
        if(regalo.precio > 10000.0) {
            mailSender.sendMail(
                Mail(
                    from = mailOrigen,
                    to = "${persona.direEmail}",
                    subject = "Modificar monto",
                    content = "Porfis modificá el monto a 5000, ty"
                )
            )
        }
    }
}
