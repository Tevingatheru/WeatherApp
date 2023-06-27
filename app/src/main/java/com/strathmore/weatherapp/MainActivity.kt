package com.strathmore.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.strathmore.weatherapp.ui.theme.DarkBlue
import com.strathmore.weatherapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}
data class TableItem(val imageRes: Int, val text1: String, val text2: String)

@Composable
fun WeatherPage() {

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(all = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Image()
        Info()
        WeatherTable()
    }

}

@Composable
fun Image() {
    Image(painter = painterResource(R.drawable.ic_couple),
        contentDescription = "image",
        modifier = Modifier
            .size(200.dp, 250.dp)
            .padding(all = 5.dp))
}

@Composable
fun Info() {
    Text(text = "11" + "\u2103", color = Color.DarkGray, fontSize = 48.sp,
        fontWeight = FontWeight.Bold)
    Text(text = "Nairobi", color = DarkBlue,
        fontSize = 20.sp,
        modifier = Modifier.padding(3.dp))
    Text(text = "Rainy", fontSize = 16.sp, color = Color.Gray, textAlign = TextAlign.Center,
        modifier = Modifier.padding(all = 3.dp) )
    Text(text = "Wind seed: 20", fontSize = 14.sp, color = Color.Gray)
}

@Composable
fun WeatherTable() {
    val data = listOf(
        TableItem(R.drawable.ic_couple, "Text 1-1", "Text 1-2"),
        TableItem(R.drawable.ic_couple, "Text 2-1", "Text 2-2"),
        TableItem(R.drawable.ic_couple, "Text 3-1", "Text 3-2"),
        TableItem(R.drawable.ic_couple, "Text 4-1", "Text 4-2")
    )

    LazyColumn {
        items(data.chunked(2)) { rowItems ->
            Row(modifier = Modifier.fillMaxWidth()) {
                rowItems.forEach { item ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(90.dp)
                                .clip(RoundedCornerShape(4.dp))
                        ) {
                            Image(
                                painter = painterResource(id = item.imageRes),
                                contentDescription = "Conditions",
                                contentScale = ContentScale.Crop,
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(item.text1)
                        Text(item.text2)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 800, widthDp = 390)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        WeatherPage()
    }
}

