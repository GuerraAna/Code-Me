package com.codeme.cmp.portfolio

data class Skill(val name: String, val level: Float)

data class Project(val name: String, val year: String, val description: String)

data class SocialLink(val label: String, val url: String)

data class Job(val year: String, val company: String, val role: String, val active: Boolean)

object PortfolioData {
    const val NAME = "Ana Clara Guerra"
    const val INITIALS = "AG"
    const val ROLE = "Engenheira de Software"
    const val LOCATION = "São Paulo, Brasil"
    const val EMAIL = "seu@email.com"
    const val BASE = "São Paulo, SP"
    const val FOCUS = "Android & Kotlin"
    const val AVAILABILITY = "Engenheira de Software no Itaú Unibanco"
    const val BIO =
        "Desde criança, sou apaixonada por tecnologia e design. Em 2021 iniciei minha história na " +
            "tecnologia e, desde então, venho me aprimorando em arquitetura, boas práticas e desenvolvimento " +
            "Android, atuando em soluções bancárias e compartilhando conhecimento em artigos, lives e vídeos."

    val navItems = listOf("Sobre", "Habilidades", "Prêmios", "Experiência")

    val stats = listOf(
        "5+" to "Anos de experiência",
        "31" to "Certificações",
        "5" to "Reconhecimentos",
    )

    val skills = listOf(
        Skill("Android", 0.92f),
        Skill("Kotlin", 0.92f),
        Skill("Java", 0.85f),
        Skill("Arquitetura & Boas práticas", 0.85f),
        Skill("Observabilidade & AWS", 0.75f),
        Skill("Comunicação & Conteúdo", 0.88f),
    )

    val projects = listOf(
        Project(
            "1º lugar no Hackathon Itaú BUPJ",
            "2026",
            "Automação do fluxo de desenvolvimento com IA (SDD, MCP, Skills, Devin e Copilot) para reduzir o awaiting time.",
        ),
        Project(
            "1º lugar no Hackathon Itaú 2021",
            "2021",
            "Protótipo de aplicativo desenvolvido em 8 horas para resolver a problemática proposta pelo Itaú.",
        ),
        Project(
            "2º lugar no DIO Awards 2021",
            "2021",
            "Desenvolvedora mais influente da plataforma, por artigos e mentorias para a comunidade.",
        ),
    )

    val jobs = listOf(
        Job("2025", "Itaú Unibanco", "Engenheira de Software", active = true),
        Job("2024", "Mercado Livre", "Engenheira de Software", active = false),
        Job("2021", "NTT DATA Europe & LATAM", "Android Developer · cliente Itaú (PIX, TED/TEF, Open Finance)", active = false),
        Job("2021", "Universidade Anhembi Morumbi", "Análise e Desenvolvimento de Sistemas", active = false),
    )

    val socialLinks = listOf(
        SocialLink("LinkedIn", "https://www.linkedin.com/in/ana-clara-guerra/"),
        SocialLink("GitHub", "https://github.com/GuerraAna"),
        SocialLink("YouTube", "https://www.youtube.com/@AnaGuerra-is6nr"),
    )
}
