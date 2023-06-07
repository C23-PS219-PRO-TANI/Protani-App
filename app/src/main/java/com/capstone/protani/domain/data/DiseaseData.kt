package com.capstone.protani.domain.data

import com.capstone.protani.domain.model.Disease

object DiseaseData {
    val disease = listOf(
        Disease(
            id = 1,
            title = "Penyakit Blast",
            body = "Blast, Blast menginfeksi tanaman padi pada semua fase pertumbuhan yang disebabkan oleh cendawan pyricularia oryzae." +
                    "Faktor pemicunya adalah terlalu banyak menggunakan pupuk yang mengandung unsur N serta curah hujan dan kelembaban tinggi. Gejalanya adalah adanya bercak seprti mata pada daun padi atau berbentuk belah ketupat, " +
                    "lebar ditengah dan kedua ujung meruncing. Selain pada daun, infeksi juga menyerang ruas batang dan leher malai."
        ),
        Disease(
            id = 2,
            title = "Penyakit Padi",
            body = "Pengendalian serangan penyakit ini dilakukan dengan cara menggunakan varietas yang tahan secara bergantian, menghindari penggunaan pupuk yang mengandung unsur N terlalu banyak, waktu tanam harus tepat agar saat " +
                    "pembungaan tidak banyak embun atau hujan, atau melakukan penyemprotan dengan fungisida secara berkala."
        ),
        Disease(
            id = 3,
            title = "Penyakit Hawar",
            body = "Hawar Daun Bakteri, Hawar daun bakteri (HDB) adalah salah satu penyakit yang" +
                    "dapat menyebabkan pertanaman padi mengalami puso. Penyakit ini disebabkan oleh" +
                    "bakteri xanthomonas oryzae pv. Oryzae  yang dapat menginfeksi tanaman mulai dari " +
                    "pembibitan sampai panen. Ada dua macam gejala penyakit HDB. Gejala yang muncul pada saat tanaman berumur kurang dari 30 hari setelah tanam, yaitu pada persemaian atau tanaman yang baru dipindah ke lapang, disebut kresek. Gejala yang timbul pada fase anakan sampai pemasakan disebut hawar (blight). Secara spesifik tanda-tanda tanaman terserang adalah timbulnya bercak berwarna kuning sampai putih, berawal dari terbentuknya garis lebam berair pada bagian tepi daun. Bercak bisa mulai dari salah satu atau kedua tepi daun yang rusak dan berkembang hingga menutupi seluruh helaian daun. Apabila infeksi melalui akar atau pangkal batang, tanaman terlihat kering seperti terbakar. Penyakit hawar daun ini merupakan bakteri yang tersebar luas dan dapat menurunkan hasil panen yang cukup signifikan. Penyakit ini menyerang saat kondisi musim hujan atau musim kemarau yang basah, terutama pada lahan sawah yang selalu tergenang dan kandungan pupuk N tinggi. " +
                    "Penyakit ini disebabkan bakteri Xanthomonas campestris pv oryzae."
        ),
    )
}