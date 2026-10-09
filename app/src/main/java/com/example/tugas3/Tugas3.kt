package com.example.tugas3

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugas3.ui.theme.Tugas3Theme

/**
 * Komponen Card (Widget) reusable yang digunakan oleh keseluruhan Card.
 */
@Composable
fun UserCard(
    backgroundColor: Color,
    name: String,
    address: String,
    modifier: Modifier = Modifier,
    phone: String? = null,
    nameFontStyle: FontStyle = FontStyle.Normal,
    nameFontWeight: FontWeight = FontWeight.Bold,
    phoneColor: Color = colorResource(id = R.color.card_text_phone_cyan),
    addressColor: Color = colorResource(id = R.color.card_text_address_yellow)
) {
    val logoSize = dimensionResource(id = R.dimen.logo_size)
    val cardCornerRadius = dimensionResource(id = R.dimen.card_corner_radius)
    val cardElevation = dimensionResource(id = R.dimen.card_elevation)
    val cardPaddingVertical = dimensionResource(id = R.dimen.card_padding_vertical)
    val cardPaddingHorizontal = dimensionResource(id = R.dimen.card_padding_horizontal)
    val spacerLogoText = dimensionResource(id = R.dimen.spacer_logo_text)
    val spacerTextLines = dimensionResource(id = R.dimen.spacer_text_lines)

    val nameFontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_card_name).toSp() }
    val phoneFontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_card_phone).toSp() }
    val addressFontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_card_address).toSp() }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(cardCornerRadius),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = cardElevation)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = cardPaddingVertical, horizontal = cardPaddingHorizontal),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Logo Kiri
            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = stringResource(id = R.string.logo_description),
                modifier = Modifier.size(logoSize)
            )

            Spacer(modifier = Modifier.width(spacerLogoText))

            // Informasi Teks di Tengah
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = name,
                    color = colorResource(id = R.color.card_text_white),
                    fontSize = nameFontSize,
                    fontWeight = nameFontWeight,
                    fontStyle = nameFontStyle
                )

                if (!phone.isNullOrEmpty()) {
                    Spacer(modifier = Modifier.height(spacerTextLines))
                    Text(
                        text = phone,
                        color = phoneColor,
                        fontSize = phoneFontSize,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(spacerTextLines))
                Text(
                    text = address,
                    color = addressColor,
                    fontSize = addressFontSize,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.width(spacerLogoText))

            // Logo Kanan
            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = stringResource(id = R.string.logo_description),
                modifier = Modifier.size(logoSize)
            )
        }
    }
}

/**
 * Fungsi Utama Layout
 */
@Composable
fun Tugas3Screen(modifier: Modifier = Modifier) {
    val headerTitleColor = colorResource(id = R.color.header_title_color)
    val headerSubtitleColor = colorResource(id = R.color.header_subtitle_color)
    val footerTextColor = colorResource(id = R.color.footer_text_color)

    val cardBgGrey = colorResource(id = R.color.card_bg_grey)
    val cardBgPurple = colorResource(id = R.color.card_bg_purple)
    val cardBgBlue = colorResource(id = R.color.card_bg_blue)
    val cardBgGreen = colorResource(id = R.color.card_bg_green)

    val paddingScreenTop = dimensionResource(id = R.dimen.padding_screen_top)
    val paddingScreenBottom = dimensionResource(id = R.dimen.padding_screen_bottom)
    val paddingScreenHorizontal = dimensionResource(id = R.dimen.padding_screen_horizontal)

    val spacerTitleSubtitle = dimensionResource(id = R.dimen.spacer_title_subtitle)
    val spacerHeaderCards = dimensionResource(id = R.dimen.spacer_header_cards)
    val spacerBetweenCards = dimensionResource(id = R.dimen.spacer_between_cards)

    val headerTitleFontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_header_title).toSp() }
    val headerSubtitleFontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_header_subtitle).toSp() }
    val footerFontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_footer).toSp() }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image UMY dari Drawable
        Image(
            painter = painterResource(id = R.drawable.umy_background),
            contentDescription = stringResource(id = R.string.background_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Konten Utama
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingScreenTop,
                    bottom = paddingScreenBottom,
                    start = paddingScreenHorizontal,
                    end = paddingScreenHorizontal
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        }
    }
}
