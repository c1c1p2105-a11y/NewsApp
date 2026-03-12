package com.pajasoft.newsapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pajasoft.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NewsApp(innerPadding)
                }
            }
        }
    }
}

data class Noticia(
    val title: String,
    val fecha: String,
    val img: String
)

val newsList = listOf(
    Noticia(
        title = "El presidente de EE.UU. no muestra sifnos de arrepentimiento.",
        fecha = "febrero 08 - 2024",
        img = "https://ichef.bbci.co.uk/news/1024/branded_news/c5d7/live/9f0195a0-d517-11ef-94cb-5f844ceb9e30.jpg"
    ),
    Noticia(
        title = "Bañarse en la pscina del desierto de Cleopatra",
        fecha = "febrero 11 - 2024",
        img = "https://s1.elespanol.com/2018/09/21/cultura/historia/curiosidades_de_la_historia-historia-historia_339728816_98134230_1706x1280.jpg"
    ),
    Noticia(
        title = "Gigantes tecnológicos",
        fecha = "febrero 12 - 24",
        img  = "https://www.gaceta.unam.mx/wp-content/uploads/2023/04/230424-aca4-des-f1-gigantes-tecnologicos-internet.jpg"
    ),
    Noticia(
        title = "El rover de Marte envia nuevas imágenes",
        fecha = "febrero 14 - 2024",
        img = "https://unamglobal.unam.mx/wp-content/uploads/2018/02/91FA91A5-4FEF-44E7-9AAF-5AC51E577B0C.jpeg"
    )
)

@Composable
fun NewsCard(noticia: Noticia){
    Box(
        modifier = Modifier
            .padding(end = 15.dp)
            .width(200.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF7B61FF))
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x997B61FF))
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(15.dp)
        ) {
            Text(
                text = noticia.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = noticia.fecha,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
    }
}

@Composable
fun CardImg(noticia: Noticia){
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFFF0F0F0))
    ) {
        AsyncImage(
            model = noticia.img,
            contentDescription = noticia.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = noticia.title,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Composable
fun NewsApp(innerPadding: PaddingValues) {
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(innerPadding)
            .padding(horizontal = 15.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Buscar") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            shape = RoundedCornerShape(45.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Noticias",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Box(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .width(30.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color(0xFF7B61FF))
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Eventos",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Clima",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                )
            }
        }


        Text(
            text = "Ultimas Noticias",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(top = 15.dp, bottom = 10.dp)
        )

        LazyRow {
            items(newsList) { noticias ->
                NewsCard(noticia = noticias)
            }
        }

        Text(
            text = "Alrededor del mundo",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 15.dp, bottom = 10.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(newsList) { noticias ->
                CardImg(noticia = noticias)
            }
        }
    }
}



@Preview(
    showBackground = true
)
@Composable
fun GreetingPreview() {
    NewsAppTheme {
        NewsApp(innerPadding = PaddingValues(0.dp))
    }
}