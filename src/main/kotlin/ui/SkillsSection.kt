package ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

import myportfolio.SoftWhite

@Composable
fun GlowingSkillsTitle(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {
        // Glowing background
        Box(
            modifier = Modifier
                .width(220.dp)
                .height(60.dp)
                .graphicsLayer {
                    // Subtle shadow
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
                    color = Color(0xFF1E1E2E), // deep purple from your Figma
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 24.dp, vertical = 10.dp)
        ) {
            Text(
                text = "Skills",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = SoftWhite,
                letterSpacing = 1.sp
            )
        }
    }


}
@Composable
fun SkillChip(skill: String) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.4f),
                        Color.LightGray.copy(alpha = 0.3f)

                    )
                ),
                shape = RoundedCornerShape(8.dp) // Subtle rectangle look
            )
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.5f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(
            text = skill,
            color = Color.Black.copy(alpha = 0.8f),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun SkillsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlowingSkillsTitle()
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.widthIn(max = 600.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SkillCategory("Android Development", listOf("Kotlin", "Jetpack Compose", "MVVM", "Retrofit"))
            SkillCategory("UI/UX Design", listOf("Figma"))
            SkillCategory("Programming Languages", listOf("Python", "C", "Kotlin"))
            SkillCategory("Other", listOf("GitHub", "Hackathon Participant"))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillCategory(title: String, items: List<String>) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = SoftWhite,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        FlowRow(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items.forEach {
                SkillChip(skill = it)
            }
        }
    }
}
