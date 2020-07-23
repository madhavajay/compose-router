package com.example.lifelike.composable.loggedout.common

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp
import com.example.lifelike.composable.common.BigButton

@Composable
fun RegFlowPanel(
    title: String,
    onNext: () -> Unit,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(40.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            Text(
                text = title,
                style = MaterialTheme.typography.h5
            )
        }
        Box(modifier = Modifier.fillMaxSize().weight(1f).wrapContentHeight(Alignment.CenterVertically)) {
            content()
        }
        Box(
            modifier = Modifier
                .preferredSizeIn(DpConstraints(maxHeight = 48.dp))
                .wrapContentSize(Alignment.CenterEnd)
        ) {
            BigButton(
                text = "Next",
                onClick = onNext
            )
        }
    }
}
