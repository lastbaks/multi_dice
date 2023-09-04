package com.example.testjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testjetpackcompose.ui.theme.TestJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val dice = mutableListOf<Int>()
                    for(i in 0 .. 5){
                        dice.add(random())
                    }
                    testCompose(dice.size)
                    }
                }
            }
        }
    }


@Composable
fun testCompose(count: Int) {

    Row(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.3f)){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .background(Color.Blue)){
                Button(onClick = {}){
                    Text("Troll")
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxSize()){
            for(i in 0 .. count - 1){
                Box(modifier = Modifier
                    .padding(15.dp)
                    .height(120.dp)
                    .fillMaxWidth()
                    .background(colorResource(R.color.dice_background))){
                    Image(
                        painter = painterResource(id = R.drawable.dice_1), contentDescription = "1"
                    )
                }
            }
        }
    }
}

fun random(): Int {
    val localRand = (1 .. 6).random()
    return localRand
}