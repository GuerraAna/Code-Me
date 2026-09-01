package com.codeme.cmp.portfolio

data class Skill(val name: String, val level: Float)

data class Project(val name: String, val year: String, val description: String)

data class Job(val year: String, val company: String, val role: String, val active: Boolean)

object PortfolioData {
    const val NAME = "Ravi Vex"
    const val INITIALS = "RV"
    const val ROLE = "Product Designer"
    const val LOCATION = "Lisboa, Portugal"
    const val EMAIL = "ravi@vex.design"
    const val BASE = "Lisboa, PT"
    const val FOCUS = "Produto & UI"
    const val BIO =
        "Designer de produto em Lisboa, criando interfaces digitais com clareza e intenção. " +
            "Foco em sistemas de design, prototipagem e colaboração com times de engenharia."

    val navItems = listOf("Sobre", "Habilidades", "Projetos", "Trabalhos")

    val stats = listOf(
        "6+" to "Anos de experiência",
        "48" to "Projetos entregues",
        "12" to "Prêmios",
    )

    val skills = listOf(
        Skill("Design de Produto", 0.95f),
        Skill("Prototipagem", 0.90f),
        Skill("UI / Figma", 0.88f),
        Skill("Motion Design", 0.82f),
        Skill("Front-end (React)", 0.74f),
        Skill("Pesquisa UX", 0.85f),
    )

    val projects = listOf(
        Project("Nimbus Bank", "2024", "Redesign de conta digital com foco em acessibilidade."),
        Project("Voyage OS", "2024", "Sistema de design para plataforma de viagens."),
        Project("Pulse Metrics", "2023", "Painel de analytics em tempo real para SaaS B2B."),
    )

    val jobs = listOf(
        Job("2024", "Lumen Studio", "Lead Product Designer", active = true),
        Job("2022", "Orbit Labs", "Senior UI Designer", active = false),
        Job("2019", "Kite Agency", "UI Designer", active = false),
    )

    val socialLinks = listOf("LinkedIn", "Dribbble", "GitHub")
}
