package com.mas.onboarding_ui_kit.screens.onboarding.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mas.onboarding_ui_kit.ui.theme.CeraProFamily
import com.mas.onboarding_ui_kit.ui.theme.Green_dark
import com.mas.onboarding_ui_kit.ui.theme.Orange

@Composable
fun CustomButtonWithCorner(
    cornerRadius: Float,
    onClick: () -> Unit,
    pageState: Int,
    itemsize: Int
) {
    val text = if (pageState < itemsize - 1) {
        "Next"
    } else {
        "Get Started"
    }
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(200.dp)
            .height(70.dp),
        shape = RoundedCornerShape(topStart = 20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange
        )

    ) {
        Text(
            text = text,
            color = Green_dark,
            fontFamily = CeraProFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}
