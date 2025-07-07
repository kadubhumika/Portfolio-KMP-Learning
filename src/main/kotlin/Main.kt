// ✅ Main.kt
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.PortfolioScreen

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "My Portfolio") {
        MaterialTheme {
            Surface(color = Color(0xFF121212)) {
                PortfolioScreen()
            }
        }
    }
}