package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .safeDrawingPadding()
                ) { innerPadding ->
                    Article(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    Column(modifier) {
        HeaderImage(modifier)
        Header(modifier)
        Body(
            stringResource(R.string.body_1),
            modifier.padding(
                start = 16.dp,
                end = 16.dp
        ))
        Body(
            stringResource(R.string.body_2),
            modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image,
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth())
}

@Preview(showBackground = true)
@Composable
fun Header(modifier: Modifier = Modifier) {
    Text(
        text = "Jetpack Compose tutorial",
        modifier = modifier
            .padding(16.dp),
        fontSize = 24.sp
    )
}

@Composable
fun Body(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Article()
    }
}