package com.sample.cafecoffeeday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sample.cafecoffeeday.R
import com.sample.cafecoffeeday.common.AppIcon
import com.sample.cafecoffeeday.ui.theme.Background
import com.sample.cafecoffeeday.ui.theme.Gray400
import com.sample.cafecoffeeday.ui.theme.Gray500
import com.sample.cafecoffeeday.ui.theme.LightRed
import com.sample.cafecoffeeday.ui.theme.MediumFont
import com.sample.cafecoffeeday.ui.theme.Red


@Composable
fun ProductDetailScreen(navHostController: NavHostController)
{
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
            ProductHeader(navHostController)
            LazyColumn {
                item {
                    ShowProduct()
                }
                item {
                    ProductDescription()
                }
            }
        }
        AppButton(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        )

    }
}

@Composable
fun ProductDescription(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        Text(
            text = "Coffee",
            style = TextStyle(
                color = Red,
                fontWeight = FontWeight.W400,
                fontSize = 18.sp,
                fontFamily = MediumFont
            ),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Cappuccino Coffee",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    fontSize = 22.sp,
                    fontFamily = MediumFont
                ),
            )
            Row(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star), contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically),
                    tint = Color.Unspecified,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "4.5",
                    style = TextStyle(
                        color = Gray400,
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp,
                        fontFamily = MediumFont
                    ),
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "A cappuccino is the perfect balance of espresso, steamed milk and foam. This coffee is all about the structure and the even splitting of all elements into equal thirds. An expertly made cappuccino should be rich, but not acidic and have a mildly sweet flavouring from the milk.",
            style = TextStyle(
                color = Gray500,
                fontWeight = FontWeight.W400,
                fontSize = 18.sp,
                fontFamily = MediumFont
            ),
        )
    }


}


@Composable
fun ShowProduct(
    modifier: Modifier = Modifier
) {
    var counter by remember { mutableStateOf(0) }
    Box(
        modifier = modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(LightRed),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.image), contentDescription = "",
                modifier = Modifier.height(220.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .width(130.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
            ) {
                AppIcon(icon = R.drawable.plus, background = Red) {
                    counter++
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "$counter",
                    style = TextStyle(
                        color = Red,
                        fontWeight = FontWeight.W400,
                        fontSize = 25.sp,
                        fontFamily = MediumFont
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )
                Spacer(modifier = Modifier.width(10.dp))
                AppIcon(
                    icon = R.drawable.minus, background = Red, modifier = Modifier.align(
                        Alignment.TopEnd
                    )
                ) {
                    if (counter > 0)
                        counter--
                }
            }
        }
    }

}

@Composable
fun AppButton(
    modifier: Modifier = Modifier
) {

    Button(
        onClick = {}, modifier = modifier.fillMaxWidth(),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        shape = RoundedCornerShape(37.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Red
        ),
    ) {
        Text(
            text = stringResource(R.string.add_to_bag),
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                fontFamily = MediumFont
            ),
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }

}

@Composable
fun ProductHeader(
    navHostController: NavHostController
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIcon(icon = R.drawable.back){
            navHostController.navigateUp()
        }
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(58.dp),
            tint = Color.Unspecified
        )
        AppIcon(icon = R.drawable.love, tint = Color.Red)
    }

}




