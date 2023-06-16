package com.capstone.protani.domain.data

import com.capstone.protani.domain.model.Disease

object DiseaseData {
    val disease = listOf(
        Disease(
            id = 1,
            title = "BACTERIALBLIGHT",
            body = "Penyakit ini disebabkan oleh Xanthomonas oryzae pv, dan merupakan salah satu penyakit utama yang menyerang tanaman padi (BBPadi, 2015). \n" +
                    "\n" +
                    "Padi yang terinfeksi bakteri ini akan menyebabkan daun padi menguning pada tepi daun yang mengakibatkan padi menjadi layu dan akhirnya mati. \n" +
                    "\n" +
                    "Gejala ini disebut juga sebagai Kresek."
        ),
        Disease(
            id = 2,
            title = "BLAST",
            body = "Penyakit ini disebabkan oleh jamur Pyricularia grisae (Mew, 2018). Saat penyakit ini menyerang batang padi, maka batang dapat berubah menjadi cokelat dan kemudian membusuk.\n" +
                    "\n" +
                    "Apabila tanaman padi dapat bertahan dan menghasilkan gabah, maka jamur ini dapat menginfeksi gabah dan akhirnya menyebar ke tanaman padi baru melalui bibit yang terinfeksi.\n" +
                    "\n" +
                    "Blast memiliki ciri yang mirip seperti brownspot, perbedaannya adalah pada infeksi blast titik tengah bercak padi berwarna putih dan bukan cokelat.",
        ),
        Disease(
            id = 3,
            title = "BROWNSPOT",
            body = "Penyakit ini diidentifikasi dengan munculnya bercak cokelat pada batang daun padi yang biasanya disebabkan oleh kurangnya unsur hara pada tanah, utamanya unsur kalium. Tercatat bahwa penyakit ini dapat menyebabkan kerugian hasil panen mulai dari 50 hingga 90 persen (Herlisa, 2022).\n" +
                    "\n" +
                    "Penyebab dari penyakit ini adalah infeksi jamur Helminthosporium oryzae, yang bisa menginfeksi batang daun padi hingga gabah dan beras. Sehingga menyebabkan padi tidak dapat dikonsumsi (Mew, 2018).",

        ),
        Disease(
            id = 4,
            title = "TUNGRO",
            body = "Penyakit ini disebabkan oleh 2 virus, yaitu Rice Tungro Spherical Virus (RTSV) dan Rice Tungro Bacilliform Virus (RTBV). Virus ini bisa ditularkan melalui serangga, khususnya wereng hijau.\n" +
                    "\n" +
                    "Tanaman padi yang terinfeksi tungro akan menampilkan gejala seperti daun yang menguning dan pertumbuhan padi menjadi terhambat serta tanaman menjadi kerdil atau ruas memendek (Hendri, 2020).",

        ),
        Disease(
            id = 5,
            title = "HEALTHY",
            body = "Padi yang sehat memiliki warna batang daun yang hijau dengan jumlah anakan padi yang cukup (25/rumpun). Selain itu, akar padi yang berwarna putih juga merupakan salah satu indikator padi yang sehat.",

        )
    )
}