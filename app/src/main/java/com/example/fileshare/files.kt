package com.example.fileshare

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Files(){
    val tabs = listOf(
        TabItem.Sent,
        TabItem.Received
    )

    val pagerState = rememberPagerState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Files")
                }
            , elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            TabBar(tabs,pagerState);
            TabContent(tabs , pagerState )
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBar(tabs:List<TabItem>, pagerState: PagerState){
    val scope = rememberCoroutineScope()

    TabRow(
        modifier = Modifier.shadow(elevation = 4.dp),
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
        ) {

        tabs.forEachIndexed { index, tab ->
            // OR Tab()
            LeadingIconTab(
                icon = { Icon(tab.icon, contentDescription = "") },
                text = { Text(tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size,
        modifier = Modifier.fillMaxSize()
        ) { page ->
        tabs[page].screen()
    }
}

typealias ComposableUnit = @Composable () -> Unit
sealed class TabItem(var icon: ImageVector, var title:String, var screen: ComposableUnit){
    object Sent: TabItem(Icons.Rounded.Upload, "Sent", {Sent()})
    object Received: TabItem(Icons.Rounded.Upload, "Received", {Received()})
}

@Composable
fun Sent(){
    Text(
        text = "Sent Files",
        fontWeight = FontWeight.Bold,
        color = Color.Gray,
        textAlign = TextAlign.Center,
        fontSize = 25.sp,
    )
}

@Composable
fun Received(){
    Text(
        text = "Received Files",
        fontWeight = FontWeight.Bold,
        color = Color.Gray,
        textAlign = TextAlign.Center,
        fontSize = 25.sp
    )
}