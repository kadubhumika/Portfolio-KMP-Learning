package ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import myportfolio.BackgroundColor

@Composable
fun PortfolioScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        BackgroundColor,
                        Color(0xFF2E294E),
                        BackgroundColor,// velvet night

                        BackgroundColor,// royal purple

                        BackgroundColor,
                      // pastel purple glow

                        BackgroundColor,
                                Color(0xFF2E294E),
                    )
                )
            )

            .padding(60.dp),
        verticalArrangement = Arrangement.spacedBy(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item { IntroductionSection() }
        item { Spacer(modifier = Modifier.height(50.dp)) }

        item { AboutMeSection() }
        item { Spacer(modifier = Modifier.height(50.dp)) }

        item { SkillsSection() }
        item { Spacer(modifier = Modifier.height(50.dp)) }

        item { Projects() }
        item { Spacer(modifier = Modifier.height(50.dp)) }

        item { HighlightsGrid() }
        item { Spacer(modifier = Modifier.height(50.dp)) }

        item { ContactScreen() }
        item { Spacer(modifier = Modifier.height(50.dp)) }
    }
}
