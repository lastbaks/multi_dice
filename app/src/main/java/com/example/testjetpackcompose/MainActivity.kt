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
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
                    val dicies = remember { mutableStateListOf<Int>()}
                    for(i in 0 .. 5){
                        dicies.add(random())
                    }
                    bodyView(dicies)
                    }
                }
            }
        }
    }


@Composable
fun bodyView(dicies: MutableList<Int>) {

    Row(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.3f)){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .background(Color.Blue),
                contentAlignment = Alignment.Center){
                Button(onClick = {
                    for(i in 0 .. 5){
                        dicies[i] = (random())
                    }
                }){
                    Text("Roll")
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxSize()){
            for(i in 0 .. dicies.size - 1){
                val randomDice = when (dicies[i]) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
                Box(modifier = Modifier
                    .padding(15.dp)
                    .height(120.dp)
                    .fillMaxWidth()
                    .background(colorResource(R.color.dice_background)),
                    contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = randomDice(1)), contentDescription = "1"
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

fun randomDice(i: Int) : Int {
    val randomDice = when (i) {
        1 -> return R.drawable.dice_1
        2 -> return R.drawable.dice_2
        3 -> return R.drawable.dice_3
        4 -> return R.drawable.dice_4
        5 -> return R.drawable.dice_5
        else -> return R.drawable.dice_6
    }
}