package com.example.fileshare

import android.content.Intent
import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val button = findViewById<Button>(R.id.get_started)
//        button.setOnClickListener(){
//            val intent:Intent = Intent(this, RootActivity::class.java)
//            this.startActivity(intent)
//        }
//
        setContent {
            View(onGetStarted = {
                val intent:Intent = Intent(this, RootActivity::class.java)
                this.startActivity(intent)
            })        }

    }

//    @Preview
    @Composable
    fun View(
        onGetStarted: ()-> Unit
    ){

        Scaffold() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp, vertical = 15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "App logo",

                    modifier = Modifier.size(150.dp).clip(CircleShape).background(Color.Green)
                    );
                Text(text = stringResource(R.string.app_name ),
                fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                    );
                Text(stringResource(R.string.intro_statement ), textAlign = TextAlign.Center,
                fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                    )
                Button(onClick = onGetStarted,
                    elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
                     modifier =    Modifier
                        .padding(horizontal = 15.dp)
                    .height(50.dp)
                    .fillMaxWidth()
                    .clip(
                        CircleShape
                    )
                ) {
                    Text("Get Started")
                }
            }
        }

    }


}
