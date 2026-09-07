package com.codeme.cmp.portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codeme.composeapp.generated.resources.Res
import codeme.composeapp.generated.resources.eu_linkedin
import org.jetbrains.compose.resources.painterResource

private val CardShape = RoundedCornerShape(16.dp)
private val PillShape = RoundedCornerShape(50)
private val MaxContentWidth = 960.dp

@Composable
fun PortfolioScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PortfolioColors.Background)
            .background(
                Brush.radialGradient(
                    colors = listOf(PortfolioColors.BackgroundGlow, Color.Transparent),
                    center = Offset(0f, 0f),
                    radius = 900f,
                ),
            ),
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
        ) {
            val compact = maxWidth < 720.dp
            Column(
                modifier = Modifier
                    .widthIn(max = MaxContentWidth)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
            ) {
                Header(compact)
                Spacer(Modifier.height(48.dp))
                Hero(compact)
                Spacer(Modifier.height(64.dp))
                SectionTitle("Habilidades", "01")
                SkillsGrid(columns = if (compact) 1 else 3)
                Spacer(Modifier.height(56.dp))
                SectionTitle("Reconhecimentos e prêmios", "02")
                ProjectsGrid(columns = if (compact) 1 else 3)
                Spacer(Modifier.height(56.dp))
                SectionTitle("Experiência e formação", "03")
                JobsList()
                Spacer(Modifier.height(40.dp))
                Footer(compact)
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun Header(compact: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(PortfolioColors.ChipBackground, CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Text(PortfolioData.INITIALS, color = PortfolioColors.TextPrimary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(10.dp))
            Text(PortfolioData.NAME, color = PortfolioColors.TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        }
        Spacer(Modifier.weight(1f))
        if (!compact) {
            Row(horizontalArrangement = Arrangement.spacedBy(28.dp)) {
                PortfolioData.navItems.forEach { item ->
                    Text(item, color = PortfolioColors.TextSecondary, fontSize = 14.sp)
                }
            }
            Spacer(Modifier.weight(1f))
        }
        Pill(text = "Contato", background = PortfolioColors.ChipBackground)
    }
}

@Composable
private fun Hero(compact: Boolean) {
    if (compact) {
        Column {
            HeroIntro()
            Spacer(Modifier.height(32.dp))
            ContactCard(Modifier.fillMaxWidth())
        }
    } else {
        Row(verticalAlignment = Alignment.Top) {
            Column(Modifier.weight(1.2f)) { HeroIntro() }
            Spacer(Modifier.width(48.dp))
            ContactCard(Modifier.weight(0.8f))
        }
    }
}

@Composable
private fun HeroIntro() {
    Row(
        modifier = Modifier
            .background(PortfolioColors.ChipBackground, PillShape)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(Modifier.size(8.dp).background(PortfolioColors.Success, CircleShape))
        Spacer(Modifier.width(8.dp))
        Text(PortfolioData.AVAILABILITY, color = PortfolioColors.TextPrimary, fontSize = 12.sp)
    }
    Spacer(Modifier.height(24.dp))
    Text(PortfolioData.NAME, color = PortfolioColors.TextPrimary, fontSize = 48.sp, fontWeight = FontWeight.Bold, lineHeight = 54.sp)
    Text(
        text = PortfolioData.ROLE,
        style = TextStyle(brush = PortfolioColors.titleGradient, fontSize = 48.sp, fontWeight = FontWeight.Bold, lineHeight = 54.sp),
    )
    Spacer(Modifier.height(20.dp))
    Text(PortfolioData.BIO, color = PortfolioColors.TextSecondary, fontSize = 16.sp, lineHeight = 26.sp)
    Spacer(Modifier.height(28.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Pill(text = "Ver prêmios", brush = PortfolioColors.accentGradient)
        Pill(text = "Baixar CV", background = PortfolioColors.ChipBackground)
    }
    Spacer(Modifier.height(36.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
        PortfolioData.stats.forEach { (value, label) ->
            Column {
                Text(value, color = PortfolioColors.TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(label, color = PortfolioColors.TextMuted, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun ContactCard(modifier: Modifier) {
    Card(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(Res.drawable.eu_linkedin),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(Modifier.width(14.dp))
            Column {
                Text(PortfolioData.NAME, color = PortfolioColors.TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Text(PortfolioData.LOCATION, color = PortfolioColors.TextSecondary, fontSize = 13.sp)
            }
        }
        Spacer(Modifier.height(20.dp))
        InfoRow("Email", PortfolioData.EMAIL)
        InfoRow("Base", PortfolioData.BASE)
        InfoRow("Foco", PortfolioData.FOCUS)
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
        Text(label, color = PortfolioColors.TextMuted, fontSize = 13.sp)
        Spacer(Modifier.weight(1f))
        Text(value, color = PortfolioColors.TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun SectionTitle(title: String, index: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, color = PortfolioColors.TextPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.weight(1f))
        Text(index, color = PortfolioColors.TextMuted, fontSize = 11.sp)
    }
    Spacer(Modifier.height(20.dp))
}

@Composable
private fun SkillsGrid(columns: Int) {
    Grid(items = PortfolioData.skills, columns = columns) { skill ->
        Card(Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth()) {
                Text(skill.name, color = PortfolioColors.TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.weight(1f))
                Text("${(skill.level * 100).toInt()}%", color = PortfolioColors.TextSecondary, fontSize = 13.sp)
            }
            Spacer(Modifier.height(14.dp))
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(PillShape)
                    .background(PortfolioColors.SurfaceBorder),
            ) {
                Box(
                    Modifier
                        .fillMaxWidth(skill.level)
                        .height(5.dp)
                        .clip(PillShape)
                        .background(PortfolioColors.accentGradient),
                )
            }
        }
    }
}

private val projectThumbs = listOf(
    listOf(Color(0xFF0B3C8C), Color(0xFF1E90FF)),
    listOf(Color(0xFF0A0D14), Color(0xFF2A3142)),
    listOf(Color(0xFF9AA5B5), Color(0xFFDCE3EC)),
)

@Composable
private fun ProjectsGrid(columns: Int) {
    Grid(items = PortfolioData.projects, columns = columns) { project ->
        val thumb = projectThumbs[PortfolioData.projects.indexOf(project) % projectThumbs.size]
        Card(Modifier.fillMaxWidth(), padding = 12.dp) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.3f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Brush.linearGradient(thumb)),
            )
            Spacer(Modifier.height(16.dp))
            Column(Modifier.padding(horizontal = 6.dp)) {
                Row(Modifier.fillMaxWidth()) {
                    Text(project.name, color = PortfolioColors.TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.weight(1f))
                    Text(project.year, color = PortfolioColors.TextMuted, fontSize = 12.sp)
                }
                Spacer(Modifier.height(6.dp))
                Text(project.description, color = PortfolioColors.TextSecondary, fontSize = 13.sp, lineHeight = 20.sp)
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun JobsList() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        PortfolioData.jobs.forEach { job ->
            Card(Modifier.fillMaxWidth(), padding = 20.dp) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(job.year, color = PortfolioColors.TextMuted, fontSize = 12.sp, modifier = Modifier.width(56.dp))
                    Box(Modifier.width(1.dp).height(36.dp).background(PortfolioColors.SurfaceBorder))
                    Spacer(Modifier.width(12.dp))
                    job.logo?.let { logo ->
                        Image(
                            painter = painterResource(logo),
                            contentDescription = null,
                            modifier = Modifier.size(36.dp),
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(Modifier.width(12.dp))
                    }
                    Column(Modifier.weight(1f)) {
                        Text(job.company, color = PortfolioColors.TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                        Text(job.role, color = PortfolioColors.TextSecondary, fontSize = 13.sp)
                    }
                    Pill(
                        text = if (job.active) "Ativo" else "Concluído",
                        background = PortfolioColors.ChipBackground,
                        fontSize = 11.sp,
                        horizontalPadding = 12.dp,
                        verticalPadding = 6.dp,
                    )
                }
            }
        }
    }
}

@Composable
private fun Footer(compact: Boolean) {
    Divider(color = PortfolioColors.SurfaceBorder)
    Spacer(Modifier.height(24.dp))
    if (compact) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            FooterCopyright()
            FooterLinks()
        }
    } else {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            FooterCopyright()
            Spacer(Modifier.weight(1f))
            FooterLinks()
        }
    }
}

@Composable
private fun FooterCopyright() {
    Text("© 2026 ${PortfolioData.NAME} — Todos os direitos reservados", color = PortfolioColors.TextMuted, fontSize = 13.sp)
}

@Composable
private fun FooterLinks() {
    val uriHandler = LocalUriHandler.current
    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        PortfolioData.socialLinks.forEach { link ->
            Text(
                text = link.label,
                color = PortfolioColors.TextSecondary,
                fontSize = 13.sp,
                modifier = Modifier.clickable { uriHandler.openUri(link.url) },
            )
        }
    }
}

@Composable
private fun Card(
    modifier: Modifier = Modifier,
    padding: Dp = 18.dp,
    content: @Composable () -> Unit,
) {
    Column(
        modifier
            .clip(CardShape)
            .background(PortfolioColors.Surface)
            .border(1.dp, PortfolioColors.SurfaceBorder, CardShape)
            .padding(padding),
    ) {
        content()
    }
}

@Composable
private fun Pill(
    text: String,
    background: Color = Color.Transparent,
    brush: Brush? = null,
    fontSize: androidx.compose.ui.unit.TextUnit = 13.sp,
    horizontalPadding: Dp = 18.dp,
    verticalPadding: Dp = 10.dp,
    onClick: () -> Unit = {},
) {
    val base = Modifier.clip(PillShape)
    val colored = if (brush != null) base.background(brush) else base.background(background)
    Box(
        modifier = colored
            .clickable(onClick = onClick)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        contentAlignment = Alignment.Center,
    ) {
        Text(text, color = PortfolioColors.TextPrimary, fontSize = fontSize, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun <T> Grid(
    items: List<T>,
    columns: Int,
    spacing: Dp = 14.dp,
    content: @Composable (T) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(spacing)) {
        items.chunked(columns).forEach { rowItems ->
            Row(horizontalArrangement = Arrangement.spacedBy(spacing)) {
                rowItems.forEach { item ->
                    Box(Modifier.weight(1f)) { content(item) }
                }
                repeat(columns - rowItems.size) { Spacer(Modifier.weight(1f)) }
            }
        }
    }
}
