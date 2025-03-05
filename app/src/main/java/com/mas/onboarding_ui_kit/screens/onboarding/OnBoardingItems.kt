package com.mas.onboarding_ui_kit.screens.onboarding

import com.mas.onboarding_ui_kit.R


class OnBoardingItems(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object{
        fun getData(): List<OnBoardingItems>{
            return listOf(
                OnBoardingItems(R.drawable.walkthrough_image_1,R.string.onBoardingTitle1, R.string.onBoardingText1),
                OnBoardingItems(R.drawable.walkthrough_image_2, R.string.onBoardingTitle2, R.string.onBoardingText2),
                OnBoardingItems(R.drawable.walkthrough_image_3, R.string.onBoardingTitle3, R.string.onBoardingText3)
            )
        }
    }
}