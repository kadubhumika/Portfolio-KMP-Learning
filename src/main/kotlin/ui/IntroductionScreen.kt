package ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import myportfolio.NeonGlow
import myportfolio.Purple
import myportfolio.SoftWhite


@Composable
fun GlowingIntroductionTitle() {
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
                .background(
                    Brush.radialGradient(
                        colors = listOf(NeonGlow.copy(alpha = 0.4f), Color.Transparent),
                        radius = 300f
                    ),
                    shape = RoundedCornerShape(30.dp)
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
            Text(
                text = "Introduction",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = SoftWhite,
                letterSpacing = 1.sp
            )
        }
    }
}
@Composable
fun IntroductionSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        GlowingIntroductionTitle()



        Spacer(Modifier.height(50.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(120.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Purple, Color.Transparent),
                        radius = 700f
                    ),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource("mypic.jpg"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.Black, CircleShape)
            )
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Hi, I'm Bhumika Kadu.",
            color = SoftWhite,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "A curious mind exploring code, design, and innovation.",
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
