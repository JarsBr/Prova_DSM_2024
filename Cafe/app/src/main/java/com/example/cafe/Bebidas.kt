package com.example.cafe

data class Bebida(val nome: String, val descricao: String, val img: Int)
object BebidaData {
    fun getBebidas(): List<Bebida> {
        return listOf(
            Bebida("Espresso", "Um café forte e concentrado feito ao forçar água quente através de café moído fino. Base de várias outras bebidas de café.", R.drawable.expresso),
            Bebida("Cappuccino", "Combina espresso com partes iguais de leite vaporizado e espuma de leite. Famoso pelo equilíbrio entre sabores ricos e textura cremosa.", R.drawable.cappucino),
            Bebida("Latte", "Uma dose de espresso com uma quantidade generosa de leite vaporizado e uma pequena camada de espuma por cima. Suave e levemente adocicado.", R.drawable.latte),
            Bebida("Americano", "Espresso diluído com água quente, resultando em um café mais suave e menos intenso. Popular entre quem gosta de sabores menos concentrados.", R.drawable.americano),
            Bebida("Mocha", "Mistura de espresso com leite vaporizado e uma dose de chocolate. Geralmente coberto com chantilly e popular entre os amantes de chocolate.",R.drawable.mocha),
            Bebida("Macchiato", "Espresso “manchado” com um pouco de espuma de leite, acentuando o sabor forte do café com apenas um toque de suavidade", R.drawable.macchiato),
            Bebida("Flat White", "Similar ao cappuccino, mas com menos espuma e uma proporção maior de leite. De origem australiana, tem sabor intenso e textura sedosa.", R.drawable.flatwhite),
            Bebida("Ristretto", "Uma dose de espresso mais concentrada e curta, com sabor mais denso e encorpado. Ideal para quem gosta de café intenso.",R.drawable.ristreto),
            Bebida("Affogato", "Uma sobremesa italiana que combina espresso quente sobre uma bola de sorvete de baunilha. Uma deliciosa fusão de quente e frio.",R.drawable.affogato),
            Bebida("Cold Brew", "Café preparado com infusão em água fria por 12-24 horas, resultando em um sabor suave e menos ácido. Servido gelado.",R.drawable.coldbrew)
        )
    }
}