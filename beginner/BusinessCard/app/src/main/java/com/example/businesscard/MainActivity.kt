package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .background(Color(0xC88EFFC4))
                    .safeDrawingPadding()) { innerPadding ->
                    BusinessCardApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier) {
    Column(modifier = modifier
        .background(Color(0xC88EFFC4))
        .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceAround
        ) {
        CardHeader("Jordan Ponce", "Senior Android Developer", Modifier)
        CardFooter("407 123 1234", "jordan@linkedin.com", "jordancw418@gmail.com", Modifier)
    }
}

@Composable
fun CardHeader(name: String, title: String, modifier: Modifier) {
    Column(modifier = modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = modifier.height(72.dp).width(72.dp).background(Color(0xFF2196F3))
            ,
            painter = painterResource(R.drawable.android_logo),
            contentScale = ContentScale.Crop,
            contentDescription = null)
        Text(
            text = name,
            color =Color(0xFF3ddc84)
        )
        Text(
            text = title,
            color =Color(0xFF3ddc84)
        )
    }
}

@Composable
fun CardFooter(phone: String, socialMedia: String, email: String, modifier: Modifier) {
    Column(modifier = modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        footerRow(Icons.Rounded.Call, phone, modifier)
        footerRow(Icons.Rounded.Share, socialMedia, modifier)
        footerRow(Icons.Rounded.Email, email, modifier)
    }
}

@Composable
fun footerRow(imageVector: ImageVector, content: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Icon(imageVector, null)
        Text(content, modifier.padding(start = 4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CardHeaderPreview() {
    BusinessCardTheme {
        CardHeader("Jordan Ponce", "Senior Android Developer", Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun CardFooterPreview() {
    BusinessCardTheme {
        CardFooter("407 123 1234", "jordan@linkedin.com", "jordancw418@gmail.com", Modifier)
    }
}