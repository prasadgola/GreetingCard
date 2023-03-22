package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingWithImage(message = "Happy", kind = "New Year", name = "Sam!", from = "Basavaprasad")
                }
            }
        }
    }
}

@Composable
fun GreetingWithImage(message: String, kind: String, name: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(painter = image, contentDescription = null, modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            ,contentScale = ContentScale.Crop
        )
        TypeOfGreetingWithText(message = message, kind = kind, name = name, from = from)
    }
}


@Composable
fun TypeOfGreetingWithText  (message: String, kind: String, name: String, from: String) {
    Column {
        Text(text = message + "..............<=>",
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(text = kind + " " + name,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 90.dp, top = 16.dp)
            )
        Text(text = "from " + from,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 150.dp, top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWithImagePreview() {
    GreetingCardTheme {
        GreetingWithImage(message = stringResource(R.string.Happy), kind = stringResource(R.string.Birthday), name = stringResource(
                    R.string.Sam), from = stringResource(R.string.Basavaprasad)
                            )
    }
}