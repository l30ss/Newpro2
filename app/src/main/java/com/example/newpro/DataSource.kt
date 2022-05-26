package  com.example.newpro

class DataSource {

    companion object{
        fun data() : ArrayList<Categories>{
            val cardList = ArrayList<Categories>()
            cardList.add(Categories("MEAT", MEATData()))
            cardList.add(Categories("VEGETBLE", VEGETBLEData()))
            cardList.add(Categories("DESSERT", DESSERTData()))
            cardList.add(Categories("BEVERAGE", cardData()))

            return cardList
        }

        private fun DESSERTData(): ArrayList<CardItem> {
            val cardList = ArrayList<CardItem>()
            cardList.add(CardItem(R.drawable.brownie,"Brownie" , false ))
            cardList.add(CardItem(R.drawable.browniefudg,"Browniefudg" , false ))
            cardList.add(CardItem(R.drawable.browniemug,"Browniemug" , false ))
            cardList.add(CardItem(R.drawable.fujipang,"Fujipang" , false ))
            cardList.add(CardItem(R.drawable.strawberryjelly,"StrawberryJelly" , false ))
            cardList.add(CardItem(R.drawable.hotgreenteagenmaicha,"hotgreenteagenmaicha" , false ))
            return cardList
        }


        private fun cardData() : ArrayList<CardItem>{
            val cardList = ArrayList<CardItem>()
            cardList.add(CardItem(R.drawable.coffee,"Coffee" , false ))
            cardList.add(CardItem(R.drawable.coffeefloat, "coffeefloat", false ))
            cardList.add(CardItem(R.drawable.lemontea, "lemontea", false ))
            cardList.add(CardItem(R.drawable.ovaltin, "ovaltin", false ))
            cardList.add(CardItem(R.drawable.ovaltinfloat, "ovaltinfloat", false ))
            cardList.add(CardItem(R.drawable.thaimilktea, "thaimilktea", false ))
            cardList.add(CardItem(R.drawable.greenteagenmaicha, "greenteagenmaicha", false ))
            cardList.add(CardItem(R.drawable.estcola, "estcola", false ))
            cardList.add(CardItem(R.drawable.estcolafloat, "estcolafloat", false ))
            cardList.add(CardItem(R.drawable.estgreen, "estgreen", false ))
            cardList.add(CardItem(R.drawable.lycheejuice, "lycheejuice", false ))
            cardList.add(CardItem(R.drawable.mineralwater, "mineralwater", false ))
            cardList.add(CardItem(R.drawable.estgreenfloat, "estgreenfloat", false ))

            return cardList
        }

        private fun MEATData() : ArrayList<CardItem>{
            val cardList = ArrayList<CardItem>()
            cardList.add(CardItem(R.drawable.akamisogyu, "AkaMisogyu", false ))
            cardList.add(CardItem(R.drawable.bacon, "Bacon", false ))
            cardList.add(CardItem(R.drawable.becon, "Becon", false ))
            cardList.add(CardItem(R.drawable.chicken, "Chicken", false ))
            cardList.add(CardItem(R.drawable.freshprawnwithmalasauce, "freshprawnwithmalasauce", false ))
            cardList.add(CardItem(R.drawable.friedchicken, "FriedChicken", false ))
            cardList.add(CardItem(R.drawable.fujichickenwing, "d", false ))
            cardList.add(CardItem(R.drawable.porkl, "Porkl", false ))
            cardList.add(CardItem(R.drawable.karubi, "Karubi", false ))
            cardList.add(CardItem(R.drawable.squidwithmalasauce, "Squidwithmalasauce", false ))
            cardList.add(CardItem(R.drawable.sokyosausage, "Sokyosausage", false ))
            cardList.add(CardItem(R.drawable.sirlointip, "Sirlointip", false ))
            cardList.add(CardItem(R.drawable.misobutakarubi, "misobutakarubi", false ))
            cardList.add(CardItem(R.drawable.porkliver, "Porkliver", false ))
            cardList.add(CardItem(R.drawable.lamb, "lamb", false ))
            cardList.add(CardItem(R.drawable.porkneck, "porkneck", false ))
            cardList.add(CardItem(R.drawable.riverprawn, "Riverprawn", false ))
            cardList.add(CardItem(R.drawable.beef, "Beef", false ))


            return cardList
        }

        private fun VEGETBLEData() : ArrayList<CardItem>{
            val cardList = ArrayList<CardItem>()
            cardList.add(CardItem(R.drawable.vbeanspoutsalad, "Beanspoutsalad", false ))
            cardList.add(CardItem(R.drawable.vedamame, "Vedamame", false ))
            cardList.add(CardItem(R.drawable.veryangii, "Eryangii", false ))
            cardList.add(CardItem(R.drawable.vfalsepakchoisalad, "falsepakchoisalad", false ))
            cardList.add(CardItem(R.drawable.vgareenoak, "gareenoak", false ))
            cardList.add(CardItem(R.drawable.vgarilledgarlic, "garilledgarlic", false ))
            cardList.add(CardItem(R.drawable.vjapanesepumpkin, "Japanesepumpkin", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "Kimji", false ))
            cardList.add(CardItem(R.drawable.vkura, "kura", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "Lattuce", false ))
            cardList.add(CardItem(R.drawable.vnamaru, "namaru", false ))
            cardList.add(CardItem(R.drawable.vocslettuce, "ocslettuce", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "Karasesa", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "okarukimji", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "Onionsalad", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "Pickledcucumberkimji", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "Sanchu", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "d", false ))
            cardList.add(CardItem(R.drawable.vonionsalad, "Tamanegi", false ))
            cardList.add(CardItem(R.drawable.vweetcorn, "Weetcorn", false ))

            return cardList
        }
    }



}