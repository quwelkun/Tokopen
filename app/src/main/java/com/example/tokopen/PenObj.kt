package com.example.tokopen

object PenObj {
    val penName = arrayOf(
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

    val pictureSource = intArrayOf(
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

    val detailPen = arrayOf(
        "Ball Pen adalah pulpen bola",
        "Drawing Pen adalah puplen untuk manggambar",
        "Fountein Pen adalah tempat menampung tinta",
        "Gallery Pen adalah pulpen dengan desain bagus",
        "Lamy Pen adalah pulpen produksi LAMY safari",
        "Luxury Pen adalah pulpen mewah",
        "Military Pen adalah pulpen yang bagus untuk orang militer",
        "My Gel Pen adalah pulpen anak sekolahan",
        "Parker Pen adalah hasil karya Parker Company Pen",
        "Premium Pen adalah pulpen mahal"
    )

    val pricePen = arrayOf(
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
            var penList: ArrayList<Pen> = arrayListOf()
            for (pos in pictureSource.indices) {
                var pen = Pen()
                pen.name = penName[pos]
                pen.detail = detailPen[pos]
                pen.price = pricePen[pos]
                pen.src = pictureSource[pos]
                penList.add(pen)
            }

            return penList
        }
}