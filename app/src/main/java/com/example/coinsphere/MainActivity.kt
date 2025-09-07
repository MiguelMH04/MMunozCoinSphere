package com.example.coinsphere

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.coinsphere.models.coins
import com.example.coinsphere.ui.theme.Background
import com.example.coinsphere.ui.theme.CoinSphereTheme
import com.example.coinsphere.ui.theme.Surface
import com.example.coinsphere.ui.theme.TextDim
import com.example.coinsphere.ui.theme.TextMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinSphereTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                HomeScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ){
        Text("CoinSphere",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = TextMain,
            modifier = Modifier
                .padding(25.dp)
        )
        Column {
            //Primera Card
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp,
                        vertical = 5.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Surface
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column {
                        Text("Global Market Cap",
                            color = Color.Gray
                            )
                        Text("$2.18T",
                            color = TextDim,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                }
            }
            //Segunda Card
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp,
                        vertical = 5.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Surface
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column {
                        Text("Fear & Greed",
                            color = Color.Gray
                        )
                        Text("Neutral (54)",
                            color = TextDim,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                }
            }
            //Tercera Card
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp,
                        vertical = 5.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Surface
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column {
                        Text("Altcoin Season",
                            color = Color.Gray
                        )
                        Text("No",
                            color = TextDim,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
        Row (
            modifier = Modifier
                .padding(20.dp)
        ){
            Text("# Name",
                color = TextDim,
                modifier = Modifier
                .weight(1f)
                )
            Text("Price",
               color = TextDim,
            modifier = Modifier
                .weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(Surface)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(coins){ CoinList -> 
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Surface)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                   Text(CoinList.number.toString(),
                       color = TextDim,
                       modifier = Modifier
                           .weight(.5f
                               ))

                   AsyncImage(model = CoinList.image,
                       contentDescription = CoinList.title,
                       modifier = Modifier
                           .size(35.dp)
                           .weight(.8f, fill = false))
                Spacer(modifier = Modifier
                    .width(8.dp))

                    Text(CoinList.title,
                        color = TextDim,
                        modifier = Modifier
                            .weight(2f
                            ))

                    Text(CoinList.price,
                        color = TextDim,
                        modifier = Modifier
                            .weight(2f
                            ))


               }
                Spacer(modifier = Modifier
                    .padding(top = 10.dp))
            }
        }
    }
}
@Preview
(
showBackground = true,
showSystemUi = true
)

@Composable
fun GreetingPreview() {
    CoinSphereTheme {
        HomeScreen(innerPadding = PaddingValues(all = 10.dp))
    }
}