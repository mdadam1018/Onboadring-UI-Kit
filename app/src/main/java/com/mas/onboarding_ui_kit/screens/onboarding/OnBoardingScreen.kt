package com.mas.onboarding_ui_kit.screens.onboarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.mas.onboarding_ui_kit.screens.onboarding.components.CustomButtonWithCorner
import com.mas.onboarding_ui_kit.ui.theme.CeraProFamily
import com.mas.onboarding_ui_kit.ui.theme.Green
import com.mas.onboarding_ui_kit.ui.theme.Green_dark
import com.mas.onboarding_ui_kit.ui.theme.Orange
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {
    val context = LocalContext.current
    val items = OnBoardingItems.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //pager
        HorizontalPager(
            count = items.size,
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        ) { page ->
            OnBoardingItem(items = items[page])
        }


        //indicator
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(vertical = 5.dp)

        ) {
            Indicators(size = items.size, index = pageState.currentPage)
        }


        //bottom button
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {

                CustomButtonWithCorner(
                    cornerRadius = 50f,
                    onClick = {
                        if (pageState.currentPage < items.size - 1) {
                            scope.launch {
                                pageState.scrollToPage(pageState.currentPage + 1)
                            }
                        } else {
                            // Handle Get Started action (start intent)
                            // Replace with your specific intent launching logic

                        }
                    },
                    pageState = pageState.currentPage,
                    itemsize = items.size
                )
            }
        }


    }
}


@Composable
fun OnBoardingItem(items: OnBoardingItems) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = items.image),
            contentDescription = "Image1",
            modifier = Modifier
                .width(340.dp)
                .height(375.dp),
            contentScale = ContentScale.FillBounds

        )

        Spacer(modifier = Modifier.height(30.dp))

        //text-content
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 65.dp),
                text = stringResource(id = items.title),
                fontFamily = CeraProFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp,
                color = Color.White,
                textAlign = TextAlign.Center,

                )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                text = stringResource(id = items.desc),
                fontFamily = CeraProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                letterSpacing = 1.sp,
            )
        }
    }
}

@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = ""
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) Orange else Green_dark
            )
    ) {

    }
}





