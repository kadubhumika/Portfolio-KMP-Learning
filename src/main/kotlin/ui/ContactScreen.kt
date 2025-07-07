package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myportfolio.*

@Composable
fun ContactScreen() {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        GlowingContactTitle()

        Spacer(modifier = Modifier.padding(50.dp))

        ContactItem(
            label = "Email",
            value = "kadubhumika2468@gmail.com",
            onClick = { uriHandler.openUri("mailto:kadubhumika2468@gmail.com") }
        )

        DividerLine()

        ContactItem(
            label = "GitHub",
            value = "github.com/kadubhumika",
            onClick = { uriHandler.openUri("https://github.com/kadubhumika") }
        )

        DividerLine()

        ContactItem(
            label = "LinkedIn",
            value = "linkedin.com/in/bhumika786",
            onClick = { uriHandler.openUri("https://www.linkedin.com/in/bhumika786") }
        )
    }
}

@Composable
fun ContactItem(
    label: String,
    value: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = SoftWhite
        )
    }
}

@Composable
fun DividerLine() {
    Divider(
        thickness = 0.5.dp,
        color = Color.Gray.copy(alpha = 0.4f)
    )
}
@Composable
fun GlowingContactTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
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
                text = "Contact",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = SoftWhite,
                letterSpacing = 1.sp
            )
        }
    }
}
