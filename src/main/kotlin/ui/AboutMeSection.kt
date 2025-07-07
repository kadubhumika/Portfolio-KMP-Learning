package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myportfolio.*

@Composable
fun GlowingAboutmeTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {

        Box(
            modifier = Modifier
                .width(220.dp)
                .height(60.dp)
                .graphicsLayer {
                    shadowElevation = 24f
                    shape = RoundedCornerShape(7.dp)
                    clip = true
                }
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = SoftWhite,
                    shape = RoundedCornerShape(30.dp)
                )
                .background(
                    color = Color(0xFF1E1E2E),
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 24.dp, vertical = 10.dp)
        ) {
            Text(
                text = "About Me",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = SoftWhite,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun GradientCardBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = Modifier.wrapContentSize()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(SoftPurple, Plum, Purple, Blue)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = "Hi! I'm a first-year B.Tech CSE student at Sri Guru Gobind Singh College of Engineering, passionate about tech, design, and innovation.\n\n" +
                            "I'm exploring Android development and proudly involved in SWAG and GDSC clubs.\n\n" +
                            "With skills in Kotlin, Jetpack Compose, and Figma, I contribute to open-source (SSoC) and love building sleek, functional apps.\n\n" +
                            "Hackathons, creative challenges, and learning by doing drive my journey.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun AboutMeSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        GlowingAboutmeTitle()
        Spacer(Modifier.height(50.dp))
        GradientCardBox()
    }
}
