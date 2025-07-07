package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myportfolio.Blue
import myportfolio.NeonPurple
import myportfolio.Plum
import myportfolio.SoftWhite

import androidx.compose.ui.graphics.graphicsLayer


import myportfolio.NeonGlow




data class Project(
    val title: String,
    val description: String,
    val images: List<String>
)

@Composable
fun ProjectCardAlwaysVisible(
    title: String,
    description: String,
    alignRight: Boolean,
    images: List<String>
) {
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            NeonPurple.copy(alpha = 0.4f),
            Plum.copy(alpha = 0.3f),
            Blue.copy(alpha = 0.2f)
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = Modifier
                .widthIn(max = 500.dp)
                .padding(vertical = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(
                        brush = backgroundGradient,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(1.dp, SoftWhite.copy(alpha = 0.3f), RoundedCornerShape(20.dp))
                    .padding(20.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = SoftWhite
                )

                Spacer(modifier = Modifier.height(10.dp))

                images.forEach { imageName ->
                    Image(
                        painter = painterResource(imageName),
                        contentDescription = "$title image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(210.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 7.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}

@Composable
fun Projects() {
    val projects = listOf(
        Project(
            title = "FireLock",
            description = "An authentication-based app built using Firebase with user login, signup and password reset.",
            images = listOf("firelock1.png", "firelock2.png")
        ),
        Project(
            title = "Calculator App",
            description = "A functional calculator with basic arithmetic operations built using XML layout and Kotlin.",
            images = listOf("calculator.png", "calculator2.png")
        ),
        Project(
            title = "PawFetch",
            description = "A fun app that fetches random dog images from the Dog API using MVVM architecture.",
            images = listOf("img.4.png")
        ),
        Project(
            title = "Krypto",
            description = "A crypto price tracker app using CoinGecko API with Jetpack Compose and clean architecture.",
            images = listOf("img6.png")
        ),
        Project(
            title = "Spotify UI",
            description = "A Spotify clone UI made using Figma and Compose UI components.",
            images = listOf("img7.png", "img8.png")
        ),
        Project(
            title = "MVVM-Quotes-App",
            description = "Displays motivational quotes using MVVM pattern and Room database.",
            images = listOf("img9.png")
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlowingProjectsTitle()

        Spacer(modifier = Modifier.padding(50.dp))

        projects.forEachIndexed { index, project ->
            val alignRight = index % 2 == 1
            ProjectCardAlwaysVisible(
                title = project.title,
                description = project.description,
                alignRight = alignRight,
                images = project.images
            )
        }
    }
}

@Composable
fun GlowingProjectsTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {

        Box(
            modifier = Modifier
                .width(165.dp)
                .height(60.dp)
                .graphicsLayer {
                    shadowElevation = 24f
                }
                .clip(RoundedCornerShape(30.dp))
                .background(
                    Brush.radialGradient(
                        colors = listOf(NeonGlow.copy(alpha = 0.4f), Color.Transparent),
                        radius = 300f
                    )
                )
        )

        // Foreground label
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
                text = "Projects",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = SoftWhite,
                letterSpacing = 1.sp
            )
        }
    }
}
