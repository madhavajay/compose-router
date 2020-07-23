package com.example.lifelike.composable.loggedin

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.lifelike.R
import com.example.lifelike.entity.Album
import com.example.lifelike.entity.albums


interface AlbumList {

    companion object {
        @Composable
        fun Content(onAlbumSelected: (Album) -> Unit) {
            ScrollableColumn {
                albums.forEach {
                    AlbumRow(it, onAlbumSelected)
                }
            }
        }

        @Composable
        private fun AlbumRow(album: Album, onAlbumSelected: (Album) -> Unit) {
            val image = imageResource(R.drawable.placeholder)
            val typography = MaterialTheme.typography

            Box(
                    modifier = Modifier.clickable(onClick = { onAlbumSelected(album) })
            ) {
                Row(modifier = Modifier.padding(all = 16.dp)) {
                    Box(modifier = Modifier.preferredSize(40.dp, 40.dp)) {
                        Image(image)
                    }
                    Spacer(modifier = Modifier.preferredWidth(16.dp))
                    Column {
                        Text(
                            album.name,
                            style = typography.subtitle1.copy(fontWeight = FontWeight.Bold)
                        )
                        Text("${album.photos.size} photos", style = typography.body1)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun AlbumListPreview() {
    AlbumList.Content {}
}
