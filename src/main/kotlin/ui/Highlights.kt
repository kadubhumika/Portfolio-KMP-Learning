package ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.foundation.background

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myportfolio.NeonGlow
import myportfolio.SoftWhite

data class Contribution(
    val title: String,
    val description: String,
    val image: String
)

@Composable
fun FlippableCard(contribution: Contribution) {
    var flipped by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (flipped) 180f else 0f,
        label = "rotation"
    )

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            }
            .clickable { flipped = !flipped },
        contentAlignment = Alignment.Center
    ) {
        if (rotation <= 90f) {
            // Front Side
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(contribution.image),
                    contentDescription = contribution.title,
                    modifier = Modifier
                        .size(160.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(2.dp, Color.LightGray, RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = contribution.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        } else {
            // Back Side
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = 180f
                    }
                    .padding(12.dp),
                elevation = 4.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF0F0C29),
                                    Color(0xFF302B63),
                                    Color(0xFF24243E)
                                )
                            )
                        )
                        .padding(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = contribution.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = contribution.description,
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HighlightsGrid() {
    val contributions = listOf(
        Contribution(
            title = "HackFusion 2.0",
            description = "As a first-year member of the GDG Swag Club, I contributed to event decoration, " +
                    "management, and behind-the-scenes work. Learned a lot, explored team collaboration, " +
                    "and helped make this 3-day hackathon a grand success at our SGGS college!",
            image = "hackfusion.jpg"
        ),
        Contribution(
            title = "Ecothon",
            description = "Built a smart energy management app for campuses—no sensors needed! " +
                    "Worked with an amazing team, tackled sustainability challenges, and learned tons. " +
                    "Organized by Sipna College & Nature Club!",
            image = "ecothon.jpg"
        ),
        Contribution(
            title = "FlutterFlow Workshop",
            description = "An exciting no-code app dev workshop with GDG on Campus at SGGSIE&T! " +
                    "Explored UI building with FlutterFlow and had an amazing interactive session with the community.",
            image = "workshop.jpg"
        ),
        Contribution(
            title = "First Year",
            description = "Started my dev journey! Explored Android, Kotlin, and built multiple Compose projects " +
                    "to sharpen my basics. Also attended functions, made amazing new friends, enjoyed, " +
                    "bunked lectures—and yeah, sacrificed some attendance too! 😄",
            image = "firstyear.jpg"
        ),
        Contribution(
            title = "Exploration Arduino Bluetooth-Controlled Car",
            description = "Built a Bluetooth-controlled car using Arduino + HC-05. Controlled it via a " +
                    "custom Android app – perfect intro to IoT and embedded systems!",
            image = "exploration.jpg"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlowingHighlightsTitle()

        Spacer(modifier = Modifier.padding(50.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp), // Adjust height as needed
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(contributions) { contribution ->
                FlippableCard(contribution)
            }
        }
    }
}
@Composable
fun GlowingHighlightsTitle(){
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
            androidx.compose.material3.Text(
                text = "Highlights",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = SoftWhite,
                letterSpacing = 1.sp
            )
        }
    }
}
