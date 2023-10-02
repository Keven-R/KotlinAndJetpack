package com.edu.curtin.kotlinandjetpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.curtin.kotlinandjetpack.model.Book
import com.edu.curtin.kotlinandjetpack.viewmodel.ExampleEvent
import com.edu.curtin.kotlinandjetpack.viewmodel.ExampleViewmodel

@Composable
fun EditField(label: String, content: () -> String, onValueChange: (String) -> Unit){
    Column (
        modifier = Modifier
            .padding(3.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "$label: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        TextField(value = content(), onValueChange = onValueChange, Modifier.fillMaxWidth())
    }
}

@Composable
fun ExampleButton(label: String, onClickEvent: () -> Unit) {
    FilledTonalButton(
        modifier = Modifier
            .padding(8.dp),
        onClick = onClickEvent
    ) {
        Text(text = label)
    }
}

@Composable
fun RoundProfileImage(
    painter: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = painter,
        contentScale = ContentScale.FillWidth,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ContactItem(
    pos: Int,
    viewModel: ExampleViewmodel,
    book: Book,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray
            )
            .padding(10.dp)
            .clickable {
                viewModel.onEvent(ExampleEvent.TempEventPrams(pos))
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        RoundProfileImage(painter = painterResource(book.picture), modifier = Modifier.height(100.dp))

        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = book.title, textAlign = TextAlign.Center, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "by", textAlign = TextAlign.Center, fontSize = 15.sp)
            Text(text = book.author, textAlign = TextAlign.Center, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
        }
    }
}