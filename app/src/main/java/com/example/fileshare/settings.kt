package com.example.fileshare

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun AppSettings() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text("Settings")
        },
            actions = {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.Transparent)
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(Icons.Rounded.LightMode, contentDescription = "")
                    Divider(modifier= Modifier
                        .padding(horizontal = 6.dp)
                        .height(24.dp)
                        .width(1.dp), color = Color.Gray)
                    Icon(Icons.Rounded.DarkMode, contentDescription = "")
                }
            }
        )
    }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp, horizontal = 30.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            Icon(Icons.Rounded.Person, contentDescription = "",
                tint =Color.Blue,
            modifier = Modifier
                .clip(CircleShape)
                .border(1.dp, Color.Gray,CircleShape)
                .padding(30.dp)
                .size(60.dp)
                )
            Text("Device name",
                fontSize = 24.sp, fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .absolutePadding(bottom = 30.dp)
                );
            ListItem(
                text = {Text("Invite")}
            , icon = {
                Icon(Icons.Rounded.PersonAddAlt, contentDescription = "")
                },
                trailing = {
                    Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "")
                }
            );
            ListItem(
                text = {Text("Rate us")}
                , icon = {
                    Icon(Icons.Rounded.StarBorder, contentDescription = "")
                },
                trailing = {
                    Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "")
                }
            );
            ListItem(
                text = {Text("Storage Location")},
                secondaryText = {
                                Text("/Internal shared storage/FileShare")
                }
                , icon = {
                    Icon(Icons.Rounded.SdStorage, contentDescription = "")
                },
                trailing = {
                    Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "")
                }
            )
            ;
            ListItem(
                text = {Text("About")}
                , icon = {
                    Icon(Icons.Rounded.Info, contentDescription = "")
                },
                trailing = {
                    Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "")
                }
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =Modifier.padding(vertical=30.dp)){
                Text("FileShare",
                fontSize = 21.sp,
                    fontWeight = FontWeight.Medium
                );
                Text("v1.0.0")
            }

        }
    }

}