package com.mrg.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrg.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

    @Composable
    fun areaZone() {

        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Area",
                fontSize = 32.sp,
                color = Color(0xfff2f2f2),

            )
            Text(
                text = "day",
                fontSize = 18.sp,
                color = Color(0xfff2f2f2),

                )

        }
    }
    @Composable
    fun weatherDegree(){
        Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.cloudy), contentDescription ="weather status" )
        }
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = "18",
                color = Color(0xfff2f2f2),
                fontSize = 64.sp)
            Text(text="Thunderstrom",color = Color(0xfff2f2f2))
        }
    }
    @Composable
    fun weatherCard() {

    }

    @Preview(showBackground = true)
    @Composable
    fun testView() {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xff1b1c1e)) {
            areaZone()
            weatherDegree()
            weatherCard()


        }
    }
}