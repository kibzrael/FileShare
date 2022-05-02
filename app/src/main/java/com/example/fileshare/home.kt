package com.example.fileshare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Fileshare")
                }
            , elevation = 4.dp,
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(vertical=15.dp),
            verticalArrangement = Arrangement.SpaceEvenly

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.Green)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Rounded.Send, contentDescription = "", modifier = Modifier
                            .clip(
                                CircleShape
                            )
                            .background(Color.Blue)
                            .clickable(onClick = {})
                            .size(72.dp)
                            .padding(12.dp)
                            .absolutePadding(left = 2.dp), tint = Color.White

                    );
                    Text("Send", fontSize = 21.sp, fontWeight = FontWeight.Medium)
                };
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Rounded.Download, contentDescription = "", modifier = Modifier
                            .clip(
                                CircleShape
                            )
                            .background(Color.Green)
                            .clickable(onClick = {})
                            .size(72.dp)
                            .padding(12.dp), tint = Color.White

                    );
                    Text("Receive", fontSize = 21.sp, fontWeight = FontWeight.Medium)
                }
            }

            Button(
                elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .height(50.dp)
                    .fillMaxWidth()
                    .clip(
                        CircleShape
                    )
            ) {
                Icon(Icons.Rounded.PersonAdd, contentDescription = "", modifier = Modifier.absolutePadding(right=15.dp));
                Text(text = "Invite");
            }
        }
    }

}