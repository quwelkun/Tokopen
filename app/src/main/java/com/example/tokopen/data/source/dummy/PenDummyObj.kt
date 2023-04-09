package com.example.tokopen.data.source.dummy

import com.example.tokopen.R
import com.example.tokopen.domain.model.Pen

object PenDummyObj {
    private val penName = arrayOf(
        "Ball Pen",
        "Drawing Pen",
        "Fountein Pen",
        "Gallery Pen",
        "Lamy Pen",
        "Luxury Pen",
        "Military Pen",
        "My Gel Pen",
        "Parker Pen",
        "Premium Pen"
    )

    private val pictureSource = intArrayOf(
        R.drawable.ballpen,
        R.drawable.drawingpen,
        R.drawable.founteinpen,
        R.drawable.gallerypen,
        R.drawable.lamypen,
        R.drawable.luxurypen,
        R.drawable.militarypen,
        R.drawable.mygelpen,
        R.drawable.parkerpen,
        R.drawable.premiumpen
    )

    private val detailPen = arrayOf(
        "Bolpoin, adalah alat tulis yang ujungnya menggunakan bola kecil yang berputar untuk mengontrol pengeluaran tinta kental yang disimpan dalam kolom berbentuk silinder. Ujung bolpoin berupa bola kecil dari kuningan, baja, atau tungsten karbida yang diameternya berbeda-beda, umumnya 0,7 hingga 1,2 mm.",
        "Drawing Pen 0.1-0.8 mm adalah salah satu peralatan untuk menulis, memberi gradasi, mewarnai, membuat sketsa dll. Drawing Pen ini sering digunakan dalam kegiatan menggambar karena lebih praktis dan simpel daripada tinta/pena.",
        "Fountain pen merupakan salah satu alat tulis yang sudah dikenal sejak lama. Kalau di Indonesia, alat yang satu ini dikenal dengan nama pena. Diciptakan setelah pena celup, fountain pen memiliki komponen berbeda dengan pulpen pada umumnya.",
        "Gallery Pen adalah pulpen dengan desain bagus",
        "Lamy Pen adalah merek pulpen yang berasal dari Jerman dan telah dikenal di seluruh dunia sejak tahun 1960-an. Pulpen Lamy dikenal karena desainnya yang ergonomis dan inovatif serta kualitas yang tinggi.",
        "Luxury Pen atau pulpen mewah adalah jenis pulpen yang memiliki nilai estetika dan kualitas yang tinggi. Luxury Pen biasanya dirancang oleh perusahaan penulisan mewah dan menggunakan material yang mahal, seperti emas, perak, platina, dan berlian.",
        "Military Pen atau pensil militer adalah alat tulis yang dirancang khusus untuk digunakan dalam lingkungan militer atau taktis. Military Pen biasanya lebih tahan lama dan dapat digunakan dalam berbagai kondisi cuaca dan lingkungan yang berbeda. ",
        "MyGel Pen adalah merek pulpen gel yang terkenal karena kualitas tinta gelnya yang sangat baik. Merek pulpen ini di produksi oleh perusahaan Zebra, yang merupakan produsen perlengkapan tulis terkemuka di Jepang.",
        "Parker Pen adalah merek pulpen yang sangat terkenal di seluruh dunia karena kualitasnya yang luar biasa dan desain yang elegan. Merek ini didirikan pada tahun 1888 di Amerika Serikat oleh George S. Parker, dan sejak itu telah menjadi salah satu merek pulpen paling terkenal di dunia.",
        "Premium Pen adalah istilah yang sering digunakan untuk menyebut pulpen yang memiliki kualitas dan desain yang sangat baik. Pulpen jenis ini biasanya dibuat dengan bahan-bahan berkualitas tinggi seperti platinum, emas, perak, atau kayu langka, dan seringkali dihiasi dengan ukiran dan detail yang indah."
    )

    private val pricePen = arrayOf(
        "1000",
        "2000",
        "3000",
        "4000",
        "5000",
        "6000",
        "7000",
        "8000",
        "9000",
        "10000"
    )

    val listPen: ArrayList<Pen>
        get() {
            val penList: ArrayList<Pen> = arrayListOf()
            for (pos in pictureSource.indices) {
                val pen = Pen().apply {
                    name = penName[pos]
                    detail = detailPen[pos]
                    price = pricePen[pos]
                    src = pictureSource[pos]
                }
                penList.add(pen)
            }

            return penList
        }
}