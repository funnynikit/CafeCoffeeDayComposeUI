package com.sample.cafecoffeeday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sample.cafecoffeeday.R
import com.sample.cafecoffeeday.common.AppIcon
import com.sample.cafecoffeeday.data_provider.menuList
import com.sample.cafecoffeeday.navigation.DETAIL_SCREEN
import com.sample.cafecoffeeday.ui.theme.Background
import com.sample.cafecoffeeday.ui.theme.DarkGray
import com.sample.cafecoffeeday.ui.theme.Gray
import com.sample.cafecoffeeday.ui.theme.LightRed
import com.sample.cafecoffeeday.ui.theme.MediumFont
import com.sample.cafecoffeeday.ui.theme.Red
import com.sample.cafecoffeeday.ui.theme.RegularFont
import com.sample.cafecoffeeday.ui.theme.SemiboldFont
import com.sample.cafecoffeeday.ui.theme.TextColor

@Composable
fun HomeScreen(navHostController: NavHostController) {

    var search by remember { mutableStateOf("") }
    var selected by remember {  mutableStateOf("All")  }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Header()
            LazyColumn {
                item {
                    Text(
                        text = "One way of loving\nyou back",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 25.sp,
                            fontFamily = SemiboldFont,
                            fontWeight = FontWeight.W500
                        ),
                        modifier = Modifier.padding(vertical = 30.dp)
                    )
                }
                item {
                    Box() {
                        CustomSearchBox(value = search, onValueChange = {  search = it }, modifier = Modifier)
                        AppIcon(icon = R.drawable.filter, background = Red, modifier = Modifier
                            .align(
                                Alignment.TopEnd
                            )
                            .size(55.dp))
                    }
                }

                item {
                    LazyRow(modifier = Modifier.padding(vertical = 10.dp))
                    {
                       items(menuList)
                       {
                           CustomFilterChip(title = it.title,selected = it.title == selected)
                           {
                                selected = it
                           }

                       }

                    }
                }

                item {
                    Populor(navHostController)
                }
            }

        }

    }


}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIcon(icon = R.drawable.menu, modifier = Modifier)
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(58.dp),
            tint = Color.Unspecified
        )
        AppIcon(icon = R.drawable.bag, modifier = Modifier)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBox(value: String, onValueChange: (String) -> Unit, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(28.dp))
            .background(Gray)
    ) {

        TextField(value = value,
            onValueChange = { onValueChange(it) },
            placeholder = {
                Text(
                    text = "Search",
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 16.sp,
                        FontWeight.W400,
                        fontFamily = RegularFont
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = {}
        )
    }
}

@Composable
fun CustomFilterChip(
  title : String,
  selected : Boolean,
  modifier: Modifier = Modifier,
  onValueChange: (String) -> Unit
) {
    TextButton(onClick = { onValueChange(title) }, shape = RoundedCornerShape(25.dp), elevation = ButtonDefaults.buttonElevation(0.dp), colors = ButtonDefaults.buttonColors(if (selected) Red else Gray ),modifier = modifier.padding(end = 15.dp)) {
        Text(text = title, style = TextStyle(color = if(selected) Color.White else TextColor, fontWeight = FontWeight.W400, fontSize = 20.sp, fontFamily = RegularFont),modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp))
    }
}

@Composable
fun Populor(navHostController: NavHostController)
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, bottom = 20.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "Populor", style = TextStyle(color = Color.Black, fontSize = 22.sp,fontWeight = FontWeight.W500, fontFamily = SemiboldFont))
            Text(text = "See All",style = TextStyle(color = Red, fontSize = 22.sp,fontWeight = FontWeight.W500, fontFamily = SemiboldFont))
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow()
        {
            items(5)
            {
                ItemEachRow()
                {
                    navHostController.navigate(DETAIL_SCREEN)
                }
            }
        }
    }
}

@Composable
fun ItemEachRow(onClick:()->Unit)
{
    var selected by remember { mutableStateOf(false) }

    Card( shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .clickable { onClick() }
            .width(220.dp)
            .padding(end = 10.dp)) {
        Column() {
            Box( modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 14.dp,
                        bottomEnd = 14.dp
                    )
                )
                .background(LightRed),
                contentAlignment = Alignment.Center) {
                Image(painter = painterResource(id = R.drawable.image), contentDescription = "", modifier = Modifier.height(180.dp))
            }

            Column(modifier = Modifier.padding(15.dp))
            {
                Text(
                    text = "Cappuccino Coffee",
                    style = TextStyle(
                        color = DarkGray,
                        fontWeight = FontWeight.W500,
                        fontSize = 20.sp,
                        fontFamily = MediumFont
                    ),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$20.00",
                        style = TextStyle(
                            color = Red,
                            fontWeight = FontWeight.W400,
                            fontSize = 25.sp,
                            fontFamily = MediumFont
                        ),
                    )
                    IconButton(onClick = {
                        selected = !selected
                    }, modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically)) {
                        Icon(
                            painter = painterResource(id = R.drawable.love),
                            contentDescription = "",
                            tint = if (selected) Red else Color.Unspecified
                        )
                    }
                }
            }

        }
    }
}

