package com.codeme.cmp.portfolio

data class Skill(val name: String, val level: Float)

data class Project(val name: String, val year: String, val description: String)

data class Job(val year: String, val company: String, val role: String, val active: Boolean)

object PortfolioData {
    const val NAME = "Ana Clara Guerra"
    const val INITIALS = "AG"
    const val ROLE = "Engenheira de Software"
    const val LOCATION = "Brasil"
    const val EMAIL = "seu@email.com"
    const val BASE = "Itaú Unibanco"
    const val FOCUS = "Android & Kotlin"
    const val AVAILABILITY = "Engenheira de Software no Itaú Unibanco"
    const val BIO =
        "Desde criança, sou apaixonada por tecnologia e design. Em 2021 iniciei a jornada em " +
            "Análise e Desenvolvimento de Sistemas e, desde então, venho me aprimorando em arquitetura, " +
            "boas práticas e desenvolvimento Android, compartilhando conhecimento em artigos, lives e vídeos " +
            "no Discord, YouTube e DIO."

    val navItems = listOf("Sobre", "Habilidades", "Projetos", "Trabalhos")

    val stats = listOf(
        "2021" to "Início na tecnologia",
        "5+" to "Certificações",
        "3" to "Plataformas de conteúdo",
    )

    val skills = listOf(
        Skill("Android", 0.90f),
        Skill("Kotlin", 0.90f),
        Skill("Arquitetura & Boas práticas", 0.85f),
        Skill("Testes", 0.80f),
        Skill("AWS", 0.70f),
        Skill("Comunicação & Conteúdo", 0.88f),
    )

    val projects = listOf(
        Project("Segurança na nuvem com AWS", "DIO", "Certificado de conclusão do bootcamp de segurança na nuvem."),
        Project("Monitoramento e análise na AWS", "DIO", "Certificado de monitoramento e análise de workloads na AWS."),
        Project("Code-Me", "2026", "App multiplataforma (Android, iOS e Web) com Compose Multiplatform."),
    )

    val jobs = listOf(
        Job("Atual", "Itaú Unibanco", "Engenheira de Software", active = true),
        Job("2021", "DIO / Alura / Udemy", "Criadora de conteúdo e estudante", active = false),
        Job("2021", "Análise e Desenvolvimento de Sistemas", "Graduação", active = false),
    )

    val socialLinks = listOf("LinkedIn", "GitHub", "YouTube")
}
