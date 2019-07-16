  private fun getRoot(){

        try {


            val file=File(Environment.getRootDirectory().toString()+"/WifiConfigStore.xml")

            if(file.isDirectory)
            {
                for (i in file.list())
                {
                    Logger.e(" FILE:  ",i)
                }
            }
            val isa = FileInputStream(file)

            val dbFactory = DocumentBuilderFactory.newInstance()
            val dBuilder = dbFactory.newDocumentBuilder()
            val doc = dBuilder.parse(isa)

            val element = doc.documentElement
            element.normalize()

            val nList = doc.getElementsByTagName("WifiConfiguration")

            for ( i in 0..nList.length) {
                Logger.e(" WIFI Lenth ",nList.length.toString())
                val node = nList.item(i)
                if (node.nodeType == Node.ELEMENT_NODE) {
                    val element2 = node as Element
                    Logger.e(" WIFI DETAILS ",element2.tagName)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
